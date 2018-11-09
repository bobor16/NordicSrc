package presentationLayer;

import Interfaces.Ilogic.Ilogic;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Root;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import logicLayer.Admin;

public class ApplicationStateHandler {

    private Ilogic logic;


    public void setManufactorerPortalView(Button button) {
        //Login as manufactorer
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ManufactorerPortalView.fxml"));
            loader.setController(new ManufacturerPortalView(logic));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setTitle("NordicSrc");
            stage.setResizable(false);
            stage.setScene(scene);
//                logic.writeToSystemlog(userNameField.getText() + " Logged in"); // writes to systemlog
        } catch (Exception e) { 
            e.printStackTrace();
//        }
        }
    }

    public void setAdminPortalView(Button button) {
        //Login as manufactorer
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminPortalView.fxml"));
            loader.setController(new AdminPortalViewController(logic));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setTitle("NordicSrc");
            stage.setResizable(false);
            stage.setScene(scene);
//                logic.writeToSystemlog(userNameField.getText() + " Logged in"); // writes to systemlog
        } catch (Exception e) {
            e.printStackTrace();
//        }
        }
    }

    public void setRegisterPortalView(Button button) {
        //Login as manufactorer
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterView.fxml"));
            loader.setController(new RegisterViewController(logic));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setTitle("NordicSrc");
            stage.setResizable(false);
            stage.setScene(scene);
//                logic.writeToSystemlog(userNameField.getText() + " Logged in"); // writes to systemlog
        } catch (Exception e) {
            e.printStackTrace();
//        }
        }
    }

    public void customerPortalView(Button button) {
        //Login as manufactorer
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerPortalView.fxml"));
            loader.setController(new CustomerPortalViewController(logic));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setTitle("NordicSrc");
            stage.setResizable(false);
            stage.setScene(scene);
//                logic.writeToSystemlog(userNameField.getText() + " Logged in"); // writes to systemlog
        } catch (Exception e) {
            e.printStackTrace();
//        }
        }
    }

        public void setLogInScreen(Button button){
        //Login as manufactorer
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LogInScreen.fxml"));
            loader.setController(new LogInScreenController(logic));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setTitle("NordicSrc");
            stage.setResizable(false);
            stage.setScene(scene);
//                logic.writeToSystemlog(userNameField.getText() + " Logged in"); // writes to systemlog
        } catch (Exception e) {
            e.printStackTrace();
//        }
        }
    }

}
