package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Application {
    int currentIndex =0;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        // background image
        Scene scene = new Scene(homePage(stage));
        scene.getStylesheets().add(getClass().getResource("Styling.css").toExternalForm());
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);  // ctrl esc
        stage.setResizable(true);
        stage.show();
    }
    public BorderPane homePage(Stage stage){

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

        //TEST - TEPORARY
        searchButton.setOnAction(event -> {
            getProductPage("glove.txt", stage);
        });


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
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);

        // most popular label
        AnchorPane.setTopAnchor(mostPopular,40.0);
        AnchorPane.setLeftAnchor(mostPopular,690.0);
        // create the anchorPane
        AnchorPane mostPopularSection = new AnchorPane();

        // set contraints for imageView
        AnchorPane.setTopAnchor(imageView, 80.0);
        AnchorPane.setLeftAnchor(imageView, 650.0);

        // create buttons on each side of the image
        Button leftButton = new Button("<");
        leftButton.setStyle("-fx-font-size: 10; -fx-text-fill: white; -fx-background-color: black;");
        Button rightButton = new Button(">");
        rightButton.setStyle("-fx-font-size: 10; -fx-text-fill: white; -fx-background-color: black;");
        // Position the buttons
        AnchorPane.setTopAnchor(leftButton, 150.0);
        AnchorPane.setLeftAnchor(leftButton, 580.0);
        AnchorPane.setTopAnchor(rightButton, 150.0);
        AnchorPane.setRightAnchor(rightButton, 600.0);

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

        rightButton.setOnAction(event -> {
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
        Label browse = new Label("Browse all products");
        //HBox browseBox = new HBox(browse);
        //browseBox.setAlignment(Pos.CENTER);
        browse.setAlignment(Pos.CENTER);
        browse.setPadding(new Insets(100,0,0,4));
        browse.setStyle("-fx-font-size: 16; -fx-text-fill: white");

        VBox firstRow = new VBox();
        ImageView leadApron = new ImageView(new Image("file:./res/test.png"));
        leadApron.setFitWidth(100);
        leadApron.setFitHeight(100);
        imageView.setPreserveRatio(true);

        ImageView mediumMRI = new ImageView(new Image("file:./res/test2.png"));
        mediumMRI.setFitWidth(100);
        mediumMRI.setFitHeight(100);
        imageView.setPreserveRatio(true);

        Label lead = new Label("Lead Aprons");
        lead.getStyleClass().add("browse-lead");
        Label phantom = new Label("Medium MRI Phantom");
        phantom.getStyleClass().add("browse-MRI");

        firstRow.getChildren().addAll(leadApron, lead,mediumMRI, phantom);
        firstRow.setSpacing(15);
        firstRow.setAlignment(Pos.CENTER);

        VBox secondRow = new VBox();
        // third image
        ImageView gloveImage = new ImageView(new Image("file:./res/test3.png"));
        gloveImage.setFitWidth(100);
        gloveImage.setFitHeight(100);
        imageView.setPreserveRatio(true);

        // fourth image
        ImageView animalImage = new ImageView(new Image("file:./res/test4.png"));
        animalImage.setFitWidth(100);
        animalImage.setFitHeight(100);
        animalImage.setPreserveRatio(true);

        Label radiationGloves = new Label("Radiation Reducing gloves");
        Label smallAnimalLabel = new Label("Small Animal Immobilizers");

        radiationGloves.getStyleClass().add("browse-gloves");
        smallAnimalLabel.getStyleClass().add("browse-animal");

        secondRow.getChildren().addAll(gloveImage, radiationGloves, animalImage, smallAnimalLabel);
        //secondRow.setPadding(new Insets(10));
        secondRow.setSpacing(15);
        secondRow.setAlignment(Pos.CENTER);

        HBox storeVBox = new HBox(firstRow, secondRow);
        storeVBox.setAlignment(Pos.CENTER);
        storeVBox.setSpacing(100);

        // set actions for the labels
        lead.setOnMouseClicked(event->{
            // code
        });
        phantom.setOnMouseClicked(event->{
            //code
        });
        radiationGloves.setOnMouseClicked(event->{
            // code
        });
        smallAnimalLabel.setOnMouseClicked(event->{
            //code
        });

        Image img = new Image("file:res/background.jpeg");
        BackgroundSize bgSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgSize);

        VBox testing = new VBox(menuBar, searchBox, mostPopularSection, browse);
        testing.setAlignment(Pos.CENTER);

        BorderPane home = new BorderPane();
        home.setTop(testing);
        //home.setTop(searchBox);
        home.setBottom(storeVBox);
        home.setBackground(new Background(bgImg));

        home.getStyleClass().add("root");
        //home.setSpacing(10);
        home.setPadding(new Insets(10));


        // return the vbox, FIX LATER
        return home;
    }
    /**
     * Sets the stage's scene to specified product's page
     * @param filename Product's text file with data
     * @param stage Current stage
     */
    public static void getProductPage(String filename, Stage stage) {

        //get data
        Image pImage = null;
        String pDescription = null;
        String pTitle = null;
        try {
            Scanner scanner = new Scanner(new File("src/application/products/" + filename));
            pTitle = scanner.nextLine();
            pImage = new Image("file:src/application/images/" + scanner.nextLine());
            pDescription = scanner.nextLine();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Menu bar
        MenuBar mb = new MenuBar();

        // Home Menu
        Menu home = new Menu("Home");
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

        //create order form menu
        Menu form = new Menu("Order Form");

        mb.getMenus().addAll(home, equipment, supplies, parts, form);
        mb.setPadding(new Insets(10));
        //Image
        ImageView pImgView = new ImageView();
        pImgView.setImage(pImage);
        pImgView.setFitHeight(700);
        pImgView.setFitWidth(700);
        pImgView.setPreserveRatio(true);

        //Desc
        Label pDescText = new Label(pDescription);
        pDescText.setPrefSize(400, 400);
        pDescText.setWrapText(true);

        //Title
        Label pTitleLabel = new Label(pTitle);

        //inline for Title
        pTitleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold");
        //Button
        Button p_details = new Button("Product Details");
        Button buy_button = new Button("buy Now!");
        //Layout
        HBox buttonBox = new HBox(20, p_details, buy_button);
        buttonBox.setAlignment(Pos.CENTER);
        VBox vbox1 = new VBox(20, pDescText, buttonBox);
        vbox1.setAlignment(Pos.TOP_RIGHT);
        HBox hbox1 = new HBox(20, pImgView, vbox1);
        hbox1.setAlignment(Pos.CENTER);
        VBox vbox2 = new VBox(20, pTitleLabel, hbox1);
        vbox2.setAlignment(Pos.CENTER);
        VBox vbox3 = new VBox(25,mb, vbox2);
        vbox3.setAlignment(Pos.TOP_LEFT);
        //HBox hbox = new HBox(30, pImgView, pDescText);
        //VBox vbox = new VBox(20, pTitleLabel, hbox);

        Scene scene = new Scene(vbox3);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);  // ctrl esc
        stage.setResizable(true);

    }
    
    /**
     * Sets the stage's scene to specified product's page
     * @param filename Product's text file with data
     * @param stage Current stage
     */
    
}


