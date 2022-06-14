package com.example.collections;

import com.example.collections.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HowToSortListColln_Ex1 {
    public static void main(String[] args) {

        Product product1 = new Product(23213, "item-a", 1000.00);
        Product product2 = new Product(13213, "item-c", 2000.00);
        Product product3 = new Product(33213, "item-b", 1500.00);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

//        Collections.sort(products);

//        Comparator<Product> byPrice = new Comparator<>() {
//            public int compare(Product o1, Product o2) {
//                return Double.compare(o1.getPrice(), o2.getPrice());
//            }
//        };
//        Collections.sort(products, byPrice);

        Comparator<Product> byId = new Comparator<Product>() {
            public int compare(Product x, Product y) {
                return Integer.compare(x.getId(), y.getId());
            }
        };
        Collections.sort(products, byId);


        display(products);

    }

    private static void display(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }


}

