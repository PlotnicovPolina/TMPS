package worker;

import factory.*;
import tool.CashMachine;

public class Cashier extends Worker {

    public Cashier() {}

    public Cashier(String name) {
        super(name);
    }

    public Cashier(String name, CashMachine tool) {
        super(name, tool);
    }

    @Override
    public void work(){
        System.out.println("Cashier works...");
    }

    public void notifyManager(int priority, String message){
        Notifier reportNotifier;
        switch (priority){
            case 1:
                reportNotifier = new RoutineReport(Priority.Routine);
                reportNotifier.notifyManager(message,Priority.Routine);
                break;
            case 2:
                reportNotifier = new RoutineReport(Priority.Routine);
                Notifier intercomNotifier = new Intercom(Priority.ASAP);
                reportNotifier.setNextNotifier(intercomNotifier);
                reportNotifier.notifyManager(message,Priority.ASAP);
                break;
            case 3:
                reportNotifier = new RoutineReport(Priority.Routine);
                intercomNotifier = new Intercom(Priority.ASAP);
                Emergency emergency = new Emergency(Priority.Important);
                reportNotifier.setNextNotifier(intercomNotifier);
                intercomNotifier.setNextNotifier(emergency);
                reportNotifier.notifyManager(message, Priority.Important);
                break;
        }
    }
}