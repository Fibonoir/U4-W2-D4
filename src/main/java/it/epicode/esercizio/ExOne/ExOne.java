package it.epicode.esercizio.ExOne;

import it.epicode.esercizio.modelClasses.Customer;
import it.epicode.esercizio.modelClasses.Order;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExOne {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Alice");
        Customer customer2 = new Customer(2, "Bob");

        List<Order> orders = Arrays.asList(
                new Order(101, customer1, 250.0),
                new Order(102, customer1, 300.0),
                new Order(103, customer2, 150.0),
                new Order(104, customer2, 200.0),
                new Order(105, customer1, 400.0)
        );

        Map<Customer, List<Order>> ordersByCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));

        ordersByCustomer.forEach((customer, orderList) -> {
            System.out.println(customer.getName() + " has the following orders:");
            orderList.forEach(System.out::println);
            System.out.println();
        });

    }
}
