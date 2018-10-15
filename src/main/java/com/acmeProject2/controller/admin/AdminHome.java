package com.acmeProject2.controller.admin;
import com.acmeProject2.model.Product;
import com.acmeProject2.service.CustomerService;
import com.acmeProject2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//ProductController can be accessed only by administrator

@Controller
@RequestMapping("/admin")

public class AdminHome
{
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;


    //root
    @RequestMapping
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productInventory";
    }

    //View Customer List
    @RequestMapping("/customer")
    public String customerManagement(Model model){

        //to add some customer service later
        return "customerManagement";
    }

}
