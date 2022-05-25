package com.example.array;

class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class Ex3 {

    public static void main(String[] args) {

        Product[] products = {
                new Product(1, "product-1", 100.00),
                new Product(2, "product-3", 200.00),
                new Product(3, "product-2", 300.00)
        };

//        System.out.println(products.length);


        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            System.out.println(product.name);
        }


        int[] numbers = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            System.out.println(n);
        }

    }

}
