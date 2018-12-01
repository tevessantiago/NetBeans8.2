/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package educacionit.javafx.tutorial06;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Rodolfo Durante
 */
public class Runner extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private boolean internalWindowIsOpen = false;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Ventana Principal");
        initRootLayout();

    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the contactABM inside the root layout.
     */
    public void showInternalWindow() {
        try {
            if (!internalWindowIsOpen) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/educacionit/javafx/tutorial06/InternalWindow.fxml"));
                AnchorPane internalWindow = (AnchorPane) loader.load();
                Stage internalWindowStage = new Stage();
                internalWindowStage.setTitle("Ventana Interna");
                internalWindowStage.initModality(Modality.NONE);
                internalWindowStage.initOwner(primaryStage);
                Scene scene = new Scene(internalWindow);
                internalWindowStage.setScene(scene);
                internalWindowStage.show();
                internalWindowIsOpen = true;
                internalWindowStage.setOnHidden((WindowEvent we) -> {
                    internalWindowIsOpen = false;
                });

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the contactABM inside the root layout.
     */
    public void showContactABM() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/educacionit/javafx/tutorial04/FillDataExample.fxml"));
            AnchorPane contactABM = (AnchorPane) loader.load();

            // Set contactABM into the center of root layout.
            // rootLayout.setCenter(contactABM);
            Stage dialogStage = new Stage();
            dialogStage.setTitle("ABM de Contactos");
            // dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initModality(Modality.NONE);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(contactABM);
            dialogStage.setScene(scene);
            // dialogStage.showAndWait();
            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}
