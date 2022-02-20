package com.networks.project.server.functionality;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImageMerger {

  public static BufferedImage joinBufferedImage(BufferedImage img1, BufferedImage img2) {
    int offset = 2;
    int width = img1.getWidth() + img2.getWidth() + offset;
    int height = Math.max(img1.getHeight(), img2.getHeight()) + offset;
    BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = newImage.createGraphics();
    Color oldColor = g2.getColor();
    g2.setPaint(Color.BLACK);
    g2.fillRect(0, 0, width, height);
    g2.setColor(oldColor);
    g2.drawImage(img1, null, 0, 0);
    g2.drawImage(img2, null, img1.getWidth() + offset, 0);
    g2.dispose();
    return newImage;
  }
}