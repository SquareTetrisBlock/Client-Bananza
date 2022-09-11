package lunacy.setting.impl;

import lunacy.setting.Setting;

import java.lang.reflect.Field;

public class SliderSetting extends Setting<ASettingSlider, Double> {

  private double min, max, increment;

  public SliderSetting(Object object, Field field) {
    super(object, field);
  }

  @Override
  public void loadValue(String str) {
    setFieldValue(Double.parseDouble(str));
  }
}
