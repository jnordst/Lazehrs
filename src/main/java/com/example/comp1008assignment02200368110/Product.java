package com.example.comp1008assignment02200368110;

import java.util.Arrays;
import java.util.List;

public class Product
{
    private String name;
    private String upc;
    private String itemId;
    private String department;
    private int aisle;
    private int shelf;
    private int row;
    private int quantity;
    private double price;

    public Product(String name, String upc, String itemId, String department, int aisle, int shelf, int row) {
        setName(name);
        setUpc(upc);
        setItemId(itemId);
        setDepartment(department);
        setAisle(aisle);
        setShelf(shelf);
        setRow(row);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 50)
        {
            this.name = name;
        }
        else
        {
            throw new IllegalArgumentException("Name must be between 2 and 5 characters");
        }
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        if (upc.length() == 12)
        {
            this.upc = upc;
        }
        else
        {
            throw new IllegalArgumentException("UPC must be 12 characters");
        }

    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        List<String> validDepartments = Arrays.asList("Produce", "Hot Deli", "Cold Deli", "Bakery", "Natural Foods", "Beauty", "Meat", "Seafood", "Grocery", "Dairy", "Frozen", "Electronics");
        if (validDepartments.contains(department))
        {
            this.department = department;
        }
        else
        {
            throw new IllegalArgumentException("Department must one of the following: " + validDepartments);
        }
    }

    public int getAisle() {
        return aisle;
    }

    public void setAisle(int aisle) {
        if (aisle <= 18 && aisle >= 1)
        {
            this.aisle = aisle;
        }
        else
        {
            throw new IllegalArgumentException("Aisle must be in range of 1 to 18");
        }
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        if (shelf <= 15 && shelf >= 1)
        {
            this.shelf = shelf;
        }
        else
        {
            throw new IllegalArgumentException("Shelf must be in range of 1 to 15");
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if (row <= 8 && row >= 1)
        {
            this.row = row;
        }
        else
        {
            throw new IllegalArgumentException("Row must be in range of 1 to 8");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 999)
        {
            this.quantity = quantity;
        }
        else
        {
            throw new IllegalArgumentException("Quantity cannot exceed 999");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 9999.99 && price >= 0.01)
        {
            this.price = price;
        }
        else
        {
            throw new IllegalArgumentException("Price must be in range of $0.01 to $9999.99");
        }
    }

    public String toString()
    {
        return name;
    }

    public String GetLocation()
    {
        return String.format("Aisle: %d Shelf: %d Row: %d", aisle, shelf, row );
    }

    public boolean inStock()
    {
        if (quantity > 0)
        {
            return true;
        }

        return false;
    }

}
