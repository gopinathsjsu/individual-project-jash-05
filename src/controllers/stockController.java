package controllers;

import java.io.BufferedReader;
import models.*;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class stockController {
	static ArrayList<String> fileContent = new ArrayList<>();
	public static HashMap<String, items> products = new HashMap<>();

	public static void loadStock() {
		for (String line : fileContent) {
			String[] item = line.split(",");
			products.put(item[1],
					new items(item[0], item[1], Double.parseDouble(item[3]), Integer.parseInt(item[2])));
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
