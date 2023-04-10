# Lazehrs
## A shopping assistant app
![lazehrs-small](https://user-images.githubusercontent.com/12515630/230989468-ff025b13-4737-46b6-9aa4-1b6935d5f535.png)

# Class Structure
![image](https://user-images.githubusercontent.com/12515630/230990287-3db8ed05-00b5-46be-832f-063084acbd14.png)

## Product
The Product class is a representation of a product in a store. 
It has attributes such as name, UPC, item ID, department, aisle, shelf, row, and Store

### Attributes
The class has the following attributes:

- `name` the name of the product.
- `upc` the Universal Product Code of the product.
- `itemId` the Id of the product.
- `department` the department in which the product belongs.
- `aisle` the aisle in which the product is located.
- `shelf` the shelf on which the product is located.
- `row` the row on which the product is located.
- `store` the Store in which the product is located.

### Methods
- `isValidName` returns `true` if the name is between 2 and 50 characters; otherwise, it returns `false`.
- `isValidUPC` returns `true` if the UPC is 12 characters or empty and does not already exist; otherwise, it returns `false`.
- `isValidId` returns `true` if the ID is 9 characters or empty and does not already exist; otherwise, it returns `false`.
- `toString` overwrites the base `toString` method and returns the name of the product.



## Store
The Store class represents a store that sells Products. It provides methods for adding and getting products from the store. It also allows you to retrieve products based on their aisle and department.


### Attributes
- `products` an ArrayList of Product objects that stores the products in the store.
- `name` the name of the store.
- `departments` a List of String objects that represents the departments in the store.
- `aisles` the maximum number of aisles in the store.
- `shelves` the maximum number of shelves in the store.
- `rows` the maximum number of rows in the store.

### Methods
- `getProducts` gets an ArrayList containing all the products in the Store.
- `getProductsFromAisle` gets an ArrayList of products from a specified aisle.
- `getProductsFromDepartment` gets an ArrayList of products from a specified department.
- `addItem` adds a Product object to the ArrayList of products.


# Demo
![image](https://user-images.githubusercontent.com/12515630/230990564-ccad33d4-85d0-4611-a102-71ff41c55228.png)
![image](https://user-images.githubusercontent.com/12515630/230994858-9bfe232f-80d3-4b0a-8cf2-b5557d115cc3.png)
![image](https://user-images.githubusercontent.com/12515630/230994954-02509dc0-4806-4fe2-ba1f-e6de9a0ef3df.png)
![image](https://user-images.githubusercontent.com/12515630/230994996-a93abf77-df42-4d89-8dfd-f86f5639e0f1.png)
![image](https://user-images.githubusercontent.com/12515630/230995012-7f695090-5d3d-4f63-a846-57b15d44dff9.png)
![image](https://user-images.githubusercontent.com/12515630/230995073-ca04b9b4-d612-4543-b808-f3d5e1e2ea4d.png)





