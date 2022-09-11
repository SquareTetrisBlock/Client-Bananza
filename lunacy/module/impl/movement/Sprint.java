package lunacy.module.impl.movement;

import lunacy.event.Event;
import lunacy.event.impl.EventPlayerUpdate;
import lunacy.module.ModInfo;
import lunacy.module.Module;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

@ModInfo(
    name = "Sprint",
    desc = "Sprints for you.",
    keyCode = Keyboard.KEY_N,
    category = Module.Category.MOVEMENT)
public class Sprint extends Module {

  @Override
  public void onEvent(Event event) {
    if (event instanceof EventPlayerUpdate) {
      KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
    }
  }
}