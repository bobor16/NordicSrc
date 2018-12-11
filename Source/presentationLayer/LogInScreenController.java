package presentationLayer;

import interfaces.iLogic.Ilogic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dataLayer.ClientController;
import dataLayer.Packet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author rasmu
 */
public class LogInScreenController extends SuperController implements Initializable {

    static Scene scene;
    private Parent root;

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private Button LoginButton;
    @FXML
    private Button registerButton;
    @FXML
    private Label passwordMsgLabel;
    @FXML
    private Label ResetPasword;
    @FXML
    private Button forgotPwdButton;
    @FXML
    private Label infoLabel;
    @FXML
    private Button okButton;

    private Ilogic logic;

    ApplicationStateHandler stateHandler = new ApplicationStateHandler();

    public LogInScreenController(Ilogic logic) {
        super(logic);
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

    private void loginError() {
        System.out.println("Wrong login");
        infoLabel.setText("Inncorrect username/password, try again!");
        infoLabel.setTextFill(Color.rgb(210, 39, 30));
        emailField.setText("");
        PasswordField.setText("");
    }

    @FXML
    private void LoginOnAction(ActionEvent event) {
        ClientController cc = new ClientController();
        String UP = emailField.getText() + " " + PasswordField.getText();
        Packet p = new Packet(1, UP.toLowerCase());
        cc.sendPackage(p);
        p = cc.receivePackage();
        if (p.getId() == 1) {
            switch ((String) p.getObject()) {
                case "admin":
                    stateHandler.setAdminPortalView(LoginButton);
                    break;

                case "manufacturer":
                    stateHandler.setManufactorerPortalView(LoginButton);
                    break;

                case "customer":
                    stateHandler.customerPortalView(LoginButton);
                    break;
                case "employee":
                    stateHandler.setEmployeeView(LoginButton);
                    break;
                case "invalid":
                    loginError();
                    break;
                case "not verified":
                    System.out.println("User not verified");
                    break;
                default:
                    System.out.println("Something went wrong, I received: " + p.getObject());
                    break;
            }
        }
        /*  //Login as admin
            if(PasswordField.getText().equalsIgnoreCase("Admin") && emailField.getText().equalsIgnoreCase("Admin"))  stateHandler.setAdminPortalView(LoginButton);

        //Login as manufactorer
            if(PasswordField.getText().equalsIgnoreCase("manufactorer") && emailField.getText().equalsIgnoreCase("manufactorer"))stateHandler.setManufactorerPortalView(LoginButton);

        //Logic as Costumer
            if(PasswordField.getText().equalsIgnoreCase("customer") && emailField.getText().equalsIgnoreCase("customer"))stateHandler.customerPortalView(LoginButton);*/
    }

    @FXML
    private void registerOnAction(ActionEvent event) {
        //Registrer button
        stateHandler.setRegisterPortalView(registerButton);
    }

    private void setEmail() {
        System.out.println("Email used to login; " + emailField.getText());
//        logic.setEmail(emailField.getText());
    }

    @FXML
    private void forgotPwdOnAction(ActionEvent event) {
        stateHandler.setPasswordView(forgotPwdButton);
    }

    @FXML
    private void okButtonOnAction(ActionEvent event) {

    }
}
