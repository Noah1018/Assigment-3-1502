package mru.tsc.model;

public class Puzzles extends Toy{
	
	private long sN;
	private String name;
	private String brand;
	private double price;
	private int count;
	private int age;
	private String type;
	
	/**
	 * Constructor
	 * @param sN
	 * @param name
	 * @param brand
	 * @param price
	 * @param count
	 * @param age
	 * @param type
	 */
	public Puzzles(long sN, String name, String brand, double price, int count, int age, String type) {
		this.sN = sN;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.count = count;
		this.age = age;
		this.type = type;
		
	}

	/**
	 * toString method for the puzzles class
	 */
	public String toString() { 
	    return "Category: Puzzles, SN: " + this.sN + " , Name: " + this.name + " , Brand: " + this.brand + " , Price: " + this.price + " , Amount Available: " + this.count + " , Age: " + this.age + " , Puzzle-Type: " + this.type;
	} 
	
	/**
	 * format method for the puzzles class
	 */
	public String format() {
		return sN + ";" + name + ";" + brand + ";" + price + ";" + count + ";" + age + ";" + type;
	}


	/**
	 * Getter for SN
	 * @return sN
	 */
	public long getsN() {
		return sN;
	}

	/**
	 * Setter for SN
	 * @return sN
	 */
	public void setsN(long sN) {
		this.sN = sN;
	}

	/**
	 * Getter for name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name
	 * @return name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for Brand
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Setter for brand
	 * @return brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Getter for price
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter for price
	 * @return price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Getter for count
	 * @return count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Setter for count
	 * @return count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Getter for age
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Setter for age
	 * @return age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Getter for puzzle type
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter for puzzles type
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

}
