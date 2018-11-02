
package presentationLayer;

import Interfaces.Ilogic.Ilogic;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ManufacturerPortalView implements Initializable {

    
    private Ilogic logic;
    @FXML
    private Label CaseIDLabel;

    /**
     * Initializes the controller class.
     */
    
    
    public ManufacturerPortalView(Ilogic logic) {
        this.logic = logic;
        // TODO
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
}
