
#-----Module Description - Data Set Generation-----------------------#
#
#  This module contains a function needed for Assignment 1 in
#  QUT's teaching unit IFB104 "Building IT Systems".  You should put
#  a copy of this file in the same folder as your solution to the
#  assignment.  The necessary element will then be imported
#  into your program automatically.
#
#  NB: Do NOT submit this file with your solution.  Changes made to
#  this module will have no effect when your assignment is graded
#  because the markers will use their own copy of the file.  If your
#  solution relies on changes made to this file it will fail to work
#  when assessed.
#
#--------------------------------------------------------------------#



#-----Preamble-------------------------------------------------------#
#
# This section imports necessary functions used for generating the
# data set.
#

# Import standard Python functions needed to support this module.
from random import randint, choice, seed, shuffle
from turtle import textinput
from re import sub

# A global variable used to ensure that the student doesn't call
# function "data_set" or "raw_data" in their code
already_called = False

#
#--------------------------------------------------------------------#



#-----Test Cases-----------------------------------------------------#
#
# Developing code when the underlying data set changes randomly can
# be difficult.  To help you develop your code you can temporarily
# provide the call to the data generation function at the bottom of
# the assignment template file with a "seed" value which will force
# it to produce a known data set.  Of course, having completed your
# solution, your program must work for any list that can be returned
# by calling the data generation function with no argument.
#
# You can use also enter seed values or test numbers by activating
# the "pop-up tester" below.  The markers will use this facility to
# test your solution efficiently.
#

# Each test contains a Test no., Seed and Description
test_cases = [
    # Some small data sets, useful for debugging your program
    [0, 79807, "Only one cell populated: I4, high"],
    [-1, 54413, "Only one cell populated: I4, low"],
    [-2, 11128, "Only one cell populated: I3, high"],
    [-3, 74493, "Cell I3 high and cell H3 low"],
    [-4, 77627, "Only two cells I4 and I3 populated, both low"],
    [-5, 47178, "Only three cells populated, all low"],
    [-6, 59331, "Only two cells populated, both high"],
    [-7, 75761, "Only two cells populated, one high and one low"],
    [-8, 70848, "Two high cells, one low (and one unchanged)"],
    [-9, 25330, "Three high cells, two low"],
    [-10, 1333,  "Four high and four low cells (no backtracking)"],
    [-11, 53301, "One high, two low, three unchanged"],
    [-12, 54984, "Four cells marked low (after one was reconsidered)"],
    [-13, 29492, "Four high cells and three low (and none revisited)"],
    [-14, 21147, "Five high cells and two low (after one was reconsidered)"],
    [-15, 72963, "Only high cells (eight in total)"],
    [-16, 76705, "Four high and three low (after revisiting several cells)"],
    # Big data sets that populate many cells and reach the map's edges
    [-17, 62697, "Cells are populated up to the right-hand edge of the map"],
    [-18, 78777, "Cells are populated up to the left-hand edge of the map"],
    [-19, 45011, "Cells are populated up to the top edge of the map"],
    [-20, 48527, "Cells are populated down to the bottom edge of the map"],
    [-21, 35289, "Cells are populated up into the top-right corner"],
    [-22, 72081, "Cells are populated up into the top-left corner"],
    [-23, 67917, "Cells are populated down into the bottom-left corner"],
    [-24, 70577, "Cells are populated down into the bottom-right corner"],
    [-25, 11224, "Many cells populated, including a hexagonal set of low cells"],
    # Data sets that produce isolated clusters of populated cells
    [-26, 45613, "Two clusters, one cell and two cells, respectively, all high"],
    [-27, 60137, "Two clusters, one cell and two cells, respectively"],
    [-28, 75155, "Two clusters, one in a curious V shape"],
    [-29, 58413, "Two clusters, three cells and eight, respectively"]
   ]

