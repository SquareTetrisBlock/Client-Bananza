package lunacy.setting;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class Setting<V> {

  private String name;
  private String desc;
  private Field field;
  private Object object;

  public Setting(Object object, Field field) {
    SettingInfo settingInfo = field.getAnnotation(SettingInfo.class);
    this.name = settingInfo.name();
    this.desc = settingInfo.desc();
    this.object = object;
  }

  public void setFieldValue(V value) {
    try {
      field.set(object, value);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public Object getObject() {
    return object;
  }

  public String getName() {
    return name;
  }

  public String getDesc() {
    return desc;
  }

  public V getFieldValue() {
    try {
      return (V) field.get(object);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return null; //ee
  }

  public abstract void loadValue(String str);

}
