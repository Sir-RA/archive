import java.util.ArrayList;

class Weapon {
	String name;
	int damage;
	ArrayList<String> hurtableEnemies = new ArrayList<>();

	Weapon(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}

	boolean canHurt(Enemy enemy) {
		for (String enemyName : hurtableEnemies) {
			if (enemy.name.contains(enemyName)) {
				return true;
			}
		}
		System.out.println("The " + this.name + " can't hurt the " + enemy.name + "!");
		return false;
	}

	@Override
	public String toString() {
		return this.name + ": " + this.damage + " Damage";
	}
}
