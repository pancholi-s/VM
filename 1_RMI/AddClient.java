import java.rmi.*;

public class AddClient {
    public static void main(String args[]) {
        try {
            // Get reference to the remote object
            String addServerURL = "rmi://" + args[0] + "/AddServer";
            AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);
            System.out.println("The first number is: " + args[1]);
            double d1 = Double.parseDouble(args[1]);
            // String d1 = args[1];
            // int d1 = Integer.parseInt(args[1]);

            //
            // 2nd parameter optional according to the question
            System.out.println("The second number is: " + args[2]);
            double d2 = Double.parseDouble(args[2]);
            // String d2 = args[1];
            // int d2 = Integer.parseInt(args[1]);
            //

            // Invoke remote method to add numbers
            // remember no. of parameters according to question
            System.out.println("The sum is: " + addServerIntf.add(d1, d2));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}