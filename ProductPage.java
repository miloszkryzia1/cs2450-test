package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
			Scanner scanner = new Scanner(new File("src\\application\\products\\" + filename));
			pTitle = scanner.nextLine();
			pImage = new Image("file:src\\application\\images\\" + scanner.nextLine());
			pDescription = scanner.nextLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Image
		ImageView pImgView = new ImageView();
		pImgView.setImage(pImage);
		pImgView.setFitHeight(400);
		pImgView.setFitWidth(400);
		pImgView.setPreserveRatio(true);
		
		//Desc
		Label pDescText = new Label(pDescription);
		pDescText.setPrefSize(500, 500);
		pDescText.setWrapText(true);
		
		//Title
		Label pTitleLabel = new Label(pTitle);
		
		//Layout
		HBox hbox = new HBox(20, pImgView, pDescText);
		VBox vbox = new VBox(20, pTitleLabel, hbox);
		
		Scene scene = new Scene(vbox,1000,1000);
		
		return scene;
	}
}