import java.awt.Color;
public class imageFilter {
    public static void main(String[] args){


        Picture flower = new Picture("whiteFlower.jpg");
        Picture lion = new Picture("femaleLionAndHall.jpg");

        Picture filteredImage = imageFilter(flower);
        Picture filteredImageTwo = imageFilter(lion);

        filteredImage.explore();
        filteredImageTwo.explore();

    }

    public static Picture imageFilter(Picture p){
        Picture copy = new Picture(p);
        Pixel [][] pix_old = p.getPixels2D();
        Pixel [][] pix_new = copy.getPixels2D();

        for (int r = 0; r < pix_new.length; r++){
            for(int c = 0; c < pix_new[r].length; c++){
                //Pixel x = pix_new[r][c];
 
 
                Pixel x_old = pix_old [r][c];
                Color c_old = x_old.getColor();
                //calculate the new color
                
                int oldB = c_old.getBlue();
 
                //System.out.println(x);
 
                
                int newB = oldB + 175;
 
 
                //update Pixel x
                
                pix_new[r][c].setBlue(newB);
                
 
 
                //System.out.println(x);
            }
            
        }
        
        return copy;
 
 
     }

}
