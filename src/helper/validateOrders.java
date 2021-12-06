package helper;

import java.util.ArrayList;
import java.util.List;

import controllers.*;
import models.*;

public class validateOrders {
	public static int EssentialsCount = 5;
	public static int LuxuryCount = 3;
	public static int MiscCount = 6;
	public static List<Boolean> result = new ArrayList<>();
	public static ArrayList<orders> InValidOrders = new ArrayList<orders>();
	public static double TotalAmountPaid = 0;

	public static void getCategoryWiseCounts() {
		int countOfEssentialItems = 0, countOfLuxuryItems = 0, countOfMiscItems = 0;
		for (String name : orderController.order.keySet()) {
			orders value = orderController.order.get(name);
			items item = stockController.products.get(name);

			if (item.getCategory() == "Essentials") {
				countOfEssentialItems += value.getQuantity();
			} else if (item.getCategory() == "Luxury") {
				countOfLuxuryItems += value.getQuantity();
			} else if (item.getCategory() == "Misc") {
				countOfMiscItems += value.getQuantity();
			}
		}
		if (countOfEssentialItems > EssentialsCount) {
			result.add(false);
		} else {
			result.add(true);
		}
		if (countOfLuxuryItems > LuxuryCount) {
			result.add(false);
		} else {
			result.add(true);
		}
		if (countOfMiscItems > MiscCount) {
			result.add(false);
		} else {
			result.add(true);
		}
	}

	public static void checkAvailableQuantityAgainstStock() {
		for (String name : orderController.order.keySet()) {
			orders order = orderController.order.get(name);
			items stock = stockController.products.get(name);

			if (stock.getQuantityStock() >= order.getQuantity()) {
				if (stock.getCategory().equals("Essential") && result.get(0)) {
					TotalAmountPaid += (order.getQuantity() * stock.getPrice());
				} else if (stock.getCategory().equals("Luxury") && result.get(1)) {
					TotalAmountPaid += (order.getQuantity() * stock.getPrice());
				} else if (stock.getCategory().equals("Misc") && result.get(2)) {
					TotalAmountPaid += (order.getQuantity() * stock.getPrice());
				} else {
					InValidOrders.add(order);
				}
			} else {
				InValidOrders.add(order);
			}
		}

	}

}
