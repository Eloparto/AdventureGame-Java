package adventureGame;

public class ToolStore extends NormalLocation {

	ToolStore(Player player) {
		super(player, "Shop");
	}

	public boolean getLocation() {

		System.out.println("Money : " + player.getMoney());
		System.out.println("1. Weapons");
		System.out.println("2. Armors");
		System.out.println("3. Exit");
		System.out.print("Your choice : ");

		int selectedTool = scan.nextInt();
		int selectedItemId;

		while (selectedTool < 1 || selectedTool > 3) {
			System.out.println("You entered an invalid number, enter a valid number : ");
			selectedTool = scan.nextInt();
		}

		switch (selectedTool) {
		case 1:
			selectedItemId = weaponMenu();
			buyWeapon(selectedItemId);
			break;
		case 2:
			selectedItemId = armorMenu();
			buyArmor(selectedItemId);
			break;
		default:
			break;
		}

		return true;
	}
	
	public int armorMenu() {
		System.out.println("1. Light armor  | Armor Strength : 1 | Price : 15 |");
		System.out.println("2. Middle armor | Armor Strength : 3 | Price : 25 |");
		System.out.println("3. Heavy armor  | Armor Strength : 5 | Price : 40 |");
		System.out.println("4. Exit");
		System.out.print("Choose a armor : ");

		int selectedArmorId = scan.nextInt();

		while (selectedArmorId < 1 || selectedArmorId > 4) {
			System.out.println("You entered an invalid number, enter a valid number : ");
			selectedArmorId = scan.nextInt();
		}

		return selectedArmorId;
	}
	
	public void buyArmor(int itemId) {

		int strength = 0;
		int price = 0;
		String armorName = null;

		switch (itemId) {
		case 1:
			strength = 1;
			armorName = "Light armor";
			price = 15;
			break;
		case 2:
			strength = 3;
			armorName = "Middle armor";
			price = 25;
			break;
		case 3:
			strength = 5;
			armorName = "Heavy armor";
			price = 40;
			break;
		case 4:
			System.out.println("You left the shop.");
			break;
		default:
			System.out.println("Invalid process !");
			break;
		}

		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInventory().setArmor(strength);
				player.getInventory().setArmorName(armorName);
				player.setMoney(player.getMoney() - price);

				System.out.println("You bought the " + armorName + "! Your current armor strength : "
						+ player.getInventory().getArmor());

				System.out.println("Remaining money : " + player.getMoney());

			} else {
				System.out.println("You don't have enough money !");
			}

		}
		
	}

	public int weaponMenu() {

		System.out.println("1.  Gun  | Price : 25 | Damage : 2 |");
		System.out.println("2. Sword | Price : 35 | Damage : 3 |");
		System.out.println("3. Rifle | Price : 45 | Damage : 7 |");
		System.out.println("4. Exit");
		System.out.print("Choose a weapon : ");

		int selectedWeaponId = scan.nextInt();

		while (selectedWeaponId < 1 || selectedWeaponId > 4) {
			System.out.println("You entered an invalid number, enter a valid number : ");
			selectedWeaponId = scan.nextInt();
		}

		return selectedWeaponId;

	}

	public void buyWeapon(int itemId) {

		int damage = 0;
		int price = 0;
		String weaponName = null;

		switch (itemId) {
		case 1:
			damage = 2;
			weaponName = "Gun";
			price = 25;
			break;
		case 2:
			damage = 3;
			weaponName = "Sword";
			price = 35;
			break;
		case 3:
			damage = 7;
			weaponName = "Rifle";
			price = 45;
			break;
		case 4:
			System.out.println("You left the shop.");
			break;
		default:
			System.out.println("Invalid process !");
			break;
		}

		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInventory().setDamage(damage);
				player.getInventory().setWeaponName(weaponName);
				player.setMoney(player.getMoney() - price);

				System.out.println("You bought the " + weaponName + "! Your current damage : "
						+ player.getTotalDamage());

				System.out.println("Remaining money : " + player.getMoney());

			} else {
				System.out.println("You don't have enough money !");
			}

		}
		
	}
}
