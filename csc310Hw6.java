// imports
import java.util.Scanner;

public class csc310Hw6 {

    // constants
    public static final String ARR_1_PROMPT = "Please enter the size of the 1st array (max 30): "; 
    public static final String ARR_2_PROMPT = "Please enter the size of the 2nd array (max 30): ";
    public static final String ARR_NUM_PROMPT = "Please enter a number for your array: ";

    // main
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); // scanner object for user inputs

        // getting array1 
        System.out.println(ARR_1_PROMPT);   // prints prompt
        int arr1Size = scan.nextInt(); // gets user input
        boolean numCheck = jvLibrary.arrNumChecks(arr1Size);    // checks if valid array size was inputted by user

        if (numCheck == false) {    // invalid array size so program is exited
            System.out.println("Please enter a valid array size (1-30)");
            System.exit(0);
        }
        
        int[] array1 = new int[arr1Size];  // declares array1 with user given size

        for (int i = 0; i < arr1Size; i++) {    // for length of array1 get user inputted nums for array values
            System.out.println(ARR_NUM_PROMPT); // prints prompt
            int temp = scan.nextInt();          // gets user inputted num for array
            array1[i] = temp;                   // assigns nums to array2
        }
        // prints array1
        System.out.print("Array 1: ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println(" ");   // adds new line
        // array1 got

        // getting array2
        System.out.println(ARR_2_PROMPT);   // prints prompt
        int arr2Size = scan.nextInt(); // gets user input
        numCheck = jvLibrary.arrNumChecks(arr2Size);    // checks if valid array size was inputted by user

        if (numCheck == false) {    // invalid array size so program is exited
            System.out.println("Please enter a valid array size (1-30)");
            System.exit(0);
        }
        
        int[] array2 = new int[arr2Size];  // declares array2 with user given size

        for (int i = 0; i < arr2Size; i++) {    // for length of array2 get user inputted nums for array values
            System.out.println(ARR_NUM_PROMPT); // prints prompt
            int temp = scan.nextInt();          // gets user inputted num for array
            array2[i] = temp;                   // assigns nums to array2
        }
        // prints array2
        System.out.print("Array 2: ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println(" ");    // adds new line
        // array2 got

        // bubbleSort array1
        array1 = jvLibrary.bubbleSort(array1);    // bubbleSorts array1
        // prints sorted array1
        System.out.print("Array 1 sorted with bubbleSort: ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println(" ");    // adds new line
        // bubbleSort array1 done

        // selectionSort array2
        array2 = jvLibrary.selectionSort(array2); // selectionSorts array2
        // prints sorted array2
        System.out.print("Array 2 sorted with selectionSort: ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println(" ");    // adds new line
        // selectionSort array2 done

        // merge arrays
        int[] arrayM = new int[array1.length + array2.length - 1];  // creates merged array with size of sum of both user arrays
        arrayM = jvLibrary.merge(array1, array2);   // merges and sorts array1 and array2 into arrayM
        // prints sorted merged array
        System.out.print("Merged array: ");
        for (int i = 0; i < arrayM.length; i++) {
            System.out.print(arrayM[i] + " ");
        }
        System.out.println(" ");    // adds new line
        // merge arrays done

        // binarySearch with random target
        int targetIndex = jvLibrary.binarySearch(arrayM); // binary searches for target and assigns index to variable
        if (targetIndex == -1) {    // error with binary search
            System.out.println("Error with binary search, please try again.");
            System.exit(0);
        } else {    // binary search succeeded
            System.out.println("The target was found at the index of: " + targetIndex); // prints out target index
        }

        scan.close();   // closes scanner
    }
}
