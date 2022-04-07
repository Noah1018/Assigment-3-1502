package mru.tsc.view;

import java.util.Scanner;

import mru.tsc.controller.TSCException;

public class AppMenu {

	Scanner input;
	static TSCException excep;
    static String error="";
    /**
     * Constructor
     */
	public AppMenu() {
		input = new Scanner(System.in);
	}

	/**
	 * Method for main menu
	 * @return option of the user
	 */
	public int showMainMenu() {
		System.out.println("******************************************");
		System.out.println("*    WELCOME TO THE TOY STORE COMPANY    *");
		System.out.println("******************************************");
		System.out.println("\n How may we help you: \n");
		System.out.println("\t1. Search Inventory and Purchase Toy");
		System.out.println("\t2. Add New Toy");
		System.out.println("\t3. Remove Toy");
		System.out.println("\t4. Save and Exit\n");
		System.out.print("Enter a number here: ");
		while (!input.hasNextInt()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}
		int option = input.nextInt();

		//Flush out scanner buffer
				input.nextLine();

		return option;
	}
	/**
	 * Sub menu to search
	 * @return option of the user
	 */
	public int searchToyMenu() {
		System.out.println("Find toys with: \n");
		System.out.println("\t1. Serial Number (SN) ");
		System.out.println("\t2. Toy Name");
		System.out.println("\t3. Type");
		System.out.println("\t4. Back to main menu\n");
		System.out.print("Enter a number here: ");
		while (!input.hasNextInt()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}
		int option = input.nextInt();

		//Flush out scanner buffer
				input.nextLine();

		return option;
	}
	/**
	 * Menu for searching by SN
	 * @return
	 */
	public long searchSNMen() {
		System.out.print("Enter a SN here: ");
		while (!input.hasNextLong()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}
		long searchSN = input.nextLong();
		
		//check if SN is valid
		if(isValid(searchSN)) {  
		}
		else
			System.out.println(error);




		//Flush out scanner buffer
		input.nextLine();
		return searchSN;
	}
	
	/**
	 * Method to check length of SN inputs
	 * @param SN
	 * @return valid or not
	 */
	public static boolean isValid(long SN) {
		
		boolean valid = true;
	        
	    try {
	    	//testing length of ssn
	        if(String.valueOf(SN).length() != 10) {
	            throw new TSCException("wrong number of characters");
	        } 
	    }
	    //prints out error
	    catch(TSCException e) {
	    	error = e.toString();
	    	valid = false;
	    }
	    
	        return valid;
	    }

	/**
	 * Menu for searching by keyword
	 * @return searchName
	 */
	public String searchNameMen() {
		System.out.print("Enter a Name here: ");
		while (!input.hasNext()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}

		String searchName = input.next();

		//Flush out scanner buffer
		input.nextLine();
		return searchName;
	}

	/**
	 * Menu for searching by toy type
	 * @return option of user
	 */
	public int searchTypeMen() {
		System.out.println("Select Type: \n");
		System.out.println("\t1. Figures ");
		System.out.println("\t2. Puzzles");
		System.out.println("\t3. Animals");
		System.out.println("\t4. Board Games\n");
		System.out.print("Enter a number here: ");
		while (!input.hasNextInt()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}

		int option = input.nextInt();



		//Flush out scanner buffer
				input.nextLine();

		return option;
	}

	/**
	 * Menu for removing a toy
	 * @return remove users choice
	 */
	public long removeToyMen() {
		System.out.print("Enter a SN here: ");
		while (!input.hasNextLong()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}

		long remove = input.nextLong();

		//Flush out scanner buffer
		input.nextLine();
		return remove;
	}

	/**
	 * Menu to ask if user would like to remove that item
	 * @return option of user
	 */
	public char askRemove() {
		System.out.println("Would you like to Remove? (Y/N)");
		char option = input.nextLine().toLowerCase().charAt(0);
		return option;
	}

	/**
	 * Menu to add a SN
	 * @return newSN
	 */
	public long addSN() {
		System.out.println("Enter SN Number: ");
		while (!input.hasNextLong()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}
		long newSN = input.nextLong();
		
		//check is sn is valid
		if(isValid(newSN)) {  
		}
		else
			System.out.println(error);

		//Flush out scanner buffer
		input.nextLine();
		return newSN;
	}

	/**
	 * Method to let user know that SN already exists
	 */
	public void dupSN() {
		System.out.println("");
		System.out.println("Duplicate SN Number, Please Re-enter:");
		System.out.println("");
	}

	/**
	 * Method to let user know what items were found from their search
	 */
	public void itemFoundMessage() {
		System.out.println("");
		System.out.println("Item(s) Found!");
		System.out.println("");
	}

	/**
	 * Method to let user know the item was removed
	 */
	public void itemRemovedMessage() {
		System.out.println("");
		System.out.println("Item Removed!");
		System.out.println("");
	}

	/**
	 * Method to prompt user to hit enter to continue
	 */
	public void promptEnterKey(){
		   System.out.println("Press \"ENTER\" to continue...");
		   Scanner input = new Scanner(System.in);
		   input.nextLine();
		}

