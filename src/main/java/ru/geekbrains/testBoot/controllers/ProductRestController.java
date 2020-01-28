package ru.geekbrains.testBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.testBoot.entities.Product;
import ru.geekbrains.testBoot.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/list")
    public List<Product> getProductList() {
        return productService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/{id}")
    public Optional getProductById(@PathVariable Long id) {
        return productService.get(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/title/{title}")
    public List getProductByTitle(@PathVariable String title) {
        return productService.getProductByTitle(title);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/maxprice")
    public List getProductByMaxPrice() {
        return productService.myProductByMaxPrice();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/minprice")
    public List getProductByMinPrice() {
        return productService.myProductByMinPrice();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/{minPrice}/{maxPrice}")
    public List getProductByAweragePrice(@PathVariable int minPrice, @PathVariable int maxPrice) {
        return productService.myAwerageProduct(minPrice, maxPrice);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create")
    public Product create(@RequestBody Product product){
        productService.save(product);
        return product;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public void update(@RequestBody Product product) {
        productService.save(product);
        System.out.println(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
