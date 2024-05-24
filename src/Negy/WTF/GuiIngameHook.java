package Negy.WTF;
import Negy.WTF.Event.EventListener;
import Negy.WTF.Event.impl.Render2DEvent;
import Negy.WTF.Mappings.FontRenderer;
import Negy.WTF.Mappings.Minecraft;
import Negy.WTF.module.impl.render.ArrayList;
import Negy.WTF.module.impl.render.Hud;
import net.minecraft.client.eA;

public class GuiIngameHook extends eA{
    FontRenderer fontRenderer = new FontRenderer();
    public GuiIngameHook(eA guiIngame){
        super(Minecraft.getMinecraft());
    }

    @Override
    public void R(float v) {
        super.R(v);
        EventListener.ListenEvent(new Render2DEvent());
        Hud.draw();
        ArrayList.draw();
    }
}
