package it.epicode.esercizio.ExThree;

import it.epicode.esercizio.modelClasses.Product;

import java.util.List;
import java.util.OptionalDouble;

public class ExThree {
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

        OptionalDouble maxPriceOptional = products.stream()
                .mapToDouble(Product::getPrice)
                .max();

        if (maxPriceOptional.isPresent()) {
            double maxPrice = maxPriceOptional.getAsDouble();

            List<Product> mostExpensiveProducts = products.stream()
                    .filter(product -> product.getPrice() == maxPrice)
                    .toList();

            System.out.println("The most expensive product(s) priced at $" + maxPrice + ":");
            mostExpensiveProducts.forEach(System.out::println);
        } else {
            System.out.println("No products found");
        }

    }
}
