package be.belfius.Zoo.domain;


public class Zoo {
	
	private final double PRICE_ADULT = 20;
	private final double PRICE_CHILD = 12.5;
	private int nbAdult;
	private int nbChildren;
	private double income;	

	
	//public int getNbAdult() {
	//	return nbAdult;
	//}
	
	public void setNbAdult(int nbAdult) {   // nbAdult wordt aangepast via console 
		this.nbAdult = nbAdult;
	}
	//public int getNbChildren() {
	//	return nbChildren;
	//}
	
	public void setNbChildren(int nbChildren) {
		this.nbChildren = nbChildren;
	}
	public double getIncome() {
		income = (nbAdult * PRICE_ADULT)+(nbChildren* PRICE_CHILD);
		return income;
	}
	
	public double getPRICE_ADULT() {
		return PRICE_ADULT;
	}
	public double getPRICE_CHILD() {
		return PRICE_CHILD;
	}


}
