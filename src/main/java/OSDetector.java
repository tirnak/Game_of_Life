public class OSDetector {
    public static boolean ifLinux() {
        return System.getProperty("os.name").equals("Linux");
    }
}
