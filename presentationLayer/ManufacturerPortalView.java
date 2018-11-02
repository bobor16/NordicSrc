
package presentationLayer;

import Interfaces.Ilogic.Ilogic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ManufacturerPortalView extends SuperController implements Initializable {

    public ManufacturerPortalView(Ilogic logic) {
        super(logic);
    }

    
    @FXML
    private Label CaseIDLabel;

    /**
     * Initializes the controller class.
     */
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void showCaseOnAction(ActionEvent event) throws IOException{
        
    }
    
    @FXML
    public void searchOnAction(ActionEvent event) throws IOException{
        
    }
    @FXML
    public void loadSceneOnAction(ActionEvent event) throws IOException{
        
    }
    @FXML
    public void OpenAttachedFilesOnAction(ActionEvent event) throws IOException{
        
    }
    @FXML
    public void PlaceBidOnAction(ActionEvent event) throws IOException{
        
    }
    @FXML
    public void SearchOnAction(ActionEvent event) throws IOException{
        
    }
    }
    
    
    
