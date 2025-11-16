
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
        
         /**
         * greyscale change
         */
        
         Picture grey = new Picture("images/IMG_4884.jpeg");
         
         Pixel[] greyy;
         greyy = grey.getPixels();
         
         for (Pixel pixelObj : greyy)
            {

            //get the redvalue
            int redValue = pixelObj.getRed();
            int greenValue = pixelObj.getGreen();
            int blueValue = pixelObj.getBlue();

            int greyScale = (int)((redValue + greenValue + blueValue)/3);    
            
            pixelObj.setRed(greyScale);
            pixelObj.setGreen(greyScale);
            pixelObj.setBlue(greyScale);

        }
        grey.explore();
        
        //create 6 photos to be used for each new method/change
        
         Picture me1= new Picture(grey);
         Picture me2 = new Picture(grey);
         Picture me3 = new Picture(grey);
         Picture me4 = new Picture(grey);
         Picture me5 = new Picture(grey);
         Picture me6 = new Picture(grey);
        

         Pixel[] pixels1;
         pixels1 = me1.getPixels();
         Pixel[] pixels2;
         pixels2 = me2.getPixels();
         Pixel[] pixels3;
         pixels3 = me3.getPixels();
         Pixel[] pixels4;
         pixels4 = me4.getPixels();
         Pixel[] pixels5;
         pixels5 = me5.getPixels();
         Pixel[] pixels6;
         pixels6 = me6.getPixels();
         
     
        Color darkBlue = new Color(3, 12, 171);
        Color red = new Color(219, 39, 33);
        Color lightBlue = new Color(72, 189, 240);
        Color offWhite = new Color(219, 233, 244);

        
                
         /**
          * method 1 change (inflexible bounds)
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
        me1.write("images/METHOD1.jpg");
        
         /**
          * method 2 change(balance)
          * 
          */
        
        int min = 257;
        int max = 0;
        int redValues=0, greenValues = 0;
        
        for(Pixel pixelObj : pixels2){
            redValues = pixelObj.getRed();
            if (redValues < min){
                min = redValues;
            }
            if (redValues > max){
                max = redValues;
            }
        }
        for (Pixel pixelObj : pixels2)
        {
            redValues = pixelObj.getRed();
            if (redValues < (int)(min+(max-min)/4)){
                pixelObj.setColor(darkBlue);
            }
            else if (redValues < (int)(min+2*(max-min)/4)){
                pixelObj.setColor(red);
            }
            else if (redValues < (int)(min+3*(max-min)/4)){
                pixelObj.setColor(lightBlue);
            }
            else{
                pixelObj.setColor(offWhite);
            }
        }
        me2.explore();
        me2.write("images/METHOD2.jpg");

         /**
          * custom color palette(1, 2, 3, 4, 5)
          * Since the two above are almost identical, we know that we have a wide range of grey scale from 0-255
          * This makes sense because there's white light shining onto our photo against the whiteboard with black hair
          * So it's beneficial for us to use an extra colour to help us manage that wider range
          */
         
        //attempt 1: using 5 colours this time, and different ones!
        
        Color colour1 = new Color(34, 14, 179);
        Color colour2 = new Color(95, 80, 204);
        Color colour3 = new Color(75, 113, 200);
        Color colour4 = new Color(255, 196, 77);
        Color colour5 = new Color(255, 217, 77);


        for (Pixel pixelObj : pixels3)
        {
            redValues = pixelObj.getRed();
            if (redValues < 52){
                pixelObj.setColor(colour1);
            }
            else if (redValues < 104){
                pixelObj.setColor(colour2);
            }
            else if (redValues < 156){
                pixelObj.setColor(colour3);
            }
            else if (redValues < 208){
                pixelObj.setColor(colour4);
            }
            else {
                pixelObj.setColor(colour5);
            }
        }
        me3.explore();
        me3.write("images/SFtry1.jpg");
        
        
        //attempt 2: Colours look nice, maybe adjust the bound of the second colour alittle to fix the face color
        //also it may help to change the colours in the future but I want to see if I can fix it before modifying RGBS
    
        for (Pixel pixelObj : pixels4)
        {
            redValues = pixelObj.getRed();
            if (redValues < 52){
                pixelObj.setColor(colour1);
            }
            else if (redValues < 90){
                pixelObj.setColor(colour2);
            }
            else if (redValues < 156){
                pixelObj.setColor(colour3);
            }
            else if (redValues < 200){
                pixelObj.setColor(colour4);
            }
            else {
                pixelObj.setColor(colour5);
            }
        }
        me4.explore();
        me4.write("images/SFtry2.jpg");

        
        //attempt 3: shading looks a little better, but I feel like the blues and yellows blend a little too well. Increase contrast between the colours.
        //also, the bright parts are VERY bright, so we should adjust  those bounds a little bit
        
        Color c1adj = new Color(47, 39, 133);
        Color c2adj = new Color(73, 63, 177);
        Color c3adj = new Color(192, 120, 108);
        Color c4adj = new Color(254, 161, 64);
        Color c5adj = new Color(254, 190, 64);
        for (Pixel pixelObj : pixels5)
        {
            redValues = pixelObj.getRed();
            if (redValues < 52){
                pixelObj.setColor(c1adj);
            }
            else if (redValues < 90){
                pixelObj.setColor(c2adj);
            }
            else if (redValues < 102){
                pixelObj.setColor(c3adj);
            }
            else if (redValues < 150){
                pixelObj.setColor(c4adj);
            }
            else {
                pixelObj.setColor(c5adj);
            }
        }
        me5.explore();
        me5.write("images/SFtry3.jpg");

        //attempt 4: this looks good, but everything is still so yellow
        //definitely want to bring out the floor pattern a little more and adjust coloration diff b/t clothes and bg
        
        for (Pixel pixelObj : pixels6)
        {
            redValues = pixelObj.getRed();
            if (redValues < 70){
                pixelObj.setColor(c1adj);
            }
            else if (redValues < 110){
                pixelObj.setColor(c2adj);
            }
            else if (redValues < 170){
                pixelObj.setColor(c3adj);
            }
            else if (redValues < 210){
                pixelObj.setColor(c4adj);
            }
            else {
                pixelObj.setColor(c5adj);
            }
        }
        me6.explore();
        me6.write("images/SFtryFINAL.jpg");

    }//main       
}//class
