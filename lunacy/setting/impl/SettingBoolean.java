package lunacy.setting.impl;

import lunacy.setting.Setting;

public class SettingBoolean extends Setting<Boolean> {

  public SettingBoolean(String name, String desc) {
    super(name, desc, false);
  }

  @Override
  public void loadFromSetting(String val) {
    setValue(Boolean.parseBoolean(val));
  }
}
