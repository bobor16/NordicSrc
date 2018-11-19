/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.presentationLayer;

import Server.Interfaces.Ilogic.Ilogic;
import Client.Interfaces.Ipresentation.Ipresentation;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mehgn
 */
public class presentationFacade extends Application implements Ipresentation{

    private static Ilogic logic;
    private static presentationFacade ui;
    
    @Override
    public void injectLogic(Ilogic logic) {
        this.logic = logic;
    }

    @Override
    public void startApplication(String[] args) {
        ui = this;
        launch(args);
    }
    
    
    public static presentationFacade getInstance() {
        return ui;
    }
    
    public Ilogic getLogic() {
        return logic;
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LogInScreen.fxml"));
        loader.setController(new LogInScreenController(logic));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        primaryStage.setScene(scene);
        primaryStage.setTitle("NordicSrc");
        primaryStage.show();
    }
}
