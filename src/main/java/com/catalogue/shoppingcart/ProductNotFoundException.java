package com.catalogue.shoppingcart;

public class ProductNotFoundException extends RuntimeException{

   public ProductNotFoundException(Integer id)
   {
       super("The product with id not present ");
   }
}
