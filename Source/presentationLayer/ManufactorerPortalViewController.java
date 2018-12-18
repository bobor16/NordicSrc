/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import javafx.stage.FileChooser;
import javafx.stage.Window;
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
    @FXML
    private Label orderIDLabel;
    @FXML
    private Label orderTitle;
    @FXML
    private Label orderAmount;
    @FXML
    private Label orderPricePer;
    @FXML
    private Label orderPriceTotal;
    @FXML
    private Label orderCompletionDate;
    @FXML
    private Label orderDeliveryDate;
    @FXML
    private Label orderDeadline;
    @FXML
    private Label orderBD;
    @FXML
    private Label pendingID;
    @FXML
    private Label pendingTitle;
    @FXML
    private Label pendingAmount;
    @FXML
    private Label pendingPricePer;
    @FXML
    private Label pendingPriceTotal;
    @FXML
    private Label pendingCompletionDate;
    @FXML
    private Label pendingDeliveryDate;
    @FXML
    private Label pendingDeadline;
    @FXML
    private Label pendingBD;
    @FXML
    private Label offerEditID;
    @FXML
    private TextField offerEditAmount;
    @FXML
    private TextField offerEditPricePer;
    @FXML
    private TextField offerEditPriceTotal;
    @FXML
    private DatePicker offerEditCompletionDate;
    @FXML
    private DatePicker offerEditDeliveryDate;
    @FXML
    private TextArea offerEditBD;
    @FXML
    private Label offerAcceptedID;
    @FXML
    private Label offerAcceptedTitle;
    @FXML
    private Label offerAcceptedAmount;
    @FXML
    private Label offerAcceptedPricePer;
    @FXML
    private Label offerAcceptedPriceTotal;
    @FXML
    private Label offerAcceptedCompletionDate;
    @FXML
    private Label offerAcceptedDeliveryDate;
    @FXML
    private Label offerAcceptedDeadline;
    @FXML
    private Label offerAcceptedBD;

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
        LogisticsView.setVisible(false);
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
            selectedOffer = logic.getOffer(id[0]);
            offerEditAmount.setText(Integer.toString(selectedOffer.getAmount()));
            offerEditPricePer.setText(Double.toString(selectedOffer.getPriceper()));
            offerEditPriceTotal.setText(Double.toString(selectedOffer.getPricetotal()));
            offerEditCompletionDate.setValue(LocalDate.parse(selectedOffer.getCompletionDate()));
            //orderEditDeadline.setValue();
            offerEditDeliveryDate.setValue(LocalDate.parse(selectedOffer.getDeliveryDate()));
            offerEditID.setText(Integer.toString(selectedOffer.getOfferID()));
            offerEditBD.setText(selectedOffer.getBriefDescription());
            productSpecification = new File(selectedOffer.getPsName());
            FileOutputStream fos;
            try {
                fos = new FileOutputStream(productSpecification);
                fos.write(selectedOffer.getPsBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    private void SearchOnAction(ActionEvent event) {
    }

    @FXML
    private void ShowImagesOnAction(ActionEvent event) {
    }

    @FXML
    private void ShowDocumentOnAction(ActionEvent event) {
        new Thread(() -> {
            String[] tempName = selectedOrder.getPsname().split("\\.");
            try {
                File temp = File.createTempFile(tempName[0], "." + tempName[1]);
                temp.deleteOnExit();
                FileOutputStream fos = new FileOutputStream(temp);
                fos.write(selectedOrder.getPsBytes());

                if (!Desktop.isDesktopSupported()) {
                    System.out.println("Desktop not supported");
                    return;
                }

                Desktop desktop = Desktop.getDesktop();

                if (temp.canRead()) {
                    desktop.open(temp);
                    System.out.println("Should show the file: " + temp.getName());
                } else {
                    System.out.println("Couldn't read file");
                }
                temp.deleteOnExit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @FXML
    private void viewDocumentOnAction(ActionEvent event) {
        new Thread(() -> {
            String[] tempName = selectedOffer.getPsName().split("\\.");
            try {
                File temp = File.createTempFile(tempName[0], "." + tempName[1]);
                temp.deleteOnExit();
                FileOutputStream fos = new FileOutputStream(temp);
                fos.write(selectedOffer.getPsBytes());

                if (!Desktop.isDesktopSupported()) {
                    System.out.println("Desktop not supported");
                    return;
                }

                Desktop desktop = Desktop.getDesktop();

                if (temp.canRead()) {
                    desktop.open(temp);
                    System.out.println("Should show the file: " + temp.getName());
                } else {
                    System.out.println("Couldn't read file");
                }
                temp.deleteOnExit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
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
            String[] id = OrderListView.getSelectionModel().getSelectedItem().split(" ");
            if (selectedOrder == null || !id[0].equals(Integer.toString(selectedOrder.getId()))) {
                selectedOrder = logic.getOrder(id[0]);
            }
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
            updateOfferLists();
        } catch (NullPointerException e) {
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
    private void acceptOrder(ActionEvent event) {
        try {
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
        } catch (NullPointerException e) {
            System.out.println("No order selected");
        }
    }

    @FXML
    private void DeleteOfferOnAction(ActionEvent event) {
        try {
            String[] id = pendingOfferList.getSelectionModel().getSelectedItem().split(" ");
            logic.deleteOffer(Integer.parseInt(id[0]));
            clearPendingOrder();
            clearApprovedOrder();
            updateOfferLists();
        } catch (NullPointerException e) {
            System.out.println("No offer selected");
        }
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
        try {
            Offer updatedOffer = new Offer(selectedOffer.getOrderID(), Integer.parseInt(offerEditAmount.getText()), Double.parseDouble(offerEditPricePer.getText()), Double.parseDouble(offerEditPriceTotal.getText()), offerEditCompletionDate.getValue().toString(), offerEditDeliveryDate.getValue().toString(), offerEditBD.getText(), productSpecification.getName());
            updatedOffer.setOfferID(Integer.parseInt(offerEditID.getText()));
            try {
                updatedOffer.setPsBytes(Files.readAllBytes(productSpecification.toPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            logic.updateOffer(updatedOffer);
            System.out.println("Order updated");
            updateOrderList();
        } catch (NullPointerException e) {
            System.out.println("No offer selected");
            e.printStackTrace();
        }
    }

    @FXML
    private void AddPictureOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Product Specification");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Product Image", "*.jpg"));
        Node source = (Node) event.getSource();
        Window stage = source.getScene().getWindow();
        productSpecification = fileChooser.showOpenDialog(stage);
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
    private void showOrderOnAction(ActionEvent event) {
        showOrderEditView.setVisible(false);
        ShowOrderView.setVisible(true);
        try {
            String[] id = OrderListView.getSelectionModel().getSelectedItem().split(" ");
            selectedOrder = logic.getOrder(id[0]);
            System.out.println(selectedOrder.getAmount());
            System.out.println(selectedOrder.getBriefdescription());
            System.out.println(selectedOrder.getCompletionDate());
            System.out.println(selectedOrder.getDeadline());
            orderIDLabel.setText(Integer.toString(selectedOrder.getId()));
            orderTitle.setText(selectedOrder.getTitle());
            orderAmount.setText(Integer.toString(selectedOrder.getAmount()));
            orderPricePer.setText(Double.toString(selectedOrder.getPriceper()));
            orderPriceTotal.setText(Double.toString(selectedOrder.getPricetotal()));
            orderCompletionDate.setText(selectedOrder.getCompletionDate());
            orderDeliveryDate.setText(selectedOrder.getDeliveryDate());
            orderDeadline.setText(selectedOrder.getDeadline());
            orderBD.setText(selectedOrder.getBriefdescription());
        } catch (NullPointerException e) {
            System.out.println("No order selected");
        }
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
        try {
            String[] id = pendingOfferList.getSelectionModel().getSelectedItem().split(" ");
            selectedOffer = logic.getOffer(id[0]);
            pendingTitle.setText(selectedOffer.getTitle());
            pendingAmount.setText(Integer.toString(selectedOffer.getAmount()));
            pendingPricePer.setText(Double.toString(selectedOffer.getPriceper()));
            pendingPriceTotal.setText(Double.toString(selectedOffer.getPricetotal()));
            pendingCompletionDate.setText(selectedOffer.getCompletionDate());
            pendingDeliveryDate.setText(selectedOffer.getDeliveryDate());
            pendingDeadline.setText("");
            pendingBD.setText(selectedOffer.getBriefDescription());
            pendingID.setText(Integer.toString(selectedOffer.getOfferID()));
        } catch (NullPointerException e) {
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
        try {
            String[] id = acceptOfferList.getSelectionModel().getSelectedItem().split(" ");
            selectedOffer = logic.getOffer(id[0]);
            selectedOrder = logic.getOrder(Integer.toString(selectedOffer.getOrderID()));
            offerAcceptedTitle.setText(selectedOffer.getTitle());
            offerAcceptedAmount.setText(Integer.toString(selectedOffer.getAmount()));
            offerAcceptedPricePer.setText(Double.toString(selectedOffer.getPriceper()));
            offerAcceptedPriceTotal.setText(Double.toString(selectedOffer.getPricetotal()));
            offerAcceptedCompletionDate.setText(selectedOffer.getCompletionDate());
            offerAcceptedDeliveryDate.setText(selectedOffer.getDeliveryDate());
            offerAcceptedDeadline.setText("");
            offerAcceptedBD.setText(selectedOffer.getBriefDescription());
            offerAcceptedID.setText(Integer.toString(selectedOffer.getOfferID()));
        } catch (NullPointerException e) {
            System.out.println("No offer selected");
        }

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
        pendingTitle.setText("");
        pendingAmount.setText("");
        pendingPricePer.setText("");
        pendingPriceTotal.setText("");
        pendingCompletionDate.setText("");
        pendingDeliveryDate.setText("");
        pendingDeadline.setText("");
        pendingBD.setText("");
        pendingID.setText("");
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
