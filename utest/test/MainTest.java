import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    Main main = new Main();

    @Test
    public void hetkeTemperatuurTest() {
        double hetke = 0;
        assertEquals(hetke, main.hetkeTemperatuur());
    }

    @Test
    public void korgeimTemperatuurTest() {
        double korgeim = 17.5;
        assertEquals(korgeim, main.korgeimTemperatuur());
    }

    @Test
    public void madalaimTemperatuurTest() {
        double madalaim = 12.3;
        assertEquals(madalaim, main.madalaimTemperatuur());
    }

    @Test
    public void koordinaadidTest() {
        double x = 59.4284;
        double y = 24.7501;
        double[] koordinaadid = new double[] {x, y};
        assertArrayEquals(koordinaadid, main.koordinaadid());
    }
}