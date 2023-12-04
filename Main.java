package application;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.util.Duration;
import java.io.*;
import javafx.scene.Parent;

public class Main extends Application {
    int currentIndex =0;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        //Load fonts
        Font.loadFont(getClass().getResourceAsStream("fonts/FiraSans-Regular.ttf"), 12);
        Font.loadFont(getClass().getResourceAsStream("fonts/FiraSans-Bold.ttf"), 12);

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

        //Menu bar
        MenuBar mb = new MenuBar();

        // Home Menu

        Label label = new Label("Home");
        label.setOnMouseClicked(event->
        {
            start(stage);
        });
        Menu home = new Menu("", label);
        // create the equipments menu
        Menu equipment = new Menu("Equipment");
        MenuItem item1 = new MenuItem("Illuminator");
        MenuItem item2 = new MenuItem("Small Animal immobilizers");
        equipment.getItems().addAll(item1,item2);

        // create supplies menu
        Menu supplies = new Menu("Supplies");
        MenuItem item3 = new MenuItem("Lead Apron");
        MenuItem item4 = new MenuItem("Radiation Reducing Gloves");
        supplies.getItems().addAll(item3, item4);

        // create the parts menu
        Menu parts = new Menu("Parts");
        MenuItem item5 = new MenuItem("Collimator");
        MenuItem item6 = new MenuItem("MRI");
        parts.getItems().addAll(item5, item6);

        //Order Policy
        Label label1 = new Label("Order Policy");
        Menu policy = new Menu("", label1);

        label1.setOnMouseClicked(event->
        {
            openLink("http://www.pnwx.com/Buy/");
        });
        //===============Display products from menu=================
        item1.setOnAction(event->{
            getProductPage("illuminators.txt" , stage);
        });
        item2.setOnAction(event->{
            getProductPage("immobilizer.txt" , stage);
        });
        item3.setOnAction(event->{
            getProductPage("full_overlap_apron.txt" , stage);
        });
        item4.setOnAction(event->{
            getProductPage("glove.txt" , stage);
        });
        item5.setOnAction(event->{
            getProductPage("collimator.txt" , stage);
        });
        item6.setOnAction(event->{
            getProductPage("MRI.txt", stage);
        });

        mb.getMenus().addAll(home, equipment, supplies, parts, policy);
        //mb.setPadding(new Insets(10));
        mb.setStyle("-fx-padding: 10 60 10 60;");

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
        search.setPrefWidth(650);
        search.setPrefHeight(50);
        search.setMaxWidth(500);
        search.getStyleClass().add("search-bar");

        // textField testing
        searchButton.setOnAction(event ->
        {
            String userInput = search.getText().toLowerCase();
            if (userInput.contains("apron")) {
                getProductPage("full_overlap_apron.txt" , stage);
            } else if (userInput.contains("mri"))
            {
                getProductPage("MRI.txt" , stage);
            } else if (userInput.contains("collimator"))
            {
                getProductPage("collimator.txt" , stage);
            } else if (userInput.contains("glove"))
            {
                getProductPage("glove.txt" , stage);
            } else if (userInput.contains("illuminator"))
            {
                getProductPage("illuminators.txt" , stage);
            } else if (userInput.contains("small animal immobilizer"))
            {
                getProductPage("immobilizer.txt" , stage);
            }	else
            {
                errorPage(stage);
            }

        });
        searchButton.setPickOnBounds(true);
        searchButton.setPrefHeight(55);
        searchButton.setMaxWidth(100);
        searchButton.getStyleClass().add("button");
        // -fx-background-color: linear-gradient(to bottom, #cccccc, #999999);

        // most popular section
        Label mostPopular = new Label("Most Popular");
        mostPopular.setStyle("-fx-text-fill: black; -fx-font-size: 20;");
        // create an array of image objects with four images from the application folder
        Image[] images = new Image[4];
        // resize the images to 300 by 200 when loading them
        // false, false = parameters for smooth and background loading. if set to true, the images move the bottom buttons
        images[0] = new Image("file:src/application/images/glove.png", 260, 200, false, false);
        images[1] = new Image("file:src/application/images/immobilizer.png", 260, 200, false, false);
        images[2] = new Image ("file:src/application/images/illuminator.png", 260, 200, false, false);
        images[3] = new Image("file:src/application/images/collimator.png", 260, 200, false, false);
        ImageView imageView = new ImageView(images[0]);
        // Link to appropriate product
        imageView.setOnMouseClicked(event ->{
        	String pName = imageView.getImage().getUrl();
        	String filename = pName.split("/")[pName.split("/").length - 1].replace("png", "txt");
        	if (filename.equals("illuminator.txt")) { 
        		filename = "illuminators.txt";
        	}
        	getProductPage(filename, stage);
        });
        // set the preserveRatio to true
        imageView.setPreserveRatio(true);

