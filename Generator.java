/*
	File example for the NumberBruteForceGenerator
	See it on GitHub => https://github.com/Lore99/Number-BruteForcer/
 */

import bruteforce.NumberBruteForce.NumberBruteForce;
public class Generator {

	public static void main(String[] args) {
		
		NumberBruteForce forcer = new NumberBruteForce("+39", 7, 335); 
		// +39 is italy's country code, 335 is one of the area codes, 7 is the lenght of the rest of the number
		//example: +39 335 *******
		
		boolean bool = forcer.bruteForce("numbers.txt"); //specify the path and the name.ext of the file	
		
		if(bool) System.out.println("Numbers added!");
		else System.out.println("Failed to add numbers!");
	}

}
