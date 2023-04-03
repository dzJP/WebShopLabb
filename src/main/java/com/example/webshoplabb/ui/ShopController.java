package com.example.webshoplabb.ui;

import com.example.webshoplabb.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShopController {
    @Autowired
    ShopService service;
    @PostMapping("/new")
    public String login(@RequestParam String name, String password, Model model) {
        model.addAttribute("customer", service.add(name, password));
        return "redirect:/";
    }

    @GetMapping("/allusers")
    public String getAll(Model m) {
        m.addAttribute("results", service.getAll());
        return "showpage";
    }
    @PostMapping("/shop")
    public String getProduct(@RequestParam Long id, @RequestParam int amount, Model m) {
        service.addToCart(id, amount);
        m.addAttribute("productList", service.showShopProducts());
        return "shoppage";
    }

    @GetMapping("/shopproducts")
    public String getProductsInShop(Model m) {
        m.addAttribute("productList", service.showShopProducts());
        return "shoppage";
    }

    @GetMapping("/varukorgen")
    public String varukorgen(Model m) {
        m.addAttribute("products", service.getCart());
        return "varukorgen";
    }

//    @PostMapping("/create")
//    public String create1(@RequestParam Long id, Model model) {
//        model.addAttribute("product", service.addToCart(id));
//        return "varukorgen";
//    }



//    @GetMapping("/varukorgen")
//    public String getAllProducts(@RequestParam Long id, Model m) {
//        Product product = service.getByIdProduct(id);
//        m.addAttribute("product", product);
//        return "varukorgen";
//    }








































//    @PostMapping("/update")
//    public String updateProduct(@ModelAttribute Product product){
//        shopService.update(product);
//        return "redirect:/";
//    }
//    @GetMapping("/create")
//    public String showCreate() {
//        return "create";
//    }
//    @PostMapping("/create")
//    public String createProduct(@ModelAttribute Product product) {
//        shopService.create(product);
//        return "create";
//    }

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
