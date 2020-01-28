package ru.geekbrains.testBoot.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.testBoot.entities.Product;

import java.util.List;

public class RestClient {

    private static final String URI = "http://localhost:8080/api";

    public static void main(String[] args) {
        // getProductList();
        // productByAweragePrice(100, 200);
        // getProductByTitle("new");
        // create();
        delete((long) 7);


    }

    private static void getProductByTitle(String title) {
        RestTemplate restTemplate = new RestTemplate();
        List<Product> productList = restTemplate.getForObject(URI + "/product/title/" + title, List.class);
        System.out.println(productList);
    }

    private static void productByAweragePrice(int minPrice, int maxPrice) {
        RestTemplate restTemplate = new RestTemplate();
        List<Product> productList = restTemplate.getForObject(URI + "/product/" + minPrice + "/" + maxPrice, List.class);
        System.out.println(productList);
    }

    private static void getProductList() {
        RestTemplate restTemplate = new RestTemplate();
        List<Product> productList = restTemplate.getForObject(URI + "/list", List.class);
        System.out.println(productList);
    }

    private static void create() {
        Product product = new Product("restProduct", 11235);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> productResponseEntity = restTemplate.postForEntity(URI + "/create", product, Product.class, new Object());
        System.out.println(productResponseEntity);
        System.out.println(productResponseEntity.getStatusCode());
    }

    private static void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(URI + "/delete/" + id);

    }

}
