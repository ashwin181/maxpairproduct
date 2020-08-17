package src.main.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * program to compute the max of the pair product of the arrays containing integers
 * @author 167058
 *
 */
public class MaxOfPairProduct {
	
	public static void main(String[] args) {
		
		int number;
		
		int sum = 0;
		
		//scanner class to read input 
		
		Scanner scan = new Scanner(System.in);
		  
		System.out.println("Enter number of array elemets");
		  
		//type the number of elements you want in the array 
		 number = scan.nextInt();
		 
		 Random randomNumber = new Random();
		  
		 //initialise integer array 
		 int arrayOfIntegers[] = new int[number];
		  
		 //get all the elements of the array 
		 for(int i =0; i< number; i++) {
		  
		 //arrayOfIntegers[i] = scan.nextInt(); 
			 arrayOfIntegers[i] = randomNumber.nextInt(1000);
		 }
		  
		 System.out.println("The array formed is " +Arrays.toString(arrayOfIntegers));
		  
		 //compute the max pair product
		 System.out.println(computeMaxProductofPair(arrayOfIntegers));
		 
	}
	
	/**
	 * Algo to compute the max pair product
	 * @param arrayOfIntegers
	 * @return
	 */
	public static int computeMaxProductofPair(int[] arrayOfIntegers) {
		
		//write algorithm
		long startTime = System.currentTimeMillis();
		System.out.println("Start Time " + startTime);
		Set<Integer> modifiedIntegerSet = new HashSet();
		
		int trackArrayIndex = 0;
		
		while(trackArrayIndex<arrayOfIntegers.length-1) {
			
			for(int i =0; i < arrayOfIntegers.length-1;i++) {
				
				if(trackArrayIndex != i+1) {
					modifiedIntegerSet.add(arrayOfIntegers[trackArrayIndex]* arrayOfIntegers[i+1]);
				}
				
			}
			
			trackArrayIndex = trackArrayIndex + 1;
		}
		
		System.out.println("modified set is " + modifiedIntegerSet);
		
		//find the max element in the modified integer set 
		
		List<Integer> productPairList = modifiedIntegerSet.stream().collect(Collectors.toList());
		
		int maxValue = findMaxElementInArray(productPairList);
		
		System.out.println("End time is " + String.valueOf(System.currentTimeMillis()-startTime));
		
		return maxValue;
	}
	
	public static int findMaxElementInArray(List<Integer> integerList) {
		
		int maxValue = 0;
		
		Integer[] arrayOfProductValues = integerList.toArray(new Integer[integerList.size()]);
		
		for(int i = 1; i < arrayOfProductValues.length;i++) {
			
			if((arrayOfProductValues[0] < arrayOfProductValues[i])) {
				
				arrayOfProductValues[0] = arrayOfProductValues[i];
				maxValue = arrayOfProductValues[0];
				
			}
			else {
				maxValue = arrayOfProductValues[0];
			}
		}
		
		System.out.println("max value computed is " + maxValue);
		
		return maxValue;
		
	}

}
