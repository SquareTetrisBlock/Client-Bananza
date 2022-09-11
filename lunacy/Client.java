package lunacy;

import lunacy.command.CommandManager;
import lunacy.event.EventManager;
import lunacy.module.ModuleManager;
import lunacy.module.impl.movement.Sprint;
import lunacy.setting.SettingManager;

public class Client {

  private static Client singleton;

  private final ModuleManager moduleManager;
  private final EventManager eventManager;
  private final CommandManager commandManager;
  private final SettingManager settingManager;

  private Client() {
    moduleManager = new ModuleManager();
    eventManager = new EventManager();
    commandManager = new CommandManager();
    settingManager = new SettingManager();
  }

  public void start() {
    moduleManager.init();
    commandManager.init();

  }

  public static Client getSingleton() {
    if(singleton == null)
      singleton = new Client();
    return singleton;
  }

  public EventManager getEventManager() {
    return eventManager;
  }

  public CommandManager getCommandManager() {
    return commandManager;
  }

  public SettingManager getSettingManager() {
    return settingManager;
  }

  public ModuleManager getModuleManager() {
    return moduleManager;
  }

}
