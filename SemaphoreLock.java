import java.util.concurrent.Semaphore;

class SemaphoreLock {

    private Semaphore lock;

    public SemaphoreLock(int val) {
        lock = new Semaphore(val);
    }

    boolean acquire() {
        return lock.tryAcquire();
    }

    void release() {
        lock.release();
    }
}