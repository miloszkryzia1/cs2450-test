package application;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;

/**
 * Provides methods to get detail tables for specific products
 */
public class Details{
	public static HBox getCollimatorDetails() {
		
		//Description headers
		Label header = new Label("Features:\r\n");
		header.getStyleClass().add("desc-header");
		
		//Description
		Label text = new Label("   - Projection Lamp: White LED\r\n"
				+ "   - Single Layer Square Adjustable Field: 0x0cm to 48x48cm at 100cm SID\r\n"
				+ "   - Mounting Plane at 80 mm (3.14\") from the focus.\r\n"
				+ "   - Continuous Film Coverage from Min: 00 x 00 cm to Max: 48 x 48 cm at 100 cm (40\") SID.\r\n"
				+ "   - Minimum Inherent Filtration: 2mm/Al equivalent\r\n"
				+ "   - Accessory Guides are used for accessories and additonal filtration.\r\n"
				+ "   - Retractable Tape mounted on the side of unit for measuring SID distance.\r\n"
				+ "   - High brightness White LED simulating the X-ray field controlled by an electronic timer.\r\n"
				+ "   - Minimum Inherent Filtration 2mm/Al equivalent.\r\n"
				+ "   - Auto-centering top plate (RO 318) with high resistant resin mounting flange allowing +/-\r\n"
				+ "   - 45° rotation of the collimator, the flange is included.\r\n"
				+ "   - Dimensions: 270.5x183x168 mm\r\n"
				+ "   - 6 Pairs of Shutters");


		VBox description = new VBox(header, text);
		
		//Table
		GridPane table = new GridPane();
		Label stockNumHeader = new Label("Stock #");
		Label priceHeader = new Label("Your Price");
		table.add(new StackPane(stockNumHeader), 0, 0);
		table.add(new StackPane(priceHeader), 1, 0);
		table.add(new StackPane(new Label("R221")), 0, 1);
		table.add(new StackPane(new Label("$2,300.00")), 1, 1);
		table.setGridLinesVisible(true);
		table.setAlignment(Pos.CENTER);
		styleTable(table, 2);
		
		HBox hbox = new HBox(40, description, table);
		hbox.setAlignment(Pos.CENTER);
		return hbox;
	}
	
