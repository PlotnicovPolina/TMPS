package person.workers;

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
}