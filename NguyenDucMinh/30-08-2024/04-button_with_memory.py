#--------------------------------------------------------------------#
#
# Simple GUI with memory
#
# As a (slightly) more realistic example, here we create a GUI which
# uses a global variable to remember how many times a button has been
# pushed.
#

#button with memory -> change state

# Import the Tkinter API
from tkinter import *

# Create the GUI window
gui = Tk()

# Give the window a name
gui.title('Count button pushes')

# Change the window's colour
gui['bg'] = 'yellow' #dictionary in python


#personA['name'] = 'Nguyen Duc Minh'
#personA['age'] = 18
# Create counter
counter = 0

# Create a label widget 
our_label = Label(gui, text = '0',
                  font = ('Arial', 36),
                  bg = 'light green')

# Function called when button is pressed
def button_pressed():
    global counter
    #counter = counter + 1
    counter += 1
    our_label['text'] = counter

def button_increased():
    global counter
    #counter = counter + 1
    counter -= 1
    our_label['text'] = counter

def button_reset():
    global counter
    #counter = counter + 1
    counter = 0
    our_label['text'] = counter        
# Create a button
my_button = Button(gui, text = ' Increase ',
                   command = button_pressed,
                   font = ('Arial', 30),
                   highlightbackground = 'yellow')

decrease_button = Button(gui, text = ' Decrease ',
                   command = button_increased,
                   font = ('Arial', 30),
                   highlightbackground = 'red')


reset_button = Button(gui, text = ' Reset ',
                   command = button_reset,
                   font = ('Arial', 30),
                   highlightbackground = 'green')


# Pack the widgets into the window
our_label.pack(padx = 5, pady = 10)
my_button.pack(padx = 5, pady = 3)
reset_button.pack(padx = 5, pady = 3)
decrease_button.pack(padx = 5, pady = 3)
# Start the event loop
gui.mainloop()

