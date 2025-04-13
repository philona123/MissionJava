package Streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ") - " + category;
    }
}

public class ProductStreamDemo {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Laptop", 1200, "Electronics"),
                new Product("Phone", 800, "Electronics"),
                new Product("T-Shirt", 25, "Clothing"),
                new Product("Book", 15, "Books"),
                new Product("Jeans", 50, "Clothing")
        );

        System.out.println("Products above 100");
        products.stream().filter(p -> p.price > 100).forEach(System.out::println);

        System.out.println("Products name in upper case");
        List<String> prodUpper = products.stream().map(p -> p.name.toUpperCase()).collect(Collectors.toList());
        System.out.println(prodUpper);

        System.out.println("Total price of all products");
        double total = products.stream().map(p ->p.price).reduce(0.0, Double::sum);
        System.out.println("Total: "+total);

        System.out.println("Group products by category");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        grouped.forEach((category, items) -> {
            System.out.println(category + ": " + items);
        });

        System.out.println("Partitioned by expensive");
        Map<Boolean, List<Product>> partitioned = products.stream()
                .collect(Collectors.partitioningBy(p -> p.price > 100));
        partitioned.forEach((isExpensive, items) -> {
            System.out.println(isExpensive ? "Expensive:" : "Affordable:");
            items.forEach(System.out::println);
        });

        System.out.println("Total Price (Parallel):");
        double parallelTotal = products.parallelStream()
                .map(p -> p.price)
                .reduce(0.0, Double::sum);
        System.out.println("$" + parallelTotal);
    }
}
