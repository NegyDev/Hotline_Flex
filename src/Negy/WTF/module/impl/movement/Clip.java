package Negy.WTF.module.impl.movement;

import Negy.WTF.Mappings.Minecraft;
import Negy.WTF.module.Category;
import Negy.WTF.module.Module;
import net.minecraft.DN;
import org.lwjgl.input.Keyboard;

import java.lang.reflect.Method;

public class Clip extends Module {
    public Clip() {
        super("Clip", Keyboard.KEY_F, Category.Movement);
    }
    public static double getPosForSetPosX(double val, float RotationYaw) {
        float yaw = RotationYaw * ((float)Math.PI / 180);
        double x = -Math.sin(yaw) * val;
        return x;
    }

    public static double getPosForSetPosZ(double val, float RotationYaw) {
        float yaw = RotationYaw * ((float)Math.PI / 180);
        double z = Math.cos(yaw) * val;
        return z;
    }
    @Override
    public void onEnable() {
        double newposX = Minecraft.getPlayer().l + Clip.getPosForSetPosX(3, Minecraft.getPlayer().e);
        double newposz = Minecraft.getPlayer().p6 + Clip.getPosForSetPosZ(3, Minecraft.getPlayer().e);
        double newposY = Minecraft.getPlayer().ph+ 2.0;
        setPosition(Minecraft.getPlayer(),newposX,newposY,newposz);
        this.moduleState = false;
    }
    public void setPosition(DN Entity,double x, double y, double z) {
        try {
            Method m = DN.class.getMethod("e",double.class,double.class,double.class);
            m.setAccessible(true);
            m.invoke(Entity,x,y,z);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
