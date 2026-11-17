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
		//testing
		Animal animal1 = new Animal("Kevin", "dog", 90, 6);
		Animal animal2 = new Animal("Prince", "dog", 100, 5);
		Animal animal3 = new Animal("Mellow", "cat", 40, 3);
		animal1.displayAnimalAnalysis();
		RescueCenter center = new RescueCenter("Scent-ter", 3);
		center.addAnimal(animal1);
		center.addAnimal(animal2);
		center.addAnimal(animal3);
		System.out.printf("%.2f ", center.calcucateTotalWeeklyFood());
	}// end main

}// end class

class Animal
{
	// instance variables
	private String name;
	private String species;
	private double weight;
	private double dailyFoodAmount;
//-----------------------------------------------------------------------
	// constructor
	public Animal(String name, String species, double weight,
			double dailyFoodAmount)
	{
		this.name = name;
		this.species = species;
		this.weight = weight;
		this.dailyFoodAmount = dailyFoodAmount;
	}// end constructor
//------------------------------------------------------------------------
	// methods start here
	public String getAnimalName()
	{
		return name;
	}// end method getAnimalName
	public double getDailyFoodAmount()
	{
		return dailyFoodAmount;
	}// end method getDailyFoodAmount
	public double calculateWeeklyFood()
	{
		return dailyFoodAmount * 7;
	}// end method calculateWeeklyFood
	public String determineWeightCategory() {
		String weightCategory;
		if (weight >= 100)
		{
			weightCategory = "Extra Large";
		} else if (weight >= 50)
		{
			weightCategory = "Large";
		} else if (weight >= 20)
		{
			weightCategory = "Medium";
		} else
		{
			weightCategory = "Small";
		}
		return weightCategory;
	}//end method determineWeightCategory
	public void displayAnimalAnalysis()
	{
		System.out.println("---------- Animal Summary ----------");
		System.out.printf("Animal name: %s\n", name);
		System.out.printf("Weight: %.2f lbs\n", weight);
		System.out.printf("Weight Category : %s\n", determineWeightCategory() );
		System.out.printf("Daily Food Amount: %.2f lbs\n", dailyFoodAmount);
		System.out.printf("Weekly Food Amount: %.2f lbs\n", calculateWeeklyFood());
	} // end displayAnimalSummary method
}// end Animal class

class RescueCenter {
	//instance variables
	private String rescueName;
	private Animal[] animals;
	private int animalCount;
//--------------------------------------------------------------
	//constructor
	public RescueCenter(String rescueName, int maxAnimals) {
		this.rescueName = rescueName;
		animals = new Animal[maxAnimals];
		animalCount = 0;
	}//end RescueCenter
//--------------------------------------------------------------
	//methods
	public String getRescueName() {
		return rescueName;
	}//end getRescueName
	public int getAnimalCount() {
		return animalCount;
	}//end getAnimalCount
	public void addAnimal(Animal animal) {
		if (animalCount < animals.length) {
		animals[animalCount] = animal;
		animalCount++;
		}
		else System.out.println("Error: Rescue Center full");
	}//end add animal
	public double calcucateTotalWeeklyFood( ) {
		double currentTotalWeekly = 0;
		for(int index = 0; index < animals.length; index++) {
			currentTotalWeekly += animals[index].calculateWeeklyFood();
		}//end for loop
		return currentTotalWeekly;
	}//end calculateTotalWeeklyFood
}//end RescueCenter class
