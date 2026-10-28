import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		System.out.println("Turn Based RPG");
		System.out.println("--------------");
		System.out.println("[1] Play");
		System.out.println("[2] Quit");

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		switch (input) {
			case "1":
				playGame(sc);
				break;
			case "2":
				break;
		}

		sc.close();
	}

	static void playGame(Scanner sc) {
		Player player = new Player("Steve");
		player.showWeapons();

		// Wave 1: a single knight
		player.seeEnemy(new Knight());
		battle(player, sc);

		// Wave 2: a knight and two wizards
		player.seeEnemy(new Knight());
		player.seeEnemy(new Wizard());
		player.seeEnemy(new Wizard());
		battle(player, sc);

		if (player.hp <= 0) {
			System.out.println("You lose...");
		} else {
			System.out.println("You win!!!");
		}
	}

	// One wave of combat. Players and enemies take turns until the player
	// is dead or every visible enemy is gone.
	static void battle(Player player, Scanner sc) {
		while (!player.visibleEnemies.isEmpty() && player.hp > 0) {
			player.playerTurn(sc);
			for (Enemy enemy : player.visibleEnemies) {
				enemy.enemyTurn(player, sc);
			}
		}
	}
}
