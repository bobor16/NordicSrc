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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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
    private PasswordField searchPendingOrder;
    @FXML
    private TableView<Order> acceptedOrdersView;
    @FXML
    private TableColumn<Order, String> acceptedOrdersColumn;
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
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab pendingOrdersTab;
    @FXML
    private Tab acceptedOrdersTab;
    ApplicationStateHandler stateHandler = new ApplicationStateHandler();

    public EmployeeController(Ilogic logic) {
        super(logic);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        tableviewPendingOrdersColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
//        acceptedOrdersColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
//        displayPendingOrdersInTable();
//        UDKOMMENTER NÅR GETORDERS IKKE RETUNERE NULL I CLIENTHANDLER
    }

    @FXML
    private void logOutButtonMethod(ActionEvent event) {
        stateHandler.setLogInScreen(logOutButton);
    }

    @FXML
    private void showPendingOrder(ActionEvent event) {
        Order order = getSelectedOrder();
        pendingOrderAmount.setText(Integer.toString(order.getAmount()));
        pendingOrderBriefDesc.setText(order.getBriefdescription());
        pendingOrderCompletionDate.setText(order.getCompletionDate());
        pendingOrderCostumer.setText(order.getCustomer());
        pendingOrderDeadline.setText(order.getDeadline());
        pendingOrderDevliviryDate.setText(order.getDeliveryDate());
        pendingOrderPricePer.setText(Double.toString(order.getPriceper()));
        pendingOrderPriceTotal.setText(Double.toString(order.getPricetotal()));
        pendingOrderTitle.setText(order.getTitle());

    }

    @FXML
    private void showAcceptedOrder(ActionEvent event) {
        Order order = getSelectedOrder(); //SCHANGE TO ACCEPTED
        pendingOrderAmount.setText(Integer.toString(order.getAmount()));
        pendingOrderBriefDesc.setText(order.getBriefdescription());
        pendingOrderCompletionDate.setText(order.getCompletionDate());
        pendingOrderCostumer.setText(order.getCustomer());
        pendingOrderDeadline.setText(order.getDeadline());
        pendingOrderDevliviryDate.setText(order.getDeliveryDate());
        pendingOrderPricePer.setText(Double.toString(order.getPriceper()));
        pendingOrderPriceTotal.setText(Double.toString(order.getPricetotal()));
        pendingOrderTitle.setText(order.getTitle());

    }

    @FXML
    private void showImagesPendingOrder(ActionEvent event) {
    }

    @FXML
    private void AcceptOnAction(ActionEvent event) {
        Order order = getSelectedOrder();
        order.setStatus(Boolean.TRUE);
    }

    @FXML
    private void RejectOnAction(ActionEvent event) {
        Order order = getSelectedOrder();
        order.setStatus(Boolean.FALSE);
    }

    @FXML
    private void showImageAcceptedOrder(ActionEvent event) {
    }

    @FXML
    private void searchMethod(ActionEvent event) {
        if (tabPane.getSelectionModel().getSelectedItem() == pendingOrdersTab) {
            if (getSelectedOrder().getTitle().equals(searchPendingOrder.getText())) {
                  tableviewPendingOrders.sort();
                searchPendingOrder();
            }
        } else if (tabPane.getSelectionModel().getSelectedItem() == acceptedOrdersTab) {
            if (getSelectedOrder().getTitle().equals(searchAcceptedOrder.getText())) {
                acceptedOrdersView.sort();
                searchAcceptedOrder();
            }
        }
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
        for (int i = 0; i < getOrders().size(); i++) {
            if (!getOrders().get(i).getStatus()) {
                tableviewPendingOrders.setItems(getOrders());
            } else {
                acceptedOrdersView.setItems(getOrders());
            }
        }
        acceptedOrdersView.getColumns().addAll(acceptedOrdersColumn);
        acceptedOrdersView.getSortOrder().add(acceptedOrdersColumn);
        tableviewPendingOrders.getColumns().addAll(tableviewPendingOrdersColumn);
        tableviewPendingOrders.getSortOrder().add(tableviewPendingOrdersColumn);
    }

    private Order getSelectedOrder() {
        Order selectedOrder;
        if (tabPane.getSelectionModel().getSelectedItem() == pendingOrdersTab) {
            selectedOrder = tableviewPendingOrders.getSelectionModel().getSelectedItem();
        } else {
            selectedOrder = acceptedOrdersView.getSelectionModel().getSelectedItem();
        }
        return selectedOrder;
    }

    private void searchPendingOrder() {
        FilteredList<Order> filteredData = new FilteredList<>(getOrders(), p -> true);

        searchPendingOrder.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(order -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (order.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (order.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Order> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tableviewPendingOrders.comparatorProperty());

        tableviewPendingOrders.setItems(sortedData);
    }

    private void searchAcceptedOrder() {
        FilteredList<Order> filteredData = new FilteredList<>(getOrders(), p -> true);

        searchAcceptedOrder.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(order -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (order.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (order.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Order> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(acceptedOrdersView.comparatorProperty());

        acceptedOrdersView.setItems(sortedData);
    }
}