        // create the anchorPane, allows positioning its children at arbitrary locations
        AnchorPane mostPopularSection = new AnchorPane();
        // most popular label
        AnchorPane.setTopAnchor(mostPopular,40.0);
        AnchorPane.setLeftAnchor(mostPopular,710.0);

        // set contraints for imageView
        AnchorPane.setTopAnchor(imageView, 80.0);
        AnchorPane.setLeftAnchor(imageView, 650.0);

        // create buttons on each side of the image
        Button leftButton = new Button("<");
        leftButton.setStyle("-fx-font-size: 30; -fx-text-fill: black; -fx-background-color: transparent;");
        Button rightButton = new Button(">");
        rightButton.setStyle("-fx-font-size: 30; -fx-text-fill: black; -fx-background-color: transparent;");
        // Position the buttons
        AnchorPane.setTopAnchor(leftButton, 150.0);
        AnchorPane.setLeftAnchor(leftButton, 520.0);
        AnchorPane.setTopAnchor(rightButton, 150.0);
        AnchorPane.setRightAnchor(rightButton, 510.0);

        // changes the currentIndex variable and sets the image view to the new image
        // wraps around the index if it goes out of bounds, so the images are displayed in a circular order
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

        mostPopularSection.getChildren().addAll(mostPopular, rightButton, imageView, leftButton);

        // browse all products section
        Label browse = new Label("Browse all products");
        browse.setAlignment(Pos.CENTER);
        browse.setPadding(new Insets(80,0,0,0));
        browse.setStyle("-fx-font-size: 20; -fx-text-fill: black");

        VBox firstRow = new VBox();

        // create two imageView objects for the first column
        ImageView leadApron = new ImageView(new Image("file:src/application/images/full_overlap_apron.png"));
        leadApron.setFitWidth(100);
        leadApron.setFitHeight(100);
        // images will maintain their original aspect ratio when resized
        imageView.setPreserveRatio(true);

        ImageView mediumMRI = new ImageView(new Image("file:src/application/images/MRI.png"));
        mediumMRI.setFitWidth(100);
        mediumMRI.setFitHeight(100);
        imageView.setPreserveRatio(true);

        // create buttons with text, labels do not have set on action so choose buttons
        Button lead = new Button("Lead Aprons");
        lead.getStyleClass().add("browse-lead");
        lead.setStyle("-fx-background-color: transparent");

        lead.setOnAction(event->{
            getProductPage("full_overlap_apron.txt", stage);
        });


        Button phantom = new Button("Medium MRI Phantom");
        phantom.setStyle("-fx-background-color: transparent");
        phantom.getStyleClass().add("browse-MRI");

        phantom.setOnAction(event->{
            getProductPage("MRI.txt", stage);
        });

        firstRow.getChildren().addAll(leadApron, lead,mediumMRI, phantom);
        firstRow.setSpacing(15);
        firstRow.setAlignment(Pos.CENTER);

        // second column of the browse all products
        VBox secondRow = new VBox();
        // third image
        ImageView gloveImage = new ImageView(new Image("file:src/application/images/glove.png"));
        gloveImage.setFitWidth(105);
        gloveImage.setFitHeight(105);
        imageView.setPreserveRatio(true);

        // fourth image
        ImageView animalImage = new ImageView(new Image("file:src/application/images/immobilizer.png"));
        animalImage.setFitWidth(120);
        animalImage.setFitHeight(120);
        animalImage.setPreserveRatio(true);

        // create buttons for those images
        Button radiationGloves = new Button("Radiation Reducing gloves");
        Button smallAnimalButton = new Button("Small Animal Immobilizers");

        radiationGloves.setOnAction(event->{
            getProductPage("glove.txt", stage);
        });

        smallAnimalButton.setOnAction(event->{
            getProductPage("immobilizer.txt", stage);
        });
        radiationGloves.getStyleClass().add("browse-gloves");
        radiationGloves.setStyle("-fx-background-color: transparent");
        smallAnimalButton.getStyleClass().add("browse-animal");
        smallAnimalButton.setStyle("-fx-background-color: transparent");

        secondRow.getChildren().addAll(gloveImage, radiationGloves, animalImage, smallAnimalButton);
        //secondRow.setPadding(new Insets(10));
        secondRow.setSpacing(15);
        secondRow.setAlignment(Pos.CENTER);

