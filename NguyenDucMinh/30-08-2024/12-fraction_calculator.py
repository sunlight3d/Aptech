#-----------------------------------------------------------------
#
# Fraction Calculator
#
# As a demonstration of adding a user interface to a back-end
# function, here we will incrementally develop a small, but
# useful application.  The full code appears below, but in the
# demonstration we will develop it step-by-step as follows:
#
# 1. Create a function which calculates fractions and returns
#    the result either as a floating point number or a percentage
# 2. Create a window to hold the various widgets
# 3. Create two text entry widgets to allow the user to enter
#    the numerator and denominator
# 4. Create a button to initiate the computation
# 5. Define a function which does the calculation and displays
#    the result when the button is pushed
# 6. Create a checkbutton widget to allow the user to choose to
#    see the result as a percentage
# 7. Modify the code that calls the back_end function to
#    implement this feature
#
# The resulting program works if the user is well-behaved, but
# can be 'crashed' easily.  In a later topic we'll learn how
# to prevent this.  Also, the user interface is visually very
# plain and could be improved considerably.
#
# Exercise: Although the compute_fraction function allows the
# desired number of decimal places to be supplied as an
# argument, our GUI doesn't give the user any way of accessing
# this capability!  Add a widget and extend the calculate_and_display
# function so that the user can choose how many decimal places
# to display.  This could be done using any one of a number of
# widgets, e.g., a text entry box, some radio buttons, a spinbox
# or something else.
#

#-----------------------------------------------------------------
# This is the back-end function which calculates fractions and
# returns them as a character string, ready for printing
def compute_fraction(numerator, denominator,
                     percentage = False, decimal_places = 4):
    if percentage:
        result = round((numerator * 100) / denominator)
        return str(result) + '%'
    else:
        result = round(numerator / denominator, decimal_places)
        # Use a string "format specification" to limit the decimal places
        # (see the Python Library Reference manual for details)
        result_format = '{:.' + str(decimal_places) + 'f}'
        return result_format.format(result)

    
# Import the Tkinter functions
from tkinter import *


#-----------------------------------------------------------------
# This is the intermediate function which links the back-end
# function to the front-end widgets
#
def calculate_and_display():
    # Get the numerator and denominator from the text entry
    # widgets and evaluate them as integers
    numer = int(numerator.get())
    denom = int(denominator.get())
    # Call the back-end function to do the calculation
    if show_percentage.get():
        answer = compute_fraction(numer, denom, True)
    else:
        answer = compute_fraction(numer, denom)
    # Display the answer in the label
    result_display['text'] = '= ' + answer


#-----------------------------------------------------------------
# This is the front-end main program which creates a graphical
# interface to help the user apply the back-end function
#
# Create a window
calculator_window = Tk()

# Give the window a title
calculator_window.title('Fraction Calculator')

# Define a huge font for use in the various widgets
gui_font = ('Arial', 26)

# Create two text entry widgets for the numerator and denominator
# with a label in between
numerator = Entry(calculator_window, width = 4,
                  justify = RIGHT, font = gui_font)
division_sign = Label(calculator_window, text = '/',
                      font = gui_font)
denominator = Entry(calculator_window, width = 4,
                    justify = LEFT, font = gui_font)

# Put the widgets in the window
numerator.grid(row = 0, column = 0, pady = 5)
division_sign.grid(row = 0, column = 1, pady = 5)
denominator.grid(row = 0, column = 2, pady = 5)

# Create a label to display the result
result_display = Label(calculator_window, width = 9,
                       justify = LEFT, font = gui_font)
    
# Put the label in the window
result_display.grid(row = 1, column = 0, columnspan = 3)

# Create a button to start the computation
compute = Button(calculator_window, text = ' Calculate ',
                 font = gui_font, command = calculate_and_display)

# Put the button in the window
compute.grid(row = 2, column = 0, columnspan = 3, padx = 5)

# Define a Boolean GUI variable which tells us whether
# the user has selected the "percentage" checkbutton
show_percentage = BooleanVar(value = False)

# Create a checkbutton for choosing to see the results as
# a percentage
percentage_check = Checkbutton(calculator_window,
                               variable = show_percentage,
                               text = 'Display percentages')

# Put the checkbutton in the window, stuck to the left
# (western) border
percentage_check.grid(row = 3, column = 0, pady = 5,
                      columnspan = 3, sticky = W)

# Start the event loop
calculator_window.mainloop()
