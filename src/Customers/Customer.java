package Customers;
import java.util.Scanner;
import ships.*;

public class Customer {
    Scanner in = new Scanner(System.in);
    String name;
    private String Address;
    String number;
    private String proof;
    public Customer(String name, String address, String number, String proof) {
        super();
        this.name = name;
        this.Address = address;
        this.number = number;
        this.proof = proof;
        System.out.println("Enter shipid");
        int id = in.nextInt();
        Ships s  = new Ships(id,"atlantis");
    }
    public void getdetails()
    {
        System.out.println(name);
        System.out.println(number);
        System.out.println(proof);
        System.out.println(Address);
    }

    

    

    

 

}