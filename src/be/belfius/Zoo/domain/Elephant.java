package be.belfius.Zoo.domain;

import java.time.LocalDate;

public class Elephant extends Animal{


	public Elephant(String animalName, LocalDate animalBirthDate){
		super(animalName, TypeOfAnimal.ELEPHANT, animalBirthDate);   // source constructor from superclass
	
	}

}
