class Knight extends Enemy {
	Knight() {
		super("knight", 4, 1);
	}

	@Override
	String makeQuestion() {
		int first = rand.nextInt(100);
		int second = rand.nextInt(100);
		this.answer = first - second;
		return "What is " + first + " - " + second + "?";
	}
}
