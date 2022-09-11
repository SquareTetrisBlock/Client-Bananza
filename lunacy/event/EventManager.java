package lunacy.event;

import lunacy.Client;
import lunacy.event.impl.EventKey;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

  private final List<IEventTarget> eventTargets = new ArrayList<>();

  public void fireEvent(Event event) {
    eventTargets.stream()
        .filter(IEventTarget::canFire)
        .forEach(iEventTarget -> iEventTarget.onEvent(event));
  }

  public void handleKeyPress(int keyCode) {
    fireEvent(new EventKey(keyCode));
    Client.getSingleton().getModuleManager()
            .getModules().forEach(module -> {
              if(module.getKeyCode() == keyCode) module.toggle();
            });
  }

  public void addEvent(IEventTarget eventTarget) {
    this.eventTargets.add(eventTarget);
  }

}
