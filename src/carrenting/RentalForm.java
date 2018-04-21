/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrenting;

/**
 *
 * @author eleve2
 */
public class RentalForm {
    
    private int rentalCode;
    private Vehicle vehicle;
    private Customer customer;
    private int period;
    private int rentalCost;
    
    public RentalForm(Vehicle vehicle, Customer customer, int period) {
        
        this.vehicle = vehicle;
        this.customer = customer;
        this.period = period;
        this.rentalCost = this.vehicle.costPerDay * this.period;
                
    }
    
    public int getRentalCode() {
        return this.rentalCode;
    }
    
    public void setRentalCode(int value) {
        this.rentalCode = value;
    }
    
    public Vehicle getVehicle() {
        return this.vehicle;
    }
    
    public void setVehicle(Vehicle newVehicle) {
        this.vehicle = newVehicle;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }
    
    public int getPeriod() {
        return this.period;
    }
    
    public void setPeriod(int value) {
        this.period = value;
    }
    
    public int getRentalCost() {
        return this.rentalCost;
    }
    
}
