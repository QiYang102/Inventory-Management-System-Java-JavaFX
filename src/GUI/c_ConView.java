package GUI;

import Product_Class.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

public class c_ConView {
    @FXML
    private TableView<Product> outputTable;

    @FXML
    private TableColumn<Product,Integer> itemNumber;
    
    @FXML
    private TableColumn<Product,String> name;
    
    @FXML
    private TableColumn<Product,Double> price;
    
    @FXML
    private TableColumn<Product,Integer> quantity;
    
    @FXML
    private TableColumn<Product,Boolean> status;
    
    @FXML
    private TableColumn<Product,String> detail;
    
    @FXML
    private TableColumn<Product, String> type;

    @FXML
    private Pane addProductPane;

    @FXML
    private Pane deleteProductPane;

    @FXML
    private Pane updatePane;

    @FXML
    private Pane addStockPane;

    @FXML
    private Pane deductStockPane;

    @FXML
    private Pane deactivatePane;

    @FXML
    private Pane activatePane;
    
    private ArrayList<Product> productList = new ArrayList<Product>();
    private Product selectedProduct;

    /* ----------------------- SETTER ----------------------- */
    public void setProductList(ArrayList<Product> productList){ this.productList = productList; }


    /*
     *  ===================== Product Table Setup =====================
     */
    public void setOutputTable() {
        itemNumber.setCellValueFactory(new PropertyValueFactory<>("productID"));
        name.setCellValueFactory(new PropertyValueFactory<>("productName"));
        type.setCellValueFactory(new PropertyValueFactory<>("productType"));
        price.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        price.setCellFactory(col -> {
            return new TableCell<Product, Double>() {
                @Override
                protected void updateItem(Double item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(String.format("%.2f", item)); // Format to 2 decimal places
                    }
                }
            };
        });
        quantity.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));
        status.setCellValueFactory(new PropertyValueFactory<>("productStatus"));
        detail.setCellValueFactory(new PropertyValueFactory<>("productDetail"));
        outputTable.getItems().addAll(productList);
        
        itemNumber.setStyle("-fx-alignment: CENTER;");
        name.setStyle("-fx-alignment: CENTER;");
        type.setStyle("-fx-alignment: CENTER;");
        price.setStyle("-fx-alignment: CENTER;");
        quantity.setStyle("-fx-alignment: CENTER;");
        status.setStyle("-fx-alignment: CENTER;");
    }
    
    
    /*
     *  ===================== Product Table Mouse Click =====================
     */
    public void rowClick(MouseEvent mouseEvent) {
        selectedProduct = outputTable.getSelectionModel().getSelectedItem();
    }

    
    /*
     *  ===================== Add New Product to Product Table =====================
     */
    public void addTable(Product newProduct) {
        outputTable.getItems().add(newProduct);
        outputTable.refresh();
    }

    
    /*
     *  ===================== Update Product Table =====================
     */
    public void updateTable() {
        outputTable.refresh();
    }


    /*
     *  ===================== Add / Delete Product Setup =====================
     */
    public void addDeleteSetup(){
        deleteProductPane.setVisible(true);
        addProductPane.setVisible(true);
        updatePane.setVisible(false);
        addStockPane.setVisible(false);
        deductStockPane.setVisible(false);
        deactivatePane.setVisible(false);
        activatePane.setVisible(false);
    }
    
    
    /*
     *  ===================== Add Button Click =====================
     */
    public void addProductButtonClick(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/AddDeleteScene.fxml"));
        Parent root2 = loader.load();

        Stage stage2 = new Stage();
        stage2.setTitle("Add Product");
        stage2.setScene(new Scene(root2));
        Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
        stage2.getIcons().add(icon);
        stage2.show();
        stage2.setResizable(false);

        d_ConAddDelete nextController = loader.getController();
        nextController.setProductList(productList);
        nextController.setPrevController(this);
    }

    
    /*
     *  ===================== Delete Button Click =====================
     */
    public void deleteProductButtonClick(ActionEvent actionEvent) throws Exception {
        if(selectedProduct == null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Error.fxml"));
            Parent root2 = loader.load();

            Stage stage2 = new Stage();
            stage2.setTitle("Error");
            stage2.setScene(new Scene(root2));
            Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
            stage2.getIcons().add(icon);
            stage2.show();
            stage2.setResizable(false);
        }
        else{
            productList.remove(selectedProduct);
            outputTable.getItems().remove(selectedProduct); // Remove from TableView
            outputTable.refresh();
        }
    }


    /*
     *  ===================== Update Product Detail Setup =====================
     */
    public void updateSetup(){
        deleteProductPane.setVisible(false);
        addProductPane.setVisible(false);
        addStockPane.setVisible(false);
        deductStockPane.setVisible(false);
        deactivatePane.setVisible(false);
        activatePane.setVisible(false);
        updatePane.setVisible(true);
    }
    
    
    /*
     *  ===================== Update Product Detail Button Click =====================
     */
    public void updateButtonClick(ActionEvent actionEvent) throws Exception {
        if(selectedProduct == null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Error.fxml"));
            Parent root2 = loader.load();

            Stage stage2 = new Stage();
            stage2.setTitle("Error");
            stage2.setScene(new Scene(root2));
            Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
            stage2.getIcons().add(icon);
            stage2.show();
            stage2.setResizable(false);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/UpdateScene.fxml"));
            Parent root2 = loader.load();

            Stage stage2 = new Stage();
            stage2.setTitle("Update Product Detail");
            stage2.setScene(new Scene(root2));
            Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
            stage2.getIcons().add(icon);
            stage2.show();
            stage2.setResizable(false);

            f_ConUpdate nextController = loader.getController();
            nextController.setPrevController(this);
            nextController.setSelectedProduct(selectedProduct);
            nextController.setTextField();
        }
    }


    /*
     *  ===================== Add Stock Setup =====================
     */
    public void addStockSetup(){
        deleteProductPane.setVisible(false);
        addProductPane.setVisible(false);
        updatePane.setVisible(false);
        deductStockPane.setVisible(false);
        deactivatePane.setVisible(false);
        activatePane.setVisible(false);
        addStockPane.setVisible(true);
    }

    /*
     *  ===================== Add Stock Button Click =====================
     */
    public void addStockButtonClick(ActionEvent actionEvent) throws Exception {
        if(selectedProduct == null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Error.fxml"));
            Parent root2 = loader.load();

            Stage stage2 = new Stage();
            stage2.setTitle("Error");
            stage2.setScene(new Scene(root2));
            Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
            stage2.getIcons().add(icon);
            stage2.show();
            stage2.setResizable(false);
        }
        else if(selectedProduct.getProductStatus() == false) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Error2.fxml"));
            Parent root2 = loader.load();

            Stage stage2 = new Stage();
            stage2.setTitle("Error");
            stage2.setScene(new Scene(root2));
            Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
            stage2.getIcons().add(icon);
            stage2.show();
            stage2.setResizable(false);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/AmountScene.fxml"));
            Parent root2 = loader.load();

            Stage stage2 = new Stage();
            stage2.setTitle("Add Stock");
            stage2.setScene(new Scene(root2));
            Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
            stage2.getIcons().add(icon);
            stage2.show();
            stage2.setResizable(false);

            g_ConAmount nextController = loader.getController();
            nextController.setPrevController(this);
            nextController.setSelectedProduct(selectedProduct);
            nextController.setAdd(true);
        }
    }


    /*
     *  ===================== Deduct Stock Setup =====================
     */
    public void deductStockSetup(){
        deleteProductPane.setVisible(false);
        addProductPane.setVisible(false);
        updatePane.setVisible(false);
        addStockPane.setVisible(false);
        activatePane.setVisible(false);
        deactivatePane.setVisible(false);
        deductStockPane.setVisible(true);
    }

    /*
     *  ===================== Deduct Stock Button Click =====================
     */
    public void deductStockButtonClick(ActionEvent actionEvent) throws Exception {
        if(selectedProduct == null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Error.fxml"));
            Parent root2 = loader.load();

            Stage stage2 = new Stage();
            stage2.setTitle("Error");
            stage2.setScene(new Scene(root2));
            Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
            stage2.getIcons().add(icon);
            stage2.show();
            stage2.setResizable(false);
        }
        else if(selectedProduct.getProductStatus() == false) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Error2.fxml"));
            Parent root2 = loader.load();

            Stage stage2 = new Stage();
            stage2.setTitle("Error");
            stage2.setScene(new Scene(root2));
            Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
            stage2.getIcons().add(icon);
            stage2.show();
            stage2.setResizable(false);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/AmountScene.fxml"));
            Parent root2 = loader.load();

            Stage stage2 = new Stage();
            stage2.setTitle("Deduct Stock");
            stage2.setScene(new Scene(root2));
            Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
            stage2.getIcons().add(icon);
            stage2.show();
            stage2.setResizable(false);

            g_ConAmount nextController = loader.getController();
            nextController.setPrevController(this);
            nextController.setSelectedProduct(selectedProduct);
            nextController.setAdd(false);
        }
    }


    /*
     *  ===================== Deactivate / Activate Product Setup =====================
     */
    public void deactivateSetup(){
        deleteProductPane.setVisible(false);
        addProductPane.setVisible(false);
        updatePane.setVisible(false);
        deductStockPane.setVisible(false);
        addStockPane.setVisible(false);
        deactivatePane.setVisible(true);
        activatePane.setVisible(true);
    }

    
    /*
     *  ===================== Activate Product Button Click =====================
     */
    public void activateButtonClick(ActionEvent actionEvent) throws Exception {
        if(selectedProduct == null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Error.fxml"));
            Parent root2 = loader.load();

            Stage stage2 = new Stage();
            stage2.setTitle("Error");
            stage2.setScene(new Scene(root2));
            Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
            stage2.getIcons().add(icon);
            stage2.show();
            stage2.setResizable(false);
        }
        else{
            selectedProduct.setProductStatus(true);
        }
        updateTable();
    }

    
    /*
     *  ===================== Deactivate Product Button Click =====================
     */
    public void deactivateButtonClick(ActionEvent actionEvent) throws Exception {
        if(selectedProduct == null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Error.fxml"));
            Parent root2 = loader.load();

            Stage stage2 = new Stage();
            stage2.setTitle("Error");
            stage2.setScene(new Scene(root2));
            Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
            stage2.getIcons().add(icon);
            stage2.show();
            stage2.setResizable(false);
        }
        else if(selectedProduct.getProductStatus() == false) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Error3.fxml"));
            Parent root2 = loader.load();

            Stage stage2 = new Stage();
            stage2.setTitle("Error");
            stage2.setScene(new Scene(root2));
            Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
            stage2.getIcons().add(icon);
            stage2.show();
            stage2.setResizable(false);
        }
        else{
            selectedProduct.setProductStatus(false);
        }
        updateTable();
    }
}


