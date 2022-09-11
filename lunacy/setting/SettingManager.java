package lunacy.setting;

import lunacy.setting.impl.ASettingBoolean;
import lunacy.setting.impl.SettingBoolean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingManager {

  private final List<Setting<?>> settings = new ArrayList<>();
  private final Map<Class<? extends Annotation>, Class<? extends Setting>> translationMap =
          new HashMap(){
            {
              put(ASettingBoolean.class, SettingBoolean.class);
            }
          };

  public void addSetting(Object o) {
    for(Field field : o.getClass().getFields()) {
      if(field.isAnnotationPresent(SettingInfo.class)) {
        Annotation annotation = field.getAnnotations()[1];

        try {
          settings.add(translationMap.get(annotation.getClass()).getConstructor(Object.class, Field.class).newInstance(o, field));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public Setting<?> getSetting(Object obj, String name) {

  }

}
