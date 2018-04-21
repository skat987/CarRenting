/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrenting;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eleve2
 */
public class CarRenting {

    private static Scanner scan = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int option = -1;
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>(); // liste des véhicules de la société
        ArrayList<Customer> customers = new ArrayList<Customer>(); // Liste des clients de la société
        ArrayList<RentalForm> rentalForms = new ArrayList<RentalForm>(); // Liste des locations
        
        String[] noms = new String[]{"CHANSAUD", "HAUATA", "LYSAO", "MANA", "MAUI", "TAIE", "TARIHAA", "TKT", "TEPA", "TUHITI"};
        String[] prenoms = new String[]{"Gaby", "Sabrina", "Miron", "Kévin", "Apetahi", "Parea", "Teraitea", "Cédric", "Vaiarii", "Chriqtopher"};
        int[] ages = new int[]{17, 17, 17, 17, 17, 17, 17, 17, 17, 17};
        int[] permis = new int[]{11111, 22222, 33333, 44444, 55555, 66666, 77777, 88888, 99999, 14578};
        
        for(int i = 0; i < noms.length; i++) {
            customers.add(new Customer(prenoms[i], noms[i], ages[i], permis[i]));
        }
    
        while(option != 0) {
            displayMainMenu();
            option = scan.nextInt();
            
            switch(option) {
                case 1:
                    Vehicle v = addNewCar();
                    vehicles.add(v);
                    break;
                case 2:
                    Customer c = addNewCustomer();
                    customers.add(c);
                    break;
                case 3:
                    RentalForm r = addNewRent(customers, vehicles);
                    r.setRentalCode(rentalForms.size() + 1);
                    rentalForms.add(r);
                    displayNewRent(r);
                    break;
                case 4:
                    payRent(rentalForms);
                    break;
                default:
                    if(option == 0) {
                        print("****************** Aurevoir *******************");
                    } else {
                        print("Choix incorrect.\n Veuillez sélectionner à nouveau une option.");                        
                    }
            }
        }
    }
    
    private static void print(Object o) {
        System.out.println(o);
    }
    
    private static void displayMainMenu() {
        print("\n*********************************");
        print("Sélectionner une option \n\n\t 1. Acquérir voiture \n\t 2. Enregistrer nouveau client \n\t 3. Louer véhicule \n\t 4. Rendre véhicule \n\t 0. Quitter");
        System.out.print("Votre choix: ");
    }
    
    private static void displayDistinctType() {
        print("\n*********************************");
        print("Sélectionner le type de véhicule: \n\n\t 1. Citadine \n\t 2. Berline \n\t 3. SUV");
        System.out.print("Votre choix: ");
    }
    
    private static void displayCustomers(ArrayList<Customer> items) {
        int index = 0;
        
        print("\n*********************************");
        print("Sélectionner un client: \n");
        
        for (Customer item : items) {
            index++;
            print("\t " + index + ". " + item.getLastName() + " " + item.getFirstName());
        }
        
        System.out.print("Votre choix: ");
    }
    
    private static void displayVehiclesByType(ArrayList<Vehicle> items, String type) {
        int index = 0;
        
        print("\n*********************************");
        print("Sélectionner un(e) " + type + ": \n");
        
        for (Vehicle item : items) {
            if (item.getType() == type && item.isAvailable()) {
                index++;
                print("\t " + index + ". " + item.getImmatriculation() + " - " + item.getPassengerQty() + " personnes - " + item.getKm() + " - " + item.getRentalCost() + " XPF/Jour");
            }
        }
        
        System.out.print("Votre choix: ");
    }
    
    private static Vehicle addNewCar() {
        Vehicle newCar = new Vehicle();
        
        displayDistinctType();
        int option = scan.nextInt();
        
        switch(option) {
            case 1:
                newCar = new CityDweller();
                break;
            case 2:
                newCar = new Sedan();
                break;
            case 3:
                newCar = new Suv();
                break;
            default:
                print("Cette option n'existe pas.");
        }
        
        initializeNewCar(newCar);
        
        return newCar;
    }
    
    private static void initializeNewCar(Vehicle newVehicle) {
        System.out.print("\nImmatriculation du véhicule: ");
        newVehicle.immatriculation = scan.nextInt();
        System.out.print("\nNombre de passagers: ");
        newVehicle.passengerQty = scan.nextInt();
        System.out.print("\nTarif par jour: ");
        newVehicle.costPerDay = scan.nextInt();
    }
    
    private static Customer addNewCustomer() {
        print("Ajouter un nouveau client: ");
        System.out.print("\nNom: ");
        String lastName = scan.next();
        System.out.print("Prénom: ");
        String firstName = scan.next();
        System.out.print("Age: ");
        int age = scan.nextInt();
        System.out.print("N° Permis: ");
        int license = scan.nextInt();
        
        return new Customer(firstName, lastName, age, license);
    }
    
    private static RentalForm addNewRent(ArrayList<Customer> customers, ArrayList<Vehicle> vehicles) { 
        int idType = 0;
        String type = "";
        
        displayCustomers(customers);
        int idCustomer = scan.nextInt(); // -1
        
        do {
            displayDistinctType();
            idType = scan.nextInt();

            switch(idType) {
                case 1:
                    type = "Citadine";
                    break;
                case 2:
                    type = "Berline";
                    break;
                case 3:
                    type = "SUV";
                    break;
                default:
                    print("Choix incorrect. \nVeuillez sélectionner à nouveau un type.");
                    idType = 0;
            }
        } while(idType == 0);
        
        displayVehiclesByType(vehicles, type);
        int id = scan.nextInt();
        int idVehicle = retrieveVehicle(vehicles, type, id);
        
        System.out.print("\nDurée location (en jour): ");
        int period = scan.nextInt();
        
        Vehicle vehicle = vehicles.get(idVehicle);
        vehicle.setAvailable(false);
        Customer customer = customers.get(idCustomer - 1);
        
        return new RentalForm(vehicle, customer, period);
    }
    
    private static int retrieveVehicle(ArrayList<Vehicle> items, String type, int id) {
        int index = 0;
        
        for (Vehicle item : items) {
            if (item.getType() == type && item.isAvailable()) {
                index++;
                
                if (index == id) {
                    break;
                }
            }
        }
        
        return (index - 1);
    }
    
    private static void displayNewRent(RentalForm r) {
        print("\n**************** Nouvel enregistrement *****************");
        print("Location n°: " + r.getRentalCode() + "\n\t>>> Voiture immatriculée " + r.getVehicle().getImmatriculation() + " de type " + r.getVehicle().getType() + "\n\t>>> louée par " + r.getCustomer().getLastName() + " " + r.getCustomer().getFirstName());
        print("Coût estimée de la location: " + r.getRentalCost());
    }
    
    private static void payRent(ArrayList<RentalForm> rentalForms) {
        print("\n************* Retour location ********************");
        System.out.print("\nEntrer le n° de location: ");
        int idRent = scan.nextInt();
        
        RentalForm r = rentalForms.get(idRent - 1);
        
        print("Merci, le montant a réglé est de: " + r.getRentalCost());
        
        r.getVehicle().setAvailable(true);
        r.getVehicle().setKm(50 * r.getPeriod());
    }
    
}
