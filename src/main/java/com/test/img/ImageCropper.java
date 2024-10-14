package com.test.img;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageCropper {
    public static void main(String[] args) {
        try {
            // 创建Robot对象
            Robot robot = new Robot();
            
            // 获取屏幕尺寸
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            
            // 截取屏幕区域的图片
            BufferedImage inputImage = robot.createScreenCapture(screenRect);
            
            // 定义截取的区域
            int x = 390;  // 起始横坐标
            int y = 104;  // 起始纵坐标
            int width = 1187;  // 截取宽度
            int height = 634; // 截取高度
            
            // 进行图片截取
            BufferedImage outputImage = inputImage.getSubimage(x, y, width, height);
            
            // 保存截取后的图片
            File outputFile = new File("F:/output3.jpg");
            ImageIO.write(outputImage, "jpg", outputFile);
            
            System.out.println("图片截取成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}