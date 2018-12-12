/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import dataLayer.ClientController;
import dataLayer.Packet;
import interfaces.iLogic.Ilogic;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import logicLayer.User;

/**
 * FXML Controller class
 *
 * @author mehgn
 */
public class AdminPortalViewController extends SuperController implements Initializable {

    @FXML
    private PasswordField SearchField;
    @FXML
    private Button SearchButton;
    @FXML
    private ListView<?> AcceptedCasesListView;
    @FXML
    private Button ShowCaseButton;
    @FXML
    private Tab NewCasesListView;
    @FXML
    private ListView<?> CaseListView11;
    @FXML
    private Button AttachedFilesButton;
    @FXML
    private Tab NewCasesListView1;
    @FXML
    private PasswordField searchUser;
    @FXML
    private Button SearchButton1;
    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, String> userColumn;
    @FXML
    private Button logOutButton;
    @FXML
    private Button adminProfileButton;
    @FXML
    private Button adminSettingsButton;
    @FXML
    private Button showUserButton;
    @FXML
    private Button createUserButton;
    @FXML
    private Button editUserButton;
    @FXML
    private Button deleteUserButton;
    @FXML
    private AnchorPane userProfilePane;

    public AdminPortalViewController(Ilogic logic) {
        super(logic);
    }

    ApplicationStateHandler appliCationStateHandler = new ApplicationStateHandler();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//                userColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//                displayUsersInTable();

    }

    public void showCaseOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void searchOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void adminSettingsOnAction(ActionEvent event) throws IOException {

    }

    public void loadSceneOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void adminProfileOnAction(ActionEvent event) throws IOException {

    }

    public void OpenAttachedFilesOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void SearchOnAction(ActionEvent event) throws IOException {

    }

    public void logout(ActionEvent event) throws IOException {

    }

    @FXML
    private void logOutButtonMethod(ActionEvent event) {
        appliCationStateHandler.setLogInScreen(logOutButton);
    }

    @FXML
    private void showUserOnAction(ActionEvent event) {
        try {
            userProfilePane.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("UserProfileView.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void registerMethod(ActionEvent event) throws IOException {

    }
     @FXML
    public void cancelButtonMethod(ActionEvent event) throws IOException {

    }
    
      @FXML
    public void createUser(ActionEvent event) throws IOException {
        appliCationStateHandler.setCreateUserView(createUserButton);
    }
    
      private ObservableList<User> getUsers() {
        ObservableList<User> usersObservableList = FXCollections.observableArrayList(displayUsers());
        return usersObservableList;
    }
    
    private void displayUsersInTable() {
        userTable.getColumns().clear();
        userTable.setItems(getUsers());
        userTable.getColumns().addAll(userColumn);
        userTable.getSortOrder().add(userColumn);
    }
    
    @FXML
    public void deleteUser(ActionEvent event) throws IOException {
        String email = userTable.getSelectionModel().getSelectedItem().getEmail();
        logic.deleteUser(email);
        displayUsersInTable();
    }
    
   
    //skal rykkes ned i datafacade
     public ArrayList<User> displayUsers() {
        ClientController cc = new ClientController();
        ArrayList<User> userEmailList = new ArrayList<>();
        for(int i = 0; i < cc.displayUsers().size(); i++){
            userEmailList.add(new User(cc.displayUsers().get(i)));
        }
        return userEmailList;
    }
}
