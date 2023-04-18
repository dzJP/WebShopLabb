package com.example.webshoplabb.ui;

import com.example.webshoplabb.shop.Product;
import com.example.webshoplabb.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/findproducts")
    public String findProductsByName(Model m, @RequestParam String productName) {
        m.addAttribute("productList", service.getByNameProduct(productName));
        return "showfoundproductspage";
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
        m.addAttribute("amount", service.getCart().getTotalCostOfProductsInCart());
        return "showcartpage";
    }
    @PostMapping("/removeproductfromcart")
    public String removeProductFromCart(Model m) {
        service.deleteProduct();
        m.addAttribute("mycart", service.getCart());
        return "showcartpage";
    }
    @PostMapping("/order")
    public String addOrder(Model m) {
        service.addOrder();
        m.addAttribute("mycart", service.getCart());
        return "addorderpage";
    }
}