	public static HBox getApronDetails() {
		
		//Description headers
		Label header = new Label("The 703 brings the Classic Infab design into the Revolution line,\r\n"
				+ " adding a Black Belt for additional lumbar support.\r\n"
				+ " This full overlap apron is lightweight,\r\n"
				+ " offers great protection, and has a Classic fit.\r\n"
				+ "\r\n"
				+ "Features:\r\n");
		header.getStyleClass().add("desc-header");
		
		//Description
		Label text = new Label("   - Exclusive Revolution outer material.\r\n"
				+ "   - Built in “Black Belt” for better lumbar support relieves weight from shoulder.\r\n"
				+ "   - Bacterial Resistant.\r\n"
				+ "   - Each Front Vest panel is 0.50mm giving a solid front body protection giving 1.0mm at overlap.\r\n"
				+ "   - Each Front Skirt panel is 0.25mm providing 0.50mm protection at overlap.\r\n"
				+ "   - Every \"Revolution\" series apron comes with Cool Wear Moisture-Wicking fabric standard.\r\n"
				+ "   - Professionally designed for an exceptional fit and comfort.\r\n"
				+ "   - Flame Resistant. Abrasion Resistant. 100% Waterproof.");

		VBox description = new VBox(header, text);
		
		//Table
		GridPane table = new GridPane();
		Label[] titles = {
			new Label("Apron Type"),
			new Label("Size"),
			new Label("Gender"),
			new Label("Stock # / Your Price")
		};
		for (int i = 0; i < titles.length; i++) {
			StackPane cell = new StackPane(titles[i]);
			table.add(cell, i, 0);
		}
		Label[] contents = {
			new Label("Revolution Full Overlap\r\n"
					+ "Lumbar Vest/Skirt"),
			new Label("Revolution Full Overlap\r\n"
					+ "Lumbar Vest/Skirt"),
			new Label("Add \"Cool Wear\"\r\n"
					+ "Moisture Wicking Lining\r\n"
					+ "to BASE Apparel"),
			new Label("Revolution Thyroid Collar"),
			new Label("Attach Collar to Apron"),
			new Label("Block Embroidery, 1 line"),
			new Label("Script Embroidery, 1 line")
		};
		for (int i = 1; i <= contents.length; i++) {
			StackPane cell = new StackPane(contents[i-1]);
			table.add(cell, 0, i);
		}
		
		//remaining contents
		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 8; j++) {
				if (i == 1 && j == 1) {
					table.add(new StackPane(new Label("SPECIFY: XS,S,M,L,XL")), i, j);
				}
				else if (i == 1 && j == 2) {
					table.add(new StackPane(new Label("2X")), i, j);
				}
				else if (i == 1 && j == 4) {
					table.add(new StackPane(new Label("One Size Fits All")), i, j);
				}
				else if ((i == 2 && j == 1) || (i == 2 && j == 2) || (i == 2 && j == 4)){
					table.add(new StackPane(new Label("Unisex")), i, j);
				}
				else if (i == 3) {
					if (j == 1) { table.add(new StackPane(new Label("703 / $1,250.00")), i, j); }
					else if (j == 2) { table.add(new StackPane(new Label("7032X / $1,335.00")), i, j); }
					else if (j == 3) { table.add(new StackPane(new Label("CW / $95.00")), i, j); }
					else if (j == 4) { table.add(new StackPane(new Label("REV-TC-KI-LF / $160.00")), i, j); }
					else if (j == 5) { table.add(new StackPane(new Label("KTC / $16.00")), i, j); }
					else if (j == 6) { table.add(new StackPane(new Label("BNME / $35.00")), i, j); }
					else if (j == 7) { table.add(new StackPane(new Label("SNME / $35.00")), i, j); }
				}
				else {
					table.add(new StackPane(new Label("-")), i, j);
				}
			}
		}
		
		table.setGridLinesVisible(true);
		table.setAlignment(Pos.CENTER);
		styleTable(table, 4);
		
		HBox hbox = new HBox(40, description, table);
		hbox.setAlignment(Pos.CENTER);
		
		return hbox;
	}
	
	public static HBox getGloveDetails() {
		
		//Description headers
		Label header = new Label("Features:\r\n");
		header.getStyleClass().add("desc-header");
		
		//Description
		Label text = new Label("   - Now both latex free and powder free!\r\n"
				+ "   - Made with premium, pure lead oxide for maximum protection.\r\n"
				+ "   - Thin fingertips provide enhanced tactile sensitivity.\r\n"
				+ "   - Latex-Free and Hypoallergenic finish creates a smooth interior which reduces skin irritation.\r\n"
				+ "   - Anatomically correct curved fingers reduce hand fatigue.\r\n"
				+ "   - Sizes range from 6 - 9 in half sizes for a better fit. MUST PICK SIZE at time of order.\r\n"
				+ "   - Attenuates up to 30% more direct beam radiation than other leading products.\r\n"
				+ "   - Available in 0.280mm (0.012\") and 0.220mm (0.0088\") finger tip thickness.\r\n"
				+ "   - 12\" length.\r\n"
				+ "   - Sterile packaging. (includes 1 right & 1 left)");
		
		VBox description = new VBox(header, text);
		
		//Table
		GridPane table = new GridPane();
		
		Label[] titles = {
				new Label("Stock #"),
				new Label("Thickness"),
				new Label("Your Price")
		};
		for (int i = 0; i < titles.length; i++) {
			StackPane cell = new StackPane(titles[i]);
			table.add(cell, i, 0);
		}
		
		table.add(new StackPane(new Label("RR1")), 0, 1);
		table.add(new StackPane(new Label("RR2")), 0, 2);
		table.add(new StackPane(new Label("0.0088\" (.24mm)")), 1, 1);
		table.add(new StackPane(new Label("0.012\" (.28mm)")), 1, 2);
		table.add(new StackPane(new Label("$44.00")), 2, 1);
		table.add(new StackPane(new Label("$47.00")), 2, 2);
		table.setGridLinesVisible(true);
		table.setAlignment(Pos.CENTER);
		styleTable(table, 3);
		
		HBox hbox = new HBox(40, description, table);
		hbox.setAlignment(Pos.CENTER);
		
		return hbox;
	}
	
	public static HBox getIlluminatorDetails() {
		
		//Description headers
		Label header = new Label("Features:\r\n");
		header.getStyleClass().add("desc-header");
		
		//Description
		Label text = new Label("  - High quality, cost effective illuminators.\r\n"
				+ "  - Available in three models: one, two, and four-bank.\r\n"
				+ "  - Upper and Lower Film Grips.\r\n"
				+ "  - Internal reflectors offer consistent illumination.\r\n"
				+ "  - Includes two 15-watt fluorescent lamps.\r\n"
				+ "  - Stand alone or use the keyhole slots for wall mounting.\r\n"
				+ "  - 6 foot power cord.\r\n"
				+ "  - UL listed.");
		
		VBox description = new VBox(header, text);
		
		//Table
		GridPane table = new GridPane();
		Label[] titles = {
			new Label("Stock #"),
			new Label("Viewbox Configuration"),
			new Label("Size"),
			new Label("Shipping Weight"),
			new Label("Your Price")
		};
		for (int i = 0; i < titles.length; i++) {
			StackPane cell = new StackPane(titles[i]);
			table.add(cell, i, 0);
		}
		Label[] contents = {
			new Label("VBS-10"),
			new Label("VBD-20"),
			new Label("VBQ-40"),
			new Label("Single Unit"),
			new Label("2 Bank Unit"),
			new Label("4 Bank Unit"),
			new Label("14W x 3-1/2D x 21-3/4\"H (356 x 89 x 553mm)"),
			new Label("28W x 3-1/2D x 21-3/4\"H (711 x 89 x 553mm)"),
			new Label("56W x 3-1/2D x 21-3/4\"H (1422 x 89 x 553mm) Ships Motor Freight"),
			new Label("17 lbs. (8 kg)"),
			new Label("34 lbs. (15.5 kg)"),
			new Label("80 lbs. (37 kg)"),
			new Label("$833.33"),
			new Label("$1,666.67"),
			new Label("$1,614.61")
		};
		int k = 0;
		for (int i = 0; i < titles.length; i++) {
			for (int j = 1; j <= 3; j++) {
				StackPane cell = new StackPane(contents[k]);
				table.add(cell, i, j);
				k++;
			}
		}
		table.setAlignment(Pos.CENTER);
		table.setGridLinesVisible(true);
		styleTable(table, 5);
		
		HBox hbox = new HBox(40, description, table);
		hbox.setAlignment(Pos.CENTER);
		return hbox;
	}
	
	public static HBox getImmobilizerDetails() {
		
		//Description headers
		Label header = new Label("Features:\r\n");
		header.getStyleClass().add("desc-header");
		
		//Description
		Label text = new Label("- \"Techo-Tuff\" Black Vinyl.\r\n"
				+ "   - Light and extremely durable, radiolucent design.\r\n"
				+ "   - Unique v-shaped design to reduce motion and prevent falls during procedures.\r\n"
				+ "   - Included hook & loop straps quickly and conveniently attach anywhere\r\n"
				+ "     along the entire trough to fit any positioning need.\r\n"
				+ "   - Waterproof, stain proof and anti-microbial black vinyl fabric!\r\n"
				+ "   - Easy and safe to clean with standard germicides and mild cleaners.\r\n"
				+ "   - Available in four standard sizes to meet nearly every need!");
		
		VBox description = new VBox(header, text);
		
		//Table
		GridPane table = new GridPane();
		Label[] titles = {
			new Label("Stock #"),
			new Label("Size"),
			new Label("Dimensions"),
			new Label("Your Price")
		};
		for (int i = 0; i < titles.length; i++) {
			StackPane cell = new StackPane(titles[i]);
			table.add(cell, i, 0);
		}
		Label[] contents = {
				new Label("VIT-X"),
				new Label("VIT-L"),
				new Label("VIT-M"),
				new Label("VIT-S"),
				new Label("VIT-B"),
				new Label("X-Large"),
				new Label("Large"),
				new Label("Medium"),
				new Label("Small"),
				new Label("Bundle (includes all above)"),
				new Label("36\" x 14\" x 9\" high"),
				new Label("24\"x 11\"x 7\" high"),
				new Label("15\"x 7\"x 5\" high"),
				new Label("10\"x 4\"x 3\" high"),
				new Label("See Above Sizing"),
				new Label("$345.00"),
				new Label("$240.00"),
				new Label("$165.00"),
				new Label("$140.00"),
				new Label("$849.33")
		};
		int k = 0;
		for (int i = 0; i < titles.length; i++) {
			for (int j = 1; j <= 3; j++) {
				StackPane cell = new StackPane(contents[k]);
				table.add(cell, i, j);
				k++;
			}
		}
		
		table.setAlignment(Pos.CENTER);
		table.setGridLinesVisible(true);
		styleTable(table, 4);
		
		HBox hbox = new HBox(40, description, table);
		hbox.setAlignment(Pos.CENTER);
		return hbox;
	}
	
	public static HBox getMriDetails() {
		
		//Description headers
		Label header1 = new Label("It can be used to measure:\r\n");
		header1.getStyleClass().add("desc-header");
		Label header2 = new Label("Technical data:\r\n");
		header2.getStyleClass().add("desc-header");
		
		//Description
		Label text1 = new Label("   - geometric distortion\r\n"
				+ "   - spatial resolution\r\n"
				+ "   - slice thickness and position\r\n"
				+ "   - interslice Gap\r\n"
				+ "   - image bandwidth\r\n"
				+ "   - low contrast detectability\r\n"
				+ "   - image uniformity\r\n"
				+ "   - signal-to-noise ratio (SNR)\r\n"
				+ "   - physical and electronic slice offset\r\n"
				+ "   - point of reference\r\n"
				+ "   - bandwidth: water-fat shift\r\n");
		Label text2 = new Label("   - outside cylinder diameter: 178 mm\r\n"
				+ "   - outside cylinder height: 157 mm\r\n"
				+ "   - inside cylinder diameter: 165 mm\r\n"
				+ "   - inside cylinder height: 134 mm\r\n"
				+ "   - filled with 10 mmol nickel chloride solution \r\n"
				+ "     containing sodium chloride 75 mmol\r\n");
		
		VBox description = new VBox(header1,text1,header2,text2);
		
		//Table
		GridPane table = new GridPane();
		table.getStyleClass().add("table");
		Label[] titles = {
				new Label("Stock #"),
				new Label("Description"),
				new Label("Case Included?"),
				new Label("ACR Rated?"),
				new Label("Your Price")
			};
			for (int i = 0; i < titles.length; i++) {
				StackPane cell = new StackPane(titles[i]);
				table.add(cell, i, 0);
			}
			Label[] contents = {
					new Label("09-301"),
					new Label("09-104"),
					new Label("09-102"),
					new Label("09-103"),
					new Label("09-201"),
					new Label("09-202"),
					new Label("Pro-MRI ACR Medium MRI Phantom"),
					new Label("Pro-MRI Detachable 3-axis spirit level"),
					new Label("Pro-MRI Heavy Duty Carrying Case"),
					new Label("Pro-MRI - 6 removable vials option\r\n"
							+ "with 6 extra vials (12 in total)"),
					new Label("Pro-MRI SpineRect"),
					new Label("Pro-MRI Agar"),
					new Label("Yes"),
					new Label("NA"),
					new Label("NA"),
					new Label("NA"),
					new Label("NA"),
					new Label("NA"),
					new Label("Yes"),
					new Label("NA"),
					new Label("NA"),
					new Label("NA"),
					new Label("NA"),
					new Label("NA"),
					new Label("$2,675.00"),
					new Label("$295.00"),
					new Label("$275.00"),
					new Label("$495.00"),
					new Label("$1,375.00"),
					new Label("$775.00")
			};
			int k = 0;
			for (int i = 0; i < titles.length; i++) {
				for (int j = 1; j <= 3; j++) {
					StackPane cell = new StackPane(contents[k]);
					table.add(cell, i, j);
					k++;
				}
			}
			
			table.setAlignment(Pos.CENTER);
			table.setGridLinesVisible(true);
			styleTable(table, 5);
			
			HBox hbox = new HBox(40, description, table);
			hbox.setAlignment(Pos.CENTER);
			return hbox;
	}
	
	// Align elements in a table
	public static void styleTable(GridPane table, int columnCount) {
		for (int i = 0; i < table.getChildren().size(); i++){
			Node node = table.getChildren().get(i);
			if (node instanceof StackPane) {
				if (i < columnCount) {
					((StackPane)node).setBackground(new Background(new BackgroundFill(Color.web("#589169"), CornerRadii.EMPTY, Insets.EMPTY)));
					if (((StackPane)node).getChildren().get(0) instanceof Label) {
						((Label)((StackPane)node).getChildren().get(0)).setPadding(new Insets(10,10,10,10));
						((Label)((StackPane)node).getChildren().get(0)).setStyle("-fx-font-size: 12.5pt");
						((Label)((StackPane)node).getChildren().get(0)).setTextFill(Color.WHITE);
					}
				}
				else {
					((StackPane)node).setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
					if (((StackPane)node).getChildren().get(0) instanceof Label) {
						((Label)((StackPane)node).getChildren().get(0)).setPadding(new Insets(10,10,10,10));
						((Label)((StackPane)node).getChildren().get(0)).setStyle("-fx-font-size: 12.5pt");
						((Label)((StackPane)node).getChildren().get(0)).setTextFill(Color.BLACK);
					}
				}
			}
		}
	}
}