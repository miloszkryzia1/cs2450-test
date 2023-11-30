package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductPage{
	public static Scene getProductPage(String filename) {
		
		//get data
		Image pImage = null;
		String pDescription = null;
		String pTitle = null;
		try {
    		String filePath = System.getProperty("user.dir");
			Scanner scanner = new Scanner(new File("src/products/" + filename));
			pTitle = scanner.nextLine();
			pImage = new Image("file:src/Images/" + scanner.nextLine());
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
		pImgView.setFitHeight(400);
		pImgView.setFitWidth(400);
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
		
		
		Scene scene = new Scene(vbox3,1000,1000);
		
		return scene;
	}
}