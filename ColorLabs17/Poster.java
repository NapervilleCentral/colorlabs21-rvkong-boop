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
         Picture me = new Picture("images/IMG_4884.jpeg");
         

         upsideDown(me);
         
         me.explore();
    }
    
    public static void copyToCanvas(Picture source, Picture target)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
     
        //loop through the columns (targetX is the starting point on the Canvas) sourceX += 2, smaller image skip pixels
        //                                                                       sourceX += 0.5, larger image double pixels, cast as int in loop body
        for (int sourceX = 0, targetX = 0; sourceX < source.getWidth(); sourceX++, targetX++)
        {
            //loop through the rows
            for (int sourceY = 0, targetY = 0; sourceY < source.getHeight(); sourceY++, targetY++)
            {
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
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
    
    
    
}
