package it.epicode.esercizio.ExSeven;

import it.epicode.esercizio.modelClasses.Product;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExSeven {
    public static List<Product> readProductsFromDisk(String filepath) throws IOException {
        File file = new File(filepath);
        if (!file.exists()) {
            throw new IOException("File not found at: " + filepath);
        }

        String content = FileUtils.readFileToString(file, "UTF-8");
        List<Product> products = new ArrayList<>();

        if (content.isEmpty()) {
            return products;
        }

        String[] productEntries = content.split("#");
        for (String entry : productEntries) {
            String[] parts = entry.split("@");
            if (parts.length != 3) {
                System.err.println("Invalid product entry: " + entry);
                continue;
            }

            String name = parts[0];
            String category = parts[1];
            double price;

            try {
                price = Double.parseDouble(parts[2]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid price for product: " + entry);
                continue;
            }

            products.add(new Product(name, category, price));
        }

        return products;
    }

    public static void main(String[] args) {
        String filePath = "products.txt";

        try {
            List<Product> products = readProductsFromDisk(filePath);
            System.out.println("Products read from " + filePath + ":");
            products.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
