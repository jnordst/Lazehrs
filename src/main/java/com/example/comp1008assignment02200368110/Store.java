package com.example.comp1008assignment02200368110;

import java.util.ArrayList;
import java.util.List;

public class Store
{
    private ArrayList<Product> products;
    private String name;
    private List<String> departments;
    private int aisles;
    private int shelves;
    private int rows;

    public Store(String name, List<String> departments, int maxNumberOfAisles, int maxNumberOfShelves, int maxNumberOfRows) {
        setName(name);
        setDepartments(departments);
        setAisles(maxNumberOfAisles);
        setShelves(maxNumberOfShelves);
        setRows(maxNumberOfRows);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    public int getAisles() {
        return aisles;
    }

    public void setAisles(int aisles) {
        this.aisles = aisles;
    }

    public int getShelves() {
        return shelves;
    }

    public void setShelves(int shelves) {
        this.shelves = shelves;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
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

    public boolean hasProductByUpc(String upc)
    {
        if (upc.equals(""))
        {
            return false;
        }

        return products.stream().anyMatch(product -> product.getUpc().equals(upc));
    }

    public boolean hasProductById(String id)
    {
        if (id.equals(""))
        {
            return false;
        }

        return products.stream().anyMatch(product -> product.getItemId().equals(id));
    }

}
