/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import com.sun.corba.se.impl.orb.ParserTable;
import dataLayer.ClientController;
import interfaces.iLogic.Ilogic;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    @FXML
    private AnchorPane createUserPane;
    @FXML
    private AnchorPane editUserPane;
    @FXML
    private RadioButton manufacturerRadioButton;
    @FXML
    private RadioButton customerRadioButton;
    @FXML
    private RadioButton employeeRadioButton;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField companyNameField;
    @FXML
    private TextField CVRField;
    @FXML
    private ListView<String> logListView;
    @FXML
    private Label userEditMailLabel;
    @FXML
    private CheckBox verifiedCheckBox;
    @FXML
    private TextField companyNameEdit;
    @FXML
    private TextField CVRNumberEdit;

    public AdminPortalViewController(Ilogic logic) {
        super(logic);
    }

    ApplicationStateHandler appliCationStateHandler = new ApplicationStateHandler();
    private final ToggleGroup group = new ToggleGroup();
    private HashMap<String, String> registerForm = new HashMap<>();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateLog();
        {manufacturerRadioButton.setToggleGroup(group);
        customerRadioButton.setToggleGroup(group);
        employeeRadioButton.setToggleGroup(group);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    registerForm.put("type", group.getSelectedToggle().getUserData().toString());
                }
            }
        });}

        //userColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        displayUsersInTable();
        //FilteredList filteredList = new FilteredList();
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
        createUserPane.setVisible(false);
        editUserPane.setVisible(false);
        userProfilePane.setVisible(true);
        ClientController cc = new ClientController();
        String email = CaseListView111.getSelectionModel().getSelectedItems().toString().replaceAll("[\\[\\]]", "");
        User user = cc.getUser(email);

        CompanyNameLabel.setText(user.getCompanyName());
        CVRNumberLabel.setText(Integer.toString(user.getCvr()));
        EmailLabel.setText(email);
    }

    @FXML
    public void registerMethod(ActionEvent event) throws IOException {
        registerForm.put("name", firstNameField.getText() + " " + lastNameField.getText());
        registerForm.put("email", emailField.getText());
        registerForm.put("password", passwordField.getText());
        if (companyNameField.getText().isEmpty()){
            registerForm.put("cname", "NULL");
        }else {
            registerForm.put("cname", companyNameField.getText());
        }
        if (CVRField.getText().isEmpty()){
            registerForm.put("cvr", "0000");
        } else {
            registerForm.put("cvr", CVRField.getText());
        }
        ClientController cc = new ClientController();
        switch (cc.register(registerForm)) {
            case "success":
                clearCreateUser();
                break;
            case "user exists":
                System.out.println("email exists already");
                break;
            default:
                System.out.println("Registration failed");
                break;
        }
    }

    @FXML
    public void cancelButtonMethod(ActionEvent event) throws IOException {
        clearCreateUser();
    }

    private ObservableList<User> getUsers() {
        return FXCollections.observableArrayList(displayUsers());
    }

    private void displayUsersInTable() {
        CaseListView111.getItems().clear();
        ArrayList<User> users = displayUsers();
        ObservableList<String> list = null;
        for (User user : users) {
            CaseListView111.getItems().add(user.getEmail());
        }
        updateLog();
    }

    @FXML
    public void deleteUserOnAction(ActionEvent event) throws IOException {
        String email = CaseListView111.getSelectionModel().getSelectedItems().toString().replaceAll("[\\[\\]]", "");
        logic.deleteUser(email);
        displayUsersInTable();
        updateLog();
    }

    @FXML
    public void createUserPaneOnAction(ActionEvent event) throws IOException {
        editUserPane.setVisible(false);
        userProfilePane.setVisible(false);
        createUserPane.setVisible(true);
        updateLog();
    }

    @FXML
    public void editUserButtonAction(ActionEvent event) throws IOException {
        ClientController cc = new ClientController();
        userProfilePane.setVisible(false);
        createUserPane.setVisible(false);
        editUserPane.setVisible(true);
        String email = CaseListView111.getSelectionModel().getSelectedItems().toString().replaceAll("[\\[\\]]", "");
        userEditMailLabel.setText(email);
        User user = cc.getUser(email);
        companyNameEdit.setText(user.getCompanyName());
        verifiedCheckBox.setSelected(user.isVerified());
        CVRNumberEdit.setText(Integer.toString(user.getCvr()));
    }

    @FXML
    public void updateUserOnAction(ActionEvent event){
        ClientController cc = new ClientController();
        HashMap<String, String> form = new HashMap<>();
        String email = CaseListView111.getSelectionModel().getSelectedItems().toString().replaceAll("[\\[\\]]", "");
        form.put("email", email);
        form.put("cname", companyNameEdit.getText());
        if (verifiedCheckBox.isSelected()){
            form.put("verified", "true");
        } else {
            form.put("verified", "false");
        }
        form.put("cvr", CVRNumberEdit.getText());
        cc.updateUser(form);
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

    private void clearCreateUser(){
        group.getProperties().clear();
        displayUsersInTable();
        updateLog();
    }

    private void updateLog(){
        ClientController cc = new ClientController();
        logListView.getItems().clear();
        ArrayList<String> log = cc.getLog();
        for (String entry : log) {
            logListView.getItems().add(entry);
        }
    }
}
