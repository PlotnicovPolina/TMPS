package factory;

public class Intercom extends Notifier{

    public Intercom (int priority){
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Need assistance:" + message);
    }
}
