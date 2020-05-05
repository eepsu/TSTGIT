package be.belfius.Zoo.domain;

public enum TypeOfAnimal {
	BEAR ("Bear"),
	LION ("Lion"),
	ELEPHANT ("Elephant");
	
	private String animalType;

	private TypeOfAnimal(String animalType) {
		this.animalType = animalType;
	}

	public String getType() {
		return animalType;
	}
		
}
