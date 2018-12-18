/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import interfaces.iLogic.Ilogic;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.DatePicker;
import logicLayer.Offer;
import logicLayer.Order;
import logicLayer.User;

/**
 * FXML Controller class
 *
 * @author rasmu
 */
public class ManufactorerPortalViewController extends SuperController implements Initializable {

    @FXML
    private Button logOutButton;
    @FXML
    private PasswordField SearchField;
    @FXML
    private ListView<String> OrderListView;
    @FXML
    private ListView<String> pendingOfferList;
    @FXML
    private Button showOfferPending;
    @FXML
    private Button showOfferAccepted;
    @FXML
    private Label TitelLabel;
    @FXML
    private Label AmountLabel;
    @FXML
    private Label PricePerLabel;
    @FXML
    private Label PriceTotalLabel;
    @FXML
    private Label CompletionDateLabel;
    @FXML
    private Label DeliveryDateLabel;
    @FXML
    private Label DeadlineLabel;
    @FXML
    private TextArea DescriptionTextArea;
    @FXML
    private Button ShowImagesButton;
    @FXML
    private Button ShowDocumentButton;
    @FXML
    private Label OrderIDLabel;
    @FXML
    private Label OfferIDLabel;
    @FXML
    private TextField AmountTextField;
    @FXML
    private TextField PricePerTextField;
    @FXML
    private TextField PriceTotalTextField;
    @FXML
    private DatePicker EstCompletionDateTextFiield;
    @FXML
    private DatePicker EstDeliveryDateTextField;
    @FXML
    private TextArea DescriptionField;
    @FXML
    private TextField AmountTextField1;
    @FXML
    private TextField PricePerTextField1;
    @FXML
    private TextField PriceTotalTextField1;
    @FXML
    private DatePicker EstCompletionDateTextFiield1;
    @FXML
    private DatePicker EstDeliveryDateTextField1;
    @FXML
    private TextArea DescriptionField1;
    @FXML
    private Button AddPictureButton;
    @FXML
    private Button AddDocumentOnAction;
    @FXML
    private Button PlaceBidButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SearchButton;
    @FXML
    private Button ViewImagesButton;
    @FXML
    private Button ViewDocumentButton;
    @FXML
    private Button ShowOfferButton;
    @FXML
    private Button EditOfferButton;
    @FXML
    private Button DeleteOfferButton;
    @FXML
    private ListView<String> acceptOfferList;
    @FXML
    private AnchorPane showPlaceOfferView;
    @FXML
    private AnchorPane editOfferView;
    @FXML
    private AnchorPane ShowOrderView;
    @FXML
    private AnchorPane showOrderEditView;
    @FXML
    private AnchorPane acceptedOfferView;
    @FXML
    private AnchorPane EditLogisticsView;
    @FXML
    private AnchorPane LogisticsView;
    @FXML
    private Label OrderIDLabel112;
    @FXML
    private Label OfferIDLabel1;
    @FXML
    private Label OfferIdLabel;
    @FXML
    private Label CompanyNameLabel1;
    @FXML
    private Label OrderIdLabel;
    @FXML
    private Label ItemQuantityLabel;
    @FXML
    private HBox OverdueLabel1;
    @FXML
    private Label OverdueDateLabel;
    @FXML
    private Label OrderStateLabel;
    @FXML
    private Label OrderIDLabel2;
    @FXML
    private Label CompanyNameLabel1111;
    @FXML
    private TextField OverdueDateTextField;
    @FXML
    private RadioButton PreproductionRadioButton;
    @FXML
    private RadioButton PRoductionRadioButton;
    @FXML
    private RadioButton PackagingRadioButton;
    @FXML
    private RadioButton DeliveryRadioButton;
    @FXML
    private Button SaveButton;
    @FXML
    private Button acceptOrderButton;
    @FXML
    private Button ShowLogisticsButton;
    @FXML
    private Button UpdateLogisticsButton;

    ApplicationStateHandler statehandler = new ApplicationStateHandler();
    @FXML
    private TextField orderEditTitle;
    @FXML
    private DatePicker orderEditDeadline;
    @FXML
    private TextField orderEditAmount;
    @FXML
    private TextField orderEditPricePer;
    @FXML
    private TextField orderEditPriceTotal;
    @FXML
    private DatePicker orderEditCompletionDate;
    @FXML
    private DatePicker orderEditDeliveryDate;
    @FXML
    private TextArea orderEditBD;
    private Order selectedOrder;
    private Offer selectedOffer, selectedAcceptedOffer;
    private File productSpecification;
    ApplicationStateHandler stateHandler = new ApplicationStateHandler();

