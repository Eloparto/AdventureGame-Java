package adventureGame;

public abstract class BattleLocation extends Location {

	protected Monster monster;
	protected String awardItem;

	BattleLocation(Player player, String name, Monster monster, String awardItem) {
		super(player);
		this.monster = monster;
		this.name = name;
		this.awardItem = awardItem;
	}

	public boolean getLocation() {
		int monsterCount = monster.monsterCount();
		System.out.println("You are now in the" + this.getName() + ".");
		System.out.println("Becareful ! There are " + monsterCount + " " + monster.getName() + " here !");
		System.out.print("(A)ttack or (E)scape : ");
		String selectedCase = scan.nextLine();
		selectedCase = selectedCase.toUpperCase();
		if (selectedCase.equals("A")) {
			if (combat(monsterCount)) {
				System.out.println("You killed all the enemies in the " + this.getName() + " location !");
				if (this.awardItem.equals("Food") && player.getInventory().isFood() == false) {
					System.out.println("You won the " + this.awardItem + " !");
					player.getInventory().setFood(true);
				} else if (this.awardItem.equals("Water") && player.getInventory().isWater() == false) {
					System.out.println("You won the " + this.awardItem + " !");
					player.getInventory().setWater(true);
				} else if (this.awardItem.equals("Firewood") && player.getInventory().isFirewood() == false) {
					System.out.println("You won the " + this.awardItem + " !");
					player.getInventory().setFirewood(true);
					return true;
				}
				return true;
			}
			if (player.getHealth() <= 0) {
				System.out.println("You died !");
				return false;
			}
		}

		return true;
	}

	public boolean combat(int monsterCount) {
		for (int i = 0; i < monsterCount; i++) {
			int defaultMonsterHealth = monster.getHealth();
			playerStats();
			enemyStats();
			while (player.getHealth() > 0 && monster.getHealth() > 0) {
				System.out.print("(H)it or (E)scape : ");
				String selectedLetter = scan.nextLine();
				selectedLetter = selectedLetter.toUpperCase();
				if (selectedLetter.equals("H")) {
					System.out.println("You hit the " + monster.getName());
					monster.setHealth(monster.getHealth() - player.getTotalDamage());
					afterHit();
					if (monster.getHealth() > 0) {
						System.out.println("");
						System.out.println(monster.getName() + " hit you !");
						if(monster.getDamage()<player.getInventory().getArmor()) {
							afterHit();
						}else {
							player.setHealth(player.getHealth() - (monster.getDamage() - player.getInventory().getArmor()));
							afterHit();
						}
					}
				} else {
					break;
				}

			}

			if (monster.getHealth() <= 0 && player.getHealth() > 0) {
				System.out.println("You killed the " + monster.getName() + " !");
				player.setMoney(player.getMoney() + monster.getAward());
				System.out.println("");
				System.out.println("Current money : " + player.getMoney());
				monster.setHealth(defaultMonsterHealth);
			} else {
				return false;
			}
			System.out.println("-----------------");
		}
		return true;
	}

	public void playerStats() {
		System.out.println("Player stats\n----------");
		System.out.println("Hp : " + player.getHealth());
		System.out.println("Damage : " + player.getTotalDamage());
		System.out.println("Money : " + player.getMoney());

		if (player.getInventory().getDamage() > 0) {
			System.out.println("Weapon : " + player.getInventory().getWeaponName());
		}

		if (player.getInventory().getArmor() > 0) {
			System.out.println("Armor : " + player.getInventory().getArmorName());
		}
	}

	public void enemyStats() {
		System.out.println("\n" + monster.getName() + " stats\n----------");
		System.out.println("Hp : " + monster.getHealth());
		System.out.println("Damage : " + monster.getDamage());
		System.out.println("Award : " + monster.getAward());
	}

	public void afterHit() {
		System.out.println("Your Hp : " + player.getHealth());
		System.out.println(monster.getName() + " Hp : " + monster.getHealth());
		System.out.println();
	}
}
