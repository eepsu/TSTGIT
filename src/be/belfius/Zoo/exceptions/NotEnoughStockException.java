package be.belfius.Zoo.exceptions;

public class NotEnoughStockException extends Exception {

	@Override
	public String getMessage() {
		return ("Sorry there's not enough food");
	}

}
