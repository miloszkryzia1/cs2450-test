package com.example.demo5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        MenuBar mb = new MenuBar();
        // create the products menu

        Menu products = new Menu("Products");
        MenuItem apron = new MenuItem("Lead Apron");
        MenuItem radiation = new MenuItem("Radiation Reducin");
        MenuItem MRI = new MenuItem("MRI");
        MenuItem animal = new MenuItem("Small animal immobilizers");
        products.getItems().addAll(apron, radiation, MRI, animal);

        apron.setOnAction(event->{

        });
        radiation.setOnAction(event->{

        });
        MRI.setOnAction(event->{

        });
        animal.setOnAction(event->{

        });


        // create the equipments menu
        Menu equipment = new Menu("Equipment");
        MenuItem item2 = new MenuItem("Small Animal immobilizers");
        equipment.getItems().addAll(item2);

        // create supplies menu
        Menu supplies = new Menu("Supplies");
        MenuItem item3 = new MenuItem("Lead Apron");
        MenuItem item4 = new MenuItem("Radiation Reducing Gloves");
        supplies.getItems().addAll(item3, item4);

        // create the parts menu
        Menu parts = new Menu("Parts");
        MenuItem MRI2 = new MenuItem("MRI");
        parts.getItems().addAll(MRI2);

        // create contact
        Label contactLabel = new Label("Contact us");
        Menu contactMenu = new Menu (null, contactLabel);
        contactLabel.setOnMouseClicked(event->{
            // info
        });


        // create the about
        Label aboutLabel = new Label ("About");
        Menu about = new Menu(null, aboutLabel);
        // set an action when about is clicked
        aboutLabel.setOnMouseClicked(event->{
            // info
        });

        mb.getMenus().addAll(products, equipment, supplies, parts, about, contactMenu);
        mb.setPadding(new Insets(10));

        // add company name

        /*
        // home menu, add later
        Label homeLabel = new Label("Home");
        Menu homeMenu = new Menu(null, homeLabel;
        homeLabel.setOnMouseClicked(event->{
            Scene scene

        });

         */


        // testing
        BorderPane root = new BorderPane();
        root.setTop(mb);
        Scene scene = new Scene(root, 600, 600);
        //Scene scene = new Scene(window1(stage));
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
}


