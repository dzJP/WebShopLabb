package com.example.webshoplabb.ui;

import com.example.webshoplabb.shop.Product;
import com.example.webshoplabb.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {
    @Autowired
    ShopService shopService;
    @PostMapping("/new")
    public String login(@RequestParam String name, String password, Model model) {
        model.addAttribute("customer", shopService.add(name, password));
        return "redirect:/";
    }

    @GetMapping("/all")
    public String getAll(Model m) {
        m.addAttribute("results", shopService.getAll());
        return "show";
    }

    @GetMapping("/shop")
    public String getProduct(Model m) {
        m.addAttribute("products", shopService.showProducts());
        return "shop";
    }

    @GetMapping("/varukorgen")
    public String varukorgen(Model m) {
        m.addAttribute("products", shopService.getAllProducts());
        return "varukorgen";
    }
    @GetMapping("/create")
    public String showCreate() {
        return "create";
    }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        shopService.create(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id,Model m) {
        m.addAttribute("id", shopService.deleteProduct(id));
        return "redirect:/varukorgen";
    }

//    @GetMapping("/delete{id}")
//    public String deleteProduct(@PathVariable("id") int id) {
//        shopService.deleteProduct(id);
//        return "redirect:/";
//    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("product", shopService.findById(id));
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product){
        shopService.update(product);
        return "redirect:/";
    }



}
