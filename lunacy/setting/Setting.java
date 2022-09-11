package lunacy.setting;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class Setting<Object> {

  private String name;
  private String desc;
  private Field field;
  private Object object;

  public Setting(Object object, Field field) {
    SettingInfo settingInfo = field.getAnnotation(SettingInfo.class);
    this.name = settingInfo.name();
    this.desc = settingInfo.desc();
  }

  public void setFieldValue(Object value) {
    try {
      field.set(object, value);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public Object getFieldValue() {
    try {
      return (Object) field.get(object);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return null; //ee
  }

  public abstract void loadValue(String str);

}
