import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static int SIZE = 500;

    public static void main(String[] args) throws IOException {
        File file = new File("se.jpg");
        BufferedImage bufferedImage = ImageIO.read(new URL("https://hobbycenter.ru/static/cache/products/41072/catalog_product_main_41072.jpg"));

        int resultHeight = (int) ((double) bufferedImage.getHeight() / ((double) bufferedImage.getWidth() / SIZE));
        int marginTop = (int) ((double) (SIZE - resultHeight) / 2);

        BufferedImage resultImage = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_BGR);
        Graphics2D graph = resultImage.createGraphics();
        graph.setColor(Color.WHITE);
        graph.fillRect(0, 0, SIZE, SIZE);
        graph.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graph.drawImage(bufferedImage, 0, marginTop, SIZE, resultHeight, null);
        graph.dispose();
        if (!file.exists()) {
            file.createNewFile();
        }
        ImageIO.write(resultImage, "jpg", file);
    }
}
