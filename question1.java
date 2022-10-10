public class question1 {

    public static void main(String args[])
    {
        String str1 = "abcdefghihihih";
        String str2 = "abcdefff";

        int length = str1.length()<str2.length()?str1.length():str2.length();
        int bigger_string = str1.length()<str2.length()?2:1; // string to be printed later 


        for (int i = 0 ; i<length ; i++)
        {
            if(str1.charAt(i) !=str2.charAt(i))
            {
                if(((int)str1.charAt(i)) - ((int)str2.charAt(i))>0)
                {
                    // true means that unicode value of char of str1 was greater hence lexically str1 should come after str2
                    bigger_string = 1; 
                }else{
                    bigger_string = 2;
                }
                break ;
            }
        }

        System.out.println(bigger_string == 1?str2:str1);
        System.out.println(bigger_string == 2?str2:str1);

        
    }    
}
