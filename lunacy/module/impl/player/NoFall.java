package lunacy.module.impl.player;

import lunacy.event.Event;
import lunacy.event.impl.EventMotion;
import lunacy.event.impl.EventPlayerUpdate;
import lunacy.module.ModInfo;
import lunacy.module.Module;
import lunacy.util.main.Dependency;

@ModInfo(name = "NoFall", desc = "Negates Fall Damage", keyCode = 0, category = Module.Category.PLAYER)
public class NoFall extends Module {

    @Override
    public void onEvent(Event event) {
        if(event instanceof EventMotion) {
            if(mc.thePlayer.fallDistance >= 2.5) {
                ((EventMotion) event).setOnGround(true);
                mc.thePlayer.fallDistance = mc.thePlayer.fallDistance >= 2.6 ? 0 : mc.thePlayer.fallDistance;
            }
        }
    }

}
