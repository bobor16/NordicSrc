package presentationLayer;

import Interfaces.Ilogic.Ilogic;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ApplicationStateHandler {

    private Ilogic logic;
    private Stage returnStage;


    public void setManufactorerPortalView(Button button) {
        //Login as manufactorer
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ManufactorerPortalView.fxml"));
            loader.setController(new ManufactorerPortalViewController(logic));
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
        //Login as Admin
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
        //RegisterView
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
        //Login as customer
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
        //Logout button
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
        
        public void setPickAFile(Button button){
        //Pick a file view
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pickAFile.fxml"));
            loader.setController(new PickAFileController(logic));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) button.getScene().getWindow();
            returnStage = stage;
            stage.setTitle("NordicSrc");
            stage.setResizable(false);
            stage.setScene(scene);
//                logic.writeToSystemlog(userNameField.getText() + " Logged in"); // writes to systemlog
        } catch (Exception e) {
            e.printStackTrace();
//        }
        }
    }
        
        public void setPlaceBidView(Button button) {
        //Login as manufactorer
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ManufactorerPortalView.fxml"));
            loader.setController(new ManufacturerBidViewController(logic));
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
        
        public void setEmployeeView(Button button){
        //Login as an Employee
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Employee.fxml"));
            loader.setController(new EmployeeController(logic));
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
        
        public Stage getStage(){
            return returnStage;
        }

}
