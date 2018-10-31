package presentationLayer;

import Interfaces.Ilogic.Ilogic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML
    private Button loadScene;
    
    private Ilogic logic;
    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public CasePortalViewController(Ilogic logic){
        this.logic = logic;
    }

    @FXML
    private void loadSceneOnAction(ActionEvent event) throws IOException {
        if (event.getSource() == loadScene) {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML/Test.fxml"));
            rootPane.getChildren().setAll(pane);
        }
    }
}
