import java.util.Random;
import java.util.Scanner;

class Enemy {
	String name;
	int hp;
	int damage;
	int answer;
	Random rand = new Random();

	Enemy(String name, int hp, int damage) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}

	@Override
	public String toString() {
		return this.name + ": " + this.hp + " HP, " + this.damage + " Damage";
	}

	void attack(Player player) {
		System.out.println(this.name + " attacks " + player.name + " for " + this.damage + " damage!");
		player.hp = Math.max(0, player.hp - this.damage);
		System.out.println(player.name + " has " + player.hp + " HP left");
		if (player.hp == 0) {
			System.out.println(player.name + " has fallen...");
		}
	}

	// A turn is: ask a question, and attack if the answer is wrong.
	// Subclasses change the question by overriding makeQuestion().
	void enemyTurn(Player player, Scanner sc) {
		if (player.hp <= 0) {
			return;
		}
		System.out.println();
		System.out.println("--- " + this.name + "'s turn ---");
		String question = makeQuestion();
		if (!askQuestion(sc, question, this.answer)) {
			attack(player);
		}
	}

	// Build a question, store its correct answer in the answer field, and
	// return the question text. The base enemy asks a simple addition.
	String makeQuestion() {
		int first = rand.nextInt(10);
		int second = rand.nextInt(10);
		this.answer = first + second;
		return "What is " + first + " + " + second + "?";
	}

	// Ask the player a math question. Returns true if the answer is correct.
	boolean askQuestion(Scanner sc, String question, int expected) {
		System.out.println(this.name + " asks: " + question);
		System.out.print("> ");
		int input = Integer.parseInt(sc.nextLine());
		if (input == expected) {
			System.out.println("Correct! " + this.name + "'s attack is blocked.");
			return true;
		}
		System.out.println("Wrong! The answer was " + expected + ".");
		return false;
	}
}
