package factory;

public class Emergency extends Notifier{
    public Emergency (int priority){
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Emergency:" + message);
    }
}
