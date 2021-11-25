package person.workers;

import tool.Computer;

public class Accountant extends Worker {

    public Accountant() {
    }

    public Accountant(String name) {
        super(name);
    }

    public Accountant(String name, Computer tool) {
        super(name, tool);
    }

    @Override
    public void work(){
        System.out.println("Accountant works...");
    }
}
