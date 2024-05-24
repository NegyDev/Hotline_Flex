package Negy.WTF.module.impl.render;

import java.awt.Color;

import Negy.WTF.Client;
import Negy.WTF.Mappings.FontRenderer;
import Negy.WTF.Mappings.Minecraft;
import Negy.WTF.module.Module;
import Negy.WTF.module.ModuleManager;
import net.minecraft.client.CC;
import org.lwjgl.input.Keyboard;

public class ArrayList {
    public static void draw() {
        CC sr = new CC(Minecraft.getMinecraft());
        FontRenderer fontRenderer = Client.fontRenderer;

        int yOffset = 4;
        int moduleCount = 0;

        for (Module module : ModuleManager.modules) {
            if (module.moduleState) {
                String moduleKey = Keyboard.getKeyName(module.moduleKey);
                String displayText = "[" + moduleKey + "] " + module.moduleName;
                int moduleKeyWidth = Minecraft.getMinecraft().er.X(moduleKey);
                int startX = (int) (sr.K() - Minecraft.getMinecraft().er.X(displayText) - 4);
                fontRenderer.drawString("[", startX, yOffset, 0xFFD700);
                startX += Minecraft.getMinecraft().er.X("[");
                fontRenderer.drawString(moduleKey, startX, yOffset, 0xFFD700);
                startX += moduleKeyWidth;
                fontRenderer.drawString("] ", startX, yOffset, 0xFFD700);
                startX += Minecraft.getMinecraft().er.X("] ");

                fontRenderer.drawString(module.moduleName, startX, yOffset, 0x00FF00);
            } else {
                String moduleKey = Keyboard.getKeyName(module.moduleKey);
                String displayText = "[" + moduleKey + "] " + module.moduleName;
                int moduleKeyWidth = Minecraft.getMinecraft().er.X(moduleKey);
                int startX = (int) (sr.K() - Minecraft.getMinecraft().er.X(displayText) - 4);
                fontRenderer.drawString("[", startX, yOffset, 0xFFD700);
                startX += Minecraft.getMinecraft().er.X("[");
                fontRenderer.drawString(moduleKey, startX, yOffset, 0xFFD700);
                startX += moduleKeyWidth;
                fontRenderer.drawString("] ", startX, yOffset, 0xFFD700);
                startX += Minecraft.getMinecraft().er.X("] ");

                fontRenderer.drawString(module.moduleName, startX, yOffset, 0x808080);
            }
            yOffset += fontRenderer.Font_height + 3;
            moduleCount++;
        }
    }


    public static int rainbow(int delay, int offset, int index) {
        double rainbowDelay = Math.ceil(System.currentTimeMillis() + (long)((long) delay * index)) / offset;
        return Color.getHSBColor((float)(rainbowDelay % 360.0 / 360.0), 0.5F, 1.0F).getRGB();
    }
}
