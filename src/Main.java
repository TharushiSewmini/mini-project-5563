import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> memorySizes = List.of(100, 200, 300, 400, 500, 600);
        Allocator allocator = new Allocator(memorySizes);

        System.out.println("Initial Memory Blocks:");
        allocator.displayMemory();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Allocate Memory");
            System.out.println("2. Deallocate Memory");
            System.out.println("3. Display Memory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Allocate memory
                    System.out.print("Enter the size of the process to allocate: ");
                    int processSize = scanner.nextInt();
                    int blockIndex = allocator.allocate(processSize);
                    if (blockIndex != -1) {
                        System.out.println("Process allocated to block " + blockIndex + ".");
                    } else {
                        System.out.println("No suitable block found for the process.");
                    }
                    break;
                case 2: // Deallocate memory
                    System.out.print("Enter the index of the block to deallocate: ");
                    int blockToDeallocate = scanner.nextInt();
                    allocator.dealocate(blockToDeallocate);
                    System.out.println("Block " + blockToDeallocate + " deallocated.");
                    break;
                case 3: // Display memory
                    allocator.displayMemory();
                    break;
                case 4: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}