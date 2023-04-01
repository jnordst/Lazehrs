package com.example.comp1008assignment02200368110;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
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
    private Label departmentLabel;

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

    }

    @FXML
    void onAdd(MouseEvent event) {

    }

    public void setupHome()
    {
        closeAll();
        homeAnchor.setDisable(false);
        homeAnchor.setVisible(true);
    }

    public void setupDepartment(String departmentName)
    {
        closeAll();
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
        productAnchor.setVisible(false);
        productAnchor.setDisable(true);
    }

    void onProduct(Product product)
    {
        closeAll();
        productAnchor.setVisible(true);
        productAnchor.setDisable(false);

        setupProduct(product);
    }

    public void setupProduct(Product product)
    {
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
