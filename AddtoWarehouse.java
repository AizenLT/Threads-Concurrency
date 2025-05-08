public class AddtoWarehouse implements Runnable { 

    private Warehouse w;

    public AddtoWarehouse(Warehouse w){
        this.w=w;
    }

    public void run(){ 
        w.updateWarehouse(1);
    }
    
} 