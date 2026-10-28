class Sword extends Weapon {
	Sword() {
		super("sword", 1);
		this.hurtableEnemies.add("wizard");
	}
}
