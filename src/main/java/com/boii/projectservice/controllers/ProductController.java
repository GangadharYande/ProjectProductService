package com.boii.projectservice.controllers;

import com.boii.projectservice.dto.FakeStoreRequestDTO;
import com.boii.projectservice.dto.ProductResponseDTO;
import com.boii.projectservice.exceptions.DBNotFoundException;
import com.boii.projectservice.exceptions.DBTimeOutException;
import com.boii.projectservice.exceptions.ProductNotFoundException;
import com.boii.projectservice.models.Product;
import com.boii.projectservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
// ways to accept incoming requests below

    @Autowired
    ProductService productService;

    @GetMapping("/products/{id}")
    public ProductResponseDTO getSingleProduct(@PathVariable("id") String productId) throws ProductNotFoundException {
        try {

            Product product = productService.getSingleProduct(productId);

            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(product);
            productResponseDTO.setResponseMessage("Success");
            return productResponseDTO;
        }
        catch (ProductNotFoundException pnfe){
            // should handle all error like nullPointer ,serverDown , product not in db etc.

            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(null);
            productResponseDTO.setResponseMessage(pnfe.getMessage() +" Product not found");
            return productResponseDTO;
        }
        catch (DBNotFoundException dbnfe) {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(null);
            productResponseDTO.setResponseMessage(dbnfe.getMessage() + " DB not Found ");
            return productResponseDTO;
        }
        catch(DBTimeOutException dbte){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(null);
            productResponseDTO.setResponseMessage(dbte.getMessage() + "DB timeOut ");
            return productResponseDTO;
        }


    }
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @GetMapping("/search")
    // localhost:9000/products?text="mens wear"
    public List<Product> searchProducts(@RequestParam("/text") String queryText) {
        List<Product> products = productService.searchProducts(queryText);
        return products;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody FakeStoreRequestDTO  fakeStoreRequestDTO) {
        Product savedProduct = productService.createProduct(fakeStoreRequestDTO);
        return savedProduct;
    }
}
