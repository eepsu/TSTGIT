package be.belfius.Zoo;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import be.belfius.Zoo.domain.Animal;
import be.belfius.Zoo.domain.Bear;
import be.belfius.Zoo.domain.Elephant;
import be.belfius.Zoo.domain.Food;
import be.belfius.Zoo.domain.Lion;
import be.belfius.Zoo.domain.TypeOfAnimal;
import be.belfius.Zoo.domain.Zoo;
import be.belfius.Zoo.services.AnimalService;
import be.belfius.Zoo.services.FoodService;

public class ZooApplication {

	static Zoo zoo = new Zoo();

	static AnimalService animalService = new AnimalService();
	static FoodService foodService = new FoodService(); // van de klasse dient een object gemaakt te worden om de
														// methodes te kunnen gebruiken

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int choice = 0;
		while (choice != 9) {
			showMenu();

			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				System.err.println("Wrong input");
			}
			switch (choice) {
			case 0:
				break;
			case 1:
				System.out.println(animalService.getAnimals());
				break;
			case 2:
				deleteAnimal();
				System.out.println(animalService.getAnimals());
				break;
			case 3:
				addAnimal();
				System.out.println(animalService.getAnimals());
				break;
			case 4:
				showKindOfAnimal();
				System.out.println(animalService.getAnimals());
				break;
			case 5:
				updateAnimal();
				System.out.println(animalService.getAnimals());
				break;
			case 6:
				calculateDayIncome();
				break;
			case 7:
				System.out.println(foodService.getFood());
			case 8:
				addFood();
			case 9:
				feedAnimal();
				break;
			}

		}
		scanner.close();
	}

	private static void addAnimal() {
		System.out.println("Which animal do you want to add ?");
		System.out.println("---------------------------------");
		int i = 1;
		for (TypeOfAnimal typeOfAnimal : TypeOfAnimal.values()) { // 2e mogelijkheid in commentaar
			System.out.println(i + ". " + typeOfAnimal.getType());
			i++;
		}
//		TypeOfAnimal[] animalTypes = TypeOfAnimal.values();
//		for (int j = 0; j < TypeOfAnimal.values().length; j++) {
//			System.out.println(j+1 + animalTypes[j].getType());
//		}
		int whichAnimalIn = scanner.nextInt();

		if (whichAnimalIn == 1) {
			System.out.println("Give the bear a name");
			String naam = scanner.next();
			System.out.println("Give the bear a birthDate(ccyy-mm-dd)");
			String datum = scanner.next();
			animalService.addAnimal(new Bear(naam, LocalDate.parse(datum)));
			System.out.println("The bear has been added");
		} else if (whichAnimalIn == 2) {
			System.out.println("Give the lion a name");
			String naam = scanner.next();
			System.out.println("Give the lion a birthDate(ccyy-mm-dd)");
			String datum = scanner.next();
			animalService.addAnimal(new Lion(naam, LocalDate.parse(datum)));
			System.out.println("The lion has been added");
		} else {
			System.out.println("Give the elephant a name");
			String naam = scanner.next();
			System.out.println("Give the elephant a birthDate(ccyy-mm-dd)");
			String datum = scanner.next();
			animalService.addAnimal(new Elephant(naam, LocalDate.parse(datum)));
			System.out.println("The elephant has been added");
		}

	}

	private static void deleteAnimal() {
		System.out.println("Which animal has to leave the zoo ?");
		System.out.println("-----------------------------------");
		List<Animal> animals = animalService.getAnimals();
		for (int i = 0; i < animals.size(); i++) {
			System.out.println(i + ". " + animals.get(i));
		}
		int whichAnimalOut = scanner.nextInt();
		animalService.deleteAnimal(animals.get(whichAnimalOut));
	}

	private static void updateAnimal() {
		System.out.println("Which animal has to change his name ?");
		System.out.println("-------------------------------------");
		List<Animal> animals = animalService.getAnimals(); // lijst def om dieren op te halen
		for (int i = 0; i < animals.size(); i++) { // ophalen lijst van dieren
			System.out.println(i + ". " + animals.get(i));
		}
		int animalToMod = scanner.nextInt();
		System.out.println("Give the animal a new name");
		String newName = scanner.next();
		Animal foundAnimal = animals.get(animalToMod); // ophalen van het te wijzigen dier
		foundAnimal.setName(newName); // naam aanpassen
		animalService.updateAnimal(foundAnimal); // update uitvoeren
	}

	private static void showMenu() {
		System.out.println("Make a choice");
		System.out.println("-------------");
		System.out.println("0. Stop");
		System.out.println("1. Show a list of animals ");
		System.out.println("2. An animal has to leave the zoo ");
		System.out.println("3. Welcome a new animal in the zoo ");
		System.out.println("4. Give the list of names of a specific animal");
		System.out.println("5. Give an animal a new name");
		System.out.println("6. Calculate day income ");
		System.out.println("7. Show a list of all food ");
		System.out.println("8. Add to foodstock");
		System.out.println("9. Feed an animal");

	}

	private static void showKindOfAnimal() {
		System.out.println("Choose an animal ?");
		System.out.println("------------------");
		System.out.println("Bear, Lion or Elephant");
		String animalType = scanner.next();
		System.out.println(animalService.getAllAnimalsByType(animalType));

	}

	private static void calculateDayIncome() {
		Zoo zoo = new Zoo();
		System.out.println("Give the number of adults");
		zoo.setNbAdult(scanner.nextInt());
		System.out.println("Give the number of children");
		zoo.setNbChildren(scanner.nextInt());
		System.out.println("Calculated income today = " + zoo.getIncome());
	}

	private static void addFood() {
		System.out.println("Which kind of food do you want to add ?");
		System.out.println("---------------------------------------");
		List<Food> food = foodService.getFood();
		for (int i = 0; i < food.size(); i++) {
			System.out.println((i + 1) + ". " + food.get(i).getName());
		}
		int nrFoodToAdd = scanner.nextInt();
		String foodName = food.get(nrFoodToAdd - 1).getName();
		System.out.println("How much do you want to add ?");
		System.out.println("-----------------------------");
		int nbAddStock = scanner.nextInt();
		foodService.updStock(foodName, nbAddStock);
		System.out.println(food);
	}

	private static void feedAnimal() {
		System.out.println("What kind of food do you need ?");
		System.out.println("-------------------------------");
		List<Food> food = foodService.getFood();
		for (int i = 0; i < food.size(); i++) {
			System.out.println((i + 1) + ". " + food.get(i).getName());
		}
		int nrFoodToFeed = scanner.nextInt();
		String foodName = food.get(nrFoodToFeed - 1).getName();
		System.out.println("How much do you need ?");
		System.out.println("-----------------------------");
		int needPortion = scanner.nextInt();
		foodService.reduceStock(foodName, needPortion);
		System.out.println(food);

	}
}
