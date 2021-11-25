package adapters;

import person.workers.Cashier;
import person.workers.Worker;

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
}
