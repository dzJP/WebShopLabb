package com.example.webshoplabb.ui;

import com.example.webshoplabb.shop.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ShopController {
    @Autowired
    ShopService service;

    @PostMapping("/createnewuser") // create a new user with admin privilegies
    public String createNewUser(@RequestParam String name, @RequestParam String password, @RequestParam(value = "admin", required = false)Boolean admin, Model model) {
        if (admin == null) {
            admin = false;
        }
        model.addAttribute("customer", service.addNewUser(name,password,admin));
        return "redirect:/";
    }
    @PostMapping("/login") // log in as an existing user
    public String login(@RequestParam String name, @RequestParam String password, Model model) {
        model.addAttribute("customer",service.login(name,password));
        return "redirect:/";
    }
    @GetMapping("/showallcustomers") // shows a page of all customers in database
    public String getAllCustomers(Model m) {
        m.addAttribute("showallcustomers", service.getAllCustomers());
        return "showallcustomerspage";
    }
    @PostMapping("/findproducts") // shows a page where we can search for a product in the database
    public String findProductsByName(Model m, @RequestParam String productName) {
        m.addAttribute("productList", service.getByNameProduct(productName));
        return "showfoundproductspage";
    }

    @PostMapping("/newproduct") // creates a new product and adds it into list of products in database
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
    @GetMapping("/showcart") // shows current cart with total sum of products
    public String showCartPage(Model m) {
        m.addAttribute("mycart",service.getCart());
        m.addAttribute("totalpriceofallproducts", service.getCart().getTotalCostOfProductsInCart());
        return "showcartpage";
    }
    @PostMapping("/removeproductfromcart") // removes an item from the cart
    public String removeProductFromCart(Model m) {
        service.deleteProduct();
        m.addAttribute("mycart", service.getCart());
        return "showcartpage";
    }
    @PostMapping("/order") // creates an order from cart
    public String addOrder(Model m) {
        service.createOrderFromCart();
        m.addAttribute("myorder", service.getCart());
        m.addAttribute("totalpriceofallproducts", service.getCart().getTotalCostOfProductsInCart());
        return "addorderpage";
    }

}
