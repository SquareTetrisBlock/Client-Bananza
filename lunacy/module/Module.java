package lunacy.module;

import lunacy.Client;
import lunacy.event.Event;
import lunacy.event.IEventTarget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

import java.awt.*;

public class Module implements IEventTarget {

  private String name;
  private String desc;
  private int keyCode;
  private Category category;
  private boolean toggled;

  protected final Minecraft mc = Minecraft.getMinecraft();
  protected final FontRenderer fr = mc.fontRendererObj;

  public Module() {
    ModInfo modInfo = getClass().getAnnotation(ModInfo.class);
    this.name = modInfo.name();
    this.desc = modInfo.desc();
    this.keyCode = modInfo.keyCode();
    this.category = modInfo.category();
    Client.getSingleton().getEventManager().addEvent(this);
  }

  @Override
  public void onEvent(Event event) {}

  public void onEnable() {}

  public void onDisable() {}

  @Override
  public boolean canFire() {
    return toggled;
  }

  public String getName() {
    return name;
  }

  public String getDesc() {
    return desc;
  }

  public int getKeyCode() {
    return keyCode;
  }

  public Category getCategory() {
    return category;
  }

  public void setKeyCode(int key) {
    this.keyCode = key;
  }

  public void toggle() {
    toggled = !toggled;
    if (toggled) onEnable();
    else onDisable();
  }

  public boolean isToggled() {
    return toggled;
  }

  public enum Category {
    COMBAT("Combat", new Color(255, 74, 74)),
    MOVEMENT("Movement", new Color(151, 151, 255)),
    PLAYER("Player", new Color(142, 184, 161)),
    RENDER("Render", new Color(255, 170, 170)),
    EXPLOIT("Exploit", new Color(255, 242, 99)),
    MISC("Misc", new Color(125, 125, 125));

    private final String name;
    private final Color color;

    Category(String name, Color color) {
      this.name = name;
      this.color = color;
    }

    public String getName() {
      return name;
    }

    public Color getColor() {
      return color;
    }

  }
}
