package presentationLayer;

import dataLayer.ClientController;
import interfaces.iLogic.Ilogic;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import logicLayer.Offer;
import logicLayer.Order;

public class CustomerPortalViewController extends SuperController implements Initializable {

    @FXML
    private Button logOutButton;

    ApplicationStateHandler stateHandler = new ApplicationStateHandler();
    @FXML
    private AnchorPane CreateOrderView;
    @FXML
    private Label OrderIDLabel;
    @FXML
    private Label OrderIDLabel1;
    @FXML
    private AnchorPane EditOrderView;
    @FXML
    private Label OrderIDLabel2;
    @FXML
    private Button searchButton111;
    @FXML
    private ListView<String> CaseListView111;
    @FXML
    private Button showCaseButton111;
    @FXML
    private AnchorPane OfferView;
    @FXML
    private Label ManfCompanyNameLabel;
    @FXML
    private ListView<String> CaseListView112;
    @FXML
    private Label ProductPriceLabel;
    @FXML
    private Button ShowPicturesButton;
    @FXML
    private Button ShowDocumentButton;
    @FXML
    private Button AcceptButton;
    @FXML
    private Button DeclineButton;
    @FXML
    private Label OrderIDLabel11;
    @FXML
    private Button ShowofferButton;
    @FXML
    private Button searchButton1;
    @FXML
    private ListView<?> CaseListView11;
    @FXML
    private Button showCaseButton1;
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
    private Label OrderIDLabel12;
    @FXML
    private AnchorPane LogisticsView;
    @FXML
    private Label CompanyNameLabel1;
    @FXML
    private Label OrderIdLabel1;
    @FXML
    private Label DeliveryDateLabel1;
    @FXML
    private Label ItemQuantityLabel1;
    @FXML
    private HBox OverdueLabel1;
    @FXML
    private Label OverdueDateLabel;
    @FXML
    private Label OrderStateLabel1;
    @FXML
    private Button ShowLogisticsButton;
    @FXML
    private AnchorPane ViewOrderView;
    @FXML
    private Button deleteOrderButton;
    @FXML
    private Button editOrderButton;
    @FXML
    private Text showCaseBDText;
    @FXML
    private Label showCaseTitle;
    @FXML
    private Label showCaseAmount;
    @FXML
    private Label showCasePricePer;
    @FXML
    private Label showCasePriceTotal;
    @FXML
    private Label showCaseCompletionDate;
    @FXML
    private Label showCaseDeliveryDate;
    @FXML
    private Label showCaseDeadline;
    @FXML
    private TextField createOrderTitle;
    @FXML
    private TextField createOrderAmount;
    @FXML
    private TextField createOrderPricePer;
    @FXML
    private TextField createOrderPriceTotal;
    @FXML
    private DatePicker createOrderDeadline;
    @FXML
    private DatePicker createOrderCompletionDate;
    @FXML
    private DatePicker createOrderDeliveryDate;
    @FXML
    private TextArea createOrderBriefDescription;
    @FXML
    private ListView<String> CaseListView1111;
    @FXML
    private AnchorPane showApproved;
    @FXML
    private Label approvedTitle;
    @FXML
    private Label approvedAmount;
    @FXML
    private Label approvedPricePer;
    @FXML
    private Label approvedPriceTotal;
    @FXML
    private Label approvedCompletionDate;
    @FXML
    private Label approvedDeliveryDate;
    @FXML
    private Label approvedDeadline;
    @FXML
    private Label approvedBD;
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

    private File productSpecification;
    private Order selectedOrder, selectedApprovedOrder;
    private Offer selectedOffer;

    public CustomerPortalViewController(Ilogic logic) {
        super(logic);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        updateOrderList();
    }

    public void loadSceneOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    private void searchMethod(ActionEvent event) {
    }

    @FXML
    private void showPendingMethod(ActionEvent event) {
        EditOrderView.setVisible(false);
        CreateOrderView.setVisible(false);
        ViewOrderView.setVisible(true);
        String[] id = CaseListView111.getSelectionModel().getSelectedItem().split(" ");

        if (selectedOrder == null || !id[0].equals(Integer.toString(selectedOrder.getId()))) {
            selectedOrder = logic.getOrder(id[0]);
        }

        showCaseTitle.setText(selectedOrder.getTitle());
        showCaseAmount.setText(Integer.toString(selectedOrder.getAmount()));
        showCasePricePer.setText(Double.toString(selectedOrder.getPriceper()));
        showCasePriceTotal.setText(Double.toString(selectedOrder.getPricetotal()));
        showCaseCompletionDate.setText(selectedOrder.getCompletionDate());
        showCaseDeliveryDate.setText(selectedOrder.getDeliveryDate());
        showCaseDeadline.setText("");
        showCaseBDText.setText(selectedOrder.getBriefdescription());
        OrderIDLabel1.setText(Integer.toString(selectedOrder.getId()));
    }

