import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kirill on 11/12/15.
 */
public class OSDetectorTest {

    @Test
    public void testIfLinux() throws Exception {
        System.setProperty("os.name", "Linux");
        Assert.assertEquals(true, OSDetector.ifLinux());
        System.setProperty("os.name", "Windows");
        Assert.assertEquals(false, OSDetector.ifLinux());
    }
}