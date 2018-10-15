package com.acmeProject2.controller;

import com.acmeProject2.model.Customer;
import com.acmeProject2.model.Product;
import com.acmeProject2.service.CustomerService;
import com.acmeProject2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

//Customer Inventory

@Controller
@RequestMapping("/customer/inventory")
public class InventoryController
{
    @Autowired
    private CustomerService customerService;

    //Autowire ProductService bean
    @Autowired
    private ProductService productService;

    //@AuthenticationPrincipal is the person that has logged in the system
    @RequestMapping
    public String getInventory(@AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());

        //retrieve the inventory and inventoryId when we register the customer
        int inventoryId=customer.getInventory().getInventoryId();

        return "redirect:/customer/inventory/" + inventoryId;
    }

    @RequestMapping("/{inventoryId}")
    public String getInventoryRedirect(@PathVariable (value = "inventoryId") int inventoryId, Model model){
        model.addAttribute("productId", inventoryId);

        return "inventory";
    }

    //Recently added things
    @RequestMapping("/product/viewProduct/{productId}")

    public String viewInventoryProduct(@PathVariable ("inventoryId") int inventoryId, @PathVariable("productId") int productId, Model model) throws IOException{
        Product product=productService.getProductById(productId);
        model.addAttribute("product", product);

        return "viewProduct";
    }
}