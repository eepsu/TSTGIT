package be.belfius.Zoo.domain;

public abstract class Food {
	private String foodType;
	private String name;
	private int portion;
	
	public Food(String foodType, String name, int portion) {
		this.foodType = foodType;
		this.name = name;
		this.portion = portion;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPortion() {
		return portion;
	}

	public void setPortion(int portion) {
		this.portion = portion;
	}

	@Override
	public String toString() {
		return foodType + " " + name + " portion=" + portion + "\n";
	}
	
	
}
