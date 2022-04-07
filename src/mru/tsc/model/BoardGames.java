package mru.tsc.model;

public class BoardGames extends Toy{
	
	private Long sN;
	private String name;
	private String brand;
	private double price;
	private int count;
	private int age;
	private int plyMin;
	private int plyMax;
	private String designers;
	
	/**
	 * Constructor
	 * @param sN
	 * @param name
	 * @param brand
	 * @param price
	 * @param count
	 * @param age
	 * @param plyMin
	 * @param plyMax
	 * @param designers
	 */
	public BoardGames(Long sN, String name, String brand, double price, int count, int age, int plyMin, int plyMax, String designers) {
		this.sN = sN;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.count = count;
		this.age = age;
		this.plyMin = plyMin;
		this.plyMax = plyMax;
		this.designers = designers;
	}
	
	/**
	 * toString method for the board games class
	 */
	public String toString() { 
	    return "SN: " + this.sN + " , Name: " + this.name + " , Brand: " + this.brand + " , Price: " + this.price + " , Amount Available: " + this.count + " , Age: " + this.age + " , Number of Players: " + this.plyMin +  "-" + this.plyMax  + " , Designers: " + this.designers;
	} 
	
	/**
	 * format method for the board games class
	 */
	public String format() {
		return sN + ";" + name + ";" + brand + ";" + price + ";" + count + ";" + age + ";" + plyMin + "-" + plyMax + ";" + designers;
	}
	
	
	/**
	 * Setter for SN
	 * @return sN
	 */
	public void setsN(Long sN) {
		this.sN = sN;
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
	 * Getter for min players
	 * @return plymin
	 */
	public int getPlyMin() {
		return plyMin;
	}

	/**
	 * Setter for min players
	 * @param plyMin
	 */
	public void setPlyMin(int plyMin) {
		this.plyMin = plyMin;
	}

	/**
	 * Getter for max players
	 * @return plymax
	 */
	public int getPlyMax() {
		return plyMax;
	}

	/**
	 * Setter for max players
	 * @param plyMax
	 */
	public void setPlyMax(int plyMax) {
		this.plyMax = plyMax;
	}

	/**
	 * Getter for game designers 
	 * @return designers
	 */
	public String getDesigners() {
		return designers;
	}
	
	/**
	 * Setter for game designers
	 * @param designers
	 */
	public void setDesigners(String designers) {
		this.designers = designers;
	}

}
