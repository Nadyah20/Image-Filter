/* the code asks questions to find out what your score in darts is. The code takes your answers then
puts them in an if statement to find out where you dart landed and how many points you have.[*/ puts them in an if state
import java.util.Scanner;
public class game{
   public static void main(String[] args){
      // 
      
      Scanner s = new Scanner(System.in);
      System.out.println("What number did you land in? ");
      double score = s.nextDouble();
      
      System.out.println("Did you land in the double ring? (answer in lower case) ");
      String doubleRing= s.next();
      
      System.out.println("you said " + doubleRing);
      
      if (doubleRing.equals("yes")) {
         System.out.println("doubling your score!");
         score *= 2;
      }
      
      System.out.println("Did you land in the triple ring? ");
      String tripleRing= s.next();
      
      if (tripleRing.equals("yes")) {
         score *= 3;
      }
      
      System.out.println("Did you land in the bullseye? ");
      String bullseye= s.next();
      
      if (bullseye.equals("yes")) {
         score = 50;
      }
      
      System.out.println("Your score is: " + score);
      
      
      
      
   
   
   
   
   
   }



}