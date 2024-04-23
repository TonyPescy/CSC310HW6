# imports
# Python does not have built-in support for Arrays, but Python Lists can be used instead.
import py_library as lib

if __name__ == '__main__':

    # array 1
    # gets array size from user
    arr_1_size = input(lib.ARR_1_PROMPT)
    # checks to see if array size entered was valid
    lib.arr_num_checks(arr_1_size, 0)
    arr_1_size = int(arr_1_size)
    # populates arr_1 with user inputs
    arr_1 = lib.get_arr_nums(arr_1_size)
    # prints user inputs
    print("Array 1 = " + str(arr_1))

    # array 2
    # gets array size from user
    arr_2_size = input(lib.ARR_2_PROMPT)
    # checks to see if array size entered was valid
    lib.arr_num_checks(arr_2_size, 0)
    arr_2_size = int(arr_2_size)
    # populates arr_2 with user inputs
    arr_2 = lib.get_arr_nums(arr_2_size)
    # prints user inputs
    print("Array 2 = " + str(arr_2))

    # bubble sort first array
    arr_1 = lib.bubble_sort(arr_1)
    print("Array 1 sorted in ascending order using bubble sort: " + str(arr_1))

    # selection sort second array
    arr_2 = lib.selection_sort(arr_2)
    print("Array 2 sorted in ascending order using selection sort: " + str(arr_2))

    # merge arrays
    arr_3 = lib.merge(arr_1, arr_2)
    print("Array 1 and array 2 merged to make array 3, which is merged and sorted in ascending order using merge: " + str(arr_3))

    # binary search with random target
    target_ind = lib.binary_search(arr_3)
    print("The target was found at the index of: " + str(target_ind))