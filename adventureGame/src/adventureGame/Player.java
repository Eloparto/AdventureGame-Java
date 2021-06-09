package adventureGame;

import java.util.Scanner;

public class Player {

	private int damage;
	private int health;
	private int firstHealth;
	private int money;
	private String name;
	private String chracterName;
	private Inventory inventory;
	Scanner scan = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
	}

	public void selectChracter() {
		switch (chracterMenu()) {
		// Samurai
		case 1:
			initPlayer("Samurai", 5, 21, 15);
			break;
		// Archer
		case 2:
			initPlayer("Archer", 7, 18, 20);
			break;
		// Knight
		case 3:
			initPlayer("Knight", 8, 24, 5);
			break;
		// default Samurai
		default:
			initPlayer("Samurai", 5, 21, 15);
			break;
		}
		
		System.out.println(getChracterName()+" selected ! |"+" Damage : " +getDamage()+" | Hp : "+getHealth()+" | Money : "+getMoney() +" |" );
		
	}

	public int chracterMenu() {
		System.out.println("Select chracter :");
		System.out.println("1- Samurai | Damage : 5 | Hp : 21 | Money : 15 |");
		System.out.println("2- Archer  | Damage : 7 | Hp : 18 | Money : 20 |");
		System.out.println("3- Knight  | Damage : 8 | Hp : 24 | Money : 5  |");
		System.out.print("Your choice : ");
		int chracterId = scan.nextInt();

		while (chracterId < 1 || chracterId > 3) {
			System.out.print("You entered an invalid number, enter a valid number : ");
			chracterId = scan.nextInt();
		}

		return chracterId;

	}
	
	public int getTotalDamage() {
		
		return this.getDamage() + this.getInventory().getDamage();
		
	}
	
	public void initPlayer(String chracterName, int damage, int health, int money) {
		setChracterName(chracterName);
		setDamage(damage);
		setHealth(health);
		setMoney(money);
		setFirstHealth(health);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChracterName() {
		return chracterName;
	}

	public void setChracterName(String chracterName) {
		this.chracterName = chracterName;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getFirstHealth() {
		return firstHealth;
	}

	public void setFirstHealth(int firstHealth) {
		this.firstHealth = firstHealth;
	}

	
}
