package me.sixteen_.insane.command.commands;

import me.sixteen_.insane.Insane;
import me.sixteen_.insane.command.Command;
import me.sixteen_.insane.module.Module;
import net.minecraft.client.util.InputUtil;

/**
 * @author 16_
 */
public class BindCommand extends Command {

	public BindCommand() {
		super("bind", "b");
	}

	@Override
	public void runCommand(final String... param) {
		final Module m = Insane.getInsane().getModuleManager().getModuleByName(param[1]);
		final InputUtil.Key key = InputUtil.fromTranslationKey(String.format("key.keyboard.%s", param[2].toLowerCase()));
		m.setKeybind(key);
	}
}