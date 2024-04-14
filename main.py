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
    arr_1_inputs = lib.get_arr_nums(arr_1_size)
    # prints user inputs
    print("Array 1 = " + str(arr_1_inputs))

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

