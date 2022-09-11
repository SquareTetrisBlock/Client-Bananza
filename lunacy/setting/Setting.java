package lunacy.setting;

public abstract class Setting<V> {

  private String name;
  private String desc;
  private V value;

  public Setting(String name, String desc, V v) {
    this.name = name;
    this.desc = desc;
    this.value = v;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public abstract void loadFromSetting(String val);

}
