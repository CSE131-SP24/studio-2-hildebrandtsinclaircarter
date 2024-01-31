package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Input Starting Amount");
		double startAmount = in.nextDouble();
		System.out.println("Input Win Probability between 0 and 100");
		double winChance = in.nextDouble();
		System.out.println("Input Limit");
		double winLimit = in.nextDouble();
		boolean end = false;
		double amount = startAmount;
		int randomNum = 0; 
		System.out.println("How many days in the casino?");
		int days = in.nextInt();
		int counter = 0;
		int losses = 0;
		double expectedruin = 0;
		double alpha = (1-winChance)/winChance;
		
		
		if (winChance == 50) {
			expectedruin = 1-(startAmount/winLimit);
		}
		else {
			expectedruin = ((Math.pow(alpha, startAmount)-Math.pow(alpha, winLimit))/(1-Math.pow(alpha, winLimit)));
		}
		
		for (int x = 1;x <= days; x++ ){
			counter=0;
			end = false;
			amount = startAmount;
		while (end==false) {
			randomNum = 0 + (int)(Math.random() * (101));
			if (randomNum <= winChance) {
				amount += 1;
			}
			else if (randomNum > winChance) {
				amount -=1;
			}
			counter+=1;
			if (amount <= 0) {
				end = true;
				System.out.println("Day " + x + " ended in a loss.");
				System.out.println("Number of plays on day " + x + ": " + counter);
				losses += 1;
			}
			if (amount>= winLimit) {
				end = true;
				System.out.println("Day " + x + " ended in a win.");
				System.out.println("Number of plays on day " + x + ": " + counter);

			}
		}
		}
		double ruinrate = (double)losses/days;
		System.out.println(losses);
		System.out.println("Expected Ruin: " + expectedruin);
		System.out.println("Ruin rate: " + ruinrate);
	}

}
