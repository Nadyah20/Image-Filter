import java.util.Scanner;

public class Area{
  public static void main(String[] args){
    
    //create a scanner
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the length: ");
    float length= s.nextFloat();

    System.out.println("Enter the width: ");
    float width= s.nextFloat();

    float area = length * width;

    System.out.println("OK the area is " + (area));
    
    
  }
  
}
