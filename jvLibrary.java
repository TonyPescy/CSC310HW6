// imports 
import java.util.Random;

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

    // merge sort
    // Receives both arrays
    // merges and sorts combined array in ascending order
    // returns merged and sorted array
    public static int[] merge(int[] arr1, int[] arr2) {
        // initializes counts for both user arrays and the new mergedArr
        int count1 = 0; 
        int count2 = 0;
        int countM = 0;
        // lengths for both user arrays
        int len1 = arr1.length - 1;
        int len2 = arr2.length - 1; 
        // declares array that will be able to hold merged array
        int[] mergedArr = new int[arr1.length + arr2.length - 1];

        while ((count1 < len1) && (count2 < len2)) {    // builds mergedArr in ascending order until arr1 or arr2 has been fully added
            
            if (arr1[count1] < arr2[count2]) {      // if arr1 has smaller number
                mergedArr[countM] = arr1[count1];   // assigns smaller number to new arr
                count1 += 1;    // increments arr1 counter
                countM += 1;    // moves count for merged array to next array position

            } else if (arr2[count2] < arr1[count1]) {   // if arr2 has smaller number
                mergedArr[countM] = arr2[count2];   // assigns smaller number to new arr
                count2 += 1;    // increments arr2 counter
                countM += 1;    // moves count for merged array to next array position

            } else {            // only if both positions in user arrays are equal
                mergedArr[countM] = arr2[count2];   // assigns number to new arr
                countM += 1;                        // increments merged array counter to prevent overwriting
                mergedArr[countM] = arr1[count1];   // assigns number to new arr
                count2 += 1;    // increments arr2 counter
                count1 += 1;    // increments arr1 counter
                countM += 1;    // moves count for merged array to next array position
                
            }  
        }
        // checks what array was fully merged and merges the rest of the other array
        if (count1 == len1) {   // if arr1 was fully merged
            while (count2 <= len2) {    // until arr2 is fully merged
                mergedArr[countM] = arr2[count2]; // assigns number to new arr
                // increments counters
                count2 += 1;
                countM += 1;
            }
        } else if (count2 == len2) {   // if arr2 was fully merged
            while (count1 <= len1) {    // until arr1 is fully merged
                mergedArr[countM] = arr1[count1]; // assigns number to new arr
                // increments counters
                count1 += 1;
                countM += 1;
            }
        }
        // returns merged andf sorted array
        return mergedArr;
    }

    // random array target
    // selects psuedo-random number in array
    // returns psuedo-random number from array
    public static int randomArrTarget(int[] arr) {
        Random rand = new Random(); // creates new random object

        int randIndex = rand.nextInt(arr.length); // generates random positive number up to size of arr
        int randTarget = arr[randIndex];    // uses random index to get the random target

        return randTarget; // returns random target
    }

    // binary search
    // gets random target in array
    // searches for random target using binary search
    // returns array index of target
    public static int binarySearch(int[] arr) {
        // random target
        int randomTarget = randomArrTarget(arr);   // gets random target for array
        System.out.println("The random target is: " + randomTarget);
        // random target done

        // high, low, and mid pointers initialized or declared
        int high = (arr.length - 1);
        int low = 0;
        int mid = -1;

        // binary search
        while (low <= high) {   // until low and high meet
            mid = low + (high - low) / 2;   // finds midpoint of arr

            if (arr[mid] == randomTarget) { // if target is at current midpoint
                break;     // breaks loop as target was found at current midpoint

            } else if (arr[mid] < randomTarget) {   // midpoint is less than the target, target must be in the upper half
                low = mid + 1;  // updates low pointer

            } else {    // midpoint is more than the target, target must be in lower half
                high = mid - 1;    // updates high pointer
            }
        }
        return mid; // returns index where target was found, else it will return -1
    }
}