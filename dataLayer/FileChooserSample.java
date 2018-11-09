package dataLayer;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public final class FileChooserSample {

    private Desktop desktop = Desktop.getDesktop();

    public void start(final Stage stage, Button button) {
        stage.setTitle("File Chooser Sample");

        final FileChooser fileChooser = new FileChooser();

    }

    private static void configureFileChooser(final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf")
        );
    }

    private void openFile(File file) {
        try {
            System.out.println(file.getAbsolutePath());
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(FileChooserSample.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }

}
