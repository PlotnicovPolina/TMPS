package adapters;

import factory.*;
import worker.Cashier;
import worker.Worker;

public class CashierAdapter extends Worker {
    private Cashier cashier;

    public CashierAdapter(Cashier cashier){
        this.cashier = cashier;
    }

    @Override
    public void work() {
        cashier.work();
    }

    @Override
    public void action() {
        cashier.action();
    }

    @Override
    public void notifyManager(int priority, String message) {
        cashier.notifyManager(priority,message);
    }
}
