package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import models.*;

public class orderController {
	static ArrayList<String> fileContent = new ArrayList<>();
	public static HashMap<String, orders> order = new HashMap<>();

	public static void loadStock() {
		for (String line : fileContent) {
			String[] item = line.split(",");
			order.put(item[0], new orders(item[0], Integer.parseInt(item[1]), item[2]));
		}
	}

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
				fileContent.add(buffer);
			}
			loadStock();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}