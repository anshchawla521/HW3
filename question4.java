import java.util.Scanner;
public class question4 {
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        int num = obj.nextInt(); // parse the integer from the input
        obj.close();
        System.out.println(num);
        while(num != 1 )
        {
            if(num%2 == 0)
            {
                //num is even
                num = num/2;
            }else{
                //num is odd
                num = num*3 +1; 
                
            }
            System.out.println(num);
        }

    }
    
}
