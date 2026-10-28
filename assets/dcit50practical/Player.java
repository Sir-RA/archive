import java.util.ArrayList;
import java.util.Scanner;

class Player {
	String name;
	int hp;
	ArrayList<Weapon> weapons = new ArrayList<>();
	ArrayList<Enemy> visibleEnemies = new ArrayList<>();

	Player(String name) {
		this.name = name;
		this.hp = 3;
		this.weapons.add(new Sword());
		this.weapons.add(new Staff());
	}

	void seeEnemy(Enemy enemy) {
		System.out.println();
		System.out.println(this.name + " sees the " + enemy.name + "!");
		System.out.println("\t" + enemy);
		visibleEnemies.add(enemy);
	}

	void showWeapons() {
		System.out.println(this.name + "'s weapons:");
		for (Weapon weapon : weapons) {
			System.out.println("  " + weapon);
		}
	}

	void attack(Enemy enemy, Weapon weapon) {
		System.out.println(this.name + " attacks " + enemy.name + " with the " + weapon.name);
		if (weapon.canHurt(enemy)) {
			enemy.hp -= weapon.damage;
			if (enemy.hp <= 0) {
				visibleEnemies.remove(enemy);
				System.out.println("The " + enemy.name + " is defeated!");
				return;
			}
		}
		System.out.println("\t" + enemy);
	}

	void playerTurn(Scanner sc) {
		System.out.println();
		System.out.println("--- " + this.name + "'s turn (" + this.hp + " HP) ---");
		System.out.println("What do you do?");
		for (int i = 0; i < visibleEnemies.size(); i++) {
			System.out.println("\t[" + i + "] Attack " + visibleEnemies.get(i));
		}
		System.out.print("> ");
		int enemyIndex = Integer.parseInt(sc.nextLine());

		System.out.println("With which weapon?");
		for (int i = 0; i < weapons.size(); i++) {
			System.out.println("\t[" + i + "] " + weapons.get(i));
		}
		System.out.print("> ");
		int weaponIndex = Integer.parseInt(sc.nextLine());

		attack(visibleEnemies.get(enemyIndex), weapons.get(weaponIndex));
	}
}
