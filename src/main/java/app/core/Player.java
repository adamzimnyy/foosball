package app.core;

public enum Player {

	AZI("Adam"),
	DCY("Daniel"),
	KKA("Karol"),
	MMI("Marcin"),
	PGR("Piotrek"),
	UGA("Ula");

	String name;

	Player(String name) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

}
