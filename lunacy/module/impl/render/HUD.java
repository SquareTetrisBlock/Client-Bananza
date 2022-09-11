package lunacy.module.impl.render;

import com.mojang.realmsclient.gui.ChatFormatting;
import javafx.scene.transform.Scale;
import lunacy.Client;
import lunacy.event.Event;
import lunacy.event.impl.EventPlayerUpdate;
import lunacy.event.impl.EventRenderGui;
import lunacy.module.ModInfo;
import lunacy.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.optifine.util.MathUtils;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.util.Comparator;

@ModInfo(
    name = "Hud",
    desc = "Renders a Heads Up Display.",
    keyCode = Keyboard.KEY_H,
    category = Module.Category.RENDER)
public class HUD extends Module {

  public HUD() {
    toggle();
  }

  int count = 0; // ??????

  @Override
  public void onEvent(Event event) {
    ScaledResolution sr = new ScaledResolution(mc);
    if (event instanceof EventRenderGui) {
      Client.getSingleton()
          .getModuleManager()
          .getModules()
          .sort(
              Comparator.comparingDouble(module -> fr.getStringWidth(((Module) module).getName()))
                  .reversed());
      for (Module module : Client.getSingleton().getModuleManager().getModules()) {
        fr.drawStringWithShadow("B" + ChatFormatting.WHITE + "onanza", 3, 3, Color.CYAN.getRGB());
        if (module.isToggled()) {
          fr.drawStringWithShadow(
              module.getName(),
              sr.getScaledWidth() - fr.getStringWidth(module.getName()) - 4,
              4 + count * 10,
              module.getCategory().getColor().getRGB());
          count++;
        }
      }
      count = 0;
      fr.drawStringWithShadow("FPS " + ChatFormatting.WHITE + ": " + Minecraft.getDebugFPS(), sr.getScaledWidth() - fr.getStringWidth("FPS " + ChatFormatting.WHITE + ": " + Minecraft.getDebugFPS()) - 2, sr.getScaledHeight() - 10, Color.CYAN.getRGB());
      fr.drawStringWithShadow("BPS " + ChatFormatting.WHITE + ": " + Math.round(((mc.thePlayer.motionX * mc.thePlayer.motionX + mc.thePlayer.motionZ * mc.thePlayer.motionZ) * 50)), sr.getScaledWidth() - fr.getStringWidth("FPS " + ChatFormatting.WHITE + ": " + Minecraft.getDebugFPS()) - fr.getStringWidth("BPS " + ChatFormatting.WHITE + ": " + Math.round(((mc.thePlayer.motionX * mc.thePlayer.motionX + mc.thePlayer.motionZ * mc.thePlayer.motionZ) * 50))) - 4, sr.getScaledHeight() - 10, Color.CYAN.getRGB());
    }
  }
}