    ManufactorerPortalViewController(Ilogic logic) {
        super(logic);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPlaceOfferView.setVisible(false);
        editOfferView.setVisible(false);
        acceptedOfferView.setVisible(true);
        EditLogisticsView.setVisible(false);
        LogisticsView.setVisible(true);
        ShowOrderView.setVisible(true);
        updateOrderList();
        updateOfferLists();
    }

    @FXML
    private void logOutButtonMethod(ActionEvent event) {
        stateHandler.setLogInScreen(logOutButton);
    }

    @FXML
    private void EditOfferOnAction(ActionEvent event) {
        showPlaceOfferView.setVisible(false);
        editOfferView.setVisible(true);
        acceptedOfferView.setVisible(false);
        EditLogisticsView.setVisible(false);
        LogisticsView.setVisible(false);
        ShowOrderView.setVisible(false);
        showOrderEditView.setVisible(false);
        if (!pendingOfferList.getSelectionModel().isEmpty()) {
            showPlaceOfferView.setVisible(false);
            editOfferView.setVisible(true);
            String[] id = pendingOfferList.getSelectionModel().getSelectedItem().split(" ");
            if (selectedOffer == null || !id[0].equals(Integer.toString(selectedOffer.getOfferID()))) {
                selectedOffer = logic.getOffer(id[0]);
            }
            orderEditTitle.setText(selectedOrder.getTitle());
            orderEditAmount.setText(Integer.toString(selectedOrder.getAmount()));
            orderEditPricePer.setText(Double.toString(selectedOrder.getPriceper()));
            orderEditPriceTotal.setText(Double.toString(selectedOrder.getPricetotal()));
            orderEditCompletionDate.setValue(LocalDate.parse(selectedOrder.getCompletionDate()));
            orderEditDeadline.setValue(LocalDate.parse(selectedOrder.getDeadline()));
            orderEditDeliveryDate.setValue(LocalDate.parse(selectedOrder.getDeliveryDate()));
            OfferIDLabel1.setText(Integer.toString(selectedOrder.getId()));
            orderEditBD.setText(selectedOrder.getBriefdescription());
            productSpecification = new File(selectedOrder.getPsname());
            FileOutputStream fos;
            try {
                fos = new FileOutputStream(productSpecification);
                fos.write(selectedOrder.getPsBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    private void SearchOnAction(ActionEvent event) {
    }

    @FXML
    private void showOrderOnAction(ActionEvent event) {

    }

    @FXML
    private void ShowImagesOnAction(ActionEvent event) {
    }

    @FXML
    private void ShowDocumentOnAction(ActionEvent event) {
    }

    @FXML
    private void AddDocumentOnAction(ActionEvent event) {
    }

    @FXML
    private void showBidView(ActionEvent event) {
        showPlaceOfferView.setVisible(false);
        editOfferView.setVisible(false);
        acceptedOfferView.setVisible(false);
        EditLogisticsView.setVisible(false);
        LogisticsView.setVisible(false);
        ShowOrderView.setVisible(false);
        showOrderEditView.setVisible(true);
        String[] id = OrderListView.getSelectionModel().getSelectedItem().split(" ");
        if (selectedOrder == null || !id[0].equals(Integer.toString(selectedOrder.getId()))) {
            selectedOrder = logic.getOrder(id[0]);
        }
        AmountTextField.setText(Integer.toString(selectedOrder.getAmount()));
        PricePerTextField.setText(Double.toString(selectedOrder.getPriceper()));
        PriceTotalTextField.setText(Double.toString(selectedOrder.getPricetotal()));
        EstCompletionDateTextFiield.setValue(LocalDate.parse(selectedOrder.getCompletionDate()));
        EstDeliveryDateTextField.setValue(LocalDate.parse(selectedOrder.getDeliveryDate()));
        DescriptionField.setText(selectedOrder.getBriefdescription());
        OfferIDLabel.setText(selectedOrder.getTitle());
    }

    @FXML
    private void PlaceBidOnAction(ActionEvent event) {
        try {
            if (selectedOrder == null) {
                String[] id = OrderListView.getSelectionModel().getSelectedItem().split(" ");
                String title = logic.getOrder(id[0]).getTitle();
                int orderId = logic.getOrder(id[0]).getId();
                LocalDate completionDate = EstCompletionDateTextFiield.getValue();
                LocalDate deliveryDate = EstDeliveryDateTextField.getValue();
                int amount = Integer.parseInt(AmountTextField.getText());
                double pricePer = Double.parseDouble(PricePerTextField.getText());
                double priceTotal = Double.parseDouble(PriceTotalTextField.getText());
                String bd = DescriptionField.getText().replaceAll("\'", "\\" + "\'");
                Offer offer = new Offer(orderId, amount, pricePer, priceTotal, completionDate.toString(), deliveryDate.toString(), bd, productSpecification.getName());
                try {
                    offer.setPsBytes(Files.readAllBytes(productSpecification.toPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                logic.createOffer(offer);
                clearCreateOffer();
                updateOrderList();
            }
        } catch(NullPointerException e){
            System.out.println("No order selected");
        }
    }

    @FXML
    private void CancelOnAction(ActionEvent event) {
        showPlaceOfferView.setVisible(true);
        editOfferView.setVisible(false);
        acceptedOfferView.setVisible(false);
        EditLogisticsView.setVisible(false);
        LogisticsView.setVisible(false);
        ShowOrderView.setVisible(false);
        showOrderEditView.setVisible(false);
    }

    @FXML
    private void ViewImagesOnAction(ActionEvent event) {
    }

    @FXML
    private void ViewDocumentOnAction(ActionEvent event) {
    }

    @FXML
    private void acceptOrder(ActionEvent event) {

        if (selectedOrder == null) {

            String[] id = OrderListView.getSelectionModel().getSelectedItem().split(" ");
            String UP = logic.getUser() + " " + id[0];
            logic.acceptOffer(UP);
            try {
                logic.deleteOffer(Integer.parseInt(id[0]));
            } catch (Exception e) {
                System.out.println("No offer exists");
            }
        } else {
            logic.deleteOffer(selectedOrder.getId());
            logic.acceptOffer(selectedOrder.getTitle());
        }
        clearPendingOrder();
        clearApprovedOrder();
        updateOrderList();
    }

    @FXML
    private void DeleteOfferOnAction(ActionEvent event) {
        if (selectedOffer == null) {
            String[] id = pendingOfferList.getSelectionModel().getSelectedItem().split(" ");
            logic.deleteOffer(selectedOffer.getOrderID());
        } else {
            System.out.println("Something went wrong");
        }
        clearPendingOrder();
        clearApprovedOrder();
        updateOrderList();
    }

    @FXML
    private void SaveOnAction(ActionEvent event) {
    }

    @FXML
    private void ShowLogisticsOnAction(ActionEvent event) {
        showPlaceOfferView.setVisible(false);
        editOfferView.setVisible(false);
        acceptedOfferView.setVisible(false);
        EditLogisticsView.setVisible(false);
        LogisticsView.setVisible(true);
        ShowOrderView.setVisible(false);
        showOrderEditView.setVisible(false);
    }

    @FXML
    private void UpdateLogisticsOnAction(ActionEvent event) {
    }

    @FXML
    private void saveOffer(ActionEvent event) {
        Offer updatedOffer = new Offer(selectedOffer.getOrderID(), Integer.parseInt(AmountTextField1.getText()), Double.parseDouble(PricePerTextField1.getText()), Double.parseDouble(PriceTotalTextField1.getText()), EstCompletionDateTextFiield1.toString(), EstDeliveryDateTextField1.toString(), DescriptionField1.getText(), productSpecification.getName());
        try {
            updatedOffer.setPsBytes(Files.readAllBytes(productSpecification.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logic.updateOffer(updatedOffer);
        System.out.println("Order updated");
        updateOrderList();
    }

    @FXML
    private void AddPictureOnAction(ActionEvent event) {
    }

    private void updateOrderList() {
        ArrayList<String> pending = logic.getManufacturerList();
        OrderListView.getItems().clear();
        for (String order : pending) {
            OrderListView.getItems().add(order);
        }
    }

    private void updateOfferLists() {
        ArrayList<String> pending = logic.getOfferList("pending");
        ArrayList<String> approved = logic.getOfferList("approved");
        pendingOfferList.getItems().clear();
        acceptOfferList.getItems().clear();

        for (String order : pending) {
            pendingOfferList.getItems().add(order);
        }
        for (String order : approved) {
            acceptOfferList.getItems().add(order);
        }
    }

    private void updatePendingAndApprovedList() {
        ArrayList<Order> pending = logic.getOrderListPending();
        pendingOfferList.getItems().clear();
        for (Order order : pending) {
            pendingOfferList.getItems().add(order.getTitle());
        }
    }

    @FXML
    private void ShowOrderOnAction(ActionEvent event) {
        showPlaceOfferView.setVisible(false);
        editOfferView.setVisible(false);
        acceptedOfferView.setVisible(false);
        EditLogisticsView.setVisible(false);
        LogisticsView.setVisible(false);
        showOrderEditView.setVisible(false);
        ShowOrderView.setVisible(true);
        String[] id = OrderListView.getSelectionModel().getSelectedItem().split(" ");
        if (selectedOrder == null || !id[0].equals(Integer.toString(selectedOrder.getId()))) {
            selectedOrder = logic.getOrder(id[0]);
        }
        System.out.println(selectedOrder.getAmount());
        TitelLabel.setText(selectedOrder.getTitle());
        AmountLabel.setText(Integer.toString(selectedOrder.getAmount()));
        PricePerLabel.setText(Double.toString(selectedOrder.getPriceper()));
        PriceTotalLabel.setText(Double.toString(selectedOrder.getPricetotal()));
        CompletionDateLabel.setText(selectedOrder.getCompletionDate());
        DeliveryDateLabel.setText(selectedOrder.getDeliveryDate());
        DeadlineLabel.setText(selectedOrder.getDeadline());
        DescriptionTextArea.setText(selectedOrder.getBriefdescription());
        OrderIDLabel.setText(Integer.toString(selectedOrder.getId()));
    }

    @FXML
    private void ShowOfferOnActionPending(ActionEvent event) {
        showPlaceOfferView.setVisible(true);
        editOfferView.setVisible(false);
        acceptedOfferView.setVisible(false);
        EditLogisticsView.setVisible(false);
        showOrderEditView.setVisible(false);
        LogisticsView.setVisible(false);
        ShowOrderView.setVisible(false);
        if(selectedOffer == null){
        String[] id = pendingOfferList.getSelectionModel().getSelectedItem().split(" ");
        System.out.println(id[0]);
        selectedAcceptedOffer = logic.getOffer(id[0]);

        TitelLabel.setText(selectedAcceptedOffer.getTitle());
        AmountLabel.setText(Integer.toString(selectedAcceptedOffer.getAmount()));
        PricePerLabel.setText(Double.toString(selectedAcceptedOffer.getPriceper()));
        PriceTotalLabel.setText(Double.toString(selectedAcceptedOffer.getPricetotal()));
        CompletionDateLabel.setText(selectedAcceptedOffer.getCompletionDate());
        DeliveryDateLabel.setText(selectedAcceptedOffer.getDeliveryDate());
        DeadlineLabel.setText("");
        DescriptionTextArea.setText(selectedAcceptedOffer.getBriefDescription());
        OfferIdLabel.setText(Integer.toString(selectedAcceptedOffer.getOfferID()));
        } else{
            System.out.println("No offer selected");
        }
    }

    @FXML
    private void ShowOfferOnActionAccepted(ActionEvent event) {
        showPlaceOfferView.setVisible(false);
        editOfferView.setVisible(false);
        acceptedOfferView.setVisible(true);
        EditLogisticsView.setVisible(false);
        LogisticsView.setVisible(false);
        ShowOrderView.setVisible(false);
        showOrderEditView.setVisible(false);
         if(selectedOffer == null){
        String[] id = acceptOfferList.getSelectionModel().getSelectedItem().split(" ");
        selectedOffer = logic.getOffer(id[0]);
        TitelLabel.setText(selectedOffer.getTitle());
        AmountLabel.setText(Integer.toString(selectedOffer.getAmount()));
        PricePerLabel.setText(Double.toString(selectedOffer.getPriceper()));
        PriceTotalLabel.setText(Double.toString(selectedOffer.getPricetotal()));
        CompletionDateLabel.setText(selectedOffer.getCompletionDate());
        DeliveryDateLabel.setText(selectedOffer.getDeliveryDate());
        DeadlineLabel.setText("");
        DescriptionTextArea.setText(selectedOffer.getBriefDescription());
        OfferIdLabel.setText(Integer.toString(selectedOffer.getOfferID()));
         }
         System.out.println("No offer selected");
    }

    private void clearApprovedOrder() {
        TitelLabel.setText("");
        AmountLabel.setText("");
        PricePerLabel.setText("");
        PriceTotalLabel.setText("");
        CompletionDateLabel.setText("");
        DeliveryDateLabel.setText("");
        DeadlineLabel.setText("");
        DescriptionTextArea.setText("");
        OfferIdLabel.setText("");
        productSpecification = null;
        selectedAcceptedOffer = null;
    }

    private void clearPendingOrder() {
        TitelLabel.setText("");
        AmountLabel.setText("");
        PricePerLabel.setText("");
        PriceTotalLabel.setText("");
        CompletionDateLabel.setText("");
        DeliveryDateLabel.setText("");
        DeadlineLabel.setText("");
        DescriptionTextArea.setText("");
        OrderIDLabel.setText("");
        productSpecification = null;
        selectedOrder = null;
    }

    private void clearCreateOffer() {
        PricePerTextField.clear();
        AmountTextField.clear();
        DescriptionField.clear();
        PriceTotalTextField.clear();
        OfferIDLabel.setText("");
        EstCompletionDateTextFiield.getEditor().clear();
        EstDeliveryDateTextField.getEditor().clear();
    }
}
