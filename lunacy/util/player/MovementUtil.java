package lunacy.util.player;

import lunacy.util.main.Dependency;

public class MovementUtil extends Dependency {

    public static boolean isMoving() {
        return mc.thePlayer.moveForward != 0 || mc.thePlayer.moveStrafing != 0;
    }

    public static boolean isOnGround() {
        return mc.thePlayer.onGround;
    }

    public static boolean isMovingOnGround() {
        return isMoving() && isOnGround();
    }

}
