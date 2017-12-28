import org.junit.Assert;
import org.junit.Test;

public class FieldTest {
    private static String DEAD = "o ";
    private static String ALIVE;
    static {
        if (OSDetector.ifLinux()) {
            ALIVE = "\u001B[35mx \u001B[0m";
        } else {
            ALIVE = "x ";
        }
    }

    @Test
    public void testToString() throws Exception {
        Field field = new Field(2);
        Assert.assertEquals(field.toString(), "" + DEAD + DEAD + "\n" + DEAD + DEAD + "\n");
    }

    @Test
    public void testSetAlive() throws Exception {
        Field field = new Field(2);
        field.setAlive(0,0);
        field.setAlive(1,1);
        Assert.assertEquals(field.toString(), "" + ALIVE + DEAD + "\n" + DEAD + ALIVE + "\n");
    }

    @Test
    public void testSetMultipleAlive() throws Exception {
        Field field = new Field(5);
        field.setAlive(2,2);
        field.setAlive(1,3);
        Assert.assertEquals(field.toString(), ""
                + DEAD  + DEAD + DEAD  + DEAD + DEAD + "\n"
                + DEAD  + DEAD + DEAD  + ALIVE+ DEAD + "\n"
                + DEAD  + DEAD + ALIVE + DEAD + DEAD + "\n"
                + DEAD  + DEAD + DEAD  + DEAD + DEAD + "\n"
                + DEAD  + DEAD + DEAD  + DEAD + DEAD + "\n");
    }

    @Test
    public void testLive() throws Exception {
        Field field = new Field(5);
        field.setAlive(1,1);
        field.setAlive(2,2);
        field.setAlive(3,3);
        field.live();
        Assert.assertEquals(field.toString(), ""
                + DEAD  + DEAD + DEAD  + DEAD + DEAD + "\n"
                + DEAD  + DEAD + DEAD  + DEAD + DEAD + "\n"
                + DEAD  + DEAD + ALIVE + DEAD + DEAD + "\n"
                + DEAD  + DEAD + DEAD  + DEAD + DEAD + "\n"
                + DEAD  + DEAD + DEAD  + DEAD + DEAD + "\n");
    }

    @Test
    public void testLiveAndDie() throws Exception {
        Field field = new Field(5);
        field.setAlive(1,2);
        field.setAlive(2,2);
        field.setAlive(2,3);
        field.setAlive(3,3);
        field.live();
        Assert.assertEquals(field.toString(), ""
                + DEAD  + DEAD + DEAD  + DEAD + DEAD + "\n"
                + DEAD  + DEAD + ALIVE + ALIVE + DEAD + "\n"
                + DEAD  + DEAD + ALIVE + ALIVE+ DEAD + "\n"
                + DEAD  + DEAD + ALIVE + ALIVE+ DEAD + "\n"
                + DEAD  + DEAD + DEAD  + DEAD + DEAD + "\n");
    }

    @Test
    public void testPlanerOne() throws Exception {
        Field field = new Field(5);
        field.setAlive(0,3);
        field.setAlive(1,3);
        field.setAlive(2,3);
        field.setAlive(2,2);
        field.setAlive(1,1);
        field.live();
        Assert.assertEquals(field.toString(), ""
                + DEAD  + DEAD + ALIVE + DEAD + DEAD + "\n"
                + DEAD  + DEAD + DEAD  + ALIVE+ ALIVE+ "\n"
                + DEAD  + DEAD + ALIVE + ALIVE+ DEAD + "\n"
                + DEAD  + DEAD + DEAD  + DEAD + DEAD + "\n"
                + DEAD  + DEAD + DEAD  + DEAD + DEAD + "\n");

    }
}