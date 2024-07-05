package com.boii.projectservice.exceptions;

public class ProductNotFoundException extends Exception {


    /* here ProductNotFoundException (childClass/subClass ) -
     will have  all the properties of Exception class (parent class/Super) */

    public ProductNotFoundException(String message) {
            super(message);
    }
}
