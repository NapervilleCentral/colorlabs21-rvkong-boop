import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Write a description of class Poster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Poster
{
    public static void main (String[]args)
    {
         Picture me1 = new Picture("images/mysunshine.jpg");
         Picture me2 = new Picture("images/mysunshine.jpg");
         Picture me3 = new Picture("images/mysunshine.jpg");
         Picture me4 = new Picture("images/mysunshine.jpg");
         Picture me5 = new Picture("images/mysunshine.jpg");
         Picture me6 = new Picture("images/mysunshine.jpg");

         Picture canvas = new Picture("images/640x480.jpg");
         
         
         
         
        copyToCanvas(me1, canvas, 0, 0); 
         
         
        upsideDown(me2);
        copyToCanvas(me2, canvas, 0, 360);
        
        me3 = negative(me3);
        copyToCanvas(me3, canvas, 0, 720);
        
        me4 = greyScale(me4);
        copyToCanvas(me4, canvas, 640, 0);
        
        me5 = recursive(me5);
        copyToCanvas(me5, canvas, 640, 360);
        
        copyToCanvas(me6, canvas, 640, 720);

        
         canvas.explore();
    }
    
    /**
     * copy one pic to another pic/canvas
     * add two int to params to place you want pic on the target
     */
    public static void copyToCanvas(Picture source, Picture canvas, int startX, int startY)
    {
        Pixel sourcePix = null;
        Pixel canvasPix = null;
      
        for (int sourceX = 0; sourceX < source.getWidth(); sourceX++)
        {
            for (int sourceY = 0; sourceY < source.getHeight(); sourceY++)
    
            {
                if (sourceX + startX < canvas.getWidth() && sourceY + startY < canvas.getHeight())

                {
                    sourcePix = source.getPixel(sourceX, sourceY);
                    canvasPix = canvas.getPixel(sourceX + startX, sourceY + startY);

                    canvasPix.setColor(sourcePix.getColor());
                }
            }
        }
    }
    
    public static void mirrorAcross(Picture source)
    {
        int width = source.getWidth();
        int midline = width/2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
      
        for (int y = 28; y <= 98; y++)
        {
            for (int x = 10; x <= midline; x++)
            {
                leftPixel = source.getPixel(x, y);
                rightPixel = source.getPixel(midline * 2 - x, y);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    
    public static void upsideDown(Picture source)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
      
        for (int y = 0; y <= source.getHeight() - 1; y++)
        {
            for (int x = 0; x <= source.getWidth() - 1; x++)
            {
                leftPixel = source.getPixel(x, y);
                rightPixel = source.getPixel(source.getWidth() - x - 1, source.getHeight() - 1 - y);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }   
    
    public static Picture negative(Picture source)
    {
        Picture edited = new Picture(source.getWidth(), source.getHeight());
      
        for (int y = 0; y <= source.getHeight() - 1; y++)
        {
            for (int x = 0; x <= source.getWidth() - 1; x++)
            {
                Pixel psource = source.getPixel(x, y);
                Pixel newP = edited.getPixel(x, y);
                
                int redScale = psource.getRed();
                int greenScale = psource.getGreen();
                int blueScale = psource.getBlue();
                
                newP.setRed(255-redScale);
                newP.setGreen(255-greenScale);
                newP.setBlue(255-blueScale);
            }
        }
        
        return edited;
    }   
    
    public static Picture greyScale (Picture source)
    {
        Picture edited = new Picture(source.getWidth(), source.getHeight());
      
        for (int y = 0; y <= source.getHeight() - 1; y++)
        {
            for (int x = 0; x <= source.getWidth() - 1; x++)
            {
                Pixel psource = source.getPixel(x, y);
                Pixel newP = edited.getPixel(x, y); 
                
                //get the redvalue
                int redValue = psource.getRed();
                int greenValue = psource.getGreen();
                int blueValue = psource.getBlue();
    
                int greyScale = (int)((redValue + greenValue + blueValue)/3);    
                
                newP.setRed(greyScale);
                newP.setGreen(greyScale);
                newP.setBlue(greyScale);

            }
        }
        
        return edited;
           
    }
    
    public static Picture recursive (Picture source)
    {
        Picture edited = new Picture(source.getWidth()/2, source.getHeight()/2);
        
        if (edited.getWidth() < 20 || edited.getHeight() < 10)
        {
            return source;
        }
        
        for (int y = 0; y < source.getHeight(); y+=2)
        {
            for (int x = 0; x < source.getWidth(); x+=2)
            {
                Pixel psource = source.getPixel(x, y);
                Pixel newP = edited.getPixel(x/2, y/2);
                
                newP.setRed(psource.getRed());
                newP.setGreen(psource.getGreen());
                newP.setBlue(psource.getBlue());

    
            }
        }
        
        return recursive(edited);  
    }
}
