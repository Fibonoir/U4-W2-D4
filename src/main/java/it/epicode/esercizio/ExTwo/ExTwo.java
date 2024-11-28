package it.epicode.esercizio.ExTwo;

import it.epicode.esercizio.Main;
import it.epicode.esercizio.modelClasses.Customer;
import it.epicode.esercizio.modelClasses.Order;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExTwo {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Alice");
        Customer customer2 = new Customer(2, "Bob");
        Customer customer3 = new Customer(3, "Charlie");

        List<Order> orders = Arrays.asList(
                new Order(101, customer1, 250.0),
                new Order(102, customer1, 300.0),
                new Order(103, customer2, 150.0),
                new Order(104, customer2, 200.0),
                new Order(105, customer1, 400.0),
                new Order(106, customer3, 100.0)
        );

        Map<Customer, Double> totalSalesByCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomer,
                        Collectors.summingDouble(Order::getAmount)
                ));
        totalSalesByCustomer.forEach((customer, totalSales) -> {
            System.out.println(customer.getName() + " has total sales of: $" + totalSales);
        });
    }
}
