import java.util.Scanner;
public class even{
 public static void main(String[]args){
  
   int num;
System.out.println("Enter a Number: ");
Scanner sc  = new Scanner(System.in);
num = sc.nextInt();
   
   if(num%5==0 && num%3==0)
  {
   System.out.println(num + "=> number is even"); 
  }else
  { 
    System.out.println(num + "=>number is odd");
   }
}
}
