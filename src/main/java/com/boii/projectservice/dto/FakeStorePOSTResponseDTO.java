package com.boii.projectservice.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStorePOSTResponseDTO {

    private String id;
    private String title;
    private Integer price ;
    private String description;
    private String image;
    private String category;

}
