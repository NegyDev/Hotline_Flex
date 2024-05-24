package Negy.WTF;

import Negy.WTF.Mappings.FontRenderer;
import Negy.WTF.Mappings.Minecraft;
import Negy.WTF.module.ModuleManager;
import net.minecraft.client.eA;

public class Client {
    public static FontRenderer fontRenderer;
    public static void setIngameGui(eA gui) {
        Minecraft.getMinecraft().eW = gui;
    }
    public static void Start() {
        fontRenderer = new FontRenderer();
        ModuleManager.INSTANCE.initialize();
        setIngameGui(new GuiIngameHook(Minecraft.getMinecraft().eW));
    }
    public static void main(String[] args) {

    }
}
