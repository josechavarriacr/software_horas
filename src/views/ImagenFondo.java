package views;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class ImagenFondo implements Border {    
    BufferedImage fondo;
    public ImagenFondo(String ruta){    
        try {       
            //se obtiene la imagen            
            URL url = new URL(getClass().getResource("..\\images\\movil.jpg").toString());            
            fondo = ImageIO.read(url);    
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }       
      
    }
    // se sobreescriben metodos propios de Border
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){     
        //se dibuja la imagen de fondo en el centro del contenedor
        //cada que se redimensione el contenedor, la imagen automaticamente se posiciona en el centro
        g.drawImage(fondo, 0, 0,width, height, null);       
    }

    @Override
    public Insets getBorderInsets(Component c){
	return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque(){
	return false;
    }

}
