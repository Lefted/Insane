package me.sixteen_.insane.command;

/**
 * @author 16_
 */
public abstract class Command {

	private final String[] name;

	public Command(final String... name) {
		this.name = name;
	}

	public abstract void runCommand(final String... param);

	public String[] getName() {
		return name;
	}
}
