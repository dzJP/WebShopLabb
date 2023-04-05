package com.example.webshoplabb.ui;

import com.example.webshoplabb.shop.Cart;
import com.example.webshoplabb.shop.OrderItem;
import com.example.webshoplabb.shop.Product;
import com.example.webshoplabb.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    ShopService service;
    @PostMapping("/createnewuser") // creates a new user
    public String login(@RequestParam String name, String password, Model model) {
        model.addAttribute("customer", service.add(name, password));
        return "redirect:/";
    }
    @GetMapping("/showallcustomers") // shows a page of all customers in database
    public String getAllCustomers(Model m) {
        m.addAttribute("showallcustomers", service.getAllCustomers());
        return "showallcustomerspage";
    }
    @PostMapping("/newproduct") // creates a new product
    String addNewProduct(@RequestParam String name, double price,  Model model) {
        model.addAttribute("product", service.addProduct(name, price));
        return "redirect:/";
    }
    @GetMapping("/newproduct")
    String addNewForm(Model m) {
        m.addAttribute("product", new Product());
        return "newproductpage";
    }
    @GetMapping("/shop-products")
    public String getProductsInShop(Model m) {
        m.addAttribute("productList", service.showProductsInStore());
        return "shoppage";
    }
    @PostMapping("/shop-products")
    public String addToCart(@RequestParam Long id, @RequestParam int amount, Model m) {
        service.addToCart(id, amount);
        m.addAttribute("productList", service.showProductsInStore());
        return "shoppage";
    }
    @GetMapping("/showcart")
    public String showCartPage(Model m) {
        m.addAttribute("mycart",service.getCart());
        return "showcartpage";
    }


//    @GetMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable int id,Model m) {
//        m.addAttribute("id", shopService.deleteProduct(id));
//        return "redirect:/varukorgen";
//    }
//    @GetMapping("/update/{id}")
//    public String update(@PathVariable("id") int id, Model model){
//        model.addAttribute("product", shopService.findById(id));
//        return "redirect:/";
//    }
//    @GetMapping("/delete{id}")
//    public String deleteProduct(@PathVariable("id") int id) {
//        shopService.deleteProduct(id);
//        return "redirect:/";
//    }

    //    @GetMapping("/create/1")
//    public String createItemOne(Model m) {
//        m.addAttribute("results", shopService.getAll());
//        return "redirect:/shop";
//    }
//
//    @PostMapping("/create/1")
//    public String create1(@RequestParam int id,Model model) {
//        model.addAttribute("product", shopService.addToCart(id));
//        return "redirect:/shop";
//    }

}
