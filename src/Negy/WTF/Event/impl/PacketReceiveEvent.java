package Negy.WTF.Event.impl;
import Negy.WTF.Event.Event;
import net.minecraft.Tz;
public class PacketReceiveEvent extends Event {
    private Tz<?> packet;

    public PacketReceiveEvent(Tz<?> packet)
    {
        this.packet = packet;
    }

    public Tz<?> getPacket()
    {
        return packet;
    }

}
