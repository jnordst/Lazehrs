package com.example.comp1008assignment02200368110;

import java.util.ArrayList;
import java.util.List;

public class Store
{
    private ArrayList<Product> products;

    public Store() {
        products = new ArrayList<>();
    }

    public void addItem(Product product)
    {
        products.add(product);
    }

    public ArrayList<Product> getProducts()
    {
        return products;
    }

    public ArrayList<Product> getProductsFromAisle(int aisle)
    {
        return new ArrayList<>(products.stream().filter(product -> product.getAisle() == aisle).toList());
    }

    public ArrayList<Product> getProductsFromDepartment(String department)
    {
        return new ArrayList<>(products.stream().filter(product -> product.getDepartment().equals(department)).toList());
    }

}
