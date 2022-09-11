package lunacy.util;

public class MouseUtil {

  public static boolean inInArea(int mouseX, int mouseY, double x, double y, double w, double h) {
    return mouseX > x && mouseX < x+w && mouseY > y && mouseY < y+h;
  }

}
