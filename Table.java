package application;

import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;

/**
 * Provides methods to get detail tables for specific products
 */
public class Table{
	public static HBox getCollimatorTable() {
		
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
		//Labels
		Label stockNumLabel = new Label("Stock #");
		Label stockNum = new Label("R221");
		Label priceLabel = new Label("Your Price");
		Label price = new Label("$2,300.00");
		//Colors
		table.add(stockNumLabel, 0, 0);
		table.add(stockNum, 0, 1);
		table.add(priceLabel, 1, 0);
		table.add(price, 1, 1);
		table.setGridLinesVisible(true);
		table.setAlignment(Pos.CENTER);
		
		HBox hbox = new HBox(40, text, table);
		hbox.setAlignment(Pos.CENTER);
		return hbox;
	}
}