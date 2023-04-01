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
        Product chips = new Product("Chips", "123456789012", "123456789", "Grocery", 3, 3, 3, 12, 2.99);
        Product cookies = new Product("Cookies", "123456789013", "123456780", "Grocery", 3, 3, 3, 12, 2.99);
        Product soup = new Product("Soup", "123456789014", "123456781", "Grocery", 3, 3, 3, 12, 2.99);

        store.addItem(chips);
        store.addItem(cookies);
        store.addItem(soup);
        setupHome();
    }
}
