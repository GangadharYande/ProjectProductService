package com.boii.projectservice.dto;

import com.boii.projectservice.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListProductResponseDTO {
    private List<Product> productList;
    private String ResponseMessage;


}
