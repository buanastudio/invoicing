/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipaymentdua;

/**
 *
 * @author karinanur
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class homebg extends JPanel{
    
    private Image image;

    public homebg() {
image = new ImageIcon(getClass().getResource("/images/tampilan.png")).getImage();
    }
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);

        Graphics2D gd = (Graphics2D) grphcs.create();
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }
}

