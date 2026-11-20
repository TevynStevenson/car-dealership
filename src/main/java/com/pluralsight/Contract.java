package com.pluralsight;

public class Contract {

    //Add constructor for the contract
    String dateOfContract;
    String customerName;
    String customerEmail;
    String vehicleSold;
    Double totalPrice;
    Double monthlyPayment;

    public Contract(String dateOfContract,
                    String customerName,
                    String customerEmail,
                    String vehicleSold,
                    Double totalPrice,
                    Double monthlyPayment) {


        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    //Generate getter/setter for items in constructor
    //date of contract getter/setter
    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    //Customer name getter and setter
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    //CustomerEmail gettter/setter
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    //Vehicle sold getter/setter
    public String getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(String vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
}
