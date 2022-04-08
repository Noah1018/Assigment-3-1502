package mru.tsc.controller;
import javafx.application.Platform;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.swing.JOptionPane;

import mru.tsc.exceptions.TSCException;
import mru.tsc.model.Animals;
import mru.tsc.model.BoardGames;
import mru.tsc.model.Figures;
import mru.tsc.model.Puzzles;
import mru.tsc.model.Toy;


public class AppManager implements Initializable{

    private final String FILE_PATH = "res/toys.txt";
    ArrayList<Toy> toys;
    private static long[] testPlease;
    static TSCException excep;
    static String error="";

    /**
     * Constructor
     * @throws Exception
     */
    public AppManager() throws Exception {
        toys = new ArrayList<>();
        loadData();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		catagory.getItems().addAll(test);
		radioName.setToggleGroup(radioGroup);
    	radioSN.setToggleGroup(radioGroup);
    	radioType.setToggleGroup(radioGroup);

	}

    @FXML
    private Button btnBuy, btnClear, btnRemove, btnSave, btnSearch, btnSaveandExit3, btnSaveandExit2, btnSaveandExit, btnSearch2;

    @FXML
    private ChoiceBox<String> catagory;
    private String[] test = {"Puzzle", "Animal", "Board Game", "Figure"};
    


    @FXML
    private TextField enterAgeApprop, enterBrand, enterClassification, enterCount, enterDesigners, enterMaterial, enterMaxPlayers, 
    enterMinPlayers, enterName, enterName2, enterPrice, enterSN, enterSN2, enterSN3, enterSize, enterType, enterType2;

    @FXML
    private ListView<Toy> lsHome, lsRemove;

    @FXML
    private RadioButton radioName, radioSN, radioType;
    


        ToggleGroup radioGroup = new ToggleGroup();
        



    /**
    * method for button actions
    * @param event
    * @throws IOException
    */
    @FXML
    void btnHandler(ActionEvent event) throws IOException {

        
    	//buying toy
    	if  (event.getSource().equals(btnBuy)) {
    		buyToy();
    	}
    	
    	//buttons to select how to search
    	if  (event.getSource().equals(btnSearch)) {
    		if (radioSN.isSelected()) {
                searchSN();
            }
            if (radioName.isSelected()) {
                searchName();
            }
            if (radioType.isSelected()) {
                searchType();
            }
    	}
    	
    	//btn to clear
    	if  (event.getSource().equals(btnClear)) {
    		lsHome.getItems().clear();
    	}
    	
    	//btn to add toy
    	if  (event.getSource().equals(btnSave)) {
    		addToy();
    	}
    	
    	//btn to remove a toy
    	if  (event.getSource().equals(btnRemove)) {
    		removeToy();	
    	}

    	//btn to save and exit
    	if  (event.getSource().equals(btnSaveandExit3)) {
            Save();
            Platform.exit();	
    	}
    	
    	//btn to save and exit
    	if  (event.getSource().equals(btnSaveandExit2)) {
            Save();
            Platform.exit();	
    	}
    	
    	//btn to save and exit
    	if  (event.getSource().equals(btnSaveandExit)) {
            Save();
            Platform.exit();	
    	}
    	
    	//btn to search in the remove tab
    	if  (event.getSource().equals(btnSearch2)) {
    		removeToySearch();
    	} 

    }
    
