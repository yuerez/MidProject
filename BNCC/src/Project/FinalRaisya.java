package Project;
import java.util.*;

public class FinalRaisya {
    static Scanner scan = new Scanner(System.in);
    static List<Kendaraan> kendaraanList = new ArrayList<>();

    public static void main(String[] args) {
        int pilih = 0;
        do {
            System.out.println("1. Input");
            System.out.println("2. View");
            System.out.println("3. Exit");
            System.out.print("Choose menu: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    inputKendaraan();
                    break;
                case 2:
                    viewKendaraan();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (pilih != 3);
    }

    static void inputKendaraan() {
        System.out.print("Input type [Car | Motorcycle]: ");
        String tipe = scan.nextLine();

        System.out.print("Enter brand: ");
        String brand = scan.nextLine();

        System.out.print("Enter name: ");
        String name = scan.nextLine();

        System.out.print("Enter license number (format: A 1234 ABC): ");
        String licenseNumber = scan.nextLine();

        System.out.print("Enter top speed (100-250): ");
        int topSpeed = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter gas capacity (30-60): ");
        int gasCap = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter number of wheels: ");
        int wheels = scan.nextInt();
        scan.nextLine();

        Kendaraan kendaraan;
        if (tipe.equalsIgnoreCase("Car")) {
            System.out.print("Enter car type (SUV/Supercar/Minivan): ");
            String carType = scan.nextLine();

            System.out.print("Enter number of entertainment systems: ");
            int entertainmentSystems = scan.nextInt();
            scan.nextLine();

            kendaraan = new Car(brand, name, licenseNumber, topSpeed, gasCap, wheels, carType, entertainmentSystems);
        } else if (tipe.equalsIgnoreCase("Motorcycle")) {
            System.out.print("Enter motorcycle type (Automatic/Manual): ");
            String motorcycleType = scan.nextLine();

            System.out.print("Enter number of helmets: ");
            int helmets = scan.nextInt();
            scan.nextLine();

            kendaraan = new Motorcycle(brand, name, licenseNumber, topSpeed, gasCap, wheels, motorcycleType, helmets);
        } else {
            System.out.println("Invalid type. Please input Car or Motorcycle.");
            return;
        }

        kendaraanList.add(kendaraan);
        System.out.println("Vehicle added successfully!");
    }

    static void viewKendaraan() {
        if (kendaraanList.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }

        System.out.println("List of Vehicles:");
        for (int i = 0; i < kendaraanList.size(); i++) {
            System.out.println((i + 1) + ". " + kendaraanList.get(i).toString());
        }

        System.out.print("Enter the number of the vehicle to view details: ");
        int choice = scan.nextInt();
        scan.nextLine();

        if (choice >= 1 && choice <= kendaraanList.size()) {
            Kendaraan chosenVehicle = kendaraanList.get(choice - 1);
            chosenVehicle.viewDetails();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}

abstract class Kendaraan {
    protected String brand;
    protected String name;
    protected String licenseNumber;
    protected int topSpeed;
    protected int gasCap;
    protected int wheels;

    public Kendaraan(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheels) {
        this.brand = brand;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.topSpeed = topSpeed;
        this.gasCap = gasCap;
        this.wheels = wheels;
    }

    abstract void viewDetails();
}

class Car extends Kendaraan {
    private String carType;
    private int entertainmentSystems;

    public Car(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheels, String carType, int entertainmentSystems) {
        super(brand, name, licenseNumber, topSpeed, gasCap, wheels);
        this.carType = carType;
        this.entertainmentSystems = entertainmentSystems;
    }

    @Override
    void viewDetails() {
        System.out.println("Car Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Name: " + name);
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Top Speed: " + topSpeed);
        System.out.println("Gas Capacity: " + gasCap);
        System.out.println("Number of Wheels: " + wheels);
        System.out.println("Car Type: " + carType);
        System.out.println("Entertainment Systems: " + entertainmentSystems);
    }
}

class Motorcycle extends Kendaraan {
    private String motorcycleType;
    private int helmets;

    public Motorcycle(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheels, String motorcycleType, int helmets) {
        super(brand, name, licenseNumber, topSpeed, gasCap, wheels);
        this.motorcycleType = motorcycleType;
        this.helmets = helmets;
    }

    @Override
    void viewDetails() {
        System.out.println("Motorcycle Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Name: " + name);
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Top Speed: " + topSpeed);
        System.out.println("Gas Capacity: " + gasCap);
        System.out.println("Number of Wheels: " + wheels);
        System.out.println("Motorcycle Type: " + motorcycleType);
        System.out.println("Number of Helmets: " + helmets);
    }
}
