package be.belfius.Zoo.domain;

import java.time.LocalDate;

public abstract class Animal {

	private String name;
	private TypeOfAnimal type;
	private LocalDate birthDate;

	public Animal(String animalName, TypeOfAnimal animalType, LocalDate animalBirthDate) {
		this.name = animalName;
		this.type = animalType;
		this.birthDate = animalBirthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypeOfAnimal getType() {
		return type;
	}

	public void setType(TypeOfAnimal type) {
		this.type = type;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {  // gegenereerd via generate toString
		// return "Animal name=" + name + ", type=" + type;
		return name + " is a " + type + " born " + birthDate;
	}
}