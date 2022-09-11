package lunacy.setting;

import lunacy.setting.impl.ASettingBoolean;
import lunacy.setting.impl.SettingBoolean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class SettingManager {

  private final List<Setting<?>> settings = new ArrayList<>();
  private final Map<Class<? extends Annotation>, Class<? extends Setting<?>>> translationMap =
          new HashMap(){
            {
              put(ASettingBoolean.class, SettingBoolean.class);
            }
          };

  public void addSetting(Object o) {
    for(Field field : o.getClass().getFields()) {
      if(field.isAnnotationPresent(SettingInfo.class) && field.getAnnotations().length > 1) {
        Annotation annotation = field.getAnnotations()[1];

        System.out.println(annotation);

        Class<?> settingClass = translationMap.get(annotation.annotationType());

        try {
          Setting<?> setting = (Setting<?>) settingClass.getConstructor(Object.class, Field.class).newInstance(o, field);
          this.settings.add(setting);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public Setting<?> getSetting(Object obj, String name) {
    for (Setting<?> setting : settings) {
      if (setting.getObject().equals(obj) && setting.getName().equalsIgnoreCase(name))
        return setting;
    }
    return null; // when the code
  }

}
