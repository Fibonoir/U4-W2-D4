package it.epicode.esercizio.ExFive;

import it.epicode.esercizio.Main;
import it.epicode.esercizio.modelClasses.Order;
import it.epicode.esercizio.modelClasses.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExFive {
    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("Caffè", "Alimentari", 3.5),
                new Product("Latte", "Alimentari", 1.5),
                new Product("Pane", "Alimentari", 2.0),
                new Product("Pasta", "Alimentari", 1.0),
                new Product("Olio", "Alimentari", 5.0),
                new Product("Detersivo", "Casa", 3.0),
                new Product("Shampoo", "Casa", 2.5),
                new Product("Balsamo", "Casa", 2.5),
                new Product("Sapone", "Casa", 1.0),
                new Product("Dentifricio", "Casa", 2.0),
                new Product("Caffè", "Alimentari", 5.0)
        );

        Map<String, Double> totalAmountByCategory = products.stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.summingDouble(Product::getPrice)
                        )
                );

        totalAmountByCategory.forEach((category, totalAmount) -> {
            System.out.println("Total amount of products in category " + category + ": $" + totalAmount);
        });
    }
}
