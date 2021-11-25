# _Software Design Techniques and Mechanisms_
## Author: _Plotnicov Polina, FAF-193_

## Global table of contents:

* [Creational Design Patterns](#laboratory-work-1)
* [Structural Design Patterns](#laboratory-work-2)

# Laboratory work №1
## Topic: _Creational Design Patterns_

---
## Table of contents:
* [Introduction](#_cdp-introduction_)
* [Implementation](#_cdp-implementation_)
* [Results](#_cdp-results_)
---

## _CDP Introduction_

In this laboratory work were been implemented `Creational Design Patterns`. What is the purpose of such patterns?
>These patterns are responsible for the convenient and safe creation of new objects or even entire families of objects

* ### 1) Builder

>The Builder Pattern separates the construction of a complex object from its representation so that different representations can result from the same design process.
![Builder](https://refactoring.guru/images/patterns/diagrams/builder/solution1.png)

* ### 2) Abstract factory

>An abstract factory is a generative design pattern that allows you to create families of related objects without being tied to the specific classes of objects that you create.
![Abs_Factory](https://refactoring.guru/images/patterns/diagrams/abstract-factory/solution2.png)

* ### 3) Factory

>A factory method is an ancestral design pattern that defines a common interface for creating objects in a superclass, allowing subclasses to change the type of objects they create.
![Factory](https://refactoring.guru/images/patterns/diagrams/factory-method/solution1.png)

* ### 4) Singleton

>A singleton is a generative design pattern that ensures that a class has only one instance and provides a global access point to it.
![Singleton](https://user-images.githubusercontent.com/6358475/135911578-1f659174-d619-415f-b2cd-3d11e29d70ea.png)

---

## _CDP Implementation_

There was implemented the simulation of the `Store` to show how design patterns work. The main idea was that there will be the `Manager`, the only one, and he can manage some money and buy another equipment like `Fridge` or `Cupboard` (or Shelf, if you want) to store `Products`.

### `Builder`:
There is a common Interface named `Product` and different classes implement it: `Drinks`, `Seafood`, `Sweets`, etc.
The mandatory attributes to be in an instance of `Product` are Name, Expiration Date and Price, while the id of equipment where product is placed is optional.
Also, all mandatory attributes are randomly generated in `Factory`, which are discussed further.

The example of `Builder` in BakeryProducts class:
```java
    static class Builder{
        private final String name;
        private final Date expirationDate;
        private final float price;
        private int idOfSpace = -1;

        public Builder(String name, Date expirationDate, float price) {
            this.name = name;
            this.expirationDate = expirationDate;
            this.price = price;
        }

        public Builder setIdOfSpace(int idOfSpace){
            this.idOfSpace = idOfSpace;
            return this;
        }

        public BakeryProducts build(){
            return new BakeryProducts(this);
        }
    }
```

### `Factory`:
There is Interface named `Factory` and it is implemented in `Fridge` and `Cupboard` classes, which are Factories, and they create new objects:
`Fridge` can create `Drinks`, `Seafood` and `Milk Products`,
`Cupboard` cam create `Sweets`, `Porridge` and `Bakery Products`

For example, main part of `Cupboard` class is:
```java
    private Product create(String type){
        switch (type){
            case "Sweets":{
                Product sweets = new Sweets.Builder(randomName(),randomDate(),randomPrice()).setIdOfSpace(id).build();
                products.add(sweets);
                capacity--;
                return  sweets;
            }
            case "Porridge":{
                Product porridge = new Porridge.Builder(randomName(),randomDate(),randomPrice()).setIdOfSpace(id).build();
                products.add(porridge);
                capacity--;
                return  porridge;
            }
            case "BakeryProducts":
            {
                Product bakeryProducts = new BakeryProducts.Builder(randomName(),randomDate(),randomPrice()).setIdOfSpace(id).build();
                products.add(bakeryProducts);
                capacity--;
                return  bakeryProducts;
            }
            default: return null;
        }
    }
```

### `Singleton`:

The `Manager` was implemented as `Singleton`, this object can be created only one time:
```java
    private String name;
    private static Manager instance;

    private Manager(String name){
        this.name = name;
    }

    public static  Manager getInstance(String context){
        if(instance == null){
            instance = new Manager(context);
        }
        return instance;
    }
```

### `Abstract factory`:

Also, the `Manager` is Abstract factory, it can create (or buy, if you want) more equipment like `Fridge` or `Cupboard`

The example code of `Manager`:

```java
    public Factory createFactory (String typeOfFactory){
        switch (typeOfFactory){
            case "Fridge": return  new Fridge();
            case "Cupboard": return new Cupboard();
            default: return null;
        }
```

## _CDP Results_

- ### Cupboard factory partial code
![image](https://user-images.githubusercontent.com/6358475/135914833-ebeca66e-f241-4e0f-98a6-4d04f0b4368e.png)

- ### Abstract factory full code
![image](https://user-images.githubusercontent.com/6358475/135914956-bb6ccaec-5e69-411d-b68d-2a3c94ae1f10.png)

- ### Seafood and builder partial code 
![image](https://user-images.githubusercontent.com/6358475/135915112-6f4c9e5a-38cd-441d-9887-38dd35a05871.png)

- ### Factory interface code
![image](https://user-images.githubusercontent.com/6358475/135915228-d3fa93e9-096f-4a4a-9318-eee80151ace0.png)

- ### The output
![image](https://user-images.githubusercontent.com/6358475/135915723-042cf3a9-bce6-4e47-9ad3-07b881c0ac30.png)

# Laboratory work №2
## Topic: _Structural Design Patterns_

---
## Table of contents:
* [Introduction](#_sdp-introduction_)
* [Implementation](#_sdp-implementation_)
* [Results](#_sdp-results_)
---

## _SDP: Introduction_

In this laboratory work were been implemented `Structural Design Patterns`. What is the purpose of such patterns?
>Scructural Design Patterns are responsible for building maintainable class hierarchies

* ### 1) Bridge

>The Bridge is a structural design pattern that separates one or more classes into two separate hierarchies - abstraction and implementation, allowing them to be changed independently of each other.

>![Bridge](https://refactoring.guru/images/patterns/diagrams/bridge/example-en.png)

* ### 2) Adapter

>The Adapter is a structural design pattern that allows objects with incompatible interfaces to work together.
![Adapter](https://refactoring.guru/images/patterns/diagrams/adapter/example.png)

* ### 3) Facade

>A Facade is a structural design pattern that provides a simple interface to a complex class system, library, or framework.
![Facade](https://refactoring.guru/images/patterns/diagrams/factory-method/solution1.png)

---

## _SDP: Implementation_

The main idea was that there will be three adapters for every worker. (Adapter)

There are three categories of workers such as:
- Accountant
- Cashier
- Merchandiser

Also, each category of workers has its own basic tool they need to work with. (Bridge)

And, in addition, there will be a simple interface for user easier interaction. (Facade)

### `Bridge`:

There is a common Interface named 'Tool' and three classes implement it: `CashMachine`, `Computer` and `Scanner`.
Every worker has its own tool he can use while working, and `Tool` and `Worker` subclasses can be extended independently.

The example of `Bridge` in Worker class:
```java
public abstract class Worker {

    private Tool tool;

    //...

    public Worker(String name, Tool tool) {
        this.name = name;
        this.tool = tool;
    }

    public void action() {
        System.out.print("From " + name + ": ");
        this.tool.action();
    }

    public abstract void work();
}
```

### `Adapter`:

There are three adapters for Workers:
- `AccountantAdapter`
- `CashierAdapter`
- `MerchandiserAdapter`

For example, the `AccountantAdapter` looks like this:
```java
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
```

### `Facade`:

The `Facade` is a useful tool for easier interaction with the classes in this project.

For example, some code of the `Facade`:
```java
public class Facade {
    private Worker accountant;
    private Worker cashier;
    private Worker merchandiser;

    //...

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

    public static String randomName() {
        return names[(int) (Math.random()* (names.length-1))];
    }
}
```


## _SDP: Results_

- ### Facade full code
![image](https://user-images.githubusercontent.com/6358475/135914833-ebeca66e-f241-4e0f-98a6-4d04f0b4368e.png)

- ### CashierAdapter full code
![image](https://user-images.githubusercontent.com/6358475/135914956-bb6ccaec-5e69-411d-b68d-2a3c94ae1f10.png)

- ### Worker full code 
![image](https://user-images.githubusercontent.com/6358475/135915112-6f4c9e5a-38cd-441d-9887-38dd35a05871.png)

- ### Scanner full code
![image](https://user-images.githubusercontent.com/6358475/135915228-d3fa93e9-096f-4a4a-9318-eee80151ace0.png)

- ### The output
![image](https://user-images.githubusercontent.com/6358475/135915723-042cf3a9-bce6-4e47-9ad3-07b881c0ac30.png)
