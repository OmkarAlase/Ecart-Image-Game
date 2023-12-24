package com.ecart.Ecart.controller.productController;

import com.ecart.Ecart.dto.productDto.ProductRequestDTO;
import com.ecart.Ecart.service.fakeStoreService.IFakeStoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    IFakeStoreProductService productService;
    @Autowired
    public ProductController(IFakeStoreProductService productService){
        this.productService = productService;
    }
    @GetMapping("/")
    public ResponseEntity<List<ProductRequestDTO>> getAllProducts() throws IOException, URISyntaxException, InterruptedException {
        List<ProductRequestDTO> products = this.productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/few")
    public String getFewProducts() throws IOException, URISyntaxException, InterruptedException {
        return "Omkar Alase";
    }

}
