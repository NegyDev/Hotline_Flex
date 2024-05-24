package Negy.WTF.Event;

public class Event {
	public boolean isCancelled;

    public boolean isCancelled()
    {
        return this.isCancelled;
    }

    public void setCancelled(boolean cancelled)
    {
        this.isCancelled = cancelled;
    }

    public void cancel()
    {
        this.isCancelled = true;
    }
}
