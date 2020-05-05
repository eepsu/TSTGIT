package be.belfius.Zoo.services;

import java.util.List;

import be.belfius.Zoo.domain.Animal;

import be.belfius.Zoo.repository.AnimalRepository;

public class AnimalService {
	private AnimalRepository animalRepository = new AnimalRepository();

	public List<Animal> getAnimals() {
		return animalRepository.getAllAnimals();
	}

	public List<Animal> getAllAnimalsByType(String animalType) {
		return animalRepository.getAllAnimalsByType(animalType);
	}

////                         klasse  naam object
	public void deleteAnimal(Animal animal) { // delete uit DB
		animalRepository.deleteAnimal(animal);
	}

	public void addAnimal(Animal animal) { // create in DB
		animalRepository.addAnimal(animal);
	}

	public void updateAnimal(Animal animal) { // create in DB
		animalRepository.updateAnimal(animal);
	}

	public void deleteAnimalByIndex(int index) {
		// TODO Auto-generated method stub

	}

}