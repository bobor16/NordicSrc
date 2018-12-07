/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import interfaces.iLogic.Ilogic;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import sun.awt.DesktopBrowse;

/**
 * FXML Controller class
 *
 * @author mehgn
 */
public class PickAFileController extends SuperController implements Initializable {

    @FXML
    private Button choseFileButton;

    @FXML
    private TextField filePathField;
    @FXML
    private Button okButton;
    @FXML
    private Button Backbutton;
    
    ApplicationStateHandler applicationHandler = new ApplicationStateHandler();

    final FileChooser fileChooser = new FileChooser();

    public final Desktop dekstop = Desktop.getDesktop();
    Ilogic logic;

    public PickAFileController(Ilogic logic) {
        super(logic);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void choseFile(ActionEvent event) throws IOException {
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(applicationHandler.getStage());
        if (file != null) {
                filePathField.setText(file.getAbsolutePath());
//            openFile(file);
        }
    }

    @FXML
    public void ok(ActionEvent event) throws IOException {
    }
    
    @FXML
    public void back(ActionEvent event)  {
        applicationHandler.setManufactorerPortalView(Backbutton);
    }
    
    
    private static void configureFileChooser(final FileChooser fileChooser) {      
            fileChooser.setTitle("View Pictures");
            fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
            );                 
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
    }
    
    
    private void openFile(File file) {
        try {
            dekstop.open(file);
        } catch (IOException ex) {
//            Logger.getLogger(FileChooserSample.class.getName()).log(
//                Level.SEVERE, null, ex
//            );
        }
    }
}
