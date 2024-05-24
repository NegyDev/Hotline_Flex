package Negy.WTF.Mappings;
import net.minecraft.client.hj;

public class FontRenderer {
    public int Font_height = 9;
    static hj FontRenderer = Minecraft.getMinecraft().er;

    public void drawString(String text,int x,int y,int color){
        FontRenderer.R(text, x, y, color);
    }
    public void drawStringWithShadow(String text,float x,float y,int color){
        FontRenderer.O(text,x,y,color);
    }
    public void drawString(String text,float x,float y,int color,boolean shadow){
        FontRenderer.X(text, x, y, color, shadow);
    }
}
