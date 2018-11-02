package presentationLayer;

import Interfaces.Ilogic.Ilogic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Interfaces.All.iAuthenticate;
import javafx.scene.Parent;
import logicLayer.User;

/**
 * FXML Controller class
 *
 * @author rasmu
 */
public class LogInScreenController implements Initializable {

    private Ilogic logic;
    static Scene scene;
    private Parent root;

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private Button LoginButton;
    @FXML
    private Button RegisterButton;
    @FXML
    private Label passwordMsgLabel;
    @FXML
    private Label ResetPasword;

    public LogInScreenController(Ilogic logic) {
        this.logic = logic;
    }

//    public Ilogic getLogic() { //Method that return logic variable value
//        return logic;
//    }

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void pressEnter(KeyEvent event) throws IOException {
    }

    @FXML
    private void LoginOnAction(ActionEvent event) {
//        logic.setType("Manufactorer");
//        if(logic.getType().equals("Manufactorer")){
        try {
            if (!logic.passwordCheck(PasswordField.getText())) {
                if (emailField.getText().equalsIgnoreCase("admin") && PasswordField.getText().equalsIgnoreCase("admin")) {//Needs email and password from database
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ManufactorerPortalView.fxml"));
                        loader.setController(new ManufacturerPortalView(logic));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) LoginButton.getScene().getWindow();
                    stage.setTitle("NordicSrc");
                    stage.setResizable(false);
                    stage.setScene(scene);
//                logic.writeToSystemlog(userNameField.getText() + " Logged in"); // writes to systemlog
                }
            }
            setEmail();
        } catch (Exception e) {
            e.printStackTrace();
//        }
        }
    }

    @FXML
    private void RegisterOnAction(ActionEvent event) {
    }

    private void setEmail() {
        System.out.println("Email used to login; " + emailField.getText());
        logic.setEmail(emailField.getText());
    }
}
