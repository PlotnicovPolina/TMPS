package adapters;

import worker.Accountant;
import worker.Worker;

public class AccountantAdapter extends Worker {

    private Accountant accountant;

    public AccountantAdapter(Accountant accountant){
        this.accountant = accountant;
    }

    @Override
    public void work() {
        accountant.work();
    }

    @Override
    public void action(){
        accountant.action();
    }

    @Override
    public void notifyManager(int priority, String message) {
        accountant.notifyManager(priority,message);
    }
}
