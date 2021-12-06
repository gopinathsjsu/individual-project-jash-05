import java.util.Scanner;

import controllers.cardController;
import controllers.orderController;
import controllers.stockController;
import helper.outputGenerator;
import helper.validateOrders;

public class main {

	public static String filePathForCardDetails;

	public static void startMarket() {
		try (Scanner input = new Scanner(System.in)) {

			// Get the input file path for stock csv
			System.out.println("Enter the path for the Stock Dataset: ");
			String filePath = input.nextLine();
			stockController.getFilePath(filePath);

			// Get the input file path for cards csv
			System.out.println("Enter the path for the Card Data: ");
			String cardDetailsFilePath = input.nextLine();
			filePathForCardDetails = cardDetailsFilePath;

			System.out.println("Enter the path for the Input Data: ");
			String InputfilePath = input.nextLine();
			orderController.getFilePath(InputfilePath);

			cardController.getFilePath(cardDetailsFilePath);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void orderValidation() {
		validateOrders.getCategoryWiseCounts();
		validateOrders.checkAvailableQuantityAgainstStock();
	}

	public static void generateOutput() {
		outputGenerator.Generate();
	}

	public static void addCardToDatabase() {
		cardController.addCard(filePathForCardDetails);
	}
}
