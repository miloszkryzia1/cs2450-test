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
        //stage.setFullScreen(true);
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

        //testing
        MRI2.setOnAction(event->
        {
        	getProductPage("MRI.txt" , stage);
        });

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
        Label label1 = new Label("Policy");
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
		//============================Products' page Layout===================================

		HBox buttonBox = new HBox(20, p_details, buy_button);
		buttonBox.setAlignment(Pos.CENTER);
		VBox vbox1 = new VBox(20, pDescText, buttonBox);
		vbox1.setAlignment(Pos.TOP_RIGHT);
		Pane pane = new Pane(pImgView);
		HBox hbox1 = new HBox(20, pane, vbox1);
		//HBox hbox1 = new HBox(20, pImgView, vbox1);
		hbox1.setAlignment(Pos.CENTER);
		Label warning = new Label("Please read order policy before placing the order.");
		warning.setStyle("fx-font-size: 14pt;-fx-font-weight: bold");
		Separator separator = new Separator(Orientation.HORIZONTAL);
		VBox vbox2 = new VBox(20, pTitleLabel, hbox1, separator,warning);
		vbox2.setAlignment(Pos.CENTER);
		//VBox vbox3 = new VBox(25,mb, vbox2);
		//vbox3.setAlignment(Pos.TOP_LEFT);
		//HBox hbox = new HBox(30, pImgView, pDescText);
		//VBox vbox = new VBox(20, pTitleLabel, hbox);
		
		
		//Scene scene = new Scene(vbox3);
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(mb);
		borderPane.setLeft(vbox2);
		Scene scene = new Scene(borderPane);
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
        Label label1 = new Label("Policy");
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
        
        HBox hbox1 = new HBox(mb);
        hbox1.setAlignment(Pos.CENTER);

		VBox vbox1 = new VBox(5, errormsg, searchBox);
		vbox1.setAlignment(Pos.CENTER);
		//Scene scene = new Scene(vbox3);
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(mb);
		borderPane.setLeft(vbox1);
		Scene scene = new Scene(borderPane);
		stage.setScene(scene);
		//stage.setFullScreen(true);
		stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);  // ctrl esc
        stage.setResizable(true);
        
        
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
        Label label1 = new Label("Policy");
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
    	scene.getStylesheets().add(new Details().getClass().getResource("Styling.css").toExternalForm());

    	stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH); // ctrl esc
		stage.setResizable(true);
    }
}
