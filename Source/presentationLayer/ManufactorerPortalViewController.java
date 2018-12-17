/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import dataLayer.ClientController;
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
    private Button ShowOrderButton;
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
    private AnchorPane OrderView;
    @FXML
    private Label OrderIDLabel112;
    @FXML
    private Label OfferIDLabel1;
    @FXML
    private AnchorPane OfferView;
    @FXML
    private Label OfferIdLabel;
    @FXML
    private AnchorPane LogisticsView;
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
    private AnchorPane EditLogisticsView;
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
    @FXML
    private AnchorPane ShowOrderView;
    @FXML
    private AnchorPane PlaceOfferView;
    @FXML
    private AnchorPane editOfferView;
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
    private Order selectedOrder, selectedApprovedOrder;
    private Offer selectedOffer;
    private File productSpecification;
    ApplicationStateHandler statehandeler = new ApplicationStateHandler();
    @FXML
    private AnchorPane showOrderPane;

    ManufactorerPortalViewController(Ilogic logic) {
        super(logic);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateOrderList();
    }

    @FXML
    private void logOutButtonMethod(ActionEvent event) {
    }

    @FXML
    private void EditOfferOnAction(ActionEvent event) {
        if (!pendingOfferList.getSelectionModel().isEmpty()) {
            PlaceOfferView.setVisible(false);
            ShowOrderView.setVisible(false);
            editOfferView.setVisible(true);
            String[] id = pendingOfferList.getSelectionModel().getSelectedItem().split(" ");

            if (selectedOrder == null || !id[0].equals(Integer.toString(selectedOrder.getId()))) {
                ClientController cc = new ClientController();
                selectedOrder = cc.getOrder(id[0]);
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
    private void PlaceBidOnAction(ActionEvent event) {
        PlaceOfferView.setVisible(true);
        editOfferView.setVisible(false);
        ShowOrderView.setVisible(false);
        ClientController cc = new ClientController();
        String[] id = OrderListView.getSelectionModel().getSelectedItem().split(" ");
        String title = cc.getOrder(id[0]).getTitle();
        int orderId = cc.getOrder(id[0]).getId();
        LocalDate completionDate = EstCompletionDateTextFiield.getValue();
        LocalDate deliveryDate = EstDeliveryDateTextField.getValue();
        OfferIDLabel.setText(title);
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
        cc.createOffer(offer);
        clearCreateOffer();
        updateOrderList();
    }

    @FXML
    private void CancelOnAction(ActionEvent event) {
    }

    @FXML
    private void ViewImagesOnAction(ActionEvent event) {
    }

    @FXML
    private void ViewDocumentOnAction(ActionEvent event) {
    }

    @FXML
    private void ShowOfferOnAction(ActionEvent event) {

    }

    @FXML
    private void acceptOrder(ActionEvent event) {
        ClientController cc = new ClientController();

        if (selectedOrder == null) {
            String[] id = OrderListView.getSelectionModel().getSelectedItem().split(" ");
            selectedOrder = cc.getOrder(id[0]);
            cc.acceptOrder(selectedOrder.getId());
            try {
//                cc.deleteOffer(selectedOrder.getId());
            } catch (Exception e) {
                System.out.println("No offer exists");
            }
        } else {
            System.out.println("LOL");
        }
        clearPendingOrder();
        clearApprovedOrder();
        updateOrderList();
    }

    @FXML
    private void DeleteOfferOnAction(ActionEvent event) {
        ClientController cc = new ClientController();
        if (selectedOffer == null) {
            String[] id = pendingOfferList.getSelectionModel().getSelectedItem().split(" ");
//            cc.deleteOffer(selectedOffer.getOfferID());
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
    }

    @FXML
    private void UpdateLogisticsOnAction(ActionEvent event) {
    }

    @FXML
    private void AddPictureOnAction(ActionEvent event) {
    }

    private void updateOrderList() {
        ClientController cc = new ClientController();
        ArrayList<String> pending = cc.getManufacturerList();
        OrderListView.getItems().clear();
        for (String order : pending) {
            OrderListView.getItems().add(order);
        }
    }

    private void updateOfferLists() {
       ClientController cc = new ClientController();
        ArrayList<String> pending = cc.getCostumerList("pending");
        ArrayList<String> approved = cc.getCostumerList("approved");
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
//        ClientController cc = new ClientController();
//        ArrayList<String> pending = cc.();
//        pendingOfferList.getItems().clear();
//        for (String order : pending) {
//            pendingOfferList.getItems().add(order);
//        }
    }

    @FXML
    private void ShowOrderOnAction(ActionEvent event) {
        PlaceOfferView.setVisible(false);
        ShowOrderView.setVisible(true);
        String[] id = OrderListView.getSelectionModel().getSelectedItem().split(" ");

        if (selectedOrder == null || !id[0].equals(Integer.toString(selectedOrder.getId()))) {
            ClientController cc = new ClientController();
            selectedOrder = cc.getOrder(id[0]);
        }

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
    private void showApprovedMethod(ActionEvent event) {
        PlaceOfferView.setVisible(false);
        ShowOrderView.setVisible(true);
        ClientController cc = new ClientController();
        String[] id = acceptOfferList.getSelectionModel().getSelectedItem().split(" ");
        selectedApprovedOrder = cc.getOrder(id[0]);

        TitelLabel.setText(selectedApprovedOrder.getTitle());
        AmountLabel.setText(Integer.toString(selectedApprovedOrder.getAmount()));
        PricePerLabel.setText(Double.toString(selectedApprovedOrder.getPriceper()));
        PriceTotalLabel.setText(Double.toString(selectedApprovedOrder.getPricetotal()));
        CompletionDateLabel.setText(selectedApprovedOrder.getCompletionDate());
        DeliveryDateLabel.setText(selectedApprovedOrder.getDeliveryDate());
        DeadlineLabel.setText("");
        DescriptionTextArea.setText(selectedApprovedOrder.getBriefdescription());
        OfferIdLabel.setText(Integer.toString(selectedApprovedOrder.getId()));
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
        selectedApprovedOrder = null;
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

    @FXML
    private void deleteOrderButtonOnAction(ActionEvent event) {
        ClientController cc = new ClientController();
        if (selectedOrder == null) {
            String[] id = OrderListView.getSelectionModel().getSelectedItem().split(" ");
            cc.deleteOrder(id[0]);
        } else {
            cc.deleteOrder(Integer.toString(selectedOrder.getId()));
        }
        clearPendingOrder();
        clearApprovedOrder();
        updateOrderList();
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
