
import compute.Compute;
import compute.Pi;
import compute.Task;

import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;


//Klient
public class ComputePi {
    public static void main(String args[]){

        try {
            MyData.info();
            System.setProperty("java.security.policy","srv.policy");
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) registry.lookup(name);


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
