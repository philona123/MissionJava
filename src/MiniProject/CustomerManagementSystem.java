package MiniProject;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

interface MessageService {
    void sendMessage(String message);

    // Default method to provide a common implementation
    default void sendWelcomeMessage(String customerName) {
        sendMessage("Welcome, " + customerName + "!");
    }

    // Static method for sending bulk notifications
    static void sendBulkNotification(List<String> customers, String message) {
        customers.forEach(customer -> System.out.println("Sent to " + customer + ": " + message));
    }
}

class Customer {
    String name;
    String email;
    LocalDate registrationDate;
    Optional<String> phoneNumber;

    Customer(String name, String email, LocalDate registrationDate, Optional<String> phoneNumber) {
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Optional<String> getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}

public class CustomerManagementSystem {
    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer("Philona", "philona@example.com", LocalDate.of(2020, 5, 15), Optional.of("1234567890")),
                new Customer("Alice", "alice@example.com", LocalDate.of(2021, 3, 20), Optional.empty()),
                new Customer("Bob", "bob@example.com", LocalDate.of(2019, 8, 1), Optional.of("0987654321"))
        );
//        customers.forEach(System.out::println);

        // Send welcome messages using default method in the interface
        MessageService messageService = message -> System.out.println("Message: " + message);
        customers.forEach(customer -> messageService.sendWelcomeMessage(customer.getName()));


        // Use Optional to handle customers with no phone number
        customers.forEach(customer -> customer.getPhoneNumber()
                .ifPresentOrElse(
                        phone -> System.out.println(customer.getName() + "'s phone: " + phone),
                        () -> System.out.println(customer.getName() + " has no phone number")
                ));


        // Stream API: Get customers who registered after 2020
        System.out.println("\nCustomers who registered after 2020:");
        customers.stream()
                .filter(c -> c.getRegistrationDate().isAfter(LocalDate.of(2020, 1, 1)))
                .forEach(c -> System.out.println(c.getName()));


        // Group customers by registration year using Collectors.groupingBy
        System.out.println("\nCustomers grouped by registration year:");
        Map<Integer, List<Customer>> groupedByYear = customers.stream()
                .collect(Collectors.groupingBy(c -> c.getRegistrationDate().getYear()));
        groupedByYear.forEach((year, customerList) -> {
            System.out.println(year + ": " + customerList.size() + " customers");
        });

        // Collect customer emails into a single string using Collectors.joining
        String emailList = customers.stream()
                .map(Customer::getEmail)
                .collect(Collectors.joining(", "));
        System.out.println("\nCustomer Emails: " + emailList);


        double avgYear = customers.stream()
                .collect(Collectors.averagingInt(c -> c.getRegistrationDate().getYear()));
        System.out.println("\nAverage Registration Year: " + avgYear);


        // Partitioning customers into old (before 2021) and new (after 2020) using Collectors.partitioningBy
        Map<Boolean, List<Customer>> partitioned = customers.stream()
                .collect(Collectors.partitioningBy(c -> c.getRegistrationDate().isBefore(LocalDate.of(2021, 1, 1))));
        System.out.println("\nOld customers (before 2021):");
        partitioned.get(true).forEach(c -> System.out.println(c.getName()));
        System.out.println("\nNew customers (after 2020):");
        partitioned.get(false).forEach(c -> System.out.println(c.getName()));


        // Static method in MessageService to send bulk notifications
        System.out.println("\nSending bulk notification...");
        MessageService.sendBulkNotification(
                customers.stream().map(Customer::getName).collect(Collectors.toList()),
                "Important update!"
        );
    }
}
