import java.util.Scanner;

public class question2 {
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Number of elements");
        int length_of_array = obj.nextInt(); // using scanner class get the size of array required by user

        int[] arr = new int[length_of_array];

        for (int i = 0 ; i < length_of_array ; i++)
        {
            arr[i] = obj.nextInt(); // input the array
        }

        obj.close();



        int[] array_count = new int[21];
        for (int i = 0 ; i <= 20;i++)
        {
        for(int j = 0 ; j < length_of_array ;j++)
        {
            if(arr[j] == i)
            {
                array_count[i] ++; // store the count of each element of input array into array_count
            }

        }
    }
    

    int[] cumulative_count = new int[21];
    int sum = 0;
    for (int i = 0;i<cumulative_count.length ; i++)
    {
        sum += array_count[i];
        cumulative_count[i] = sum; // calculate the cumulative count of the elements from the array_count

    }
    
    

    int[] array_sorted = new int[length_of_array];
    for(int i =0 ; i<arr.length;i++)
    {
        cumulative_count[arr[i]]--; // now apply the algorithm by going through the original array and then finding the position of elemt using cumulative count array
        array_sorted[cumulative_count[arr[i]]] = arr[i];
    }

    System.out.println("Sorted Array is");
    for(int i = 0 ; i < array_sorted.length ;i++)
    {
        System.out.println(array_sorted[i]); // print the array
    }

    }
    
}

