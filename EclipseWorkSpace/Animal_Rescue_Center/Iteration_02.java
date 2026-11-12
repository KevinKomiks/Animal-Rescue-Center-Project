/**
 * 
 */

/**
 * 
 */
public class Iteration_02
{

	/**
	 * @param args
	 *            Implement and Test the Animal Class Implement and Test the
	 *            RescueCenter Class
	 */

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}// end main

}// end class

class Animal
{
	// instance variables
	private String name;
	private String species;
	private double weight;
	private double dailyFoodAmount;

	// constructor
	public Animal(String name, String species, double weight,
			double dailyFoodAmount)
	{
		this.name = name;
		this.species = species;
		this.weight = weight;
		this.dailyFoodAmount = dailyFoodAmount;
	}// end constructor

	// methods start here
	public String getAnimalName()
	{
		return name;
	}// end method getAnimalName
	public double getDailyFoodAmount()
	{
		return dailyFoodAmount;
	}// end method getDailyFoodAmount
	public double calculateWeeklyFood(double dailyFood)
	{
		return dailyFood * 7;
	}// end method calculateWeeklyFood

}// end Animal class
