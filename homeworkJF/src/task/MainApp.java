package task;/**
 * Created by AMakas on 24.01.2017.
 */

import javafx.application.Application;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import task.five.FiveController;
import task.four.FourController;
import task.one.OneController;
import task.three.ThreeController;
import task.two.TwoController;


public class MainApp extends Application {

    private Stage primaryStage;
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private AnchorPane personOverview;
    public AnchorPane getPersonOverview() {
        return personOverview;
    }

    private BorderPane borderPanel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddredssApp");

        //initTask_1();
        //initTask_2();
        //initTask_3();
        //initTask_4();
        initTask_5();
        //initTask_6();
        //initTask_7();

    }

    public void initTask_5() {
        try {
            this.primaryStage.setTitle("Text Editor");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("five/disign.fxml"));
            borderPanel = (BorderPane) loader.load();

            Scene scene = new Scene(borderPanel);
            primaryStage.setScene(scene);

            FiveController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initTask_4() {
        try {
            this.primaryStage.setTitle("Calculator");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("four/disign.fxml"));
            GridPane panel = (GridPane) loader.load();

            Scene scene = new Scene(panel);
            primaryStage.setScene(scene);

            FourController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initTask_3() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("three/disign.fxml"));
            personOverview = (AnchorPane) loader.load();

            Scene scene = new Scene(personOverview);
            primaryStage.setScene(scene);

            ThreeController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initTask_2() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("two/disign.fxml"));
            personOverview = (AnchorPane) loader.load();

            Scene scene = new Scene(personOverview);
            primaryStage.setScene(scene);

            TwoController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initTask_1() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("one/disign.fxml"));
            personOverview = (AnchorPane) loader.load();

            Scene scene = new Scene(personOverview);
            primaryStage.setScene(scene);

            OneController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