	/**
	 * method to catch exeption of minPly>maxPly
	 * @param minPly
	 * @param maxPly
	 * @return
	 */
    public static boolean isValidPly(int minPly, int maxPly) {
		
		boolean valid = true;
	        
	    try {
	    	//testing minPly is not greater than maxPly
	        if(maxPly < minPly) {
	            throw new TSCException("Minimum Number of Players is greater than Max Number of Players");
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
     * method to catch exeption of price being negative
     * @param price
     * @return
     */
    public static boolean isValidPrice(double price) {
		
		boolean valid = true;
	        
	    try {
	        //testing is price is negative
	        if (price < 0) {
	        	throw new TSCException("Price is Negative");
	        
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
     * method to buy a toy
     */
    private void buyToy() {
    	Toy t2;
    	t2 = lsHome.getSelectionModel().getSelectedItem();

    	int count = t2.getCount();
    	int newCount = count -1;
    	t2.setCount(newCount);
    	
    	JOptionPane.showMessageDialog(null, "Item Purchased!");
    }
    
    /**
     * method to search by toy name
     */
    private void searchName() {
        int i = -1;
        int count = 0;
        String searchName = enterName.getText();
        for (Toy t : toys){
            long sn = t.getsN();
             if (t.getName().toLowerCase().contains(searchName.toLowerCase())){
                 ObservableList<Toy> name = FXCollections.observableArrayList(t);
                    lsHome.getItems().addAll(name);
             }
        }
        }
    
    /**
     * Method to search for an item using the SN
     */
    private void searchSN() {
        int count = 0;
        String stringSN = enterSN.getText();
        Long SN = Long.parseLong(stringSN);
        for (Toy t : toys){
            long checkSN = t.getsN();
            int result = Long.compare(SN, checkSN);
             if (result == 0) {
                    ObservableList<Toy> searchSN = FXCollections.observableArrayList(t);
                    lsHome.getItems().addAll(searchSN);

             } else {
                 System.out.print("");
             }
            }
        }
    
    /**
     * Method to search for an item by item type
     */
    private void searchType() {
        long firstDigit = -1;
        int count = 0;
        String stringType = enterType.getText().toLowerCase();
        char type = stringType.charAt(0);

        if (type == 'f') {
            int i = -1;

            for (Toy t : toys) {
                long sn = t.getsN();
                firstDigit = t.getsN();
                while (firstDigit >=10) {
                    firstDigit = firstDigit/10;
                    if (firstDigit == 0 || firstDigit == 1) {
                        ObservableList<Toy> searchType = FXCollections.observableArrayList(t);
                        lsHome.getItems().addAll(searchType);

                    }
                }
            }

        } else if (type == 'a'){
            int i = -1;
            for (Toy t : toys) {
                long sn = t.getsN();
                firstDigit = t.getsN();
                while (firstDigit >=10) {
                    firstDigit = firstDigit/10;
                    if (firstDigit == 2 || firstDigit == 3) {
                        ObservableList<Toy> searchType = FXCollections.observableArrayList(t);
                        lsHome.getItems().addAll(searchType);
                    }
                }
            }
        
        } else if (type == 'p') {
            int i = -1;
            for (Toy t : toys) {
                long sn = t.getsN();
                firstDigit = t.getsN();
                while (firstDigit >=10) {
                    firstDigit = firstDigit/10;
                    if (firstDigit == 4 || firstDigit == 5 || firstDigit == 6) {
                        ObservableList<Toy> searchType = FXCollections.observableArrayList(t);
                        lsHome.getItems().addAll(searchType);
                    }
                }
            }
            
        } else if (type == 'b') {
            int i = -1;
            for (Toy t : toys) {
                long sn = t.getsN();
                firstDigit = t.getsN();
                while (firstDigit >=10) {
                    firstDigit = firstDigit/10;
                    if (firstDigit == 7 || firstDigit == 8 || firstDigit == 9) {
                        ObservableList<Toy> searchType = FXCollections.observableArrayList(t);
                        lsHome.getItems().addAll(searchType);
                    }
                }
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "NO ITEMS FOUND!");
        }
    }

    /**
     * method to search for the toy you like to remove
     */
    private void removeToySearch() {
        Toy t = null;
        String stringRemoveSearch = enterSN3.getText();
        long removeSearch = Long.parseLong(stringRemoveSearch);
        for (Toy t1: toys){
            long checkRemove = t1.getsN();
            int result = Long.compare(checkRemove, removeSearch);
            checkRemove = Long.parseLong(Long.toString(checkRemove).substring(1));
            int resultTwo = Long.compare(checkRemove, removeSearch);
             if (result == 0 || resultTwo == 0) {
                t = t1;
                ObservableList<Toy> test = FXCollections.observableArrayList(t1);
                lsRemove.getItems().addAll(test);

             } else {

             }
        } 
    }
    
    /**
     * method to remove toy from text file
     */
    private void removeToy() {
        Toy t = null;
        String stringRemove = enterSN3.getText();
        long remove = Long.parseLong(stringRemove);
        for (Toy t1: toys){
            long checkRemove = t1.getsN();
            int result = Long.compare(checkRemove, remove);
            checkRemove = Long.parseLong(Long.toString(checkRemove).substring(1));
            int resultTwo = Long.compare(checkRemove, remove);
             if (result == 0 || resultTwo == 0) {
                t = t1;
                toys.remove(t);
             } else {

             }
        } 

    }
    
    /**
     * method to add a toy
     */
    private void addToy() {
        String stringSN = enterSN2.getText();
        long newSN = Long.parseLong(stringSN);
        for (Toy t:toys) {
            if (newSN == t.getsN()) {
             	JOptionPane.showMessageDialog(null, "THAT SERIAL NUMBER ALREADY EXISTS!");
                addToy();
            }
        } 
        
        long firstDigit = newSN;
        int numDigits = String.valueOf(newSN).length();
            
        while (firstDigit >=10) {
            firstDigit = firstDigit/10;
        }
            
        String name = enterName2.getText();
        String brand = enterBrand.getText();
        String stringPrice = enterPrice.getText();
        double price = Double.parseDouble(stringPrice);
        if (isValidPrice(price)) {
        	
        	
        } else {  
        	JOptionPane.showMessageDialog(null, error);
        }
        String stringCount = enterCount.getText();
        int count = Integer.parseInt(stringCount);
        String stringAge = enterAgeApprop.getText();
        int age = Integer.parseInt(stringAge);
            
            
        if (firstDigit == 1) {
            String classification = enterClassification.getText();
                
            Toy toyP = new Figures(newSN, name, brand, price, count, age, classification);
            toys.add(toyP);
                
            } else if (numDigits < 10) {
            String classification = enterClassification.getText();
            String check = Long.toString(newSN);
            long fixSN = Long.parseLong("10" + check);
            Toy toyP = new Figures(fixSN, name, brand, price, count, age, classification);
            toys.add(toyP); 
            } else if(firstDigit == 2 || firstDigit == 3) {
                String material = enterMaterial.getText();
                String size = enterSize.getText();
                
                Toy toyP = new Animals(newSN, name, brand, price, count, age, material, size);
                toys.add(toyP);
                
            } else if(firstDigit == 4 || firstDigit == 5 || firstDigit == 6) {
                String puzzleType = enterType2.getText();
                
                Toy toyP = new Puzzles(newSN, name, brand, price, count, age, puzzleType);
                toys.add(toyP);
                
            } else if (firstDigit == 7 || firstDigit == 8 || firstDigit == 9) {
                String stringMinPly = enterMinPlayers.getText();
                String stringMaxPly = enterMaxPlayers.getText();
                int minPly = Integer.parseInt(stringMinPly);
                int maxPly = Integer.parseInt(stringMaxPly);
                if (isValidPly(minPly, maxPly)) {
                	
                } else {  
                	JOptionPane.showMessageDialog(null, error);
                }
                String designers = enterDesigners.getText();
                
                Toy toyP = new BoardGames(newSN, name, brand, price, count, age, minPly, maxPly , designers);
                toys.add(toyP);
            }
     	JOptionPane.showMessageDialog(null, "TOY ADDED!");
        }
    
    /**
     * method to save to the text file
     * @throws IOException
     */
    private void Save() throws IOException { 
		File db = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(db);
		
		for (Toy t: toys) {
			long firstDigit = t.getsN();
			while (firstDigit >=10) {
				firstDigit = firstDigit/10; }
			
			if (firstDigit == 0) {
				pw.println(t.formatTwo());
			}
			if (firstDigit == 1) {
				pw.println(t.format());
			} 
			if (firstDigit == 2 || firstDigit == 3) {
				pw.println(t.format());
			}
			if (firstDigit == 4 || firstDigit == 5 || firstDigit == 6) {
				pw.println(t.format());
			}
			if (firstDigit == 7 || firstDigit == 8 || firstDigit == 9) {
				pw.println(t.format());
			} 
			
		}
		
		pw.close();
		
	}
    
    /**
     * method to load data from the text file
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
			
				if (firstDigit == '0') {
					Toy toyP = new Figures(Long.parseLong("1" + splittedLine[0]), splittedLine[1], splittedLine[2], Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toys.add(toyP);
				}
				if (firstDigit == '1') {
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
