package com.boii.projectservice.dto;

import com.boii.projectservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private Product product;
    private String responseMessage;
}
