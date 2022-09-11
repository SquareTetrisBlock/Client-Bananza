package lunacy.command.impl;

import lunacy.command.Command;
import lunacy.command.CommandInfo;
import lunacy.config.ConfigManager;

import java.util.Locale;

@CommandInfo(name = "config", desc = "Saves a config", aliases = {"cfg"})
public class CommandConfig extends Command {

  @Override
  public void onCommand(String[] args) {
    try {
      switch (args[1].toLowerCase(Locale.ROOT)) {
        case "save":
          ConfigManager.saveConfig(args[2], false);
          break;
        case "load":
          ConfigManager.loadConfig(args[2]);
      }
    } catch (Exception e) {}
  }
}
