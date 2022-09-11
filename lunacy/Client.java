package lunacy;

import lunacy.event.EventManager;
import lunacy.module.ModuleManager;

public class Client {

  private static Client singleton;

  private final ModuleManager moduleManager;
  private final EventManager eventManager;

  private Client() {
    moduleManager = new ModuleManager();
    eventManager = new EventManager();
  }

  public void start() {
    moduleManager.init();
  }

  public static Client getSingleton() {
    if(singleton == null)
      singleton = new Client();
    return singleton;
  }

  public EventManager getEventManager() {
    return eventManager;
  }

  public ModuleManager getModuleManager() {
    return moduleManager;
  }

}
