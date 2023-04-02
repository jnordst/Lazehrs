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
        if (isValidName(name))
        {
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            this.name = name;
        }
        else
        {
            throw new IllegalArgumentException("Name must be between 2 and 5 characters");
        }
    }

    public boolean isValidName(String name)
    {
        if (name.length() >= 2 && name.length() <= 50)
        {
            return true;
        }

        return false;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        if (isValidUPC(upc))
        {
            this.upc = upc;
        }
        else
        {
            throw new IllegalArgumentException("UPC must be 12 characters or empty");
        }
    }

    public boolean isValidUPC(String upc)
    {
        if (upc.length() == 12 && upc.matches("\\d+") || upc.length() == 0)
        {
            return true;
        }

        return false;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        if (isValidId(itemId))
        {
            this.itemId = itemId;
        }
        else
        {
            throw new IllegalArgumentException("Item Id must be 9 characters or empty");
        }

    }

    public boolean isValidId(String itemId)
    {
        if (itemId.length() == 9 && itemId.matches("\\d+") || itemId.length() == 0)
        {
            return true;
        }

        return false;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (getValidDepartments().contains(department))
        {
            this.department = department;
        }
        else
        {
            throw new IllegalArgumentException("Department must one of the following: " + getValidDepartments());
        }
    }

    public List<String> getValidDepartments()
    {
        return Arrays.asList("Natural Foods", "Health", "Beauty", "Grocery", "Dairy", "Frozen");
    }

    public int getAisle() {
        return aisle;
    }

    public void setAisle(int aisle) {
        if (getValidAisles().contains(aisle))
        {
            this.aisle = aisle;
        }
        else
        {
            throw new IllegalArgumentException("Aisle must be between" + getValidAisles().get(0) + " and "+ getValidAisles().get(-1));
        }
    }

    public List<Integer> getValidAisles()
    {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        if (getValidShelves().contains(shelf))
        {
            this.shelf = shelf;
        }
        else
        {
            throw new IllegalArgumentException("Shelf must be between " + getValidShelves().get(0) + " and "+ getValidShelves().get(-1));
        }
    }

    public List<Integer> getValidShelves()
    {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if (getValidRows().contains(row))
        {
            this.row = row;
        }
        else
        {
            throw new IllegalArgumentException("Row must be between " + getValidRows().get(0) + " and "+ getValidRows().get(-1));
        }
    }

    public List<Integer> getValidRows()
    {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    }

    public String toString()
    {
        return name;
    }

    public String GetLocation()
    {
        return String.format("Aisle: %d Shelf: %d Row: %d", aisle, shelf, row );
    }

}
