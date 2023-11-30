package application;


import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;

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
        //TEST - TEPORARY
        searchButton.setOnAction(event -> {
        	getProductPage("glove.txt", stage);
        });
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
        MenuItem item3 = new MenuItem("Lead Apron");
        MenuItem item4 = new MenuItem("Radiation Reducing Gloves");
        supplies.getItems().addAll(item3, item4);

        // create the parts menu
        Menu parts = new Menu("Parts");
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
}


