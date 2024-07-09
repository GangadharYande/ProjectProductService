package com.boii.projectservice.controllers;

import com.boii.projectservice.dto.FakeStoreRequestDTO;
import com.boii.projectservice.dto.ListProductResponseDTO;
import com.boii.projectservice.dto.ProductResponseDTO;
import com.boii.projectservice.exceptions.DBNotFoundException;
import com.boii.projectservice.exceptions.DBTimeOutException;
import com.boii.projectservice.exceptions.ProductNotFoundException;
import com.boii.projectservice.models.Product;
import com.boii.projectservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
// ways to accept incoming requests below

    @Autowired
    @Qualifier("FakeStoreProductService")  // Best way to decide which bean to be used  fakeStore or Real one in this case
    ProductService productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getSingleProduct(@PathVariable("id") String productId) throws ProductNotFoundException, DBTimeOutException, DBNotFoundException {
        Product product = productService.getSingleProduct(productId);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProduct(product);
        productResponseDTO.setResponseMessage("Success");
        ResponseEntity<ProductResponseDTO> responseEntity = new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
        return responseEntity;


    }

    @GetMapping("/products")
    public ResponseEntity<ListProductResponseDTO> getAllProducts() {

        List<Product> products = productService.getAllProducts();
        ListProductResponseDTO responseDTO = new ListProductResponseDTO();
        responseDTO.setProductList(products);
        responseDTO.setResponseMessage("Success");
        ResponseEntity<ListProductResponseDTO> responseEntity = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/search")
    // localhost:9000/products?text="mens wear"
    public List<Product> searchProducts(@RequestParam("/text") String queryText) {
        List<Product> products = productService.searchProducts(queryText);
        return products;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody FakeStoreRequestDTO fakeStoreRequestDTO) {
        Product savedProduct = productService.createProduct(fakeStoreRequestDTO);
        return savedProduct;
    }
}
