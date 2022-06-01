package com.example.basic.mini;


import java.util.Objects;

class Product implements  Cloneable{
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name);
    }

    public int hashCode() {
        // algm
        return 124234234;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ObjectCass_Ex {
    public static void main(String[] args) throws CloneNotSupportedException {

        Product product1 = new Product(101, "product1", 1000.00);
        Product product2 = new Product(101, "product1", 2000.00);

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product1.equals(product2));

        //-------------------------------------------------------------------

        Class<?> clazz = product1.getClass();
        System.out.println(clazz.getName());

        //-------------------------------------------------------------------

        System.out.println(product1.hashCode());
        System.out.println(product2.hashCode());


        Product product11 = (Product) product1.clone();
        System.out.println(product11);

        //--------------------------------------------------------------------

    }
}
