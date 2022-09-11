package lunacy.command.impl;

import lunacy.Client;
import lunacy.command.Command;
import lunacy.command.CommandInfo;
import lunacy.module.Module;

@CommandInfo(name = "Toggle", desc = "Toggles the command given.", aliases = {"t"})
public class CommandToggle extends Command {

  @Override
  public void onCommand(String[] args) {
    try {
      Module module = Client.getSingleton().getModuleManager().getModule(args[1]);
      module.toggle();
    } catch (Exception e) {
     e.printStackTrace();
    }
  }
}
