
/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class TestPicture17
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
     /* 
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();

     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //relative path
     /**/
     Picture apic = new Picture("images\\beach.jpg");
     Picture ferris1 = new Picture("images/snowman.jpg");
     Picture ferris2 = new Picture("images/snowman.jpg");
     Picture ferris3 = new Picture("images/snowman.jpg");
     Picture ferris4 = new Picture("images/snowman.jpg");
     Picture ferris5 = new Picture("images/snowman.jpg");
               

     //apic.explore();
     ferris1.explore();
     
     //makes an array of pixels
     Pixel[] pixels1;
     //gets pixels from picture and assigns to pixels array
     pixels1 = ferris1.getPixels();
     
     Pixel[] pixels2;
     pixels2 = ferris2.getPixels();
     
     Pixel[] pixels3;
     pixels3 = ferris3.getPixels();
     
     Pixel[] pixels4;
     pixels4 = ferris4.getPixels();
     
     Pixel[] pixels5;
     pixels5 = ferris5.getPixels();
     /*
    
     //how many pixels or how large array
    System.out.println("This is a large array"+pixels.length  );


    /**/
    /*
        //access each index
    System.out.println(pixels1[17]);
    //access each pixel
    Pixel spot = ferris1.getPixel(100,100);
    
    System.out.println(pixels[17].getColor());
    System.out.println(spot);
    /**/
/*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);

    ferris1.explore();
/*
   // loop to access indexes of array or collection

    //for each loop spot  is a ?
    for (Pixel spot : pixels)
    System.out.println( spot );


   
 /**/

 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /*
    for (Pixel pixelObj : pixels)
        {
            //set the red value of the current pixel to the new value
           

        }
    ferris1.explore();
    
/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/*
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

  /**/ 
    //write/save a picture as a file
    

    
    
//ADJUST RED
    for (Pixel pixelObj : pixels1)
    {

        //get the redvalue
        int value = pixelObj.getBlue();
        
        //decrease the red value by 50%
        int newBlue = (int)(value*0.25);

        //set the red value of the current pixel to the new value
        pixelObj.setBlue(newBlue);

    }
    ferris1.explore();
    //ferris1.write("images/snowman.jpg");

    /**/
    
//NEGATE
    for (Pixel pixelObj : pixels2)
    {

        //get the redvalue
        int valueRed = pixelObj.getRed();
        int valueBlue = pixelObj.getBlue();
        int valueGreen = pixelObj.getGreen();

        //decrease the red value by 50%
        int Red = 255-valueRed;
        int Blue = 255-valueBlue;
        int Green = 255-valueGreen;


        //set the red value of the current pixel to the new value
        pixelObj.setRed(Red);
        pixelObj.setBlue(Blue);
        pixelObj.setGreen(Green);

    }
    ferris2.explore();
    //ferris2.write("images/snowman.jpg");

//GRAYSCALE

    for (Pixel pixelObj : pixels3)
    {

        //get the redvalue
        int valueRed = pixelObj.getRed();
        int valueBlue = pixelObj.getBlue();
        int valueGreen = pixelObj.getGreen();

        //average values into grayscale
        int grayScale = (int)((valueRed+valueBlue +valueGreen)/3);


        //set each color to make gray
        pixelObj.setRed(grayScale);
        pixelObj.setBlue(grayScale);
        pixelObj.setGreen(grayScale);

    }
    ferris3.explore();
    //ferris3.write("images/snowman.jpg");
    
//LIGHTEN

    for (Pixel pixelObj : pixels4)
    {

        //get the redvalue
        int valueRed = pixelObj.getRed();
        int valueBlue = pixelObj.getBlue();
        int valueGreen = pixelObj.getGreen();

        //average values into grayscale
        int lighterRed = (int)(valueRed*1.3);
        int lighterBlue = (int)(valueBlue*1.3);
        int lighterGreen = (int)(valueGreen*1.3);


        //set each color to make gray
        pixelObj.setRed(lighterRed);
        pixelObj.setBlue(lighterBlue);
        pixelObj.setGreen(lighterGreen);

    }
    ferris4.explore();
    //ferris4.write("images/snowman.jpg");
    
//SKYRED

    for (Pixel pixelObj : pixels5)
    {

        //get the redvalue
        int valueRed = pixelObj.getRed();
        int valueBlue = pixelObj.getBlue(); 
        int valueGreen = pixelObj.getGreen();

        //average values into grayscale
        if (Math.abs(85-valueRed) <= 10 && Math.abs(217-valueBlue) <= 10 && Math.abs(133-valueGreen) <=10){
            pixelObj.setRed(200);
            pixelObj.setBlue(60);
            pixelObj.setGreen(60);
        }

    }
    ferris5.explore();
    //ferris5.write("images/snowman.jpg");
  }//main
}//class
