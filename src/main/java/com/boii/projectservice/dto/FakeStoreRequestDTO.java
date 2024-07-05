package com.boii.projectservice.dto;

import com.boii.projectservice.models.Category;
import lombok.Getter;
import lombok.Setter;

// Its purpose is to accept Request form the  frontend / browser etc

@Getter
@Setter
public class FakeStoreRequestDTO {

    /*              title: 'test product',
                    price: 13.5,
                    description: 'lorem ipsum set',
                    image: 'https://i.pravatar.cc',
                    category: 'electronic'

     */
    private String title;
    private Double  price ;
    private  String description;
    private  String image;
    private String category;

}
