package model;

public class Tea extends Product {
	
	private boolean isHerbal;
	private String brewColour, medicinalUse;
	private double caffeineContent; //measured in grams
	
	//there are different constructors for if the tea is herbal or not, and if the id is given
	public Tea (String name, String supplier, int price, String brewColour, double caffeineContent) {
		this(0, name, supplier, price, brewColour, caffeineContent);
	}
	
	public Tea (String name, String supplier, int price, String brewColour, String medicinalUse) {
		this(0, name, supplier, price, brewColour, medicinalUse);
		this.medicinalUse = medicinalUse;
	}
	
	public Tea (int id, String name, String supplier, int price, String brewColour, double caffeineContent) {
		super(id, name, supplier, price, true);
		this.brewColour = brewColour;
		this.caffeineContent = caffeineContent;
	}
	
	public Tea (int id, String name, String supplier, int price, String brewColour, String medicinalUse) {
		super(id, name, supplier, price, true);
		this.brewColour = brewColour;
		this.medicinalUse = medicinalUse;
	}
	
	/**
	 * @return if the tea is herbal or not
	 */
	public boolean isHerbal() {
		return isHerbal;
	}

	/**
	 * @param isHerbal set if the tea is herbal or not
	 */
	public void setHerbal(boolean isHerbal) {
		this.isHerbal = isHerbal;
	}

	/**
	 * @return the colour of the tea
	 */
	public String getBrewColour() {
		return brewColour;
	}

	/**
	 * @param brewColour the colour of the tea to set
	 */
	public void setBrewColour(String brewColour) {
		this.brewColour = brewColour;
	}

	/**
	 * @return the medicinal use of the tea
	 */
	public String getMedicinalUse() {
		return medicinalUse;
	}

	/**
	 * @param medicinalUse the medicinal use to set
	 */
	public void setMedicinalUse(String medicinalUse) {
		this.medicinalUse = medicinalUse;
	}

	/**
	 * @return the amount of caffeine in the tea in grams
	 */
	public double getCaffeineContent() {
		return caffeineContent;
	}

	/**
	 * @param caffeineContent the amount of caffeine to set
	 */
	public void setCaffeineContent(int caffeineContent) {
		this.caffeineContent = caffeineContent;
	}
	
	/**
	 * description of this tea
	 * varies depending on if it is herbal
	 */
	public String toString() {
		String desc = super.toString() + "Brew Colour: " + brewColour + "\n";
		
		if (isHerbal) {
			desc += "Used for: " + medicinalUse;
		}
		else {
			desc += "Caffeine content: " + caffeineContent;
		}
		
		return desc;
	}
	
}