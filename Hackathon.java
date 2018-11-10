package hackathon;
import java.util.Scanner;

public class Hackathon {

	static Scanner scanner = new Scanner(System.in);
	public static void main (String[] args) {	
			
			System.out.print("Enter your name: ");
			String name = scanner.nextLine();
			
			//enter a delay
			delay();
			System.out.print("Hello, " + name);

			for (int i = 1; i < 4 ; i++) {
				System.out.print(".");
				delay();
			}

			
			System.out.print("\n" + "\n" + "How old are you? ");
			int age = scanner.nextInt();
			
			if (age < 18) {
				System.out.println("This is a game for mature people only, fool.");
				System.exit(0);
			} else if (age == 18) {
				System.out.println("Dope, 18 year olds are the GOATS.");
			} else {
				System.out.println("Welcome to the game, old ass.");
			}
			
			startGame();
					
	}
	public static void delay() {
		try {
			Thread.sleep(500); 
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	public static void startGame() {
		int money = 100;
		int turns = 0;
		System.out.println("\n" + "We will begin the roulette game.");
		delay();
		System.out.println("\n" + "You will start with " + money + " dollars." );
		delay();
		
		while(money > 0) {
			System.out.print("Pick a number: 1 (Black- 45%), 2 (Red - 45%), 3 (Green - 10%): ");
			delay();
			
			double colorValue =(int)(Math.random() * 100);
			int correctValue = 0;
			
			if (colorValue < 45) {
				correctValue = 1;
			} else if (colorValue >= 45 && colorValue < 90) {
				correctValue = 2;
			} else if (colorValue >= 90) {
				correctValue = 3;
			}
			
			while(true) {
				int color = scanner.nextInt();

				if(color == 1 || color == 2) {
					if (color == correctValue) {
						System.out.println("\n" + "You won " + money + " dollars!");
						money = money + money; 
					} else {
						money = money / 2;
						System.out.println("\n" + "You lost " + money + " dollars, LOL!");
					} break;
				} else if (color == 3) {
					if (color == correctValue) {
						System.out.println("\n" + "You won " + (money * 9) + " dollars!");
						money = money * 10; 
					} else {
						money = money / 2;
						System.out.println("\n" + "You lost " + money + " dollars, LOL!");
					} break;
				} else {
					System.out.print("Enter a valid value: ");
				} 
			} delay(); System.out.println("You have " + money + " dollars." + "\n"); turns++;
		} 
		
		System.out.println("Thanks for playing, dont gamble in the future bro.");
		System.out.println("You lasted " + turns + " turns.");
	}
}
