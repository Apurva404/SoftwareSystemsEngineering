package com.sjsu.softwareengineering.test;

import com.sjsu.softwareengineering.payment.PaymentMode;
import com.sjsu.softwareengineering.payment.PaymentProcessor;
import com.sjsu.softwareengineering.notifiers.PlacedOrderProcessor;
import com.sjsu.softwareengineering.order.Bill;
import com.sjsu.softwareengineering.order.Order;
import com.sjsu.softwareengineering.people.chef.AppetizerChef;
import com.sjsu.softwareengineering.people.chef.Chef;
import com.sjsu.softwareengineering.people.Customer;
import com.sjsu.softwareengineering.people.Owner;
import com.sjsu.softwareengineering.people.Waiter;
import com.sjsu.softwareengineering.people.chef.DessertChef;
import com.sjsu.softwareengineering.people.chef.DrinkChef;
import com.sjsu.softwareengineering.people.chef.EntreeChef;
import com.sjsu.softwareengineering.menu.Menu;
import com.sjsu.softwareengineering.restaurant.Restaurant;
import com.sjsu.softwareengineering.restaurant.Table;

public class TestBench {

    public static void main(String args[]){
        //----------------------STEP 1 (Setting Up the Restaurant)-----------------------------
        System.out.println("----------------------STEP 1 (Setting Up the Restaurant)-----------------------------");
        // create the restaurant
        Restaurant restaurant = Restaurant.getInstance(); // singleton class

        System.out.println();
        System.out.println();

        //creating a single instance of owner
        Owner owner = Owner.getInstance("Bob");
        owner.setUsername("bob123");
        owner.setPassword("password");
        owner.setEmailId("bob@smartEat.com");
        owner.setContactNo("+165678901");
        restaurant.assignOwner(owner);

        System.out.println("Owner of Restaurant: " + Restaurant.getInstance().getOwner().getName() + " (" + Restaurant.getInstance().getOwner().getEmailId() +")");
        System.out.println();
        System.out.println();

        //Setting up restaurant resources
        // Adding chefs
        Chef chef1 = new DessertChef("Tom", "Chef#1");
        chef1.setUsername("Tom123");
        chef1.setPassword("1234");
        chef1.setEmailId("tom@smartEat.com");
        chef1.setContactNo("+123456789");

        Chef chef2 = new DrinkChef("Harry", "Chef#2");
        chef2.setUsername("harry123");
        chef2.setPassword("6789");
        chef2.setEmailId("harry@smartEat.com");
        chef2.setContactNo("+123456798");
        
        Chef chef3 = new AppetizerChef("Ronny", "Chef#3");
        chef3.setUsername("ronny123");
        chef3.setPassword("7890");
        chef3.setEmailId("ronny@smartEat.com");
        chef3.setContactNo("+123456798");
        
        Chef chef4 = new EntreeChef("Ester", "Chef#4");
        chef4.setUsername("ester123");
        chef4.setPassword("5670");
        chef4.setEmailId("ester@smartEat.com");
        chef4.setContactNo("+123456798");

        restaurant.addChef(chef1);
        restaurant.addChef(chef2);
        restaurant.addChef(chef3);
        restaurant.addChef(chef4);

        // Adding waiters
        Waiter waiter1 = new Waiter("John", "Waiter#1");
        waiter1.setUsername("john123");
        waiter1.setPassword("5432");
        waiter1.setEmailId("jhon@smartEat.com");
        waiter1.setContactNo("567890123");

        Waiter waiter2 = new Waiter("Julie", "Waiter#2");
        waiter2.setUsername("julie123");
        waiter2.setPassword("5342");
        waiter2.setEmailId("julie@smartEat.com");
        waiter2.setContactNo("567890132");
        
        Waiter waiter3 = new Waiter("Sam", "Waiter#3");
        waiter3.setUsername("sam123");
        waiter3.setPassword("2453");
        waiter3.setEmailId("sam@smartEat.com");
        waiter3.setContactNo("567890321");
        
        Waiter waiter4 = new Waiter("Rick", "Waiter#4");
        waiter4.setUsername("rick123");
        waiter4.setPassword("7891");
        waiter4.setEmailId("rick@smartEat.com");
        waiter4.setContactNo("567893210");

        restaurant.addWaiter(waiter1);
        restaurant.addWaiter(waiter2);
        restaurant.addWaiter(waiter3);
        restaurant.addWaiter(waiter4);


        // Adding tables
        Table table1 = new Table("Table#1", 2);
        Table table2 = new Table("Table#2", 5);
        Table table3 = new Table("Table#3", 5);
        Table table4 = new Table("Table#4", 10);
        restaurant.addTable(table1);
        restaurant.addTable(table2);
        restaurant.addTable(table3);
        restaurant.addTable(table4);

        //--------------------------------------------------------------------------------------------
        //----------------------STEP 2 (Welcoming Customer in Restaurant)-----------------------------
        System.out.println("----------------------STEP 2 (Welcoming Customer in Restaurant)-----------------------------");
        //creating customers
        Customer customer1 = new Customer("annie");
        customer1.setEmailId("annie@gmail.com");
        customer1.setContactNo("98765432");
        customer1.setPartySize(3);
        customer1.setPaymentMode(PaymentMode.Cash);

        Customer customer2 = new Customer("marie");
        customer2.setEmailId("marie@gmail.com");
        customer2.setContactNo("98765423");
        customer2.setPartySize(2);
        customer2.setPaymentMode(PaymentMode.CreditCard);
        
        Customer customer3 = new Customer("anna");
        customer3.setEmailId("anna@gmail.com");
        customer3.setContactNo("98765412");
        customer3.setPartySize(9);
        customer3.setPaymentMode(PaymentMode.DebitCard);
        
        restaurant.addCustomer(customer1);
        restaurant.addCustomer(customer2);
        restaurant.addCustomer(customer3);

        
        // Customers walks into the restaurant, waiter finds them a table
        Table selectedTable = waiter1.seatCustomer(customer1);
        
        // menu is shown to customer
        Restaurant.getInstance().showMenu();
        
        System.out.println();
        System.out.println();


        //--------------------------------------------------------------------------------------------
        //----------------------STEP 3(Customer Places the order)-----------------------------
        System.out.println("----------------------STEP 3(Customer Places the order)-----------------------------");
        // customer creates an order using the app
        Order order = new Order("Order#1");
        order.addItemToOrder(Menu.getDessertByName("Tiramisu"));
        // repeating an item
        order.addItemToOrder(Menu.getDessertByName("Tiramisu"));
        order.addItemToOrder(Menu.getDessertByName("Walnut Brownie"));
        // removing an item from menu
        order.removeItemFromOrder(Menu.getDessertByName("Walnut Brownie"));
        order.addItemToOrder(Menu.getEntreeByName("Mushroom Ravioli"));
        order.addItemToOrder(Menu.getAppetizerByName("Chicken Nuggets"));
        order.addItemToOrder(Menu.getDrinkByName("Mojito"));

        // customer finalizes the order
        customer1.setAssociatedOrders(order);
        // the app places the order on their behalf
        //the waiters are notified by the processor
        // the concerned waiter process the order and places item-wise order to the kitchen
        // the chefs are notified for each item request
        // concerned chef prepares the dish and notifies all waiters
        // concerned waiter picks up the dish, serves them to the table and keeps track of progress of the order
        // once all items in the order is served, waiter marks the order as complete and a bill can be generated for the same
        PlacedOrderProcessor.getInstance().placeOrder(selectedTable.getTableId(), order);
        

        System.out.println();
        System.out.println();

        //--------------------------------------------------------------------------------------------
        //----------------------STEP 4(Waiter Generates Bill after the order is complete)-----------------------------
        System.out.println("----------------------STEP 4(Waiter Generates Bill after the order is complete)-------------------");
        // bill generation
        Bill bill = waiter1.generateBillForTableId(selectedTable.getTableId());
        System.out.println("-----Bill------");
        System.out.println(bill.listItemizedBill());
        System.out.println("Total = $" + bill.computeTotalBill());
        System.out.println("---------------");
        
        System.out.println();
        System.out.println();

        //--------------------------------------------------------------------------------------------
        //----------------------STEP 5(Customer Pays the bill using different options(Cash,Credit Card or Debit Card)-----------------------------
        System.out.println("----------------------STEP 5(Customer Pays the bill using different options(Cash,Credit Card or DebiCard)-------------");
        // Process payment from customer
        //Pay the Bill
        PaymentProcessor paySystem = new PaymentProcessor();
        paySystem.processPayment(bill, customer1.getPaymentMode());


        System.out.println();
        System.out.println();

        //--------------------------------------------------------------------------------------------
        //----------------------STEP 6(Re-setting the Restaurant after customer leaves)-----------------------------
        // Once the customer leaves, empty the table and clean it
        System.out.println("----------------------STEP 6(Re-setting the Restaurant after customer leaves)------------------------");
        selectedTable.emptyTable();
        selectedTable.cleanTable();
        waiter1.disassociateTable(selectedTable);

    }
}