# For markers (or interested students): Set the following constant
# to True to enable the pop-up seed/test no. prompt.  Positive
# values entered are interpreted as seeds for the random number
# generator.  Zero or negative numbers are interpreted as one of the
# test cases listed above.  Any other values entered are ignored and
# a random seed is used instead.
pop_up_tester = False
           
#
#--------------------------------------------------------------------#


#-----Data Set Function for Assessing Your Solution------------------#
#
# The function in this section is called by the assignment template
# to generate the data sets used by your program. It creates a random
# data set defining the overall image to draw.  Your program must
# work for ANY data set that can be produced by this function.  The
# results returned by calling this function will be used as the
# argument to your data visualisation function during marking.  For
# convenience during code development and marking this function also
# prints the data set generated to the shell window.  NB: Your own
# solution should not print anything else to the shell.  Make sure
# any debugging calls to the "print" function are disabled before
# you submit your solution.

def raw_data(given_seed):

    # Confirm that this is the first time functions "data_set" or
    # "raw_data" have been called, otherwise abort the program
    global already_called
    assert not already_called, "Program attempts to create a second data set - Aborting!"
    already_called = True

    # Decide which seed to use
    if pop_up_tester:
        # Get the seed number from the user
        markers_choice = textinput('Seed or test case selection',
                                   'Enter seed or test case number')
        try:
            number_entered = int(markers_choice)
            if number_entered > 0:
                # Use the number entered as the seed
                chosen_seed = number_entered
                description = 'Manually-entered seed'
            else:
                # Get the seed from the list of test cases
                chosen_seed = test_cases[abs(number_entered)][1]
                description = test_cases[abs(number_entered)][2]
        except:
            # User's input is not a number or is not in the
            # range of test cases, so ignore it
            print('Invalid seed or test number ignored ...\n')
            chosen_seed = given_seed
            description = 'Randomly-chosen seed'            
    else:
        # Use the argument given to raw_data
        chosen_seed = given_seed
        description = 'Argument to function data_set'
    # Set the random number seed and inform the user
    print(f'Using seed {chosen_seed}\n({description}) ...\n')
    seed(chosen_seed)

    # Choose the starting cell, and initialise the data set
    # and movement limiters (assuming a 17 x 6 grid)
    if randint(0, 1) == 0:
        survey = [['Start in Cell I4', choice(['Mark Low', 'Mark High'])]]
        x_posn, y_posn = 9, 4
    else:
        survey = [['Start in Cell I3', choice(['Mark Low', 'Mark High'])]]
        x_posn, y_posn = 9, 3

    # Create a list of potential directions to move, biased
    # towards moving horizontally (since the grid is much
    # wider than high)
    directions = choice([['Go North', 'Go South', 'Go East'] + ['Go West'] * 3,
                         ['Go North', 'Go South', 'Go West'] + ['Go East'] * 3])
 
    # Create the individual moves and survey results
    for num_move in range(randint(0, 30)):
        # Choose a potential direction to move
        move = choice(directions)
        # Confirm that the move remains within the grid (assuming a
        # 17 x 6 grid)
        if (move == 'Go North' and y_posn < 6) or \
           (move == 'Go South' and y_posn > 1) or \
           (move == 'Go East' and x_posn < 17) or \
           (move == 'Go West' and x_posn > 1):
            # Decide how to mark the current cell, biased slightly
            # against not changing it
            survey_result = choice(['No Change'] + ['Mark Low', 'Mark High'] * 2)
            # Add the move and survey result to the data set
            survey.append([move, survey_result])
            # Update the movement limiters
            if move == 'Go North':
                y_posn = y_posn + 1
            elif move == 'Go South':
                y_posn = y_posn - 1
            elif move == 'Go East':
                x_posn = x_posn + 1
            else:
                x_posn = x_posn - 1

    # Print the whole data set to the shell window, laid out
    # one move per line
    print("The survey results to be visualised are:\n")
    print(str(survey).replace(' [', '\n [') + '\n')
    # Return the data set to the caller
    return survey

#
#--------------------------------------------------------------------#

