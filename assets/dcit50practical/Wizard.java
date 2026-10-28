class Wizard extends Enemy {
	Wizard() {
		super("wizard", 2, 1);
	}

	@Override
	String makeQuestion() {
		int first = rand.nextInt(10);
		int second = rand.nextInt(10);
		this.answer = first * second;
		return "What is " + first + " * " + second + "?";
	}
}