	/**
	 * Method to prompt for toy name
	 */
	public String enterName() {
		System.out.print("Enter a name here: ");
		String name = input.nextLine().trim();
		return name;
	}

	/**
	 * Method to prompt for toy brand
	 */
	public String enterBrand() {
		System.out.print("Enter Brand name here: ");
		String brand = input.nextLine().trim();
		return brand;
	}

	/**
	 * Method to prompt for toy price
	 */
	public double enterPrice() {
		System.out.println("Enter Price Amount Here: ");
		while (!input.hasNextDouble()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}
		double toyPrice = input.nextDouble();
		input.nextLine();
		return toyPrice;
	}

	/**
	 * Method to prompt for toy count
	 */
	public int enterCount() {
		System.out.println("Enter Amount Aviable Here: ");
		while (!input.hasNextInt()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}
		int countAmount = input.nextInt();
		input.nextLine();
		return countAmount;
	}

	/**
	 * Method to prompt for recommended toy age
	 */
	public int enterStandardAge() {
		System.out.println("Enter Age Here: ");
		while (!input.hasNextInt()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}
		int age = input.nextInt();
		input.nextLine();
		return age;
	}

	/**
	 * Method to prompt for recommended toy age
	 */
	public int enterAge() {
		System.out.println("Enter Age Here: ");
		while (!input.hasNextInt()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}
		int age = input.nextInt();
		input.nextLine();
		return age;
	}

	/**
	 * Method to prompt for toy classification
	 */
	public char enterClassification() {
		System.out.print("Enter Classification here: ");
		char option = input.nextLine().toUpperCase().charAt(0);
		return option;
	}

	/**
	 * Method to prompt for toy material
	 */
	public String enterMaterial() {
		System.out.print("Enter Material here: ");
		String material = input.nextLine().trim();
		return material;
	}

	/**
	 * Method to prompt for animal size
	 */
	public char enterAnimalSize() {
		System.out.print("Enter Size here: ");
		char size = input.nextLine().toUpperCase().charAt(0);
		return size;
	}

	/**
	 * Method to prompt for puzzle type
	 */
	public char enterPuzzle() {
		System.out.print("Enter Puzzle-Type here: ");
		char type = input.nextLine().toUpperCase().charAt(0);
		return type;
	}

	/**
	 * Method to prompt for max players
	 */
	public int enterPlayerMax() {
		System.out.println("Enter Max Number of Players Here: ");
		while (!input.hasNextInt()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}
		int numply = input.nextInt();
		input.nextLine();
		return numply;
	}
	/**
	 * Method to prompt for mine players
	 */
	public int enterPlayerMin() {
		System.out.println("Enter Min Number of Players Here: ");
		while (!input.hasNextInt()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}
		int numply = input.nextInt();
		input.nextLine();
		return numply;
	}
	
	/**
	 * Method to prompt for toy designers
	 */
	public String enterDesigners() {
		System.out.print("Enter Designers here: ");
		String designers = input.nextLine().trim();
		return designers;
	}

	/**
	 * Method to let user know the toy has been added 
	 */
	public void toyAddedNow() {
		System.out.println("");
		System.out.println("Item Added!");
		System.out.println("");
	}
	/**
	 * Method to let user know that the item was not found
	 */
	public void itemNotFound() {
		System.out.println("");
		System.out.println("Item not Found. Please try Again");
		System.out.println("");
	}

	/**
	 * Method to ask user if they would like to purchase the item
	 * @return option of user
	 */
	public char askPurchase() {
		System.out.println("Would you like to Purchase? (Y/N)");
		char option = input.nextLine().toLowerCase().charAt(0);
		return option;
	}

	/**
	 * Method to let user know the item has been purchased
	 */
	public void itemPurchased() {
		System.out.println("");
		System.out.println("Item Purchased!");
		System.out.println("");
	}

	/**
	 * Method to let user know the purchased failed
	 */
	public void errorPurchase() {
		System.out.println("");
		System.out.println("Items not in stock, Purchase Failed");
		System.out.println("");
	}
	
	/**
	 * Method to let user know the item was not removed
	 */
	public void itemNotRemoved() {
		System.out.println("");
		System.out.println("Item not Removed");
		System.out.println("");
	}

	/**
	 * Method to let user know the item was not purchased
	 */
	public void itemNotPurchased() {
		System.out.println("");
		System.out.println("Item not Purchased");
		System.out.println("");
	}

	/**
	 * Method to go back to menu
	 */
	public void backToMenu() {
		System.out.println("Back to Menu");
	}

	/**
	 * Method for user to select the item they would like to buy
	 * @return option of user
	 */
	public int enterPurchaseOption() {
		System.out.print("Enter Number Selection Here: ");
		while (!input.hasNextInt()) {
			System.out.println("Invalid Entry");
			System.out.println("Please Re-enter here:");
			input.nextLine();
		}
		int option = input.nextInt();

		//Flush out scanner buffer
				input.nextLine();

		return option;
	}

}


