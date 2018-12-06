package BMI_Calculator;

import java.util.Scanner;
public class BMI_Calc {

	public static void main(String[] args) {
		
		// Create variables
		double bmi = 0.0;
		String bodStatus;
		
		// input will be used to get user input
		Scanner input = new Scanner(System.in); 
		
		//Great the user, then ask their prefered measurement system
		System.out.println("Hello, and welcome to the BMI calculator!");
		System.out.println("The empirical system uses pounds and inches");
		System.out.println("The metric system uses kilograms and meters");
		System.out.print("Which system would you like to use (type \"empirical\" or \"metric\"): ");
		String unitOfMeasurement = input.nextLine();
		System.out.println();
		
		// Use the user's input to select the way the BMI gets calculated
		switch(unitOfMeasurement) {
		
			case "metric": {
				
				bmi = weightHeightMetric();
				break;
				
			} //End case "metric"
			
			case "empirical":{
				
				bmi = weightHeighEmpirical();
				break;
				
			} // End case "empirical"
		
		} // End switch statement
		
		// Determine the body status
		bodStatus = bodStat(bmi);
		
		// Display the results
		System.out.printf("\nBased on your height and weight, we detrmined that your BMI is %.2f and your body status is %s",
				bmi, bodStatus);
		
		//Closing the input
		input.close();

	}// End main method
	
	/*
	 * 
	 * Use if the user selects the metric system
	 * Ask the user how much they way (kilograms) and their height (meters)
	 * 
	 */
	public static double weightHeightMetric() {
		
		Scanner input = new Scanner(System.in);
		
		//Ask the user for their height in meters
		System.out.print("Please type your height in meters: ");
		double height = input.nextDouble();
		
		//Ask the user for their weight in kilograms
		System.out.print("Please type your weight in kilograms: ");
		double weight = input.nextDouble();
		
		//Send the values to bmiMetric 
		double bmi = bmiMetric(height, weight);
		
		// Close input and return the bmi
		input.close();
		return bmi;
		
	} // End weightHeightMetric method
	
	/*
	 *
	 * Use if the user selected the metric system
	 * Calculate the bmi of the user using metric measurements
	 * bmi = (weightInKilograns) / (heightInMeters * heightInMeters)
	 * 
	 */
	public static double bmiMetric(double height, double weight) {
		
		double bmi = (weight) / (height * height);
		return bmi;
		
	} // End bmiMetric method

	/*
	 * 
	 * Use if the user selects the empirical system
	 * Ask the user for their weight (pounds), their height (in feet), and their height (in inches) separately
	 * 
	 */
	public static double weightHeighEmpirical() {
		
		// Create input scanner for keyboard input
		Scanner input = new Scanner(System.in);
		
		// Ask and record the user's height in feet and inches
		System.out.print("Please enter your height in feet (Only the feet): ");
		double feet = input.nextDouble();
		System.out.print("Please enter your height in inches(from after the height in feet): ");
		double inches = input.nextDouble();
		
		// Calculate total inches of the user
		double height = feetToInches(feet, inches);
		
		// Ask and record the user's weight in pounds
		System.out.print("Please enter your weight in pounds: ");
		double weight = input.nextDouble();
		
		//Calculate the bmi 
		double bmi = bmiEmpirical(height, weight);
		
		// Close input and return the bmi
		input.close();
		return bmi;
		
	} // End weightHeightImperical method
	
	/*
	 * 
	 * Use if the user selects the empirical system
	 * Calculate the user's height in inches from their given weight
	 * inchTotal = (feet * 12) + inches
	 * 
	 */
	public static double feetToInches(double feet, double inches) {
		
		double totalInches = (feet * 12) + inches;
		return totalInches;
		
	} // End feetToInches method
	
	/*
	 * 
	 * Use if user selects the empirical system
	 * Calculate the bmi using empirical measurements
	 * bmi = (weightInPounds * 703) / (heightInInches * heightInInches)
	 * 
	 */
	public static double bmiEmpirical(double height, double weight) {
		
		double bmi = (weight * 703) / (height * height);
		return bmi;
		
	} // End bmiEmpirical method
	
	/*
	 * 
	 * Determine the user's body status with the bmi
	 * 
	 * Underweight: less than 18.5 
	 * Normal: between 18.5 and 24.9 
	 * Overweight: between 25 and 29.9 
	 * Obese: 30 or greater
	 * 
	 */
	public static String bodStat(double bmi) {
		
		// Determin the body status using the bmi
		if (bmi < 18.5) {
			
			return "underweight";
			
		} else if (bmi >= 18.5 && bmi < 25) {
			
			return "normal";
			
		} else if (bmi >= 25 && bmi < 30) {
			
			return "overweight";
			
		} else {
			
			return "obese";
			
		} // End if/else statement
		
	} // End bodStat method
	
} // End BMI_Calc class