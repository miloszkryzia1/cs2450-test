package com.example.testing3;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {
    int currentIndex =0;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        // background image
        Scene scene = new Scene(homePage(stage));
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);  // ctrl esc
        stage.setResizable(true);
        stage.show();
    }
    public VBox homePage(Stage stage){

        MenuBar menuBar = new MenuBar();
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

        menuBar.getMenus().addAll(products, equipment, supplies, parts, about, contactMenu);
        menuBar.setPadding(new Insets(10));

        // add company name

        /*
        // home menu, add later
        Label homeLabel = new Label("Home");
        Menu homeMenu = new Menu(null, homeLabel;
        homeLabel.setOnMouseClicked(event->{
            Scene scene

        });

         */
        // search bar
        TextField search = new TextField();
        Button searchButton = new Button("Go!");
        HBox searchBox = new HBox(search, searchButton);

        // most popular section
        Label mostPopular = new Label("Most Popular");
        mostPopular.setStyle("-fx-font-size: 24; -fx-text-fill: BLACK;");
        // create an array of product images
        Image[] images = new Image[4];
        images[0] = new Image("file:./res/test.png");
        images[1] = new Image("file:./res/test2.png");
        images[2] = new Image ("file:./res/test3.png");
        images[3] = new Image("file:./res/test4.png");
        ImageView imageView = new ImageView(images[0]);
        imageView.setFitWidth(200);
        imageView.setFitHeight(400);
        imageView.setPreserveRatio(true);

        // create the anchorPane
        AnchorPane root = new AnchorPane();
        AnchorPane.setTopAnchor(imageView, 50.0);
        AnchorPane.setLeftAnchor(imageView, 200.0); // change later

        // create buttons on each side of the image
        Button leftButton = new Button("<");
        leftButton.setStyle("-fx-font-size: 10; -fx-text-fill: white; -fx-background-color: black;");
        Button rightButton = new Button(">");
        rightButton.setStyle("-fx-font-size: 10; -fx-text-fill: white; -fx-background-color: black;");
        // Position the buttons
        AnchorPane.setTopAnchor(leftButton, 200.0);
        AnchorPane.setLeftAnchor(leftButton, 50.0);
        AnchorPane.setTopAnchor(rightButton, 200.0);
        AnchorPane.setRightAnchor(rightButton, 50.0);

        leftButton.setOnAction(event -> {
            // Decrement the current index
            currentIndex--;
            // Wrap around if the index is out of bounds
            if (currentIndex < 0) {
                currentIndex = images.length - 1;
            }
            // Set the image view to the new image
            imageView.setImage(images[currentIndex]);
        });

        rightButton.setOnAction(e -> {
            // Increment the current index
            currentIndex++;
            // Wrap around if the index is out of bounds
            if (currentIndex >= images.length) {
                currentIndex = 0;
            }
            // Set the image view to the new image
            imageView.setImage(images[currentIndex]);
        });
        // create a hbox for the images
        root.getChildren().addAll(rightButton,imageView, leftButton);

        // browse all products
        Label browse = new Label("Browse all products");
        Button leadApron = new Button("Lead Apron");
        Button gloves = new Button("Radiation reducing gloves");
        Button mri = new Button("Medium MRI Phantom");
        Button animalImmobilizers = new Button("Small Animal Immobilizers");

        VBox homePage = new VBox( menuBar, searchBox, mostPopular,root, browse);
        homePage.setAlignment(Pos.CENTER);
        homePage.setSpacing(10);
        homePage.setPadding(new Insets(10));

        // return the vbox, FIX LATER
        return homePage;
    }
}


