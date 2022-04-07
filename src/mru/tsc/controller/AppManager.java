package mru.tsc.controller;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.model.Animals;
import mru.tsc.model.BoardGames;
import mru.tsc.model.Figures;
import mru.tsc.model.Puzzles;
import mru.tsc.model.Toy;
import mru.tsc.view.*;
import mru.tsc.view.AppMenu;
import mru.tsc.controller.TSCException;



public class AppManager {

	private final String FILE_PATH = "res/toys.txt";
	ArrayList<Toy> toys;
	AppMenu sysMenu;
	private static long[] testPlease;



	/**
	 * Constructor
	 * 
	 * @throws Exception
	 */
	public AppManager() throws Exception {
		toys = new ArrayList<>();
		sysMenu = new AppMenu();
		loadData();
		launchApplication();
	}

	/**
	 * Method to launch the application
	 * Then prompts user on what function they would like to use
	 * @throws IOException
	 */
	private void launchApplication() throws IOException {

		boolean flag = true;
		int option;

		while (flag) {

			option = sysMenu.showMainMenu();

			switch (option) {
			case 1:
				searchToy();
				break;
			case 2:
				addToy();
				break;
			case 3:
				removeToy();
				break;
			case 4:
				Save();
				flag = false;
			} 
		}

}	
	/**
	 * Method to run sub menu to select how to search
	 */
	private void searchToy() {
		int option = sysMenu.searchToyMenu();

		switch (option) {
		case 1:
			searchSN();
			break;
		case 2:
			searchName();
			break;
		case 3:
			searchType();
			break;
		case 4:
			System.out.print("Back to main menu \n");
			break;

		}
	}
	/**
	 * Method to add toy to the data base
	 */
	private void addToy() {
		long newSN = sysMenu.addSN();
		//check if sn already exists
		for (Toy t:toys) {
			if (newSN == t.getsN()) {
				sysMenu.dupSN();
				addToy();
			}
		} 

		long firstDigit = newSN;


		while (firstDigit >=10) {
			firstDigit = firstDigit/10;
		}

		String name = sysMenu.enterName();
		String brand = sysMenu.enterBrand();
		double price = sysMenu.enterPrice();
		int count = sysMenu.enterCount();
		int age = sysMenu.enterAge();


		if (firstDigit == 0 || firstDigit == 1) {
			char c = sysMenu.enterClassification();
			String classification = String.valueOf(c);

			Toy toyP = new Figures(newSN, name, brand, price, count, age, classification);
			toys.add(toyP);

			} else if(firstDigit == 2 || firstDigit == 3) {
				String material = sysMenu.enterMaterial();
				char s = sysMenu.enterAnimalSize();
				String size = String.valueOf(s);

				Toy toyP = new Animals(newSN, name, brand, price, count, age, material, size);
				toys.add(toyP);

			} else if(firstDigit == 4 || firstDigit == 5 || firstDigit == 6) {
				char p = sysMenu.enterPuzzle();
				String puzzleType = String.valueOf(p);

				Toy toyP = new Puzzles(newSN, name, brand, price, count, age, puzzleType);
				toys.add(toyP);

			} else if (firstDigit == 7 || firstDigit == 8 || firstDigit == 9) {
				int minPly = sysMenu.enterPlayerMin();
				int maxPly = sysMenu.enterPlayerMax();
				String designers = sysMenu.enterDesigners();

				Toy toyP = new BoardGames(newSN, name, brand, price, count, age, minPly, maxPly , designers);
				toys.add(toyP);
			}
			sysMenu.toyAddedNow();
			sysMenu.promptEnterKey();
		}

