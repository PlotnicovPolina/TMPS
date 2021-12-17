import factory.Factory;
import factory.Manager;
import factory.Notifier;
import factory.RoutineReport;
import product.ProductType;
import worker.Cashier;

public class Main {

    public static void main(String[] args) {
        Manager manager = Manager.getInstance("Oleg");
        System.out.println(manager.getName());
        Factory fridge = manager.createFactory("Fridge");
        Factory cupboard = manager.createFactory("Cupboard");

        fridge.testCreate(ProductType.MilkProduct);
        fridge.testCreate(ProductType.Seafood);
        fridge.testCreate(ProductType.Drinks);
        fridge.testCreate(ProductType.Seafood);
        fridge.testCreate(ProductType.Drinks);

        cupboard.testCreate(ProductType.BakeryProducts);
        cupboard.testCreate(ProductType.Porridge);
        cupboard.testCreate(ProductType.Sweets);
        cupboard.testCreate(ProductType.BakeryProducts);
        cupboard.testCreate(ProductType.Porridge);

        fridge.showProducts();
        cupboard.showProducts();

//        Accountant accountant = new Accountant("Sean", new Computer());
//
//        accountant.action();
//
//        Cashier cashier = new Cashier("Maria", new CashMachine());
//
//        cashier.action();
//
//        Merchandiser merchandiser = new Merchandiser("Juan", new Scanner());
//
//        merchandiser.action();

//        Worker[] person.workers = {new adapters.AccountantAdapter(new Accountant("Sean", new Computer())),
//                            new adapters.CashierAdapter(new Cashier("Maria", new CashMachine())),
//                            new adapters.MerchandiserAdapter(new Merchandiser("Juan",new Scanner()))};
//
//        for(Worker worker: person.workers){
//            worker.work();
//            worker.action();
//        }

        Facade facade = new Facade();

        facade.accountantWorks();
        facade.cashierWorks();
        facade.merchandiserWorks();
        facade.cashierNotify(1,"List of products sold");
        facade.cashierNotify(2, "Problem with client");
        facade.cashierNotify(3, "Fire");

    }
}
