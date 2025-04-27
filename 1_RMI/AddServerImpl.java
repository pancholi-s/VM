import java.rmi.*;
import java.rmi.server.*;

//class that implements the remote interface
public class AddServerImpl extends UnicastRemoteObject
        implements AddServerIntf {
    // constructor
    public AddServerImpl() throws RemoteException {
    }

    // implement method declared in the interface
    public double add(double d1, double d2) throws RemoteException {
        return d1 + d2;
    }



    // public int count_vowel(String c) throws RemoteException {
    //     int vc = 0;
    //     for (int i = 0; i < c.length(); i++) {
    //         char ch = c.charAt(i);
    //         if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
    //             vc++;
    //         }
    //     }

    //     return vc;
    // }



    // public int factorial(int c) throws RemoteException {
    //     int fact = 1;
    //     for (int i = 1; i <= c; i++) {
    //         fact = fact * i;
    //     }
    //     return fact;
    // }



    // public double power_of_two(double d1) throws RemoteException {
    //     double resultPow = Math.pow(2, d1);
    //     return resultPow;
    // }



    // public double celsius_to_fahrenheit(double c) throws RemoteException {
    //     double celtofah = (c * (9 / 5) + 32);
    //     return celtofah;
    // }



    // public double mile_to_km(double c) throws RemoteException {
    //     double miletokm = c * 1.609344;
    //     return miletokm;
    // }



    // public String hello_echo(String c) throws RemoteException {
    //     return "Hello " + c;
    // }



    // public String lexi_string(String c, String m) throws RemoteException {
    //     int comparisonResult = c.compareTo(m);
    //     if (comparisonResult > 0) {
    //         return c;
    //     } else if (comparisonResult < 0) {
    //         return m;
    //     }
    //     return c;
    // }
}