package adapters;

import person.workers.Merchandiser;
import person.workers.Worker;

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
}
