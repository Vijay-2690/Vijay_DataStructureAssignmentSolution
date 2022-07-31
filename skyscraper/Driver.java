package com.greatlearning.projects.skyscraper;

import java.util.*;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Object of Skyscraper class
		Skyscraper building = new Skyscraper();
		
		//taking input from user to enter the value of number of floors
		System.out.println("Please enter the number of Floors: ");
			int numOfFloors = sc.nextInt();
			
		//Queue to store the size of floors for different days
		Queue<Integer> floors = new LinkedList<>();
			
		//calling method to insert value of floor sizes
		building.insertValues(floors, numOfFloors);
		
		//Variable to store the maximum value of the floor
		int max = building.setMax(floors);
		
		//Stack to store the lesser value of size not to be assembled on current day
		Stack outputFloors = new Stack();

		//Calling method to give the output
		building.floorPlan(floors, outputFloors, numOfFloors, max);

	}

}
