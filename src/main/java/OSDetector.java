/**
 * Created by kirill on 11/12/15.
 */
public class OSDetector {
    public static boolean ifLinux() {
        return System.getProperty("os.name").equals("Linux");
    }
}
