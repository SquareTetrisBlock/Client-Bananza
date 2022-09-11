package lunacy.setting.impl;

import lunacy.setting.Setting;

public class SettingSlider extends Setting<Double> {

  private final double min, max, increment;

  public SettingSlider(String name, String desc, Double aDouble, double min, double max, double increment) {
    super(name, desc, aDouble);
    this.min = min;
    this.max = max;
    this.increment = increment;
  }

  public double getMin() {
    return min;
  }

  public double getMax() {
    return max;
  }

  public double getIncrement() {
    return increment;
  }

  @Override
  public void loadFromSetting(String val) {

  }
}
