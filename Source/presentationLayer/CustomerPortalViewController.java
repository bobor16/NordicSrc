package presentationLayer;

import dataLayer.ClientController;
import interfaces.iLogic.Ilogic;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import logicLayer.Order;

import javax.swing.text.View;

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
    private ListView<?> CaseListView112;
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
    private void showCaseMethod(ActionEvent event) {
        EditOrderView.setVisible(false);
        CreateOrderView.setVisible(false);
        ViewOrderView.setVisible(true);
        ClientController cc = new ClientController();
        String[] id = CaseListView111.getSelectionModel().getSelectedItem().split(" ");
        Order order = cc.getOrder(id[0]);

        showCaseTitle.setText(order.getTitle());
        showCaseAmount.setText(Integer.toString(order.getAmount()));
        showCasePricePer.setText(Double.toString(order.getPriceper()));
        showCasePriceTotal.setText(Double.toString(order.getPricetotal()));
        showCaseCompletionDate.setText(order.getCompletionDate());
        showCaseDeliveryDate.setText(order.getDeliviryDate());
        showCaseDeadline.setText("");
        showCaseBDText.setText(order.getBriefdescription());
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
    }

    @FXML
    private void ShowOfferOnAction(ActionEvent event) {
    }

    @FXML
    private void ShowLogisticsOnAction(ActionEvent event) {
    }

    @FXML
    private void deleteOrderButtonOnAction(ActionEvent event) {

    }

    @FXML
    private void editOrderButtonOnAction(ActionEvent event) {
        CreateOrderView.setVisible(false);
        ViewOrderView.setVisible(false);
        EditOrderView.setVisible(true);
    }

    private void updateOrderList(){
        ClientController cc = new ClientController();
        ArrayList<String> orders = cc.getOrderList();
        CaseListView111.getItems().clear();

        for (String order: orders) {
            CaseListView111.getItems().add(order);
        }
    }
}
