package lunacy;

import lunacy.command.CommandManager;
import lunacy.event.EventManager;
import lunacy.module.ModuleManager;

public class Client {

  private static Client singleton;

  private final ModuleManager moduleManager;
  private final EventManager eventManager;
  private final CommandManager commandManager;

  private Client() {
    moduleManager = new ModuleManager();
    eventManager = new EventManager();
    commandManager = new CommandManager();
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

  public ModuleManager getModuleManager() {
    return moduleManager;
  }

}
