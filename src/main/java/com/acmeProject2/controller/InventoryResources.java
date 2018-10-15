package com.acmeProject2.controller;

import com.acmeProject2.model.Inventory;
import com.acmeProject2.model.InventoryItem;
import com.acmeProject2.model.Customer;
import com.acmeProject2.model.Product;
import com.acmeProject2.service.InventoryItemService;
import com.acmeProject2.service.InventoryService;
import com.acmeProject2.service.CustomerService;
import com.acmeProject2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Rest Service controller - use it as resources used to provide with inventory view page with resources

@Controller
@RequestMapping("/rest/inventory")
public class InventoryResources
{
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private InventoryItemService inventoryItemService;

    //Map the inventoryId path and responding to return a Inventory object and turn it into JSON format (@ResponseBody)
    @RequestMapping("/{inventoryId}")
    public @ResponseBody Inventory getInventoryById(@PathVariable(value = "inventoryId") int inventoryId){
        return inventoryService.getInventoryById(inventoryId);
    }

    //this method will be used as addItem and map it with http request method of PUT
    //GET is used to retrieve info
    //POST is used to submit a form
    //PUT is used to update some info
    //DELETE is used to delete some info
    /*When you add an item to your inventory you want to first see if this product already exists in the inventory. If it already exists we just increase the
    quantity by one, if not then just add a new item and set the quantity = 1*/

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User activeUser){

        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        Inventory inventory = customer.getInventory();
        Product product = productService.getProductById(productId);
        List<InventoryItem> inventoryItems = inventory.getInventoryItems();

        //loop through the items in the inventory
        for(int i=0; i<inventoryItems.size(); i++){
            //if this product is a product that already exists in the inventory then we increase the quantity by 1
            if(product.getProductId() == inventoryItems.get(i).getProduct().getProductId()){
                InventoryItem inventoryItem = inventoryItems.get(i);
                inventoryItem.setQuantity(inventoryItem.getQuantity()+1);
                inventoryItem.setTotalPrice(product.getProductPrice()*inventoryItem.getQuantity());
                inventoryItemService.addInventoryItem(inventoryItem);

                return; //we add an empty return to finish the execution of the loop
            }
        }

        //If we haven't found any item in the inventory then we add a new product to the inventoryItem and save it in database
        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setProduct(product);
        inventoryItem.setQuantity(1);
        inventoryItem.setTotalPrice(product.getProductPrice()*inventoryItem.getQuantity());
        inventoryItem.setInventory(inventory);
        inventoryItemService.addInventoryItem(inventoryItem);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "productId") int productId){
        InventoryItem inventoryItem = inventoryItemService.getInventoryItemByProductId(productId);
        inventoryItemService.removeInventoryItem(inventoryItem);
    }


    @RequestMapping(value = "/{inventoryId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearInventory(@PathVariable(value = "inventoryId") int inventoryId){
        Inventory inventory = inventoryService.getInventoryById(inventoryId);
        inventoryItemService.removeAllInventoryItems(inventory);
    }



    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors(Exception e){}


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors(Exception e){}
}