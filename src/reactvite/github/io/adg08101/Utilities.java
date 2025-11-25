package reactvite.github.io.adg08101;

public class Utilities {
    static void tryForWait(int time) {
        try {
            Thread.sleep(time);  // Wait 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
