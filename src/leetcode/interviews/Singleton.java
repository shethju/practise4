package leetcode.interviews;

// https://www.youtube.com/watch?v=zUYLY8kYavs
public class Singleton {
    private volatile static Singleton instance; // volatile will make sure that different threads cannot 
    // see value when instance is getting assigned value
    private Singleton() {}
    // If we use synchronized, it becomes slower since other threads have to wait till initialization complete
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) { // double check locking
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}