	/**
	 * Method to remove toy from database
	 */
	private void removeToy() {
		boolean check = false;
		Toy t = null;
		long remove = sysMenu.removeToyMen();
		for (Toy t1: toys){
			long checkRemove = t1.getsN();
			int result = Long.compare(checkRemove, remove);
	         if (result == 0) {
	        	check = true;
	        	t = t1;
	        	sysMenu.itemFoundMessage();
	        	System.out.println(t1.toString());
	         } else {
	        	 System.out.print("");
	         }
		} 
		if (check == true) {
			sysMenu.promptEnterKey();
			char option = sysMenu.askRemove();
			if (option == 'y') {
				toys.remove(t);
				sysMenu.itemRemovedMessage();
			} else {
				sysMenu.itemNotRemoved();
			}
		} else {
			sysMenu.itemNotFound();
		}
		sysMenu.promptEnterKey();
	}
	/**
	 * Method to search for an item using the SN
	 */
	private void searchSN() {
		boolean check = false;
		int count = 0;
		long SN = sysMenu.searchSNMen();
		for (Toy t : toys){
			long checkSN = t.getsN();
			int result = Long.compare(SN, checkSN);
	         if (result == 0) {
	        	 check = true;
	        	 count = t.getCount();
	        	sysMenu.itemFoundMessage();
		        System.out.println(t.toString());
	         } else {
	        	 System.out.print("");
	         }
		}

		if (check == true) {
			char p = sysMenu.askPurchase();
			if (p == 'y') {
				if (count > 0) {
					sysMenu.itemPurchased();
					count = count -1;
					for (Toy t: toys) {
						t.setCount(count);
					}
				} else {
					sysMenu.errorPurchase();
				}
			} else {
				sysMenu.itemNotPurchased();
			}
		} else {
			sysMenu.itemNotFound();
		}
		sysMenu.promptEnterKey();
		searchToy();
	}
	/**
	 * Method to search for an item by item type
	 */
	private void searchType() {
		long firstDigit = -1;
		int count = 0;
		int type = sysMenu.searchTypeMen();
		testPlease = new long[99999];

		if (type == 1) {
			int i = -1;

			for (Toy t : toys) {
				long sn = t.getsN();
				firstDigit = t.getsN();
				while (firstDigit >=10) {
					firstDigit = firstDigit/10;
					if (firstDigit == 0 || firstDigit == 1) {
						i = i+1;
						System.out.println("\t (" + i + ")  " + t.toString());
						testPlease[i] = sn;

					}
				}
			}


			int choice = sysMenu.enterPurchaseOption();
			long purchaseSN = testPlease[choice];
			for (Toy t : toys){
				long checkSN = t.getsN();
				int result = Long.compare(purchaseSN, checkSN);
		         if (result == 0) {
		        	 count = t.getCount();
		        	 if (count > 0) {
		        		 count = count -1;
		        		 t.setCount(count);
		        		 sysMenu.itemPurchased(); 
		        	 } else {
		        		 sysMenu.errorPurchase();
		        	 }

		         }
			}


		} else if (type == 2){
			int i = -1;
			for (Toy t : toys) {
				long sn = t.getsN();
				firstDigit = t.getsN();
				while (firstDigit >=10) {
					firstDigit = firstDigit/10;
					if (firstDigit == 2 || firstDigit == 3) {
						i = i +1;
						System.out.println("\t (" + i + ")  " + t.toString());
						testPlease[i] = sn;
					}
				}
			}
			
			int choice = sysMenu.enterPurchaseOption();
			long purchaseSN = testPlease[choice];
			for (Toy t : toys){
				long checkSN = t.getsN();
				int result = Long.compare(purchaseSN, checkSN);
		         if (result == 0) {
		        	 count = t.getCount();
		        	 if (count > 0) {
		        		 count = count -1;
		        		 t.setCount(count);
		        		 sysMenu.itemPurchased(); 
		        	 } else {
		        		 sysMenu.errorPurchase();
		        	 }
		        	 
		         }
			}
			
		} else if (type == 3) {
			int i = -1;
			for (Toy t : toys) {
				long sn = t.getsN();
				firstDigit = t.getsN();
				while (firstDigit >=10) {
					firstDigit = firstDigit/10;
					if (firstDigit == 4 || firstDigit == 5 || firstDigit == 6) {
						i = i +1;
						System.out.println("\t (" + i + ")  " + t.toString());
						testPlease[i] = sn;
					}
				}
			}

			int choice = sysMenu.enterPurchaseOption();
			long purchaseSN = testPlease[choice];
			for (Toy t : toys){
				long checkSN = t.getsN();
				int result = Long.compare(purchaseSN, checkSN);
		         if (result == 0) {
		        	 count = t.getCount();
		        	 if (count > 0) {
		        		 count = count -1;
		        		 t.setCount(count);
		        		 sysMenu.itemPurchased(); 
		        	 } else {
		        		 sysMenu.errorPurchase();
		        	 }
		        	 
		         }
			}
			
		} else if (type == 4) {
			int i = -1;
			for (Toy t : toys) {
				long sn = t.getsN();
				firstDigit = t.getsN();
				while (firstDigit >=10) {
					firstDigit = firstDigit/10;
					if (firstDigit == 7 || firstDigit == 8 || firstDigit == 9) {
						i = i +1;
						System.out.println("\t (" + i + ")  " + t.toString());
						testPlease[i] = sn;
					}
				}
			} 

			int choice = sysMenu.enterPurchaseOption();
			long purchaseSN = testPlease[choice];
			for (Toy t : toys){
				long checkSN = t.getsN();
				int result = Long.compare(purchaseSN, checkSN);
		         if (result == 0) {
		        	 count = t.getCount();
		        	 if (count > 0) {
		        		 count = count -1;
		        		 t.setCount(count);
		        		 sysMenu.itemPurchased(); 
		        	 } else {
		        		 sysMenu.errorPurchase();
		        	 }
		        	 
		         }
			}
			
		} else {
			sysMenu.itemNotFound();
		}
		
		sysMenu.promptEnterKey();
	}
	/**
	 * Method to search for an item by keyword
	 */
	private void searchName() {
		int i = -1;
		int count = 0;
		testPlease = new long[99999];
		String searchName = sysMenu.searchNameMen();
		sysMenu.itemFoundMessage();
		for (Toy t : toys){
			long sn = t.getsN();
	         if (t.getName().toLowerCase().contains(searchName.toLowerCase())){
	        	 i = i +1;
					System.out.println("\t (" + i + ")  " + t.toString());
					testPlease[i] = sn;
	         }
		}
		
		int choice = sysMenu.enterPurchaseOption();
		long purchaseSN = testPlease[choice];
		for (Toy t : toys){
			long checkSN = t.getsN();
			int result = Long.compare(purchaseSN, checkSN);
	         if (result == 0) {
	        	 count = t.getCount();
	        	 if (count > 0) {
	        		 count = count -1;
	        		 t.setCount(count);
	        		 sysMenu.itemPurchased();
	        		 sysMenu.promptEnterKey();
	        	 } else {
	        		 sysMenu.errorPurchase();
	        		 sysMenu.promptEnterKey();
	        	 }
	        	 
	         }
		}
		
		
	}
	
