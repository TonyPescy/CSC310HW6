// imports 

// library of methods for java implementation of hw6
public class jvLibrary {
    
    // arrNumChecks
    // checks to see if user input was a valid number for array size
    // returns true if numbers are valid, else will exit program
    public static boolean arrNumChecks(int x) {
        // checks if valid size of array was inputted
        if (0 < x || x < 30) {
            return true;
        } else {    // if size of array was too large
            return false;
        }
    }

    // bubble sort
    // receives first array
    // array sorted in ascending order using bubble sort
    // returns array
    public static int[] bubbleSort(int[] arr) {
        int temp;                           // declares temp variable
        int length = arr.length; // initializes length as arrays length

        for (int i = 0; i < length - 1; i++) {    // accesses every element in array
            boolean swap = false;            // initializes swap to false

            for (int j = 0; j < length - i - 1; j++) {    // loop to compare elements

                    if (arr[j] > arr[j + 1]) {      // compares adjacent values
                        // swaps elements
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swap = true;
                    }
            }

            if (!swap) {
                break;
            }
        }
        return arr; // returns sorted array
    }

    // selection sort 
    // receives second array 
    // array sorted in ascending order using selection sort
    // returns array
    public static int[] selectionSort(int[] arr) {
        int minIndex;   // declares minimum index variable
        int temp;       // declares temp variable
        int length = arr.length; // initializes length as arrays length

        for (int i = 0; i < length - 1; i++) {  // First unsorted index is set as minimum index
            minIndex = i;

            for (int j = i + 1; j < length; j++) {  // loop for all other unsorted elements
                
                if (arr[j] < arr[minIndex]) {  // selects minimum index out of remaining unsorted elements
                    minIndex = j;
                }
            }
        // swaps elements
        temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
        }
        return arr; // returns sorted array
    }
}