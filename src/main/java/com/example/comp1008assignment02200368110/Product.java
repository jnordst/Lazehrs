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
    private Store store;

    public Product(String name, String upc, String itemId, String department, int aisle, int shelf, int row, Store store) {
        this.store = store;
        setName(name);
        setUpc(upc);
        setItemId(itemId);
        setDepartment(department);
        setAisle(aisle);
        setShelf(shelf);
        setRow(row);
    }

    // Name ----------------------------------------------------------------------------------------------
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

    // UPC -----------------------------------------------------------------------------------------------
    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        if (isValidUpc(upc))
        {
            this.upc = upc;
        }
        else
        {
            throw new IllegalArgumentException("UPC must be 12 characters or empty. Upc must also not already exist.");
        }
    }

    public boolean isValidUpc(String upc)
    {
        if (store.getProducts().contains(this))
        {
            if (store.getProducts().get(store.getProducts().indexOf(this)).upc.equals(upc))
            {
                return true;
            }
        }

        if (upc.length() == 12 && upc.matches("\\d+") && !store.hasProductByUpc(upc) || upc.length() == 0)
        {
            return true;
        }

        return false;
    }

    // ID ------------------------------------------------------------------------------------------------
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
            throw new IllegalArgumentException("Item Id must be 9 characters or empty. Id must also not already exist");
        }
    }

    public boolean isValidId(String itemId)
    {
        if (store.getProducts().contains(this))
        {
            if (store.getProducts().get(store.getProducts().indexOf(this)).itemId.equals(itemId))
            {
                return true;
            }
        }

        if (itemId.length() == 9 && itemId.matches("\\d+") && !store.hasProductById(itemId) || itemId.length() == 0)
        {
            return true;
        }

        return false;
    }

    // Department ----------------------------------------------------------------------------------------
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (store.getDepartments().contains(department))
        {
            this.department = department;
        }
        else
        {
            throw new IllegalArgumentException("Department must one of the following: " + store.getDepartments());
        }
    }

    // Aisle ---------------------------------------------------------------------------------------------
    public int getAisle() {
        return aisle;
    }

    public void setAisle(int aisle) {
        if (aisle > 0 && aisle <= store.getAisles())
        {
            this.aisle = aisle;
        }
        else
        {
            throw new IllegalArgumentException("Aisle must be between 1 and " + store.getAisles());
        }
    }

    // Shelf ---------------------------------------------------------------------------------------------
    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        if (shelf > 0 && shelf <= store.getShelves())
        {
            this.shelf = shelf;
        }
        else
        {
            throw new IllegalArgumentException("Shelf must be between 1 and " + store.getShelves());
        }
    }

    // Row -----------------------------------------------------------------------------------------------
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if (row > 0 && row <= store.getRows())
        {
            this.row = row;
        }
        else
        {
            throw new IllegalArgumentException("Row must be between 1 and " + store.getRows());
        }
    }

    // Behaviour -----------------------------------------------------------------------------------------
    public String toString()
    {
        return name;
    }

    public String GetLocation()
    {
        return String.format("Aisle: %d Shelf: %d Row: %d", aisle, shelf, row );
    }

}
