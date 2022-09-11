package lunacy.module.impl.movement;

import lunacy.event.Event;
import lunacy.event.impl.EventPlayerUpdate;
import lunacy.module.ModInfo;
import lunacy.module.Module;
import lunacy.util.player.MovementUtil;
import org.lwjgl.input.Keyboard;

@ModInfo(name = "Speed", desc = "Makes you able to move faster.", keyCode = Keyboard.KEY_Q, category = Module.Category.MOVEMENT)
public class Speed extends Module {

    @Override
    public void onEvent(Event event) {
        if(event instanceof EventPlayerUpdate) {
            if(MovementUtil.isMovingOnGround()) {
                mc.thePlayer.jump();
            }
        }
    }

}
