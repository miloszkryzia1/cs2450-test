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
		
		//Table
		GridPane table = new GridPane();
		table.add(new Label("R221"), 0, 0);
		table.add(new Label("Stock #"), 0, 1);
		table.add(new Label("Your Price"), 1, 0);
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
		
		//Table
		GridPane table = new GridPane();
		table.add(new Label("Stock #"), 0, 0);
		table.add(new Label("Thickness"), 1, 0);
		table.add(new Label("Your Price"), 2, 0);
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
}