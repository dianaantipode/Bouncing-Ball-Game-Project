// File: Pause.java
// Author: Aaron Stevens (azs@bu.edu)

public class Pause {

    public static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }
}
