package lunacy.module;

import lunacy.Client;
import lunacy.event.Event;
import lunacy.event.IEventTarget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

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
    Client.getSingleton().getSettingManager().addSetting(this);
  }

  @Override
  public void onEvent(Event event) {}
  public void onEnable() {}
  public void onDisable() {}

  @Override
  public boolean canFire() {
    return toggled;
  }

  public String getName() {return name;}
  public String getDesc() {return desc;}
  public int getKeyCode() {return keyCode;}
  public Category getCategory() {return category;}

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
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    PLAYER("Player"),
    RENDER("Render"),
    EXPLOIT("Exploit"),
    MISC("Misc");

    private final String name;

    Category(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }


  }

}
