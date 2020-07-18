package com.epam.maven_oops;
import java.util.*;
public class NewYearGiftAnalysis {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Chocolates> chocolates = new ArrayList<Chocolates>();
	static ArrayList<Chocolates> candies = new ArrayList<Chocolates>();
	static ArrayList<Sweets> sweets = new ArrayList<Sweets>();
	static HashMap<String, Integer> nameToWeight = new HashMap<String, Integer>();
	static HashMap<String, Integer> nameToPrice = new HashMap<String, Integer>();
	public static void main(String[] args) {
		inputChocolates();
		inputSweets();
		System.out.println("Total weight of gift is:"+(calculateTotalWeight()));
		System.out.println("Choose the way to sort(Enter the number):1.By price 2.By Weight");
		int sortType = sc.nextInt();
		if(sortType == 1) {
			Comparator<Chocolates> compareByPrice = (Chocolates c1, Chocolates c2) -> ((Integer) c1.getPrice()).compareTo(c2.getPrice());
			Collections.sort(chocolates,compareByPrice);
			System.out.println("The sorted result by price is: ");
			for(Chocolates choc: chocolates) {
				System.out.println(choc.getPrice());
			}
		}
		else {
			Comparator<Chocolates> compareByWeight = (Chocolates c1, Chocolates c2) -> ((Integer) c1.getWeight()).compareTo(c2.getWeight());
			Collections.sort(chocolates,compareByWeight);
			System.out.println("The sorted result by weight is: ");
			for(Chocolates choc: chocolates) {
				System.out.println(choc.getWeight());
			}
		}
		calcRange(sortType);
	}
	private static void calcRange(int sortType) {
		System.out.println("Lets find the range");
		int lowerLimit,higherLimit;
		if(sortType==1) {
			System.out.println("Enter the lowerLimit of the price:");
			lowerLimit=sc.nextInt();
			System.out.println("Enter the higherLimit of the price:");
			higherLimit=sc.nextInt();
			Set<Map.Entry<String, Integer>> candySet=nameToPrice.entrySet();
			Iterator<Map.Entry<String,Integer>> candyIterator=candySet.iterator();
			while(candyIterator.hasNext()) {
				Map.Entry candyElement = (Map.Entry)candyIterator.next();
				int currentPrice =(int)candyElement.getValue();
				if(currentPrice>=lowerLimit && currentPrice <= higherLimit) {
					System.out.println(candyElement.getKey());
				}
			}
		}
		else {
			System.out.println("Enter the lowerLimit of the weight:");
			lowerLimit=sc.nextInt();
			System.out.println("Enter the higherLimit of the weight:");
			higherLimit=sc.nextInt();
			Set<Map.Entry<String, Integer>> candySet=nameToWeight.entrySet();
			Iterator<Map.Entry<String,Integer>> candyIterator=candySet.iterator();
			while(candyIterator.hasNext()) {
				Map.Entry candyElement = (Map.Entry)candyIterator.next();
				int currentWeight =(int)candyElement.getValue();
				if(currentWeight>=lowerLimit && currentWeight <= higherLimit) {
					System.out.println(candyElement.getKey());
				}
			}
		}
		
	}
	private static int calculateTotalWeight() {
		int total = 0;
		for(Chocolates choco : chocolates) {
			total += choco.getWeight();
		}
		for(Sweets sweet : sweets) {
			total += sweet.getWeight();
		}
		return total;
	}
	private static void inputSweets() {
		System.out.print("Enter no.of sweets:");
		int noSweets = sc.nextInt();
		for(int i = 1; i <= noSweets; i++) {
			System.out.println("Enter type of sweet(Enter the number): 1.KaajuKatli 2.gulabJamun");
			System.out.print("Enter weight of sweet:");
			int sweetWeight = sc.nextInt();
			System.out.println("Enter price of chocolate: ");
			int sweetPrice = sc.nextInt();
			Sweets sweet = new Sweets(sweetWeight, sweetPrice);
			sweets.add(sweet);
		}
		
	}
	private static void inputChocolates() {
		System.out.print("Enter no.of chocolates:");
		int noChocolates = sc.nextInt();
		for(int i = 1; i <= noChocolates; i++) {
			System.out.println("Enter type of chocolate(Enter the number): 1.Candy 2.Wafer");
			int chocoType = sc.nextInt();
			System.out.print("Enter weight of chocolate:");
			int chocoWeight = sc.nextInt();
			System.out.println("Enter price of chocolate: ");
			int chocoPrice = sc.nextInt();
			if(chocoType == 1) {
				System.out.println("Enter name of candy : ");
				String candyName = sc.next();
				if(nameToWeight.containsKey(candyName))
					nameToWeight.put(candyName, (int)nameToWeight.get(candyName) + chocoWeight);
				else
					nameToWeight.put(candyName, chocoWeight);
				if(nameToPrice.containsKey(candyName))
					nameToPrice.put(candyName, (int)nameToPrice.get(candyName) + chocoPrice);
				else
					nameToPrice.put(candyName, chocoPrice);
				Candy candy = new Candy(chocoPrice, chocoWeight, candyName);
			}
			else {
				System.out.println("Enter name of wafer : ");
				String waferName = sc.next();
				if(nameToWeight.containsKey(waferName))
					nameToWeight.put(waferName, (int)nameToWeight.get(waferName) + chocoWeight);
				else
					nameToWeight.put(waferName, chocoWeight);
				if(nameToPrice.containsKey(waferName))
					nameToPrice.put(waferName, (int)nameToPrice.get(waferName) + chocoPrice);
				else
					nameToPrice.put(waferName, chocoPrice);
				Wafer wafer = new Wafer(chocoPrice, chocoWeight, waferName);
			}
			Chocolates choco = new Chocolates(chocoPrice, chocoWeight);
			chocolates.add(choco);
		}
	}

}