    @FXML
    private void showApprovedMethod(ActionEvent event) {
        OfferView.setVisible(false);
        showApproved.setVisible(true);
        String[] id = CaseListView1111.getSelectionModel().getSelectedItem().split(" ");
        selectedApprovedOrder = logic.getOrder(id[0]);

        approvedTitle.setText(selectedApprovedOrder.getTitle());
        approvedAmount.setText(Integer.toString(selectedApprovedOrder.getAmount()));
        approvedPricePer.setText(Double.toString(selectedApprovedOrder.getPriceper()));
        approvedPriceTotal.setText(Double.toString(selectedApprovedOrder.getPricetotal()));
        approvedCompletionDate.setText(selectedApprovedOrder.getCompletionDate());
        approvedDeliveryDate.setText(selectedApprovedOrder.getDeliveryDate());
        approvedDeadline.setText("");
        approvedBD.setText(selectedApprovedOrder.getBriefdescription());
        OrderIDLabel11.setText(Integer.toString(selectedApprovedOrder.getId()));
    }

    @FXML
    private void createNewOrderMethod(ActionEvent event) {
        EditOrderView.setVisible(false);
        ViewOrderView.setVisible(false);
        CreateOrderView.setVisible(true);
    }


    @FXML
    private void logOutButtonMethod(ActionEvent event) {
        stateHandler.setLogInScreen(logOutButton);
    }

    @FXML
    private void ShowPicturesOnAction(ActionEvent event) {
    }

    @FXML
    private void ShowDocumentOnAction(ActionEvent event) {
    }

    @FXML
    private void AcceptOnAction(ActionEvent event) {
    }

    @FXML
    private void DeclineOnAction(ActionEvent event) {
        HashMap<Integer, String> offerMap = new HashMap<>();
        if (selectedOffer == null) {
            //offerMap.put(Integer.toString(selectedOrder.getId(), value) //VALUE = MANF EMAIL
            String[] id = CaseListView112.getSelectionModel().getSelectedItem().split(" ");
          //  cc.deleteOffer()); 
        } else {
            
        }
         
    }

    @FXML
    private void ShowOffersOnAction(ActionEvent event) {
        OfferView.setVisible(true);
        showApproved.setVisible(false);
        updateOfferList();
    }

    @FXML
    private void ShowLogisticsOnAction(ActionEvent event) {
    }

    @FXML
    private void deleteOrderButtonOnAction(ActionEvent event) {
        if (selectedOrder == null) {
            String[] id = CaseListView111.getSelectionModel().getSelectedItem().split(" ");
            logic.deleteOrder(id[0]);
        } else {
            logic.deleteOrder(Integer.toString(selectedOrder.getId()));
        }
        clearPendingOrder();
        clearApprovedOrder();
        updateOrderList();
    }

