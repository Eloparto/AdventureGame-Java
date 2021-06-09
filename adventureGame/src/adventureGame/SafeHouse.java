package adventureGame;

public class SafeHouse extends NormalLocation {

	SafeHouse(Player player) {
		
		super(player, "Safe House");

	}

	public boolean getLocation() {
		player.setHealth(player.getFirstHealth());
		
		System.out.println("Your hp filled ! | "+ player.getHealth() +" |");
		
		System.out.println("You are in the safe house now.");
		
		return true;
	}
}
