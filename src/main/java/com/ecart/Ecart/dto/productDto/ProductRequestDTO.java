package com.ecart.Ecart.dto.productDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    private String productName;
    private String category;
    private String imageURL;
    private Double price;
}
