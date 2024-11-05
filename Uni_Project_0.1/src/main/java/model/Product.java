package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Product {
	protected int id, price; // id=0 means no id set (a new, unsaved, product)
	protected String name, supplier;
	protected boolean isTea;
	
	//there are different constructors for if the id is different
	protected Product(String name, String supplier, int price, boolean isTea){
		this(0, name, supplier, price, isTea);
	}
	
	protected Product(int id, String name, String supplier, int price, boolean isTea){
		this.id = id;
		this.name = name;
		this.supplier = supplier;
		this.price = price;
		this.isTea = isTea;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getSupplier() {
		return supplier;
	}

	/**
	 * @param description the description to set
	 */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	protected void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * @return if this item is tea or coffee
	 */
	protected String getType() {
		if (isTea) {
			return "Tea";
		}
		return "Coffee";
	}
	
	/**
	 * @param isTea the item type to set
	 */
	protected void setType(boolean isTea) {
		this.isTea = isTea;
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