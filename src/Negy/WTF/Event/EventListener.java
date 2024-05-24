package Negy.WTF.Event;


import Negy.WTF.module.Module;

public class EventListener {
	public static void ListenEvent(Event e) {
        Module.onEventAdd(e);
    }
}
