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
public class Vehicle {
    
    protected int immatriculation;
    protected int passengerQty;
    protected int costPerDay;
    protected int totalKm;
    protected boolean available;
    protected int rentalQty;
    protected String type;
    
    public Vehicle() {
        this.totalKm = 0;
        this.available = true;
    }
    
    protected int getImmatriculation() {
        return this.immatriculation;
    }
    
    protected void setImmatriculation(int newImmatriculation) {
        this.immatriculation = newImmatriculation;
    }
    
    protected int getPassengerQty() {
        return this.passengerQty;
    }
    
    protected void setPassengerQty(int qty) {
        this.passengerQty = qty;
    }
    
    protected int getRentalCost() {
        return this.costPerDay;
    }
    
    protected void setRentalCost(int cost) {
        this.costPerDay = cost;
    }
    
    protected int getKm() {
        return this.totalKm;
    }
    
    protected void setKm(int value) {
        this.totalKm = value;
    }
    
    protected boolean isAvailable() {
        return this.available;
    }
    
    protected void setAvailable(boolean value) {
        this.available = value;
    }
    
    protected int getRentalQty() {
        return this.rentalQty;
    }
    
    protected void setRentalQty(int value) {
        this.rentalQty = value;
    }
    
    protected String getType() {
        return this.type;
    }
    
    protected void setType(String newType) {
        this.type = newType;
    }
    
}
