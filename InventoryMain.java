import java.util.ArrayList;

public class InventoryMain{ 

    
    public static void main (String[] args) throws InterruptedException{ 
        final int add=Integer.parseInt(args[0]);
        final int sub=Integer.parseInt(args[1]);
        final int bug=Integer.parseInt(args[2]);

        final Warehouse w = new Warehouse(bug);

        final AddtoWarehouse a = new AddtoWarehouse(w); 
        final RemoveFromWarehouse r = new RemoveFromWarehouse(w);

        final ArrayList <Thread> threads = new ArrayList<>();
        

        for(int i=0; i<add; i++){ // creates add threads
            Thread t = new Thread(a);
            threads.add(t);
        }
        for(int i=0; i<sub; i++){ // creates sub threads
            Thread u = new Thread(r);  
            threads.add(u);
        }

        
        for(int i=0; i<threads.size();i++){ // starts threads
            (threads.get(i)).start();
        }



        try { // Waits for threads to finish
            for(int i=0; i<threads.size();i++){
                (threads.get(i)).join();
            }
        }
        
            catch(InterruptedException e) {e.printStackTrace();
        }
        
        System.out.println("Final inventory size = "+w.checkWarehouse());     
    } 
} 