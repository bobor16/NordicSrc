/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import dataLayer.ClientController;
import interfaces.iLogic.Ilogic;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import logicLayer.Order;

/**
 * FXML Controller class
 *
 * @author mehgn
 */
public class EmployeeController extends SuperController implements Initializable {

    @FXML
    private Button logOutButton;
    @FXML
    private Button pendingOrderSearchButton;
    @FXML
    private Button showPendingOrderButton;
    @FXML
    private TableView<Order> tableviewPendingOrders;
    @FXML
    private TableColumn<Order, String> tableviewPendingOrdersColumn;
    @FXML
    private Label pendingOrderTitle;
    @FXML
    private Label pendingOrderAmount;
    @FXML
    private Label pendingOrderPricePer;
    @FXML
    private Label pendingOrderPriceTotal;
    @FXML
    private Label pendingOrderCompletionDate;
    @FXML
    private Label pendingOrderDevliviryDate;
    @FXML
    private Label pendingOrderDeadline;
    @FXML
    private TextArea pendingOrderBriefDesc;
    @FXML
    private Button pendingOrderShowImagesButton;
    @FXML
    private Button AcceptButton;
    @FXML
    private Button RejectButton;
    @FXML
    private Label OrderIDLabel1;
    @FXML
    private PasswordField searchAcceptedOrder;
    @FXML
    private Button searchAcceptedOrderButton;
    @FXML
    private Button showAcceptedOrderButton;
    @FXML
    private TableView<?> acceptedOrdersView;
    @FXML
    private TableColumn<?, ?> acceptedOrdersColumn;
    @FXML
    private AnchorPane LogisticsPortalView;
    @FXML
    private Label CompanyNameLabel;
    @FXML
    private Label DeliveryDateLabel;
    @FXML
    private Label ItemQuantityLabel;
    @FXML
    private Label OrderIdLabel;
    @FXML
    private Label OrderStateLabel;
    @FXML
    private Label acceptedOrderTitle;
    @FXML
    private Label acceptedOrderAmount;
    @FXML
    private Label pricePerAcceptedOrders;
    @FXML
    private Label priceTotalAcceptedOrder;
    @FXML
    private Label completionDateAcceptedOrder;
    @FXML
    private Label deliveryDateAcceptedOrder;
    @FXML
    private Label deadLineAcceptedOrder;
    @FXML
    private TextArea briefDescAcceptedOrders;
    @FXML
    private Button showImagesButtonAcceptedOrder;
    @FXML
    private Label OrderIDLabel12;
    @FXML
    private Label manuFactorerLabel;
    @FXML
    private Label pendingOrderCostumer;

    public EmployeeController(Ilogic logic) {
        super(logic);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableviewPendingOrdersColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        displayPendingOrdersInTable();
    }

    @FXML
    private void logOutButtonMethod(ActionEvent event) {
    }

    @FXML
    private void searchPending(ActionEvent event) {
    }

    @FXML
    private void showCaseMethod(ActionEvent event) {
    }

    @FXML
    private void showImagesPendingOrder(ActionEvent event) {
    }

    @FXML
    private void AcceptOnAction(ActionEvent event) {
    }

    @FXML
    private void RejectOnAction(ActionEvent event) {
    }

    @FXML
    private void showImageAcceptedOrder(ActionEvent event) {
    }

    @FXML
    private void searchMethod(ActionEvent event) {
    }

    public ArrayList<Order> getOrderListPending() {
        ClientController cc = new ClientController();
        return cc.getOrderListPending();
    }

    private ObservableList<Order> getOrders() {
        ObservableList<Order> usersObservableList = FXCollections.observableArrayList(getOrderListPending());
        return usersObservableList;
    }

    private void displayPendingOrdersInTable() {
        tableviewPendingOrders.getColumns().clear();
        tableviewPendingOrders.setItems(getOrders());
        tableviewPendingOrders.getColumns().addAll(tableviewPendingOrdersColumn);
        tableviewPendingOrders.getSortOrder().add(tableviewPendingOrdersColumn);
    }
}
