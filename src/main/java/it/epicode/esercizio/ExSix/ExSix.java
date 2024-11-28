package it.epicode.esercizio.ExSix;

import it.epicode.esercizio.modelClasses.Product;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExSix {

    public static void SaveProductOnDisk(List<Product> products, String filePath) throws IOException {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            sb.append(product.getName())
                    .append("@").
                    append(product.getCategory()).
                    append("@").
                    append(product.getPrice());
                    if (i < products.size() - 1) {
                        sb.append("#");
                    }
        }

        File file = new File(filePath);
        FileUtils.writeStringToFile(file, sb.toString(), "UTF-8");
    }

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
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

        String filePath = "products.txt";

        try {
            SaveProductOnDisk(products, filePath);
            System.out.println("Products saved to " + filePath);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
