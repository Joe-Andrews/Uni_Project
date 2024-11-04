package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Product {
	protected int id; // id=0 means no id set (a new, unsaved, product)
	protected String name;
	protected String supplier;
	protected int price;
	
	//there are different constructors for if the id is different
	protected Product(String name, String supplier, int price){
		this(0, name, supplier, price);
	}
	
	protected Product(int id, String name, String supplier, int price){
		this.id = id;
		this.name = name;
		this.supplier = supplier;
		this.price = price;
	}
	
	/**
	 * @return the id
	 */
	protected int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	protected void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	protected String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	protected String getSupplier() {
		return supplier;
	}

	/**
	 * @param description the description to set
	 */
	protected void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	/**
	 * @return the price
	 */
	protected int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	protected void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * 
	 * @return price formatted with two decimal places to represent pounds & pence (or dollars & cents, or...)
	 */
	protected double getFormattedPrice(){
		BigDecimal bd = new BigDecimal(price / 100.0);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	/**
	 * base description of any item
	 */
	public String toString(){
		return name + " " + getFormattedPrice() + "\n From " + supplier + "\n";
	}

}