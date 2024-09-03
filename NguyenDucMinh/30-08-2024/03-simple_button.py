#--------------------------------------------------------------------#
#
# Simple Button
#
# As an example of a button which does something (but not very much!),
# this program creates a GUI which writes to the shell window each
# time a button is pressed.
#

# Import the Tkinter API
from tkinter import *

# Create a window
my_window = Tk()

# Change title
my_window.title('My Window')

# Create a label
my_label = Label(my_window, text = ' Hello ',
                 font = ('Arial', 45), bg = 'light green')

# The action to do when the button is pushed
def print_message():
    print('Ouch!')

# Create a button
my_button = Button(my_window, text = 'Hit me!',
                   command = print_message)

# Pack the widgets into the window
my_label.pack()
my_button.pack(pady = 5) #padding y = vertical padding

# Start event loop
my_window.mainloop()
