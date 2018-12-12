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
import logicLayer.User;

/**
 * FXML Controller class
 *
 * @author rasmu
 */
public class ManufactorerPortalViewController implements Initializable {

    @FXML
    private Button logOutButton;
    @FXML
    private PasswordField SearchField;
    @FXML
    private ListView<?> OrderListView;
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
    private TextField EstCompletionDateTextFiield;
    @FXML
    private TextField EstDeliveryDateTextField;
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
    private ListView<?> CaseListView11;
    @FXML
    private AnchorPane OrderView;
    @FXML
    private Label OrderIDLabel112;
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
    private Button ShowLogisticsButton;
    @FXML
    private Button UpdateLogisticsButton;
    @FXML
    private AnchorPane ShowOrderView;
    @FXML
    private AnchorPane PlaceOfferView;

    ManufactorerPortalViewController(Ilogic logic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logOutButtonMethod(ActionEvent event) {
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
    }

    @FXML
    private void CancelOnAction(ActionEvent event) {
    }

    @FXML
    private void ShowOrderOnAction(ActionEvent event) {
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
    private void EditOfferOnAction(ActionEvent event) {
    }

    @FXML
    private void DeleteOfferOnAction(ActionEvent event) {
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
    
}
