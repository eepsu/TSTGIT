package be.belfius.Zoo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import be.belfius.Zoo.domain.Animal;
import be.belfius.Zoo.domain.Bear;
import be.belfius.Zoo.domain.Elephant;
import be.belfius.Zoo.domain.Lion;

public class AnimalRepository {
	private List<Animal> animals = new ArrayList<>();

	public AnimalRepository() {
		Bear bear = new Bear("Baloe", LocalDate.parse("2019-12-12")); // animals.add(new Bear("Baloe")); = combinatie
																		// van 2 lijnen
		animals.add(bear);
		Lion lion = new Lion("Simba", LocalDate.of(2018, 12, 16));
		animals.add(lion);
		animals.add(new Elephant("Lulu", LocalDate.parse("2006-08-08")));
		animals.add(new Bear("Winnie", LocalDate.parse("2009-05-05")));
		animals.add(new Elephant("Ellie", LocalDate.parse("2001-01-01")));
	}

	public List<Animal> getAllAnimals() { // read in DB

		return animals;
	}

	public List<Animal> getAllAnimalsByType(String animalType) { // read in DB
		List<Animal> foundAnimals = new ArrayList<>();
		for (Animal animal : animals) {
			if (animal.getClass().getSimpleName().equals(animalType)) {
				foundAnimals.add(animal);
			}
		}
		return foundAnimals;
	}

	public void addAnimal(Animal animal) { // create in DB
		animals.add(animal);
	}

	public void updateAnimal(Animal animal) { // update in DB
		animals.set(animals.indexOf(animal), animal); // indexof positie ophalen van animal in tabel

	}

	public void deleteAnimal(Animal animal) { // delete uit DB

		animals.remove(animal);
	}

}