        HBox storeVBox = new HBox(firstRow, secondRow);
        storeVBox.setAlignment(Pos.CENTER);
        storeVBox.setSpacing(150);
        //storeVBox.setPadding(new Insets(10,0, 30, 0));

        // put menu bar, search box, most popular section and the browse lable in  a vbox
        VBox top = new VBox(mb, searchBox, mostPopularSection, browse);
        top.setAlignment(Pos.CENTER);

        BorderPane homeBp = new BorderPane();
        homeBp.setTop(top);
        // set the browse section at the bottom
        homeBp.setBottom(storeVBox);

        homeBp.getStyleClass().add("root");


        // return the borderPane
        return homeBp;
    }
//================================== Product Page ==============================

    static String pTitle = null;
    /**
     * Sets the stage's scene to specified product's page
     * @param filename Product's text file with data
     * @param stage Current stage
     */
    public void getProductPage(String filename, Stage stage) {

        //get data
        Image pImage = null;
        String pDescription = null;

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

        Label label = new Label("Home");
        label.setOnMouseClicked(event->
        {
            start(stage);
        });
        Menu home = new Menu("", label);
        // create the equipments menu
        Menu equipment = new Menu("Equipment");
        MenuItem item1 = new MenuItem("Illuminator");
        MenuItem item2 = new MenuItem("Small Animal immobilizers");
        equipment.getItems().addAll(item1,item2);

        // create supplies menu
        Menu supplies = new Menu("Supplies");
        MenuItem item3 = new MenuItem("Lead Apron");
        MenuItem item4 = new MenuItem("Radiation Reducing Gloves");
        supplies.getItems().addAll(item3, item4);

        // create the parts menu
        Menu parts = new Menu("Parts");
        MenuItem item5 = new MenuItem("Collimator");
        MenuItem item6 = new MenuItem("MRI");
        parts.getItems().addAll(item5, item6);

        //Order Policy
        Label label1 = new Label("Order Policy");
        Menu policy = new Menu("", label1);
        label1.setOnMouseClicked(event->
        {
            openLink("http://www.pnwx.com/Buy/");
        });
        //===============Display products from menu=================
        item1.setOnAction(event->{
            getProductPage("illuminators.txt" , stage);
        });
        item2.setOnAction(event->{
            getProductPage("immobilizer.txt" , stage);
        });
        item3.setOnAction(event->{
            getProductPage("full_overlap_apron.txt" , stage);
        });
        item4.setOnAction(event->{
            getProductPage("glove.txt" , stage);
        });
        item5.setOnAction(event->{
            getProductPage("collimator.txt" , stage);
        });
        item6.setOnAction(event->{
            getProductPage("MRI.txt", stage);
        });

        mb.getMenus().addAll(home, equipment, supplies, parts, policy);
        //mb.setPadding(new Insets(10));
        mb.setStyle("-fx-padding: 10 60 10 60;");
        //Image
        ImageView pImgView = new ImageView();
        pImgView.setImage(pImage);
        pImgView.setFitHeight(500);
        pImgView.setFitWidth(500);
        pImgView.setPreserveRatio(true);

        //Animating
        pImgView.setScaleX(1.0);
        pImgView.setScaleY(1.0);
        ScaleTransition sTransition = new ScaleTransition(new Duration(500), pImgView);
        sTransition.setFromX(1.0);
        sTransition.setFromY(1.0);
        sTransition.setToX(1.055);
        sTransition.setToY(1.055);

        pImgView.setOnMouseEntered(event ->
        {
            sTransition.setRate(1.0);
            sTransition.playFromStart();
        });
        pImgView.setOnMouseExited(event ->
        {
            sTransition.setRate(-1.0);
            sTransition.play();
        });
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
        //redirect to details
        p_details.setOnAction(event -> {
            getDetailsPage(filename, pTitle, stage.getScene(), stage);
        });

        Button buy_button = new Button("Buy Now!");
        // redirect to order form
        buy_button.setOnAction(event->
        {
            openLink("http://www.pnwx.com/PNWX-OrderForm.pdf");
        });
        //============================Search Bar==============================================
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
        search.setPrefWidth(650);
        search.setPrefHeight(50);
        search.setMaxWidth(500);
        search.getStyleClass().add("search-bar");
        
        // textField testing
        searchButton.setOnAction(event ->
        {
        	String userInput = search.getText().toLowerCase();
        	 if (userInput.contains("apron")) {
        		 getProductPage("full_overlap_apron.txt" , stage);
             } else if (userInput.contains("mri"))
             {
            	 getProductPage("MRI.txt" , stage);
             } else if (userInput.contains("collimator"))
             {
            	 getProductPage("collimator.txt" , stage);
             } else if (userInput.contains("glove"))
             {
            	 getProductPage("glove.txt" , stage);
             } else if (userInput.contains("illuminator"))
             {
            	 getProductPage("illuminators.txt" , stage);
             } else if (userInput.contains("small animal immobilizer"))
             {
            	 getProductPage("immobilizer.txt" , stage);
             }	else
             {
            	 errorPage(stage);
             }
 
        });
        searchButton.setPickOnBounds(true);
        searchButton.setPrefHeight(55);
        searchButton.setMaxWidth(100);
        searchButton.getStyleClass().add("button-search");
    //============================Products' page Layout===================================
        HBox buttonBox = new HBox(20, p_details, buy_button);
		buttonBox.setAlignment(Pos.CENTER);
		Pane pane = new Pane(pImgView);
		GridPane gridPane = new GridPane();
		gridPane.add(pane, 0 , 0);
		gridPane.add(pDescText, 1,0);
		gridPane.add(buttonBox, 1, 1);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(30);
		Label warning = new Label("Please read order policy before placing the order.");
		warning.setStyle("fx-font-size: 14pt;-fx-font-weight: bold");
		Separator separator = new Separator(Orientation.HORIZONTAL);
		VBox vbox1 = new VBox(20, searchBox,pTitleLabel,gridPane, separator, warning);
		vbox1.setAlignment(Pos.CENTER);
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(mb);
		VBox vbox2 = new VBox(10, borderPane, vbox1);
		//borderPane.setCenter(vbox1);
		Scene scene = new Scene(vbox2);
		scene.getStylesheets().add(getClass().getResource("Styling.css").toExternalForm());
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);  // ctrl esc
        stage.setResizable(true);
    }
