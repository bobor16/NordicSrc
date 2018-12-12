/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import com.sun.deploy.util.StringUtils;
import dataLayer.ClientController;
import interfaces.iLogic.Ilogic;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import logicLayer.User;

import javax.swing.text.LabelView;

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
    private ListView<String> CaseListView111;
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
    @FXML
    private Label CVRNumberLabel;
    @FXML
    private Label EmailLabel;
    @FXML
    private Label PhoneNumberLabel;
    @FXML
    private Label CompanyNameLabel;

    public AdminPortalViewController(Ilogic logic) {
        super(logic);
    }

    ApplicationStateHandler appliCationStateHandler = new ApplicationStateHandler();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //userColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        displayUsersInTable();
        FilteredList filteredList = new FilteredList();
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
        ClientController cc = new ClientController();
        String email = CaseListView111.getSelectionModel().getSelectedItems().toString().replaceAll("[\\[\\]]", "");
        User user = cc.getUser(email);

        CompanyNameLabel.setText(user.getCompanyName());
        CVRNumberLabel.setText(Integer.toString(user.getCvr()));
        EmailLabel.setText(email);
    }

    @FXML
    public void registerMethod(ActionEvent event) throws IOException {

    }

    @FXML
    public void cancelButtonMethod(ActionEvent event) throws IOException {

    }

    private ObservableList<User> getUsers() {
        return FXCollections.observableArrayList(displayUsers());
    }

    private void displayUsersInTable() {
        CaseListView111.getItems().clear();
        ArrayList<User> users = displayUsers();
        ObservableList<String> list = ;
        for (User user : users) {
            CaseListView111.getItems().add(user.getEmail());
        }
        /*
        userTable.getColumns().clear();
        userTable.setItems(getUsers());
        userTable.getColumns().addAll(userColumn);
        userTable.getSortOrder().add(userColumn);
        */
    }

    @FXML
    public void deleteUserOnAction(ActionEvent event) throws IOException {
        String email = CaseListView111.getSelectionModel().getSelectedItems().toString().replaceAll("[\\[\\]]", "");
        logic.deleteUser(email);
        displayUsersInTable();
    }


    //skal rykkes ned i datafacade
    public ArrayList<User> displayUsers() {
        ClientController cc = new ClientController();
        ArrayList<User> userEmailList = new ArrayList<>();
        ArrayList<String> emails = cc.getEmails();
        for (int i = 0; i < emails.size(); i++) {
            userEmailList.add(new User(emails.get(i)));
        }
        return userEmailList;
    }

}
