package factory;

public class RoutineReport extends Notifier {

    public RoutineReport(int priority){
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Daily Report:" + message);
    }
}
