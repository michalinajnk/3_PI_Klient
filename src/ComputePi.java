
import compute.Compute;
import compute.Task;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;


//Klient
public class ComputePi {
    public static void main(String args[]) {
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) registry.lookup(name);
            //Compute comp = (Compute) Naming.lookup("//localhost/Compute");

            Task<BigDecimal> taskPi = new Pi(Integer.parseInt(args[1]));
            BigDecimal pitest = comp.testPI();
            BigDecimal pi = comp.executeTask(taskPi);
            System.out.println(pitest);
            System.out.println(pi);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            System.err.println(e.getMessage());
            System.err.println( e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
