package com.example.webshoplabb.ui;

import com.example.webshoplabb.shop.Customer;
import com.example.webshoplabb.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    ShopService shopService;

    @PostMapping("/new")
    public String login(@RequestParam String name, Model model) {
        model.addAttribute("customer", shopService.add(name));
        return "redirect:/";
    }

    @GetMapping("/all")
    public String getAll(Model m) {
        m.addAttribute("customerList",shopService.getAll());
        return "show";
    }

    @GetMapping("/customer")
    public String customer(@RequestParam long id, Model m) {
        Customer c = shopService.getById(id);
        m.addAttribute("customer", c);
        return "customer";
    }
}
