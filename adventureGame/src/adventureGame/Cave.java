package adventureGame;

public class Cave extends BattleLocation {

	Cave(Player player) {
		super(player, "Cave", new Zombie(),"Food");
	}

}