    @FXML
    private void editOrderButtonOnAction(ActionEvent event) {
        if (!CaseListView111.getSelectionModel().isEmpty()) {
            CreateOrderView.setVisible(false);
            ViewOrderView.setVisible(false);
            EditOrderView.setVisible(true);
            String[] id = CaseListView111.getSelectionModel().getSelectedItem().split(" ");

            if (selectedOrder == null || !id[0].equals(Integer.toString(selectedOrder.getId()))) {
                selectedOrder = logic.getOrder(id[0]);
            }

            orderEditTitle.setText(selectedOrder.getTitle());
            orderEditAmount.setText(Integer.toString(selectedOrder.getAmount()));
            orderEditPricePer.setText(Double.toString(selectedOrder.getPriceper()));
            orderEditPriceTotal.setText(Double.toString(selectedOrder.getPricetotal()));
            orderEditCompletionDate.setValue(LocalDate.parse(selectedOrder.getCompletionDate()));
            orderEditDeadline.setValue(LocalDate.parse(selectedOrder.getDeadline()));
            orderEditDeliveryDate.setValue(LocalDate.parse(selectedOrder.getDeliveryDate()));
            OrderIDLabel11.setText(Integer.toString(selectedOrder.getId()));
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

    private void updateOrderList() {
        ArrayList<String> pending = logic.getCostumerList("pending");
        ArrayList<String> approved = logic.getCostumerList("approved");
        CaseListView111.getItems().clear();
        CaseListView1111.getItems().clear();

        for (String order : pending) {
            CaseListView111.getItems().add(order);
        }
        for (String order : approved) {
            CaseListView1111.getItems().add(order);
        }
    }

    private void updateOfferList(){
        ArrayList<String> offers = logic.getOfferList("");
        CaseListView112.getItems().clear();
        for (String offer: offers) {
            CaseListView112.getItems().add(offer);
        }
    }

    @FXML
    private void showDocumentOnAction(ActionEvent event) {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void clearCreateOrder() {
        createOrderPricePer.clear();
        createOrderAmount.clear();
        createOrderBriefDescription.clear();
        createOrderPriceTotal.clear();
        createOrderTitle.clear();
        createOrderCompletionDate.getEditor().clear();
        createOrderDeadline.getEditor().clear();
        createOrderDeliveryDate.getEditor().clear();
    }

    @FXML
    private void createOrderOnAction(ActionEvent event) {
        LocalDate completionDate = createOrderCompletionDate.getValue();
        LocalDate deliveryDate = createOrderDeliveryDate.getValue();
        LocalDate deadline = createOrderDeadline.getValue();
        String title = createOrderTitle.getText();
        int amount = Integer.parseInt(createOrderAmount.getText());
        double pricePer = Double.parseDouble(createOrderPricePer.getText());
        double priceTotal = Double.parseDouble(createOrderPriceTotal.getText());
        String bd = createOrderBriefDescription.getText().replaceAll("\'", "\\" + "\'");
        Order order = new Order(title, amount, pricePer, priceTotal, completionDate.toString(), deliveryDate.toString(), deadline.toString(), bd, productSpecification.getName());
        try {
            order.setPsBytes(Files.readAllBytes(productSpecification.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logic.createOrder(order);
        clearCreateOrder();
        updateOrderList();
    }

    @FXML
    private void uploadDocumentOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Product Specification");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Product Specification", "*.pdf"));
        Node source = (Node) event.getSource();
        Window stage = source.getScene().getWindow();
        productSpecification = fileChooser.showOpenDialog(stage);
    }

    private void clearApprovedOrder() {
        approvedTitle.setText("");
        approvedAmount.setText("");
        approvedPricePer.setText("");
        approvedPriceTotal.setText("");
        approvedCompletionDate.setText("");
        approvedDeliveryDate.setText("");
        approvedDeadline.setText("");
        approvedBD.setText("");
        OrderIDLabel11.setText("");
        productSpecification = null;
        selectedApprovedOrder = null;
    }

    private void clearPendingOrder() {
        showCaseTitle.setText("");
        showCaseAmount.setText("");
        showCasePricePer.setText("");
        showCasePriceTotal.setText("");
        showCaseCompletionDate.setText("");
        showCaseDeliveryDate.setText("");
        showCaseDeadline.setText("");
        showCaseBDText.setText("");
        OrderIDLabel1.setText("");
        productSpecification = null;
        selectedOrder = null;
    }

    @FXML
    private void updateOrderOnAction(ActionEvent event) {
        Order updatedOrder = new Order(orderEditTitle.getText(),
                Integer.parseInt(orderEditAmount.getText()),
                Double.parseDouble(orderEditPricePer.getText()),
                Double.parseDouble(orderEditPriceTotal.getText()),
                orderEditCompletionDate.getValue().toString(),
                orderEditDeliveryDate.getValue().toString(),
                orderEditDeadline.getValue().toString(),
                orderEditBD.getText().replaceAll("\\'", "\\'"),
                productSpecification.getName());
        updatedOrder.setId(Integer.parseInt(OrderIDLabel11.getText()));
        try {
            updatedOrder.setPsBytes(Files.readAllBytes(productSpecification.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logic.updateOrder(updatedOrder);
        selectedOrder = logic.getOrder(OrderIDLabel11.getText());
        System.out.println("Order updated");
        updateOrderList();
    }
}
