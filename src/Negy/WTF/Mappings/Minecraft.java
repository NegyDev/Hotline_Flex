package Negy.WTF.Mappings;

import java.lang.reflect.Field;
import net.minecraft.client.Pe;
import net.minecraft.client.*;
import net.minecraft.client.hj;

public class Minecraft {
    public static Pe getMinecraft(){
        try{
            Field TheMinecraft = Pe.class.getDeclaredField("eb");
            TheMinecraft.setAccessible(true);
            return (Pe) TheMinecraft.get(null);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static kX getPlayer()
    {
        return getMinecraft().eS;
    }
    public static CY getWorld()
    {
        return getMinecraft().e9;
    }
}
