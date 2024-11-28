package it.epicode.esercizio.ExFour;

import it.epicode.esercizio.modelClasses.Customer;
import it.epicode.esercizio.modelClasses.Order;

import java.util.List;
import java.util.OptionalDouble;

public class ExFour {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Alice");
        Customer customer2 = new Customer(2, "Bob");

        List<Order> orders = List.of(
                new Order(101, customer1, 250.0),
                new Order(102, customer1, 300.0),
                new Order(103, customer2, 150.0),
                new Order(104, customer2, 200.0),
                new Order(105, customer1, 400.0)
        );

        OptionalDouble averageOrderValueOpt = orders.stream()
                .mapToDouble(Order::getAmount)
                .average();

        if (averageOrderValueOpt.isPresent()) {
            double averageOrderValue = averageOrderValueOpt.getAsDouble();
            System.out.println("The average order value is: $" + averageOrderValue);
        } else {
            System.out.println("No orders found");
        }
    }
}
