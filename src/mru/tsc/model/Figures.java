package mru.tsc.model;

public class Figures extends Toy {
	
	private long sN;
	private String name;
	private String brand;
	private double price;
	private int count;
	private int age;
	private String classification;
	
	/**
	 * Constructor
	 * @param sN
	 * @param name
	 * @param brand
	 * @param price
	 * @param count
	 * @param age
	 * @param classification
	 */
	public Figures(long sN, String name, String brand, double price, int count, int age, String classification) {
		this.sN = sN;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.count = count;
		this.age = age;
		this.classification = classification;
	}

	/**
	 * toString method for the figures class
	 */
	public String toString() { 
	    return "SN: " + this.sN + " , Name: " + this.name + " , Brand: " + this.brand + " , Price: " + this.price + " , Amount Available: " + this.count + " , Age: " + this.age + " , Classification: " + this.classification;
	} 
	
	/**
	 * format method for the figures class
	 */
	public String format() {
		return sN + ";" + name + ";" + brand + ";" + price + ";" + count + ";" + age + ";" + classification;
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
	 * Getter for classification
	 * @return classification
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * Setter for classification
	 * @param classification
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}

}
