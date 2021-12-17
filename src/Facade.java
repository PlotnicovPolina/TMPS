import adapters.AccountantAdapter;
import adapters.CashierAdapter;
import adapters.MerchandiserAdapter;
import tool.CashMachine;
import tool.Computer;
import tool.Scanner;
import worker.Accountant;
import worker.Cashier;
import worker.Merchandiser;
import worker.Worker;

public class Facade {
    private Worker accountant;
    private Worker cashier;
    private Worker merchandiser;

    private static String[] names = new String[] {
            "Fred", "Vika", "Luna", "Nichita", "Met", "Shrek", "Nail", "Eva",
            "Gosha", "Kirill", "Sasha", "Fikus", "Calin", "Sara", "Lesha", "Marius",
            "Fedea", "Karlson", "Stasean", "Jou", "Vlad", "Vova", "Edik", "Cringe" };

    public Facade (){
        accountant = new AccountantAdapter(new Accountant(randomName(), new Computer()));
        cashier = new CashierAdapter(new Cashier(randomName(), new CashMachine()));
        merchandiser = new MerchandiserAdapter(new Merchandiser(randomName(),new Scanner()));
    }

    public void accountantWorks(){
        accountant.work();
        accountant.action();
    }

    public void cashierWorks(){
        cashier.work();
        cashier.action();
    }

    public void merchandiserWorks(){
        merchandiser.work();
        merchandiser.action();
    }

    public void cashierNotify(int priority, String message){
        cashier.notifyManager(priority,message);
    }

    public static String randomName() {
        return names[(int) (Math.random()* (names.length-1))];
    }
}
