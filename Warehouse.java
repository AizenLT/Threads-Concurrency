public class Warehouse {
    private int stock;
    private SemaphoreLock lock;


    public Warehouse(int bug){
        this.stock=0;

        if (bug ==1){
            this.lock = new SemaphoreLock(2);
        }
        else{
            this.lock = new SemaphoreLock(1);
        }
    }
    
    public void updateWarehouse(int change){         
        
        while (!lock.acquire()){// Hold threads untill permit avaliable
        }
        

        int temp = this.stock; // Critical section
        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e){}
        temp=temp+change;
        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e){}
        this.stock = temp;


        if (change==1){
            System.out.println("Added. Inventory Size now = "+checkWarehouse());
        }
        else{
            System.out.println("Removed. Inventory Size now = "+checkWarehouse());
        }
        lock.release(); // End of critical section
    }
    
    public int checkWarehouse(){
        return this.stock;
    }
}
