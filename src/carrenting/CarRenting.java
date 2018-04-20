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
                    //
                    break;
                case 4:
                    //
                    break;
                default:
                    print("Choix incorrect.\n Veuillez sélectionner à nouveau une option.");
            }
        }
    }
    
    private static void print(Object o) {
        System.out.println(o);
    }
    
    private static void displayMainMenu() {
        print("*********************************");
        print("Sélectionner une option \n\t 1. Acquérir voiture \n\t 2. Enregistrer nouveau client \n\t 3. Louer véhicule \n\t 4. Rendre véhicule \n\t 0. Quitter");
        System.out.print("Votre choix: ");
    }
    
    private static void displayDistinctType() {
        print("*********************************");
        print("Sélectionner le type de véhicule: \n\t 1. Citadine \n\t 2. Berline \n\t 3. SUV");
        System.out.print("Votre choix: ");
    }
    
    private static void displayCustomers(ArrayList<Customer> items) {
        int index = 0;
        
        print("*********************************");
        
        for (Customer item : items) {
            index++;
            print("\t " + index + ". " + item.getLastName() + " " + item.getFirstName());
        }
        
        print("Votre choix: ");
    }
    
    private static void displayVehiclesByType(String type) {
        
    }
    
    private static Vehicle addNewCar() {
        int option = -1;
        Vehicle newCar = new Vehicle();
        
        displayDistinctType();
        option = scan.nextInt();
        
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
    
}
