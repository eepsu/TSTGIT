package be.belfius.Zoo.domain;

import java.time.LocalDate;

public class Bear extends Animal{

	public Bear(String animalName, LocalDate animalBirthDate) {
		super(animalName, TypeOfAnimal.BEAR, animalBirthDate);
	}

}
