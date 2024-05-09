import java.awt.Color;
public class Steganography
{
    public static void main(String[] args)
    {

        //beach.explore();

        
        Picture beach = new Picture("beach.jpg");
        Picture moon = new Picture("moon-surface.jpg");

        Picture lion = new Picture("femaleLionAndHall.jpg");
        Picture flower = new Picture("whiteFlower.jpg");
        
        Picture swan = new Picture("swan.jpg");
        Picture kitten = new Picture("kitten2.jpg");

        
        if (canHide(beach,moon)){
            Picture hiddenPicture = hidePicture(moon,beach);
            System.out.println("Hidden Picture Dimensions: " + 
            hiddenPicture.getWidth() + " x "+ hiddenPicture.getHeight());
            hiddenPicture.explore();
            Picture revealedPicture = revealPicture(hiddenPicture);
            revealedPicture.explore();
        } else {
            //System.out.println("First picture dimensions: "+ );
            System.out.println("Cannot hide because the dimensions aren't compatible. Try again");
        }

        if (canHide(lion,flower)){
            Picture hiddenPicture = hidePicture(lion,flower);
            System.out.println("Hidden Picture Dimensions: " + 
            hiddenPicture.getWidth() + " x "+ hiddenPicture.getHeight());
            hiddenPicture.explore();
            Picture revealedPicture = revealPicture(hiddenPicture);
            revealedPicture.explore();
        } else {
            System.out.println("Cannot hide because the dimensions aren't compatible. Try again");
        }
        
        if (canHide(kitten,swan)){
            Picture hiddenPicture = hidePicture(kitten,swan);
            System.out.println("Hidden Picture Dimensions: " + 
            hiddenPicture.getWidth() + " x "+ hiddenPicture.getHeight());
            hiddenPicture.explore();
            Picture revealedPicture = revealPicture(hiddenPicture);
            revealedPicture.explore();
        } else {
            System.out.println("Cannot hide because the dimensions aren't compatible. Try again");
        }
        
    }
    
    public static Picture revealPicture(Picture p){
        //Picture copy = new Picture(p.getHeight(), p.getWidth());
        Picture copy = new Picture(p);
        Pixel [][] pix_old = p.getPixels2D();
        Pixel [][] pix_new = copy.getPixels2D();


       //write nested loops
       //to visit every pixel in pix_new

       for (int r = 0; r < pix_new.length; r++){
           for(int c = 0; c < pix_new[r].length; c++){
               //Pixel x = pix_new[r][c];


               Pixel x_old = pix_old [r][c];
               Color c_old = x_old.getColor();
               //calculate the new color
               int oldR = c_old.getRed();
               int oldG = c_old.getGreen();
               int oldB = c_old.getBlue();

               //System.out.println(x);

               int newR = (oldR % 4 % 64);
               int newG = (oldG % 4 % 64);
               int newB = (oldB % 4 % 64);


               //update Pixel x
               pix_new[r][c].setRed(newR);
               pix_new[r][c].setBlue(newB);
               pix_new[r][c].setGreen(newG);
               //x.setRed(newR);
               //x.setBlue(newB);
               //x.setGreen(newG);


               //System.out.println(x);
           }
           
       }


       
       return copy;


    }

    public static boolean canHide(Picture source, Picture secret){
        double widthSource = source.getWidth();
        double widthSecret = secret.getWidth();

        double hSource = source.getHeight();
        double hSecret = secret.getHeight();
        
        
        if ((widthSource == widthSecret) && (hSource == hSecret)){
            return true;
        } else {
            return false;
        }

    }
    public static Picture hidePicture(Picture source, Picture secret){
        Picture hiddenImage = new Picture(source);
        Pixel [][] sourcePixels = source.getPixels2D();
        Pixel [][] secretPixels = secret.getPixels2D();
        Pixel [][] hiddenPixels = hiddenImage.getPixels2D();

        canHide(source,secret);

        //write nested loops
        //to visit every pixel in pix_new
        for (int r = 0; r < secretPixels.length; r++){
            for(int c = 0; c < secretPixels[r].length; c++){
                Pixel sourcePixel = sourcePixels[r][c];
                Pixel secretPixel = secretPixels[r][c];


                int newR = ((sourcePixel.getRed() >> 2) << 2) | (secretPixel.getRed() >> 6);
                int newG = ((sourcePixel.getGreen() >> 2) << 2) | (secretPixel.getGreen() >> 6);
                int newB = ((sourcePixel.getBlue() >> 2) << 2) | (secretPixel.getBlue() >> 6);

                //update hiddenPixel
                hiddenPixels[r][c].setColor(new Color(newR, newG, newB));
                
            }
        }
        
        return hiddenImage;


    }

    /**
    * Clear the lower (rightmost) two bits in a pixel.
    */

    
    //public static void clearLow( Pixel p )
    //{
       /* */ /* To be implemented */
        //Color old = p.getColor();
        
        //int r = old.getRed();
        //int g = old.getGreen();
        //int b = old.getBlue();

        // clear the right most bit
        
        //r/=8;
        //r*=8;

       // g/=8;
        //g*=8;

        //b/=8;
        //b*=8;

        //p.setColor(new Color(r,g,b));

        

    //} 
    
    /**
     * Returns a new Picture object with the lowest two bits of each pixel cleared.
     */
    
     //public static Picture testClearLow(Picture p)
    //{
        /* To be implemented */
        //Picture p2 = new Picture(p);

        //p2.getPixels2D();

        //Pixel[][] pix = p2.getPixels2D;

        //for(int r = 0; r<pix.length;r++){
            //for(int c = 0; c < pix[0].length; c++){
                //Pixel x = pix[r][c];
                //clearLow(x);

            //}

        //}

        //return p2;
    //}
    
    
}
