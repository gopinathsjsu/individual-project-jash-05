package helper;

import controllers.*;
import models.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class outputGenerator {
	static int randomNum = ThreadLocalRandom.current().nextInt(1, 100);

	public static void Generate() {
		try {

			if (validateOrders.InValidOrders.size() == 0) {
				FileWriter errorFile = new FileWriter(
						"/Applications/projects/individual-project-jash-05/outputs" + "/Order_" + randomNum + ".txt");
				errorFile.write("Amount Paid : \n");
				errorFile.write(validateOrders.TotalAmountPaid + "\n");
				errorFile.close();
				System.out.println("Output file for Orders has been generated at the given path !");
			} else {
				FileWriter errorFile = new FileWriter(
						"/Applications/projects/individual-project-jash-05/outputs" + "/Order_" + randomNum + ".txt");
				errorFile.write("Please correct quantities of one of the following items : \n");
				for (orders order : validateOrders.InValidOrders) {
					errorFile.write("Item : " + order.getItem() + " \t " + " Input Quantity : " + order.getQuantity()
							+ " \t" + "Inventory Quantity : "
							+ stockController.products.get(order.getItem()).getQuantityStock() + "\n");
				}
				errorFile.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
