package com.example.webshoplabb.rest;

import com.example.webshoplabb.shop.Category;
import com.example.webshoplabb.shop.Product;
import com.example.webshoplabb.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class RestControllerCrud {
    @Autowired
    ShopService shopService;

    @GetMapping("rest/create/product/{name}/{price}/{category}") // CREATE
    public List<Product> addProduct(@PathVariable String name, @PathVariable Double price, @PathVariable String category){
        shopService.addProduct(name,price, Category.valueOf(category));
        return shopService.getAllProducts();
    }

    @PostMapping("rest/create/product/{name}/{price}/{category}")
    public List<Product> addPost(@PathVariable String name, @PathVariable Double price, @PathVariable String category) {
        shopService.addProduct(name, price, Category.valueOf(category));
        return shopService.getAllProducts();
    }

    @GetMapping("rest/products/showallproducts") // READ
    public List<Product> getAllProducts() {
        return shopService.getAllProducts();
    }

    @GetMapping("rest/products/id/{id}") // READ BY ID
    public Product getProduct(@PathVariable Long id) {
        return shopService.getByIdProduct(id);
    }

    @GetMapping("rest/product/category/{category}") // READ BY CATEGORY
    public List<Product> getCategory(@PathVariable String category){
        return shopService.findByCategory(category);
    }

    @GetMapping("rest/product/name/{name}") // READ BY NAME
    public Product getNameProduct(@PathVariable String name) {
        return shopService.findByName(name);
    }

    @DeleteMapping("rest/delete/product/{id}") // DELETE BY ID
    public List<Product> deleteProduct(@PathVariable Long id){
        return shopService.deleteProductFromDataBase(id);
    }

//    @PutMapping("rest/update/product/{id}/{price}") // UPDATE BY ID,PRICE
//    public List<Product> updateProductPrice(@PathVariable Long id,@PathVariable Double price){
//        shopService.updatePrice(id,price);
//        return shopService.getAllProducts();
//    }

    @PutMapping("rest/update/product/{id}/{name}") // UPDATE BY ID, NAME
    public List<Product> updateProductName(@PathVariable Long id, @PathVariable String name){
        shopService.updateName(id,name);
        return shopService.getAllProducts();

    }

    @GetMapping("rest/time")
    public MyTimeDate getTime() {
        return new MyTimeDate();
    }
}
class MyTimeDate {


    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    int[] array = {3,4,7,1,3,0,};

    public int[] getArray() {
        return array;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}