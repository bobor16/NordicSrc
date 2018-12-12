package presentationLayer;

import interfaces.iLogic.Ilogic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

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
    private AnchorPane CreateOrderView1;
    @FXML
    private Label OrderIDLabel2;
    @FXML
    private Button searchButton111;
    @FXML
    private ListView<?> CaseListView1111;
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

    public CustomerPortalViewController(Ilogic logic) {
        super(logic);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void loadSceneOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    private void searchMethod(ActionEvent event) {
    }

    @FXML
    private void showCaseMethod(ActionEvent event) {
    }

    @FXML
    private void createNewOrderMethod(ActionEvent event) {
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

}
