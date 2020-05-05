package be.belfius.Zoo.services;

import java.util.List;

import be.belfius.Zoo.domain.Animal;
import be.belfius.Zoo.domain.Food;
import be.belfius.Zoo.exceptions.NotEnoughStockException;
import be.belfius.Zoo.repository.FoodRepository;

public class FoodService {
	private FoodRepository foodRepository = new FoodRepository(); // 1 object aanmaken om repos te kunnen gebruiken

	public List<Food> getFood() {
		return foodRepository.getFood();
	}

	public void updStock(String name, int portion) {
		foodRepository.updStock(name, portion);
	}

	public void reduceStock(String name, int portion) {
		try {
			foodRepository.reduceStock(name, portion);
		} catch (NotEnoughStockException e) {
			e.getMessage();
		}
	}

}
