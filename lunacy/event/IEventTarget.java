package lunacy.event;

public interface IEventTarget {

  void onEvent(Event event);
  boolean canFire();

}