//======================== Open Link Method==============================
    private void openLink(String url) {
        HostServices hostServices = getHostServices();
        hostServices.showDocument(url);
    }
//==================== Error Page ======================================
    public void errorPage(Stage stage)
    {
    	Label errormsg = new Label("No Matches - Please revive your query and try again! ");
    	
    	//Menu bar
        MenuBar mb = new MenuBar();
        
        // Home Menu
        Label label = new Label("Home");
        label.setOnMouseClicked(event->
        {
        	start(stage);
        });
        Menu home = new Menu("", label);
		// create the equipments menu
        Menu equipment = new Menu("Equipment");
        MenuItem item1 = new MenuItem("Illuminator");
        MenuItem item2 = new MenuItem("Small Animal immobilizers");
        equipment.getItems().addAll(item1,item2);
       
        // create supplies menu
        Menu supplies = new Menu("Supplies");
        MenuItem item3 = new MenuItem("Lead Apron");
        MenuItem item4 = new MenuItem("Radiation Reducing Gloves");
        supplies.getItems().addAll(item3, item4);

        // create the parts menu
        Menu parts = new Menu("Parts");
        MenuItem item5 = new MenuItem("Collimator");
        MenuItem item6 = new MenuItem("MRI");
        parts.getItems().addAll(item5, item6);
        
        //Order Policy
        Label label1 = new Label("Order Policy");
        Menu policy = new Menu("", label1);
        label1.setOnMouseClicked(event->
        {
        	openLink("http://www.pnwx.com/Buy/");
        });
        //===============Display products from menu=================
        item1.setOnAction(event->{
        	getProductPage("illuminators.txt" , stage);
        });
        item2.setOnAction(event->{
        	getProductPage("immobilizer.txt" , stage);
        });
        item3.setOnAction(event->{
        	getProductPage("full_overlap_apron.txt" , stage);
        });
        item4.setOnAction(event->{
        	getProductPage("glove.txt" , stage);
        });
        item5.setOnAction(event->{
        	getProductPage("collimator.txt" , stage);
        });
        item6.setOnAction(event->{
        	getProductPage("MRI.txt", stage);
        });
       
        mb.getMenus().addAll(home, equipment, supplies, parts, policy);
        //mb.setPadding(new Insets(10));
        mb.setStyle("-fx-padding: 10 60 10 60;");
        
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
        
        searchButton.setOnAction(event ->
        {
        	String userInput = search.getText().toLowerCase();
        	 if (userInput.contains("apron")) {
        		 getProductPage("full_overlap_apron.txt" , stage);
             } else if (userInput.contains("mri"))
             {
            	 getProductPage("MRI.txt" , stage);
             } else if (userInput.contains("collimator"))
             {
            	 getProductPage("collimator.txt" , stage);
             } else if (userInput.contains("glove"))
             {
            	 getProductPage("glove.txt" , stage);
             } else if (userInput.contains("illuminator"))
             {
            	 getProductPage("illuminators.txt" , stage);
             } else if (userInput.contains("small animal immobilizer"))
             {
            	 getProductPage("immobilizer.txt" , stage);
             }	else
             {
            	 errorPage(stage);
             }
 
        });
        
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(mb);
        VBox vbox = new VBox(20, searchBox, errormsg);
        vbox.setAlignment(Pos.CENTER);
        VBox vbox1 = new VBox(10, borderPane,vbox);
        Scene scene = new Scene(vbox1);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("Styling.css").toExternalForm());
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);  // ctrl esc
        stage.setResizable(true);
        stage.show();
        }


    //======================== Open Details Page for a Specified Product ==============================
    public void getDetailsPage(String filename, String productName, Scene previousScene, Stage stage) {

        //Menu bar
        MenuBar mb = new MenuBar();

        // Home Menu

        Label label = new Label("Home");
        label.setOnMouseClicked(event->
        {
            start(stage);
        });
        Menu home = new Menu("", label);
        // create the equipments menu
        Menu equipment = new Menu("Equipment");
        MenuItem item1 = new MenuItem("Illuminator");
        MenuItem item2 = new MenuItem("Small Animal immobilizers");
        equipment.getItems().addAll(item1,item2);

        // create supplies menu
        Menu supplies = new Menu("Supplies");
        MenuItem item3 = new MenuItem("Lead Apron");
        MenuItem item4 = new MenuItem("Radiation Reducing Gloves");
        supplies.getItems().addAll(item3, item4);

        // create the parts menu
        Menu parts = new Menu("Parts");
        MenuItem item5 = new MenuItem("Collimator");
        MenuItem item6 = new MenuItem("MRI");
        parts.getItems().addAll(item5, item6);

        //Order Policy
        Label label1 = new Label("Order Policy");
        Menu policy = new Menu("", label1);
        label1.setOnMouseClicked(event->
        {
            openLink("http://www.pnwx.com/Buy/");
        });
        //===============Display products from menu=================
        item1.setOnAction(event->{
            getProductPage("illuminators.txt" , stage);
        });
        item2.setOnAction(event->{
            getProductPage("immobilizer.txt" , stage);
        });
        item3.setOnAction(event->{
            getProductPage("full_overlap_apron.txt" , stage);
        });
        item4.setOnAction(event->{
            getProductPage("glove.txt" , stage);
        });
        item5.setOnAction(event->{
            getProductPage("collimator.txt" , stage);
        });
        item6.setOnAction(event->{
            getProductPage("MRI.txt", stage);
        });

        mb.getMenus().addAll(home, equipment, supplies, parts, policy);
        //mb.setPadding(new Insets(10));
        mb.setStyle("-fx-padding: 10 60 10 60;");

        //Title
        Label name = new Label(productName);
        name.setId("product-name");
        name.setStyle("-fx-font-size: 20.0pt");
        Label l = new Label("Product Details");
        l.setStyle("-fx-font-size: 20.0pt");
        VBox title = new VBox(name, l);
        title.setAlignment(Pos.CENTER);

        //Back button
        Button backBtn = new Button("Back");
        backBtn.setOnAction(event -> {
            stage.setScene(previousScene);
            stage.setFullScreen(true);
            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH); // ctrl esc
            stage.setResizable(true);
        });

        // TODO needs an argument and check what product to display
        Parent content;
        switch (filename) {
            case ("collimator.txt"):
                content = Details.getCollimatorDetails();
                break;
            case ("full_overlap_apron.txt"):
                content = Details.getApronDetails();
                break;
            case ("glove.txt"):
                content = Details.getGloveDetails();
                break;
            case ("illuminators.txt"):
                content = Details.getIlluminatorDetails();
                break;
            case ("immobilizer.txt"):
                content = Details.getImmobilizerDetails();
                break;
            case ("MRI.txt"):
                content = Details.getMriDetails();
                break;
            default:
                return;
        }

        VBox vbox = new VBox(40, title, content, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20,20,20,20));

        BorderPane bp = new BorderPane();
        bp.setTop(mb);
        bp.setCenter(vbox);

        Scene scene = new Scene(bp);
        scene.getStylesheets().add(getClass().getResource("Styling.css").toExternalForm());

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH); // ctrl esc
        stage.setResizable(true);
    }
}
