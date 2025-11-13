
/**
 * Make myself colourful
 * Ryan Kong
 * 11/12/2025
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
        
         //opens selfie picture 
        /*
         String fileName = FileChooser.pickAFile();
         Picture pictObj = new Picture("images/IMG_4739.jpeg");
         pictObj.explore();
         /**/
         
         //relative path
         //change with selfie picture
         Picture me1= new Picture("images/IMG_4739.jpeg");
         Picture me2 = new Picture("images/IMG_4739.jpeg");
         Picture me3 = new Picture("images/IMG_4739.jpeg");
         Picture me4 = new Picture("images/IMG_4739.jpeg");
         Picture me5 = new Picture("images/IMG_4739.jpeg");


         
         Pixel[] pixels1;
         pixels1 = me1.getPixels();
     
        Color darkBlue = new Color(3, 12, 171);
        Color red = new Color(219, 39, 33);
        Color lightBlue = new Color(72, 189, 240);
        Color offWhite = new Color(219, 233, 244);

     
        /**
         * greyscale change
         */
        for (Pixel pixelObj : pixels1)
            {

            //get the redvalue
            int redValue = pixelObj.getBlue();
            int greenValue = pixelObj.getBlue();
            int blueValue = pixelObj.getBlue();

            int greyScale = (int)((redValue + greenValue + blueValue)/3);    
            
            pixelObj.setRed(greyScale);
            pixelObj.setGreen(greyScale);
            pixelObj.setBlue(greyScale);

        }
        me1.explore();
        
         /**
          * method 1 change
          * 
          */
         
        for (Pixel pixelObj : pixels1)
        {
            int redValues = pixelObj.getRed();
            if (redValues < 64){
                pixelObj.setColor(darkBlue);
            }
            else if (redValues < 128){
                pixelObj.setColor(red);
            }
            else if (redValues < 196){
                pixelObj.setColor(lightBlue);
            }
            else{
                pixelObj.setColor(offWhite);
            }
        }
        me1.explore();

         /**
          * method 2 change
          * 
          */
        
        int min = 257;
        int max = 0;
        int redValues=0, greenValues = 0;
        
        for(Pixel pixelObj : pixels1){
            redValues = pixelObj.getRed();
            if (redValues < min){
                min = redValues;
            }
            if (redValues > max){
                max = redValues;
            }
        }
        for (Pixel pixelObj : pixels1)
        {
            redValues = pixelObj.getRed();
            if (redValues < (int)((max-min)/4)){
                pixelObj.setColor(darkBlue);
            }
            else if (redValues < (int)(2*(max-min)/4)){
                pixelObj.setColor(red);
            }
            else if (redValues < (int)(3*(max-min)/4)){
                pixelObj.setColor(lightBlue);
            }
            else{
                pixelObj.setColor(offWhite);
            }
        }
        me1.explore();
        
        for(Pixel pixelObj : pixels1){
            greenValues = pixelObj.getGreen();
            if (greenValues < min){
                min = redValues;
            }
            if (greenValues > max){
                max = redValues;
            }
        }
        for (Pixel pixelObj : pixels1)
        {
            greenValues = pixelObj.getGreen();
            if (greenValues < (int)((max-min)/4)){
                pixelObj.setColor(darkBlue);
            }
            else if (greenValues < (int)(2*(max-min)/4)){
                pixelObj.setColor(red);
            }
            else if (greenValues < (int)(3*(max-min)/4)){
                pixelObj.setColor(lightBlue);
            }
            else{
                pixelObj.setColor(offWhite);
            }
        }
        me1.explore();


         /**
          * custom color palette
          */

         
    }//main       
}//class
