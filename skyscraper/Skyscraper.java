package com.greatlearning.projects.skyscraper;

import java.util.*;

public class Skyscraper {
		Stack outputFloors = new Stack();
		int max;
		Scanner sc = new Scanner(System.in);
		
		//Method to set the maximum value of the size of the floor from the Queue of non assembled floors.
		public static int setMax(Queue <Integer> queue) {
		
			if(queue.peek() == null) {
				return - 1;// if the queue is empty the maximum value will be set to -1
		}
		
		
			int max = queue.peek();// setting the maximum value as the first element of the queue
		
		// loop to get the maximum value of the floor from the queue of all the floors remaining to be assembled
		
			for(int i: queue) {
			if(i > max) {
				max = i;
			}
		}
		
			return max;
	}
	
	// Method to insert values of the floors taking input from the user.
		public void insertValues(Queue queue, int size) {
		
			for(int i = 0; i < size; i++) {
			
				System.out.println("Please enter the size of the floor given on Day " + (i+1));
			
				int num = sc.nextInt();
			
				queue.add(num);						
		}
	}
	
		
	// Method to give the output as the number of floor to be assembled on a particular day
		public void floorPlan(Queue <Integer> queue, Stack stack, int size, int max) {
		
			this.max = max;
		
			for(int i = 0; i < size; i++) {
			
				if((int)queue.peek() == max) {
				System.out.println("Day " + (i+1));

				System.out.print(queue.remove()+ " ");
				max = setMax(queue);

				if(!outputFloors.isEmpty() && !queue.isEmpty()) {
					while(!outputFloors.isEmpty() && max <= (int)outputFloors.peek()) {
						System.out.print(outputFloors.pop()+ " ");
					}
				}
				if(!outputFloors.isEmpty() && max == -1) {
					while(!outputFloors.isEmpty()) {
					System.out.print(outputFloors.pop()+ " ");
					}
				}
				if(!outputFloors.isEmpty() && max != -1 && max <= (int)outputFloors.peek()) {
					System.out.print(outputFloors.pop()+ " ");

				}
				else {
					System.out.println();
				}
				
			}
			else {
				System.out.print("Day " + (i + 1) + "\n \n");
				
				
				outputFloors.push(queue.remove());
			}
		}
	}
	
}
