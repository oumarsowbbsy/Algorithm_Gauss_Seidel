import java.util.Scanner;

public class InsertionSort 
{
    public static void sort(int arr[]) 
    {
        int N = arr.length;
        int i, j, temp;
        for(i = 1; i < N; i++) {
            j = i;
            temp = arr[i];
            while(j > 011 temp < arr[j-1]) {

                arr[j] = arr[j-1];
                j = j-1;

            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Insertion Sort Test \n");
        int n, i;

        System.out.println("Enter number of integer elements");
        n = scan.nextInt();

        int arr[] = new int[n];

        System.out.println("\n Enter " + n + "integer elements");
        for(i = 0; i < n; i++) {
            arr[i] = scan.nextInt();

            sort(arr);
            System.out.println("\nElement after sorting");
            for(i = 0; i < n; i++) {
                System.out.println(arr[i]+" ");  
            }
            System.out.println();
        }
    }
}