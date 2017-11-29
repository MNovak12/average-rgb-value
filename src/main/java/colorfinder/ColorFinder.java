package colorfinder;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ColorFinder {
  private static final int WIDTH = 10;
  private static final int HEIGHT = 10;

  // Read file containing URLs
  List<String> readFile(String fileName) {
    ClassLoader classLoader = getClass().getClassLoader();
    try {
      return IOUtils.readLines(classLoader.getResourceAsStream(fileName));
    } catch (IOException e) {
      System.out.println("Error loading urls.txt - check that file is in src/main/resources");
      e.printStackTrace();
    }

    return null;
  }

  // Get resized image from url
  static BufferedImage getImage(String urlStr) throws IOException {
    URL url = new URL(urlStr);
    BufferedImage img = ImageIO.read(url);

    // resize image to conserve speed and resources (iterate over fewer pixels in next step)
    return Thumbnails.of(img)
        .size(WIDTH, HEIGHT)
        .asBufferedImage();
  }

  // Calculate the average RBG value for all pixels the image contains
  static String averageColor(BufferedImage img) {
    long sumr = 0, sumg = 0, sumb = 0;
    int width = img.getWidth();
    int height = img.getHeight();
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Color pixel = new Color(img.getRGB(x, y));
        sumr += pixel.getRed();
        sumg += pixel.getGreen();
        sumb += pixel.getBlue();
      }
    }
    int num = width * height;  // total number of pixels
    return String.format("%d;%d;%d", sumr / num, sumg / num, sumb / num);
  }

  public static void main(String[] args) {
    ColorFinder colorFinder = new ColorFinder();
    List<String> urls = colorFinder.readFile("urls.txt");

    FileWriter fileWriter = null;
    try {
      fileWriter = new FileWriter("colors.csv");

      if (urls != null && urls.size() > 0) {
        for (String url : urls) {
          BufferedImage img = null;
          try {
            img = getImage(url);
          } catch (IOException e) {
            System.out.println("Error creating image from URL: " + url);
            e.printStackTrace();
          }
          if (img != null) {
            fileWriter.append(url)
                .append(";")
                .append(averageColor(img))
                .append("\n");
          }
        }
      }
    } catch (IOException e) {
      System.out.println("IOException with output file.");
      e.printStackTrace();
    } finally {
      try {
        if (fileWriter != null) {
          fileWriter.flush();
          fileWriter.close();
        }
      } catch (IOException e) {
        System.out.println("Error while flushing/closing fileWriter");
        e.printStackTrace();
      }
    }
  }
}
