package lunacy.module.impl.movement;

import lunacy.event.Event;
import lunacy.event.impl.EventMotion;
import lunacy.module.ModInfo;
import lunacy.module.Module;
import org.lwjgl.input.Keyboard;
@ModInfo(
        name = "Step",
        desc = "Step Up Blocks.",
        keyCode = 0,
        category = Module.Category.MOVEMENT)
public class Step extends Module {

    @Override
    public void onDisable() {
        mc.thePlayer.stepHeight = 0.6f;
        super.onDisable();
    }

    @Override
    public void onEvent(Event event) {
        if(event instanceof EventMotion) {
            mc.thePlayer.stepHeight = 2;
        }
    }
}
