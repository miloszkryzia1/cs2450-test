package com.example.testing3;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
public class Main extends Application {
    int currentIndex =0;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        // background image
        Scene scene = new Scene(homePage(stage));
        scene.getStylesheets().add("Styling.css");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);  // ctrl esc
        stage.setResizable(true);
        stage.show();
    }
    public VBox homePage(Stage stage){

        MenuBar menuBar = new MenuBar();

        // create the equipments menu
        Menu equipment = new Menu("Equipment");
        MenuItem item2 = new MenuItem("Small Animal immobilizers");
        equipment.getItems().addAll(item2);

        // create supplies menu
        Menu supplies = new Menu("Supplies");
        supplies.setStyle("-fx-text-fill: white");
        MenuItem item3 = new MenuItem("Lead Apron");
        MenuItem item4 = new MenuItem("Radiation Reducing Gloves");
        supplies.getItems().addAll(item3, item4);

        // create the parts menu
        Menu parts = new Menu("Parts");
        parts.setStyle("-fx-text-fill: white");
        MenuItem MRI2 = new MenuItem("MRI");
        parts.getItems().addAll(MRI2);



        // create contact
        Label contactLabel = new Label("Contact us");
        Menu contactMenu = new Menu (null, contactLabel);
        contactMenu.setStyle("-fx-text-fill: white");
        contactLabel.setOnMouseClicked(event->{
            // info
        });


        // create the about
        Label aboutLabel = new Label ("About");
        Menu about = new Menu(null, aboutLabel);
        about.setStyle("-fx-text-fill: white");
        // set an action when about is clicked
        aboutLabel.setOnMouseClicked(event->{
            // info
        });

        menuBar.getMenus().addAll(equipment, supplies, parts, about, contactMenu);
        //menuBar.setPadding(new Insets(10));
        menuBar.setPrefWidth(stage.getWidth());
        menuBar.getStyleClass().add("menu-bar");

        // search bar area
        Label name = new Label("Pacific North West X-Ray INC");
        name.getStyleClass().add("label-name");
        TextField search = new TextField();
        Button searchButton = new Button("Go!");
        HBox searchBox = new HBox(name, search, searchButton);
        searchBox.setAlignment(Pos.CENTER);
        searchBox.setSpacing(10);
        searchBox.setPadding(new Insets(30,0,0, 0));

        // testing
        searchButton.setOnAction(event -> {
            stage.setScene(ProductPage.getProductPage("full_overlap_apron.txt"));
        });

        search.setPromptText("Search");
        search.setPrefWidth(775);
        search.setPrefHeight(58);
        search.setMaxWidth(600);
        search.getStyleClass().add("search-bar");

        searchButton.setPickOnBounds(true);
        searchButton.setPrefHeight(55);
        searchButton.setMaxWidth(100);
        searchButton.getStyleClass().add("button-search");
        // -fx-background-color: linear-gradient(to bottom, #cccccc, #999999);


        // most popular section
        Label mostPopular = new Label("Most Popular");
        mostPopular.setStyle("-fx-text-fill: white; -fx-font-size: 20; -fx-font-weight: bold;");
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

        // most popular label
        AnchorPane.setTopAnchor(mostPopular,50.0);
        AnchorPane.setLeftAnchor(mostPopular,700.0);
        // create the anchorPane
        AnchorPane mostPopularSection = new AnchorPane();

        // set contraints for imageView
        AnchorPane.setTopAnchor(imageView, 200.0);
        AnchorPane.setLeftAnchor(imageView, 600.0); // change later

        // create buttons on each side of the image
        Button leftButton = new Button("<");
        leftButton.setStyle("-fx-font-size: 10; -fx-text-fill: white; -fx-background-color: black;");
        Button rightButton = new Button(">");
        rightButton.setStyle("-fx-font-size: 10; -fx-text-fill: white; -fx-background-color: black;");
        // Position the buttons
        AnchorPane.setTopAnchor(leftButton, 150.0);
        AnchorPane.setLeftAnchor(leftButton, 500.0);
        AnchorPane.setTopAnchor(rightButton, 150.0);
        AnchorPane.setRightAnchor(rightButton, 500.0);

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
        // create a hbox for the images]\
        mostPopularSection.getChildren().addAll(mostPopular, rightButton, imageView, leftButton);

        // browse all products section
        Label browse = new Label("Browse all Products");


        Image img = new Image("file:res/background.jpeg");
        BackgroundSize bgSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgSize);

        VBox home = new VBox(menuBar, searchBox, mostPopularSection, browse);
        home.setBackground(new Background(bgImg));

        home.getStyleClass().add("root");
        home.setSpacing(10);
        home.setPadding(new Insets(10));


        // return the vbox, FIX LATER
        return home;
    }
}


