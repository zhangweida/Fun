package test;

import com.sun.glass.events.KeyEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by dell on 2017/7/26.
 */
public class JustForFun {

    //获取屏幕大小
    Dimension screeSize = Toolkit.getDefaultToolkit().getScreenSize();
    //图片存储位置
    static String path = "D:\\desktop.png";
    //模拟机器
    Robot robot = new Robot();

    public JustForFun() throws AWTException {
    }

    public void showDesktop() throws AWTException {
        //显示桌面
        robot.mouseMove((int)screeSize.getWidth(), (int)screeSize.getHeight());
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void screeShot() throws AWTException, IOException, UnsupportedFlavorException {

         //jar包转换为exe文件后获取分辨率失败
         BufferedImage image = new Robot().createScreenCapture(new Rectangle(screeSize));
         File file = new File(path);

        //桌面截屏
         ImageIO.write(image, "png", file);


        /**
         * //按下截屏键
        robot.keyPress(KeyEvent.VK_PRINTSCREEN);

        //获取剪贴板中图片
        Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        Image image = null;

        if(null != transferable && transferable.isDataFlavorSupported(DataFlavor.imageFlavor)) {
           image = (Image) transferable.getTransferData(DataFlavor.imageFlavor);
        }

        //将图片保存
        File file = new File(path);
        if(image != null) {
            ImageIO.write((RenderedImage) image, "png", file);
        }*/
    }

    public void showImage() {
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(path));

        //显示截屏
        //frame.getContentPane().add(label, BorderLayout.CENTER);
        //frame.setUndecorated(true);
        //frame.pack();
        label.setBackground(Color.black);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws AWTException, IOException, InterruptedException, UnsupportedFlavorException {
        JustForFun fun = new JustForFun();

        fun.showDesktop();
        new Thread().sleep(100);
        fun.screeShot();
        fun.showImage();
    }
}
