package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.HashSet;
// import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;
// import controllers.*;
import models.*;

public class cardController {
	public static HashSet<String> cards = new HashSet<String>();
	static HashSet<String> ListOfCardsNeedToBeAdded = new HashSet<String>();
	static HashSet<String> orderCards = new HashSet<String>();

	public static void getFilePath(String filePath) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Paths.get(filePath).toFile()));
			String buffer = "";
			boolean firstline = true;
			while ((buffer = bufferedReader.readLine()) != null) {
				if (firstline) {
					firstline = false;
					continue;
				}
				cards.add(buffer);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void addCard(String filePath) {

		for (String name : orderController.order.keySet()) {
			orders order = orderController.order.get(name);
			orderCards.add(order.getCardNumber());
		}

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Paths.get(filePath).toFile()));
			String buffer = "";
			while ((buffer = bufferedReader.readLine()) != null) {
				cards.add(buffer);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}

		for (String card : orderCards) {
			if (!cards.contains(card)) {
				ListOfCardsNeedToBeAdded.add(card);
			}
		}

		try {
			FileWriter pw = new FileWriter("Cards.csv", true);
			for (String line : ListOfCardsNeedToBeAdded) {
				pw.append("\n " + line + " ");
			}
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
