package com.example.comp1008assignment02200368110;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class LazehrsController implements Initializable {

    Store store;
    Product product;

    // Home ----------------------------------------------------------------------------------------------
    @FXML
    private AnchorPane homePage;

    // Results -------------------------------------------------------------------------------------------
    @FXML
    private AnchorPane resultsPage;
    @FXML
    private Label resultsLabel;
    @FXML
    private ListView<?> listView;


    // Product -------------------------------------------------------------------------------------------
    @FXML
    private AnchorPane productPage;
    @FXML
    private Label productLabel;
    @FXML
    private Label productAisle;
    @FXML
    private Label productDepartment;
    @FXML
    private ImageView productImage;
    @FXML
    private Label productName;
    @FXML
    private Label productNumber;
    @FXML
    private Label productRow;
    @FXML
    private Label productShelf;
    @FXML
    private Label productUPC;

    // New Product ---------------------------------------------------------------------------------------
    @FXML
    private AnchorPane newProductPage;
    @FXML
    private Label warningLabel;
    @FXML
    private TextField newProductName;
    @FXML
    private TextField newProductUPC;
    @FXML
    private TextField newProductNumber;
    @FXML
    private MenuButton newProductDepartment;
    @FXML
    private MenuButton newProductAisle;
    @FXML
    private MenuButton newProductShelf;
    @FXML
    private MenuButton newProductRow;

    @FXML
    void onBeauty(MouseEvent event) {
        setupDepartment("Beauty");
    }

    @FXML
    void onDairy(MouseEvent event) {
        setupDepartment("Dairy");
    }

    @FXML
    void onFrozen(MouseEvent event) {
        setupDepartment("Frozen");
    }

    @FXML
    void onGrocery(MouseEvent event) {
        setupDepartment("Grocery");
    }

    @FXML
    void onHealth(MouseEvent event) {
        setupDepartment("Health");
    }

    @FXML
    void onNatFoods(MouseEvent event) {
        setupDepartment("Natural Foods");
    }

    @FXML
    void onAisle1(MouseEvent event) {
        setupAisle(1);
    }

    @FXML
    void onAisle2(MouseEvent event) {
        setupAisle(2);
    }

    @FXML
    void onAisle3(MouseEvent event) {
        setupAisle(3);
    }

    @FXML
    void onAisle4(MouseEvent event) {
        setupAisle(4);
    }

    @FXML
    void onAisle5(MouseEvent event) {
        setupAisle(5);
    }

    @FXML
    void onAisle6(MouseEvent event) {
        setupAisle(6);
    }

    @FXML
    void onHome(MouseEvent event) {
        setupHome();
    }

    @FXML
    void onList(MouseEvent event) {
        showAllProducts();
    }

    @FXML
    void onAdd(MouseEvent event) {
        setupNewProduct();
    }

    @FXML
    void editProduct(ActionEvent event) {
        editProduct(product);
    }

    // Home ----------------------------------------------------------------------------------------------
    void setupHome()
    {
        closeAll();
        this.product = null;
        homePage.setDisable(false);
        homePage.setVisible(true);
    }

    // Results -------------------------------------------------------------------------------------------
    void showAllProducts()
    {
        closeAll();
        resultsPage.setDisable(false);
        resultsPage.setVisible(true);
        resultsLabel.setText("All Products");
        ObservableList oStores = FXCollections.observableArrayList(store.getProducts());
        listView.getItems().clear();
        listView.setItems(oStores);
        listView.getSelectionModel().selectedItemProperty().addListener((obs, old, itemSelected)->{
            if (itemSelected != null)
            {
                onProduct((Product)itemSelected);
            }
        });
    }

    void setupDepartment(String departmentName)
    {
        closeAll();
        this.product = null;
        resultsPage.setDisable(false);
        resultsPage.setVisible(true);
        resultsLabel.setText(departmentName);
        ObservableList oStores = FXCollections.observableArrayList(store.getProductsFromDepartment(departmentName));
        listView.getItems().clear();
        listView.setItems(oStores);
        listView.getSelectionModel().selectedItemProperty().addListener((obs, old, itemSelected)->{
            if (itemSelected != null)
            {
                onProduct((Product)itemSelected);
            }
        });
    }

    void setupAisle(int aisleNumber)
    {
        closeAll();
        this.product = null;
        resultsPage.setDisable(false);
        resultsPage.setVisible(true);
        resultsLabel.setText("Aisle " + aisleNumber);
        ObservableList oStores = FXCollections.observableArrayList(store.getProductsFromAisle(aisleNumber));
        listView.getItems().clear();
        listView.setItems(oStores);
        listView.getSelectionModel().selectedItemProperty().addListener((obs, old, itemSelected)->{
            if (itemSelected != null)
            {
                onProduct((Product)itemSelected);
            }
        });
    }

    // Product -------------------------------------------------------------------------------------------
    void onProduct(Product product)
    {
        closeAll();
        productPage.setVisible(true);
        productPage.setDisable(false);

        setupProduct(product);
    }

    void setupProduct(Product product)
    {
        this.product = product;

        productName.setText(product.getName());
        productUPC.setText(product.getUpc());
        productNumber.setText(product.getItemId());
        productDepartment.setText(product.getDepartment());
        productAisle.setText("" + product.getAisle());
        productShelf.setText("" + product.getShelf());
        productRow.setText("" + product.getRow());
    }

    void setupNewProduct()
    {
        this.product = null;
        productLabel.setText("New Product");
        closeAll();
        newProductPage.setDisable(false);
        newProductPage.setVisible(true);

        // Reset Values
        newProductName.setText("");
        newProductUPC.setText("");
        newProductNumber.setText("");
        newProductDepartment.setText("*Select");
        newProductAisle.setText("*Select");
        newProductShelf.setText("*Select");
        newProductRow.setText("*Select");

        setupMenuSelects();
    }

    void editProduct(Product product)
    {
        productLabel.setText("Edit Product");
        closeAll();
        newProductPage.setDisable(false);
        newProductPage.setVisible(true);

        // Reset Values
        newProductName.setText(product.getName());
        newProductUPC.setText(product.getUpc());
        newProductNumber.setText(product.getItemId());
        newProductDepartment.setText(product.getDepartment());
        newProductAisle.setText("" + product.getAisle());
        newProductShelf.setText("" + product.getShelf());
        newProductRow.setText("" + product.getRow());

        setupMenuSelects();
    }

    void setupMenuSelects()
    {
        if (product == null)
        {
            product = new Product("Validator", "", "", "Grocery", 1, 1, 1, store);
        }

        // Clear the lists
        newProductDepartment.getItems().clear();
        newProductAisle.getItems().clear();
        newProductShelf.getItems().clear();
        newProductRow.getItems().clear();

        // Add items to the lists
        for (String dep : store.getDepartments())
        {
            MenuItem menuItem = new MenuItem(dep);
            newProductDepartment.getItems().add(menuItem);
            menuItem.setOnAction((event -> {
                newProductDepartment.setText(dep);
            }));
        }

        for (int i = 0; i < store.getAisles(); i++)
        {
            int finalI = i+1;
            MenuItem menuItem = new MenuItem("" + finalI);
            newProductAisle.getItems().add(menuItem);
            menuItem.setOnAction((event -> {
                newProductAisle.setText("" + finalI);
            }));
        }

        for (int i = 0; i < store.getShelves(); i++)
        {
            int finalI = i+1;
            MenuItem menuItem = new MenuItem("" + finalI);
            newProductShelf.getItems().add(menuItem);
            menuItem.setOnAction((event -> {
                newProductShelf.setText("" + finalI);
            }));
        }

        for (int i = 0; i < store.getRows(); i++)
        {
            int finalI = i+1;
            MenuItem menuItem = new MenuItem("" + finalI);
            newProductRow.getItems().add(menuItem);
            menuItem.setOnAction((event -> {
                newProductRow.setText("" + finalI);
            }));
        }
    }

    @FXML
    void submitNewProduct(ActionEvent event)
    {
        if (product == null)
        {
            product = new Product("Validator", "", "", "Grocery", 1, 1, 1, store);
        }

        // Validate Name
        if (!product.isValidName(newProductName.getText()))
        {
            setupWarningLabel("Name must be between 2 and 5 characters");
            return;
        }

        // Validate UPC
        if (!store.getProducts().contains(product))
        {
            if (store.hasProductByUpc(newProductUPC.getText()))
            {
                setupWarningLabel("UPC Already Exists");
                return;
            }
        }

        if (!product.isValidUpc(newProductUPC.getText()))
        {
            setupWarningLabel("UPC must be either 12 numbers or empty");
            return;
        }

        // Validate Id
        if (!product.isValidId(newProductNumber.getText()))
        {
            setupWarningLabel("Item Id must be either 9 numbers or empty");
            return;
        }

        // Validate Department
        if (!store.getDepartments().contains(newProductDepartment.getText()))
        {
            setupWarningLabel("Please select a department");
            return;
        }

        // Validate Aisle
        if (newProductAisle.getText().equals("*Select"))
        {
            setupWarningLabel("Please select an aisle");
            return;
        }

        // Validate Shelf
        if (newProductShelf.getText().equals("*Select"))
        {
            setupWarningLabel("Please select a shelf");
            return;
        }

        // Validate Row
        if (newProductRow.getText().equals("*Select"))
        {
            setupWarningLabel("Please select a row");
            return;
        }

        // Set Values
        product.setName(newProductName.getText());
        product.setUpc(newProductUPC.getText());
        product.setItemId(newProductNumber.getText());
        product.setDepartment(newProductDepartment.getText());
        product.setAisle(Integer.parseInt(newProductAisle.getText()));
        product.setShelf(Integer.parseInt(newProductShelf.getText()));
        product.setRow(Integer.parseInt(newProductRow.getText()));

        if (!store.getProducts().contains(product))
        {
            store.addItem(product);
        }

        setupHome();
    }

    void setupWarningLabel(String text)
    {
        warningLabel.setVisible(true);
        warningLabel.setText(text);
    }

    // Close Panes ---------------------------------------------------------------------------------------
    void closeAll()
    {
        closeDepartment();
        closeHome();
        closeProduct();
        closeNewProduct();
        warningLabel.setVisible(false);
    }

    void closeDepartment()
    {
        resultsPage.setDisable(true);
        resultsPage.setVisible(false);
    }

    void closeHome()
    {
        homePage.setDisable(true);
        homePage.setVisible(false);
    }

    void closeProduct()
    {
        productPage.setDisable(true);
        productPage.setVisible(false);
    }

    void closeNewProduct()
    {
        newProductPage.setDisable(true);
        newProductPage.setVisible(false);
    }

    // Initialize ----------------------------------------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        store = new Store("Zehrs", Arrays.asList("Natural Foods", "Health", "Beauty", "Grocery", "Dairy", "Frozen"), 6, 10, 8);

        // Sample Products
        Product stoveTopChickenStuffingMix = new Product("Stove Top Chicken Stuffing Mix", "000000000001", "000000001", "Grocery", 3, 6, 2, store);
        Product christieChipsAhoyOriginal = new Product("Chips Ahoy Cookies Original", "000000000002", "000000002", "Grocery", 4, 4, 5, store);
        Product greenGiantPeachesnCream = new Product("Green Giant Peaches & Cream Corn", "000000000003", "000000003", "Grocery", 3, 4, 5, store);
        Product oldSpiceSwaggerShampoo = new Product("Old Spice Swagger Shampoo", "000000000004", "000000004", "Beauty", 1, 1, 5, store);
        Product sensadyneToothpasteWhitening = new Product("Sensadyne White Toothepaste", "000000000005", "000000005", "Beauty", 1, 1, 5, store);
        Product veggieStrawsOriginal = new Product("Veggie Straws Original", "000000000006", "000000006", "Natural Foods", 2, 5, 3, store);
        Product silkAlmondOriginal = new Product("SIlk Almond Original", "000000000007", "000000007", "Natural Foods", 2, 1, 3, store);
        Product nelson2PercentMilk = new Product("Nelson 2% Milk", "000000000008", "000000008", "Dairy", 5, 1, 3, store);
        Product blackDiamondMarbleCheese = new Product("Black Diamond Marble Cheese", "000000000009", "000000009", "Dairy", 5, 1, 3, store);
        Product chapmansFudgeIceCream = new Product("Chapmans Fudge Ice Cream", "000000000010", "000000010", "Frozen", 5, 1, 3, store);

        store.addItem(stoveTopChickenStuffingMix);
        store.addItem(christieChipsAhoyOriginal);
        store.addItem(greenGiantPeachesnCream);
        store.addItem(oldSpiceSwaggerShampoo);
        store.addItem(sensadyneToothpasteWhitening);
        store.addItem(veggieStrawsOriginal);
        store.addItem(silkAlmondOriginal);
        store.addItem(nelson2PercentMilk);
        store.addItem(blackDiamondMarbleCheese);
        store.addItem(chapmansFudgeIceCream);

        setupHome();
    }
}
