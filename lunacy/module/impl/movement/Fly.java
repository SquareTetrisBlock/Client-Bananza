package lunacy.module.impl.movement;

import lunacy.event.Event;
import lunacy.event.impl.EventPlayerUpdate;
import lunacy.module.ModInfo;
import lunacy.module.Module;
import lunacy.util.player.MovementUtil;
import org.lwjgl.input.Keyboard;

@ModInfo(
    name = "Fly",
    desc = "Makes you able to Fly.",
    keyCode = Keyboard.KEY_F,
    category = Module.Category.MOVEMENT)
public class Fly extends Module {

  @Override
  public void onEvent(Event event) {
    if (event instanceof EventPlayerUpdate) {
      if (MovementUtil.isMovingOnGround()) mc.thePlayer.jump();
      mc.thePlayer.motionY = MovementUtil.isMovingOnGround() ? 0.42 : 0;
    }
  }
}
