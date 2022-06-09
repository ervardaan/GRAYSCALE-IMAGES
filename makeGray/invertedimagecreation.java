
/**
 * Write a description of invertedimagecreation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
public class invertedimagecreation {
public ImageResource myconversion(ImageResource ir1)
{
    ImageResource ir2=new ImageResource(ir1.getWidth(),ir1.getHeight());
    for(Pixel p1:ir2.pixels())//p1 is pixel of output image while p2 is pixel of input image
    {
        Pixel p2=ir1.getPixel(p1.getX(),p1.getY());
        p1.setRed(255-p2.getRed());
        p1.setBlue(255-p2.getBlue());
        p1.setGreen(255-p2.getGreen());
    }
    return ir2;//we return the wholly grayscale output image
}
public void testmyconversion()
{
    ImageResource ir1=new ImageResource();
    ImageResource ir2=myconversion(ir1);
    ir2.draw();
}
public void manyimagesgrayscale()
{
    DirectoryResource dr=new DirectoryResource();
    for(File f:dr.selectedFiles())
    {
        ImageResource ir=new ImageResource(f);
        ImageResource getimage=myconversion(ir);
         String initialname=ir.getFileName();//get name of input file
        String finalname="gray-"+initialname;//create new file name
        getimage.setFileName(finalname);//set grayscale image's name to new file name
         
        getimage.save();//save grayscale image
}
}
}

