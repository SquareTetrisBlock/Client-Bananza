package lunacy.setting.impl;

import lunacy.setting.Setting;

import java.lang.reflect.Field;

public class SettingBoolean extends Setting<ASettingBoolean, Boolean> {

  public SettingBoolean(Object object, Field field) {
    super(object, field);
  }

  @Override
  public void loadValue(String str) {
    setFieldValue(Boolean.parseBoolean(str));
  }

}
