package com.boii.projectservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
// This class , itself is not going to be Table

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identity => Auto Increment 1 2 3 -> last +1
    // Auto => automatically value is assigned it can be anything/ random number 1 5 6 7  10 12  ->last + random num
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private  boolean isDeleted ;

}
