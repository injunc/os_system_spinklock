package presentation;

import java.util.concurrent.atomic.AtomicBoolean;

public class Spinlock {
    private AtomicBoolean lockFlag;

       public Spinlock() {
           lockFlag = new AtomicBoolean(false);
       }

       public void lock() {
           while (!lockFlag.compareAndSet(false, true)) {}
       }

       public void unlock() {
           lockFlag.set(false);
       }

}

