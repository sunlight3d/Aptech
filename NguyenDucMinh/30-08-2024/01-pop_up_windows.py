#----------------------------------------------------------------
#
# Pop-Up Windows
#
# A simple demonstration of a GUI window that creates
# other GUI windows recursively.
#

# Import the Tkinter functions
from tkinter import *

# Keep track of the current window number
window_num = 0


#-----
# A function to create a new window when the button in the
# root window is pressed
#
def button_pressed():

    # Create a new 'top level' window on the screen
    new_window = Toplevel()

    # Give the window a title containing its number
    global window_num
    window_num = window_num + 1
    new_window.title('Window ' + str(window_num))

    # Add the image 
    Label(new_window, image = pop_up_image).pack()

    # Create a button widget whose parent container is the
    # new window
    Button(new_window, text = 'Try again!',
           font = ('Arial', 24),
           command = button_pressed).pack()

    # Start the new window's event loop
    new_window.mainloop()



#-----
# This is the main program which begins the process by
# creating the root window
#
root_window = Tk()

# Import an image to display in the windows
pop_up_image = PhotoImage(file = 'pop_up.gif')

# Add the image to the root window as a Label widget
Label(root_window, image = pop_up_image).pack()

# Define the root window's title
root_window.title('Pop-Ups!')

# Create a button widget in the root window
Button(root_window, text = "Press me!",
       font = ('Arial', 24),
       command = button_pressed).pack()

# Start the root window's event loop
root_window.mainloop()

