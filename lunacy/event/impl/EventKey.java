package lunacy.event.impl;

import lunacy.event.Event;

public class EventKey extends Event {
  private int keyCode;

  public EventKey(int keyCode) {
    this.keyCode = keyCode;
  }

  public int getKeyCode() {
    return keyCode;
  }

}
