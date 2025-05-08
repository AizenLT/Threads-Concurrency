public class RemoveFromWarehouse implements Runnable { 

    private Warehouse w;

    public RemoveFromWarehouse(Warehouse w){
        this.w=w;
    }

    public void run(){  
        w.updateWarehouse(-1);   
    }
    
} 