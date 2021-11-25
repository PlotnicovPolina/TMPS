package adapters;

import person.workers.Accountant;
import person.workers.Worker;

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
}