	/**
	 * Method to save information to the database
	 * @throws IOException
	 */
	private void Save() throws IOException { 
		File db = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(db);

		for (Toy t: toys) {

			pw.println(t.format());
		}

		pw.close();

	}


	/**
	 * Method to load data from text file
	 * @throws Exception
	 */
	private void loadData() throws Exception {
		File db = new File(FILE_PATH);
		String currentLine;
		String[] numberPlyLine;
		String[] splittedLine;

		if (db.exists()) {
			Scanner fileReader = new Scanner(db);
			while (fileReader.hasNextLine()) {
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				numberPlyLine = splittedLine[6].split("-");
				char firstDigit = currentLine.charAt(0);

				if (firstDigit == '0' || firstDigit == '1') {
					Toy toyP = new Figures(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2], Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toys.add(toyP);
				} 
				if (firstDigit == '2' || firstDigit == '3') {
					Toy toyP = new Animals(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2], Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
					toys.add(toyP);
				}
				if (firstDigit == '4' || firstDigit == '5' || firstDigit == '6') {
					Toy toyP = new Puzzles(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2], Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toys.add(toyP);
				}
				if (firstDigit == '7' || firstDigit == '8' || firstDigit == '9') {
					Toy toyP = new BoardGames(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2], Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), Integer.parseInt(numberPlyLine[0]), Integer.parseInt(numberPlyLine[1]) , splittedLine[7]);
					toys.add(toyP);
				} 


			}

			fileReader.close();
		}
	}
} 
