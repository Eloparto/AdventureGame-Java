package adventureGame;

import java.util.Scanner;

public class Game {

	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);
	private String playerNickName;

	public void login() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Adventure Game !");

		System.out.print("Enter your nickname before starting the game : ");

		playerNickName = scan.nextLine();

		player = new Player(playerNickName);

		player.selectChracter();

		start();
	}

	public void start() {

		while(true) {
			System.out.println();
			System.out.println("========================================");
			System.out.println();
			System.out.println("Choose a location : ");
			System.out.println();
			System.out.println("1. Safe House --> Your safe space, no enemies.");
			System.out.println("2.    Cave    --> Zombies can spawn on this area.");
			System.out.println("3.   Forest   --> Vampires can spawn on this area.");
			System.out.println("4.    River   --> Bears can spawn on this area.");
			System.out.println("5.    Shop    --> You can buy weapons or armor");
			System.out.print("Your choice : ");

			int selectLocation = scan.nextInt();

			while (selectLocation < 1 || selectLocation > 5) {
				System.out.println("You entered an invalid number, enter a valid number : ");
				selectLocation = scan.nextInt();
			}

			switch (selectLocation) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);
			}
			
			if(location.getClass().getName().contains("SafeHouse")) {
				if(player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater()) {
					System.out.println("======================================================");
					System.out.println("Congratulations "+playerNickName+"! You won the game !");
					System.out.println("======================================================");
					break;
				}
			}
			
			if(!location.getLocation()) {
				System.out.println("======================================================");
				System.out.println("                     Game Over!");
				System.out.println("======================================================");
				break;
			}
		}
	}
}
