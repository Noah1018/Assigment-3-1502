package mru.tsc.model;

public abstract class Toy {

	private String name;
	private long sN;
	private String brand;
	private double price;
	private int count;
	private int age;

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
	 * Constructor
	 */
	public Toy() {

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
	 * toString method for the toy class
	 */
	public String toString() { 
	    return "SN: " + this.sN + " , Name: " + this.name + " , Brand: " + this.brand + " , Price: " + this.price + " , Amount Available: " + this.count + " , Age: " + this.age;
	} 

	/**
	 * format method for the toy class
	 * @return formated text
	 */
	public String format() {
		return sN + ";" + name + ";" + brand + ";" + price + ";" + count + ";" + age;
	}
	
	public String formatTwo() {
		return "";
	}

}