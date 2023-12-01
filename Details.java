package application;

import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;

/**
 * Provides methods to get detail tables for specific products
 */
public class Details{
	public static HBox getCollimatorDetails() {
		
		//Description
		Label text = new Label("Features:\r\n"
				+ "Projection Lamp: White LED\r\n"
				+ "  - Single Layer Square Adjustable Field: 0x0cm to 48x48cm at 100cm SID\r\n"
				+ "  - Mounting Plane at 80 mm (3.14\") from the focus.\r\n"
				+ "  - Continuous Film Coverage from Min: 00 x 00 cm to Max: 48 x 48 cm at 100 cm (40\") SID.\r\n"
				+ "  - Minimum Inherent Filtration: 2mm/Al equivalent\r\n"
				+ "  - Accessory Guides are used for accessories and additonal filtration.\r\n"
				+ "  - Retractable Tape mounted on the side of unit for measuring SID distance.\r\n"
				+ "  - High brightness White LED simulating the X-ray field controlled by an electronic timer.\r\n"
				+ "  - Minimum Inherent Filtration 2mm/Al equivalent.\r\n"
				+ "  - Auto-centering top plate (RO 318) with high resistant resin mounting flange allowing +/-\r\n"
				+ "  - 45° rotation of the collimator, the flange is included.\r\n"
				+ "  - Dimensions: 270.5x183x168 mm\r\n"
				+ "  - 6 Pairs of Shutters");
		text.getStyleClass().add("detail-description");
		
		//Table
		GridPane table = new GridPane();
		Label stockNumHeader = new Label("Stock #");
		stockNumHeader.getStyleClass().add("table-header");
		Label priceHeader = new Label("Your Price");
		priceHeader.getStyleClass().add("table-header");
		table.add(new Label("R221"), 0, 1);
		table.add(stockNumHeader, 0, 0);
		table.add(priceHeader, 1, 0);
		table.add(new Label("$2,300.00"), 1, 1);
		table.setGridLinesVisible(true);
		table.setAlignment(Pos.CENTER);
		
		HBox hbox = new HBox(40, text, table);
		hbox.setAlignment(Pos.CENTER);
		return hbox;
	}
	
	public static HBox getApronDetails() {
		
		//Description
		Label text = new Label("The 703 brings the Classic Infab design into the Revolution line, adding a Black Belt for additional lumbar support.\r\n"
				+ " This full overlap apron is lightweight, offers great protection, and has a Classic fit.\r\n"
				+ "   - Exclusive Revolution outer material.\r\n"
				+ "   - Built in “Black Belt” for better lumbar support relieves weight from shoulder.\r\n"
				+ "   - Bacterial Resistant.\r\n"
				+ "   - Each Front Vest panel is 0.50mm giving a solid front body protection giving 1.0mm at overlap.\r\n"
				+ "   - Each Front Skirt panel is 0.25mm providing 0.50mm protection at overlap.\r\n"
				+ "   - Every \"Revolution\" series apron comes with Cool Wear Moisture-Wicking fabric standard.\r\n"
				+ "   - Professionally designed for an exceptional fit and comfort.\r\n"
				+ "   - Flame Resistant. Abrasion Resistant. 100% Waterproof.");
		text.getStyleClass().add("detail-description");
		
		//Table
		GridPane table = new GridPane();
		Label[] titles = {
			new Label("Apron Type"),
			new Label("Size"),
			new Label("Gender"),
			new Label("Stock # / Your Price")
		};
		for (int i = 0; i < titles.length; i++) {
			table.add(titles[i], i, 0);
			titles[i].getStyleClass().add("table-header");
		}
		Label[] types = {
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
		for (int i = 1; i <= types.length; i++) {
			table.add(types[i-1], 0, i);
		}
		table.setGridLinesVisible(true);
		table.setAlignment(Pos.CENTER);
		
		HBox hbox = new HBox(40, text, table);
		hbox.setAlignment(Pos.CENTER);
		
		return hbox;
	}
	
	public static HBox getGloveDetails() {
		
		//Description
		Label text = new Label("Features:\r\n"
				+ "   - Now both latex free and powder free!\r\n"
				+ "   - Made with premium, pure lead oxide for maximum protection.\r\n"
				+ "   - Thin fingertips provide enhanced tactile sensitivity.\r\n"
				+ "   - Latex-Free and Hypoallergenic finish creates a smooth interior which reduces skin irritation.\r\n"
				+ "   - Anatomically correct curved fingers reduce hand fatigue.\r\n"
				+ "   - Sizes range from 6 - 9 in half sizes for a better fit. MUST PICK SIZE at time of order.\r\n"
				+ "   - Attenuates up to 30% more direct beam radiation than other leading products.\r\n"
				+ "   - Available in 0.280mm (0.012\") and 0.220mm (0.0088\") finger tip thickness.\r\n"
				+ "   - 12\" length.\r\n"
				+ "   - Sterile packaging. (includes 1 right & 1 left)");
		text.getStyleClass().add("detail-description");
		
		//Table
		GridPane table = new GridPane();
		
		Label[] titles = {
				new Label("Stock #"),
				new Label("Thickness"),
				new Label("Your Price")
		};
		for (int i = 0; i < titles.length; i++) {
			table.add(titles[i], i, 0);
			titles[i].getStyleClass().add("table-header");
		}
		
		table.add(new Label("RR1"), 0, 1);
		table.add(new Label("RR2"), 0, 2);
		table.add(new Label("0.0088\" (.24mm)"), 1, 1);
		table.add(new Label("0.012\" (.28mm)"), 1, 2);
		table.add(new Label("$44.00"), 2, 1);
		table.add(new Label("$47.00"), 2, 2);
		table.setGridLinesVisible(true);
		table.setAlignment(Pos.CENTER);
		
		HBox hbox = new HBox(40, text, table);
		hbox.setAlignment(Pos.CENTER);
		
		return hbox;
	}
	
	public static HBox getIlluminatorDetails() {
		
		//Description
		Label text = new Label("Features:\r\n"
				+ "  - High quality, cost effective illuminators.\r\n"
				+ "  - Available in three models: one, two, and four-bank.\r\n"
				+ "  - Upper and Lower Film Grips.\r\n"
				+ "  - Internal reflectors offer consistent illumination.\r\n"
				+ "  - Includes two 15-watt fluorescent lamps.\r\n"
				+ "  - Stand alone or use the keyhole slots for wall mounting.\r\n"
				+ "  - 6 foot power cord.\r\n"
				+ "  - UL listed.");
		
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
			table.add(titles[i], i, 0);
			titles[i].getStyleClass().add("table-header");
			titles[i].setAlignment(Pos.CENTER);
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
				table.add(contents[k], i, j);
				k++;
			}
		}
		table.setAlignment(Pos.CENTER);
		table.setGridLinesVisible(true);
		
		HBox hbox = new HBox(40, text, table);
		hbox.setAlignment(Pos.CENTER);
		return hbox;
	}
}