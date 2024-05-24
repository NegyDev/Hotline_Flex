package Negy.WTF.module.impl.render;

import Negy.WTF.Client;
import Negy.WTF.Mappings.FontRenderer;

import java.awt.*;

public class Hud {

    public static void draw(){
        drawRainbowString("Hotline | .gg/e5DXHFMUzP",5,5,5L);
    }
    public static void drawRainbowString(String text, int x, int y, long time) {
        float hue = (float) (System.nanoTime() - time) / 1.0E10f % 1.0f;
        int rainbowColor = Color.HSBtoRGB(hue, 1.0f, 1.0f);
        Client.fontRenderer.drawString(text, x, y, rainbowColor);
    }
}
