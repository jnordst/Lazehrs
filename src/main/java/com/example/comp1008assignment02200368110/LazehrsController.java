package com.example.comp1008assignment02200368110;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class LazehrsController implements Initializable {

    Store store;
    String departmentName;
    Product product;

    @FXML
    private AnchorPane homeAnchor;
    @FXML
    private AnchorPane departmentAnchor;
    @FXML
    private AnchorPane productAnchor;
    @FXML
    private AnchorPane newProductAnchor;
    @FXML
    private Label warningLabel;
    @FXML
    private Label departmentLabel;
    @FXML
    private Label productLabel;
    @FXML
    private ListView<?> listView;
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
        setupList();
    }

    void setupList(){
        closeAll();
        departmentAnchor.setDisable(false);
        departmentAnchor.setVisible(true);
        departmentLabel.setText("All Products");
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

    @FXML
    void onAdd(MouseEvent event) {
        setupNewProduct();
    }

    @FXML
    void editProduct(ActionEvent event) {
        editProduct(product);
    }

    void setupNewProduct()
    {
        productLabel.setText("New Product");
        closeAll();
        newProductAnchor.setDisable(false);
        newProductAnchor.setVisible(true);

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
        newProductAnchor.setDisable(false);
        newProductAnchor.setVisible(true);

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
            product = new Product("Validator", "123456789012", "123456789", "Grocery", 1, 1, 1);
        }

        for (String dep : product.getValidDepartments())
        {
            MenuItem menuItem = new MenuItem(dep);
            newProductDepartment.getItems().add(menuItem);
            menuItem.setOnAction((event -> {
                newProductDepartment.setText(dep);
            }));
        }

        for (Integer aisle : product.getValidAisles())
        {
            MenuItem menuItem = new MenuItem("" + aisle);
            newProductAisle.getItems().add(menuItem);
            menuItem.setOnAction((event -> {
                newProductAisle.setText("" + aisle);
            }));
        }

        for (Integer shelf : product.getValidShelves())
        {
            MenuItem menuItem = new MenuItem("" + shelf);
            newProductShelf.getItems().add(menuItem);
            menuItem.setOnAction((event -> {
                newProductShelf.setText("" + shelf);
            }));
        }

        for (Integer row : product.getValidRows())
        {
            MenuItem menuItem = new MenuItem("" + row);
            newProductRow.getItems().add(menuItem);
            menuItem.setOnAction((event -> {
                newProductRow.setText("" + row);
            }));
        }
    }


    @FXML
    void submitNewProduct(ActionEvent event) {
        if (product == null)
        {
            product = new Product("Validator", "123456789012", "123456789", "Grocery", 1, 1, 1);
        }

        // Validate Name
        if (!product.isValidName(newProductName.getText()))
        {
            setupWarningLabel("Name must be between 2 and 5 characters");
            return;
        }

        // Validate UPC
        if (!product.isValidUPC(newProductUPC.getText()))
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
        if (!product.getValidDepartments().contains(newProductDepartment.getText()))
        {
            setupWarningLabel("Please select a department");
            return;
        }

        // Validate Aisle
        if (newProductAisle.getText().equals("*Select")  || !product.getValidAisles().contains(Integer.parseInt(newProductAisle.getText())))
        {
            setupWarningLabel("Please select an aisle");
            return;
        }

        // Validate Shelf
        if (newProductShelf.getText().equals("*Select") || !product.getValidShelves().contains(Integer.parseInt(newProductShelf.getText())))
        {
            setupWarningLabel("Please select a shelf");
            return;
        }

        // Validate Row
        if (newProductRow.getText().equals("*Select") || !product.getValidRows().contains(Integer.parseInt(newProductRow.getText())))
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

    boolean isNumeric(String string)
    {
        if (string.matches("\\d+")) {
            return true;
        }

        return false;
    }

    void setupHome()
    {
        closeAll();
        this.product = null;
        homeAnchor.setDisable(false);
        homeAnchor.setVisible(true);
    }

    void setupWarningLabel(String text)
    {
        warningLabel.setVisible(true);
        warningLabel.setText(text);
    }

    void setupDepartment(String departmentName)
    {
        closeAll();
        this.product = null;
        departmentAnchor.setDisable(false);
        departmentAnchor.setVisible(true);
        departmentLabel.setText(departmentName);
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
        departmentAnchor.setDisable(false);
        departmentAnchor.setVisible(true);
        departmentLabel.setText("Aisle " + aisleNumber);
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
        departmentAnchor.setDisable(true);
        departmentAnchor.setVisible(false);
    }

    void closeHome()
    {
        homeAnchor.setDisable(true);
        homeAnchor.setVisible(false);
    }

    void closeProduct()
    {
        productAnchor.setDisable(true);
        productAnchor.setVisible(false);
    }

    void closeNewProduct()
    {
        newProductAnchor.setDisable(true);
        newProductAnchor.setVisible(false);
    }

    void onProduct(Product product)
    {
        closeAll();
        productAnchor.setVisible(true);
        productAnchor.setDisable(false);

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        store = new Store();

        // Sample Products
        Product stoveTopChickenStuffingMix = new Product("Stv Tp Chckn Stffng Mx", "000000000001", "000000001", "Grocery", 3, 6, 2);
        Product christieChipsAhoyOriginal = new Product("Chrst Chips Ahoy Orig", "000000000002", "000000002", "Grocery", 4, 4, 5);
        Product greenGiantPeachesnCream = new Product("Grn Gnt Pchs & Crm Corn", "000000000003", "000000003", "Grocery", 3, 4, 5);
        Product oldSpiceSwaggerShampoo = new Product("Old Spice Swagger Shamp", "000000000004", "000000004", "Beauty", 1, 1, 5);
        Product sensadyneToothpasteWhitening = new Product("Sensadyne White Toothepaste", "000000000005", "000000005", "Beauty", 1, 1, 5);
        Product veggieStrawsOriginal = new Product("Veggie Straws Original", "000000000006", "000000006", "Natural Foods", 2, 5, 3);
        Product silkAlmondOriginal = new Product("SIlk Almond Original", "000000000007", "000000007", "Natural Foods", 2, 1, 3);
        Product nelson2PercentMilk = new Product("Nelson 2% Milk", "000000000008", "000000008", "Dairy", 5, 1, 3);
        Product blackDiamondMarbleCheese = new Product("Black Diamond Marble Cheese", "000000000009", "000000009", "Dairy", 5, 1, 3);
        Product chapmansFudgeIceCream = new Product("Chapmans Fudge Ice Cream", "000000000010", "000000010", "Frozen", 5, 1, 3);

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
