package colorfinder;

import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ColorFinderTest {
  private static ColorFinder colorFinder;
  private static final int MIN_DIMENSION = 10;

  @BeforeClass
  public static void init() {
    colorFinder = new ColorFinder();
  }

  @Test
  public void testReadFile() {
    List<String> files = colorFinder.readFile("urls.txt");
    assertEquals(3, files.size());
  }

  @Test
  public void testGetImage() throws IOException {
    BufferedImage img = colorFinder.getImage("http://i.imgur.com/FApqk3D.jpg");
    assertTrue(img.getWidth() <= MIN_DIMENSION);
    assertTrue(img.getHeight() <= MIN_DIMENSION);
  }

  @Test(expected = IOException.class)
  public void testInvalidImage() throws IOException {
    colorFinder.getImage("http://not/an/image");
  }

  @Test
  public void testGetAverageColor() throws IOException {
    BufferedImage img = colorFinder.getImage("http://i.imgur.com/FApqk3D.jpg");
    String expected = colorFinder.averageColor(img);
    assertEquals("218;219;210", expected);
  }
}
