#----------------------------------------------------------------
#
# Display bits
#
# A simple demonstration of a Graphical User Interface
# which reacts to user inputs.  It creates two buttons which
# can be used to print binary strings.  (At this stage we
# are not trying to make our interface look nice.  We just
# want to get it to work.)
#

# Import the Tkinter functions
from tkinter import Tk, Button, END
from tkinter.scrolledtext import ScrolledText

# Create a window
the_window = Tk()

# Give the window a title
the_window.title('Binary numbers')

# Create a scrolling text field to display the button presses
display = ScrolledText(the_window, font = ('Arial', 24), width = 8,
                       height = 4, borderwidth = 2, relief = 'groove')

# Define the two functions to be called when the buttons are pressed
def display_zero():
    display.insert(END, '0') #append 0 to the end of ScrolledText(display)

def display_one():
    display.insert(END, '1')

# Create two button widgets, each associated with a
# different function
button_zero = Button(the_window, text = ' Zero ', font = ('Arial', 24),
                     activeforeground = 'green',
                     command = display_zero)
button_one = Button(the_window, text = ' One ', font = ('Arial', 24),
                    activeforeground = 'red',
                    command = display_one)

# Call the geometry manager to "pack" the widgets onto
# the window (using default settings for now)
display.pack()
button_zero.pack()
button_one.pack()

# Start the event loop to react to user inputs
the_window.mainloop()
