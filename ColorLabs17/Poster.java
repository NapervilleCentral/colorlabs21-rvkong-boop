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
         
        me1.write("images/Collage1.jpg");
         
        upsideDown(me2);
        copyToCanvas(me2, canvas, 0, 360);
        
        me2.write("images/Collage2.jpg");

        me3 = negative(me3);
        copyToCanvas(me3, canvas, 0, 720);

        me3.write("images/Collage3.jpg");

        me4 = greyScale(me4);
        copyToCanvas(me4, canvas, 640, 0);

        me4.write("images/Collage4.jpg");

        recursive(me5);
        copyToCanvas(me5, canvas, 640, 360);
        
        me5.write("images/Collage5.jpg");

        me6 = sepia(me6);
        copyToCanvas(me6, canvas, 640, 720);
        
        me6.write("images/Collage6.jpg");


        
         canvas.explore();
         
         
        canvas.write("images/FINALCOLLAGE.jpg");

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
    
    public static Picture recursive(Picture source)
    {
        Picture edited = new Picture(source.getWidth()/2, source.getHeight()/2);
    
        if (edited.getWidth() < 20 || edited.getHeight() < 10)
        {
            return source;
        }
    
        for (int y = 0; y < edited.getHeight(); y++)
        {
            for (int x = 0; x< edited.getWidth(); x++)
            {
                Pixel psource = source.getPixel(x*2, y* 2);
                Pixel newP = edited.getPixel(x, y);
    
                int redValue = psource.getRed();
                int greenValue = psource.getGreen();
                int blueValue = psource.getBlue();
    
                newP.setRed(redValue);
                newP.setGreen(greenValue);
                newP.setBlue(blueValue);
            }
        }
    
        Picture recursed = recursive(edited);
    
        for (int y = 0; y < recursed.getHeight(); y++)
        {
            for (int x = 0; x < recursed.getWidth(); x++)
            {
                source.getPixel(x, y).setColor(recursed.getPixel(x, y).getColor());
            }
        }
    
        return source;
    }
    
    public static Picture sepia(Picture source)
    {
        Picture edited = new Picture(source.getWidth(), source.getHeight());
      
        for (int y = 0; y <= source.getHeight() - 1; y++)
        {
            for (int x = 0; x <= source.getWidth() - 1; x++)
            {
                Pixel psource = source.getPixel(x, y);
                Pixel newP = edited.getPixel(x, y); 
                
                
                int redValue = psource.getRed();
                int greenValue = psource.getGreen();
                int blueValue = psource.getBlue();
    
                int sepiaRed= (int)(redValue *0.47+ greenValue * 0.83+ blueValue *0.22);
                int sepiaGreen = (int)(redValue *0.30+ greenValue * 0.59+ blueValue *0.14);
                int sepiaBlue= (int)(redValue *0.20+ greenValue * 0.41+ blueValue *0.10);
                
                newP.setRed(sepiaRed);
                newP.setGreen(sepiaGreen);
                newP.setBlue(sepiaBlue);
            }
        }
        
        return edited;
           
    }
}
