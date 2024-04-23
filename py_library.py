# imports
import sys
import random

# prompts
ARR_1_PROMPT = "Please enter the size of the 1st array (max 30): "
ARR_2_PROMPT = "Please enter the size of the 2nd array (max 30): "

# arr_num_checks
# checks to see if user input was a valid number for array size
# returns true if numbers are valid, else will exit program
def arr_num_checks(input, case):
    # checks if input was a number
    try:
        x = int(input)
    except ValueError as e:
        print(e)
        print("Please try again!")
        sys.exit(0)

    # case that is called when function is used for the array size checker
    if case == 0:       
        if 0 > x or x > 31:  # checks if array size was inputted as less than 0 or greater than 30
            print("Array size is invalid, please enter a number from 1-30 inclusive.")
            sys.exit(0)
        else:           # valid array size number
            return True
        
    # case that is called when function is used for the numnbers of the array
    if case == 1:
        return True

# get_arr_nums
# gets all inputs from user for their arrays
# returns the filled array
def get_arr_nums(size):
    arr = []
    # gets inputs for full size of array
    for i in range(size):
        valid_num = False
        while valid_num == False:
            temp = input("Please enter a number for your array: ")
            # checks if input is a number
            if arr_num_checks(temp, 1) == True:
                arr.append(temp)
                valid_num = True    # breaks while loop
        continue
    return arr

# bubble sort
# receives first array 
# array sorted in ascending order using bubble sort
# returns array
def bubble_sort(arr):

    # fixes any confusion with numbers being read as strings
    arr = [int(x) for x in arr]

    # loop to access every element
    for i in range(len(arr)):
        swap = False

        # loop to compare elements
        for j in range(0, len(arr) - i - 1):

            # compare the adjacent values
            if arr[j] > arr[j + 1]:
                    # swaps elements
                    temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                    swap = True
        
        if not swap:
            break
    # returns array to be printed and/or used in main
    return arr

# selection sort 
# receives second array 
# array sorted in ascending order using selection sort
# returns array
def selection_sort(arr):  

    # ensures all values of arr are interpreted as ints
    arr = [int(x) for x in arr]

    # first unsorted element is set as minimum index
    for i in range(len(arr)):
        min_index = i

        # loop for all other unsorted elements
        for j in range(i + 1, len(arr)):
            
            # selects minimum index out of remaining unnsorted elements
            if arr[j] < arr[min_index]:
                min_index = j

        # swaps elements
        temp = arr[i]
        arr[i] = arr[min_index]
        arr[min_index] = temp
    # returns sorted array
    return arr

# merge sort
# Receives both arrays
# merges and sorts combined array in ascending order
# returns merged and sorted array
def merge(arr_1, arr_2):
    # counts used to select the index of the user's arrays
    count_1 = 0
    count_2 = 0
    # lengths of user arrays - 1 for use with array indexes
    len_arr_1 = len(arr_1) - 1
    len_arr_2 = len(arr_2) - 1
    # empty array for appending to
    arr_3 = []
    # ensures all values of arr are interpreted as ints
    arr_1 = [int(x) for x in arr_1]
    arr_2 = [int(x) for x in arr_2]

    # builds arr_3 in ascending order until one of the arrays have been fully added to arr_3
    while (count_1 < len_arr_1) and (count_2 < len_arr_2):
        # arr_1 has the smaller number
        if arr_1[count_1] < arr_2[count_2]:
            # appends to arr_3 and increments arr_1 counter
            arr_3.append(arr_1[count_1])
            count_1 += 1
        # arr_2 has smaller number
        elif arr_2[count_2] < arr_1[count_1]:
            # appends to arr_3 and increments arr_2 counter
            arr_3.append(arr_2[count_2])
            count_2 += 1
        # both elements of both arrays are equivalent so both are appended and counters incremented
        else:
            arr_3.append(arr_1[count_1])
            arr_3.append(arr_2[count_2])
            count_1 += 1
            count_2 += 1

    # checks to see what array was fully appended
    if (count_1 == len_arr_1):
        # fills rest of arr_3 with rest arr_2
        while (count_2 <= len_arr_2):
            arr_3.append(arr_2[count_2])
            count_2 += 1
    elif (count_2 == len_arr_2):
        # fills rest of arr_3 with rest arr_1
        while (count_1 <= len_arr_1):
            arr_3.append(arr_1[count_1])
            count_1 += 1
    # returns merged arr_3 sorted in ascending order
    return arr_3

# random array target
# selects psuedo-random number in array
# returns psuedo-random number from array
def rand_arr_tar(arr):
    # seed
    random.seed()
    # gets random index for array
    rand_index = random.randint(0, len(arr) - 1)
    
    rand_target = arr[rand_index]
    # returns random target from array
    return rand_target

# binary search
# gets random target in array
# searches for random target using binary search
# returns array index of target
def binary_search(arr):
    # generated random target
    target = int(rand_arr_tar(arr))
    print("The random target is: " + str(target))
    # high and low pointers
    high = int(len(arr) - 1)
    low = 0

    # binary search
    # repeats until low and high meet
    while low <= high:
        # finds midpoint of array
        mid = low + (high - low) // 2
        # if target is at current midpoint, returns index of target
        if arr[mid] == target:
            return mid
        # the midpoint is less than the target, target must be in upper half
        elif arr[mid] < target:
            low = mid + 1
        # the midpoint is more than the target, target must be in lower half
        else:
            high = mid - 1