package ru.geekbrains.testBoot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.testBoot.entities.Product;
import ru.geekbrains.testBoot.services.ProductService;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public String showProductList(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("productList", productList);
        System.out.println(productList);
        return "product-list";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.GET)
    public String addNewProductList(Model model) {
        Product product = new Product();
        product.setTitle("new");
        product.setPrice(0);
        model.addAttribute("productAdd", product);
        return "product-add";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addNewProductList(Product product) {
        productService.save(product);
        return "redirect:/product/list";
    }

    @RequestMapping(value = "/product/price", method = RequestMethod.GET)
    public String showProductListInPrice(Model model) {
        Product product = new Product();
        model.addAttribute("productPriceList", product);
        return "product-price-list";
    }

    @GetMapping(path = "/showProductById")
    public String showProductById(Model model, @RequestParam(value = "minPrice") int minPrice, @RequestParam(value = "maxPrice") int maxPrice) {
        List<Product> productList = productService.myAwerageProduct(new Integer(minPrice),new Integer(maxPrice));
        System.out.println(productList);
        model.addAttribute("productList", productList);
        return "product-list";
    }
}
