/**
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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
		String fileName = "Animals2.txt";
		try {
		RescueCenter center = new RescueCenter("Scent-ter", 4);
		rescueSetUp(fileName, center);
		System.out.printf("%.2f\n", center.calculateAverageDailyFood());
		center.displayAnimalsAtOrAboveAverageDailyFood(center.calculateAverageDailyFood());
		} catch(FileNotFoundException exception) {
			System.out.println("Error: Unable to find file " + fileName);
		}
	}// end main
	
	public static void rescueSetUp(String fileName, RescueCenter rescue) throws FileNotFoundException
	{
		File inputFileName = new File(fileName);
		Scanner fileScanner = new Scanner(inputFileName);
		// reads the animals name. species, weight and daily food from text file
		while (fileScanner.hasNext()) {
			String name = fileScanner.next();
			String species = fileScanner.next();
			double weight = fileScanner.nextDouble();
			double dailyFood = fileScanner.nextDouble();
			Animal animal = new Animal(name, species, weight, dailyFood);
			rescue.addAnimal(animal);
		} // end loop
		fileScanner.close();
	}// end rescueCenterSetUp

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
		System.out.printf("Weight Category: %s\n", determineWeightCategory() );
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
	
	public double calculateTotalWeeklyFood() {
		double currentTotalWeekly = 0;
		for(int index = 0; index < animalCount; index++) {
			currentTotalWeekly += animals[index].calculateWeeklyFood();
		}//end for loop
		return currentTotalWeekly;
	}//end calculateTotalWeeklyFood
	
	public double calculateAverageDailyFood() {
		double sum = 0;
		for(int index = 0; index < animalCount; index++) {
			sum += animals[index].getDailyFoodAmount();
		}//end for loop
		return sum/animalCount;
	}//end calculateAverageDailyFood method
	
	public void displayAnimalsAtOrAboveAverageDailyFood(double average) {
		System.out.println("Animals at or Above Daily Food Amount:");
		for(int index = 0; index < animalCount; index++) {
			if (animals[index].getDailyFoodAmount() >= average) {
				System.out.printf("%s: %.2f\n",animals[index].getAnimalName(), animals[index].getDailyFoodAmount());
			}//end if
		}//end loop
	}//end displayAnimalsAtOrAboveAverageDailyFood method
	
}//end RescueCenter class
