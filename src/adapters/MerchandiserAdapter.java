package adapters;

import worker.Merchandiser;
import worker.Worker;

public class MerchandiserAdapter extends Worker {

    private Merchandiser merchandiser;

    public MerchandiserAdapter(Merchandiser merchandiser){
        this.merchandiser = merchandiser;
    }

    @Override
    public void work() {
        merchandiser.work();
    }
    @Override
    public void action(){
        merchandiser.action();
    }

    @Override
    public void notifyManager(int priority, String message) {
        merchandiser.notifyManager(priority,message);
    }
}
