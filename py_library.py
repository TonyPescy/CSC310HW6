# imports
import sys

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