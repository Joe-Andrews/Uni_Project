package model;

public class Coffee extends Product {
	
	private int caffeineContent, recAmt; //both in grams
	
	//there are different costructors for if the id is given
	public Coffee(String name, String supplier, int price, int caffeineContent, int recAmt) {
		this(0, name, supplier, price, caffeineContent, recAmt);
	}
	
	public Coffee(int id, String name, String supplier, int price, int caffeineContent, int recAmt) {
		super(id, name, supplier, price);
		this.caffeineContent = caffeineContent;
		this.recAmt = recAmt;
	}

	/**
	 * @return the amount of caffeine in the coffee in grams
	 */
	public int getCaffeineContent() {
		return caffeineContent;
	}
	
	/**
	 * @param caffeineContent the amount of caffeine to set
	 */
	public void setCaffeineContent(int caffeineContent) {
		this.caffeineContent = caffeineContent;
	}

	/**
	 * @return the recommended amount of coffee per serving
	 */
	public int getRecAmt() {
		return recAmt;
	}

	/**
	 * @param recAmt the recommended amount to set
	 */
	public void setRecAmt(int recAmt) {
		this.recAmt = recAmt;
	}
	
	/**
	 * description of this coffee
	 */
	public String toString() {
		return super.toString() + "Caffeine content: " + caffeineContent + "\nRecommended amount per cup in grams: " + recAmt;
	}
	
}