package be.belfius.Zoo.repository;

import java.util.ArrayList;
import java.util.List;

import be.belfius.Zoo.domain.Food;
import be.belfius.Zoo.domain.MeatyFood;
import be.belfius.Zoo.domain.VeggieFood;
import be.belfius.Zoo.exceptions.NotEnoughStockException;

public class FoodRepository {

	private List<Food> foodStock = new ArrayList<>();

	public List<Food> getFood() {
		return foodStock;
	}

	public FoodRepository() {
		foodStock.add(new MeatyFood("Zebrasteak", 1000));
		foodStock.add(new MeatyFood("Antilopesteak", 1500));
		foodStock.add(new VeggieFood("Grass pile", 50));
		foodStock.add(new VeggieFood("Leafs", 600));

	}

	public void updStock(String name, int portion) {
		for (Food foodToUpdate : getFood()) {
			if (foodToUpdate.getName().equals(name)) {
				foodToUpdate.setPortion(foodToUpdate.getPortion() + portion);
			}
		}
	}
	public void reduceStock(String name, int portion) throws NotEnoughStockException {
		for (Food foodToUpdate : getFood()) {
			if (foodToUpdate.getName().equals(name)) {
				if (foodToUpdate.getPortion() < portion) {
					throw new NotEnoughStockException();
				} else {
					foodToUpdate.setPortion(foodToUpdate.getPortion() - portion);
				}
			}
		}
	}
}
