
package presentationLayer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;


public class CasePortalViewController implements Initializable {

    @FXML
    private ListView<?> CaseListView;
    @FXML
    private Label CaseIDLabel;
    @FXML
    private Label OrderTitleLabel;
    @FXML
    private Label QuantityLabel;
    @FXML
    private Label DeliveryDateLabel;
    @FXML
    private AnchorPane rootPane;
    
    

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void loadScene2(ActionEvent event) throws IOExeotion {
        AnchorPane pane = FXMLLoader.load(getClass().getResources("Test.fxml"));
        rootPane.getChildren().set
    }
}
