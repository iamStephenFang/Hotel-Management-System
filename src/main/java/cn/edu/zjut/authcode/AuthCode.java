package cn.edu.zjut.authcode;

import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

@Component
public class AuthCode implements IAuthCode {
    private int width = 95;
    private int height = 30;
    private Random rand = new Random();
    private String[] fontNames = {"宋体", "黑体", "微软雅黑"};
    private String sequence = "1234567890zxcvbnmasdfghjklqwertyuiopZXCVBNMASDFGHJKLPOIUYTREWQ";
    private Color bgColor = new Color(255, 255, 255);
    private String code;

    /**
     * 随机字体
     */
    private Font randomFont() {
        int index = rand.nextInt(fontNames.length);
        String fontName = fontNames[index];
        int style = rand.nextInt(4);
        int size = rand.nextInt(5) + 24;
        return new Font(fontName, style, size);
    }

    /**
     * 画干扰线
     */
    private void drawLine(BufferedImage image) {
        int num = 3;
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {
            int x1 = rand.nextInt(width);
            int y1 = rand.nextInt(height);
            int x2 = rand.nextInt(width);
            int y2 = rand.nextInt(height);
            g2.setStroke(new BasicStroke(1.5F));
            g2.setColor(Color.CYAN);
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 随机字符
     */
    private char randomChar() {
        int index = rand.nextInt(sequence.length());
        return sequence.charAt(index);
    }

    /**
     * 随机颜色
     */
    private Color randomColor() {
        int red = rand.nextInt(150);
        int green = rand.nextInt(150);
        int blue = rand.nextInt(150);
        return new Color(red, green, blue);
    }

    /**
     * 添加背景色
     */
    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(this.bgColor);
        g2.fillRect(0, 0, width, height);
        return image;
    }

    /**
     * 得到验证码
     * @return string 返回含验证码的图片
     */
    public String getImage() throws IOException {
        BufferedImage image = createImage();
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        StringBuilder builder = new StringBuilder();
        // 生成四个字符
        for (int i = 0; i < 4; i++) {
            String s = randomChar() + "";
            builder.append(s);
            float x = i * width / 4.0F;
            g2.setFont(randomFont());
            g2.setColor(randomColor());
            g2.drawString(s, x, height - 5);
        }
        this.code = builder.toString();
        drawLine(image);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        String base64Img = Base64Utils.encodeToString(outputStream.toByteArray());
        System.out.println(base64Img);
        outputStream.close();
        return "data:image/jpg;base64," + base64Img;
    }

    /**
     * 返回验证码
     */
    public String getCode() {
        return code;
    }
}
