#----------------------------------------------------------------
#
# Frustrating button
#
# A very simple demonstration of a Graphical User Interface
# created using Tkinter.  It creates a window with a label
# and a frustrating button that does nothing.
#

# Import the Tkinter functions
from tkinter import *

# Create a window
the_window = Tk()

# Give the window a title
the_window.title('Tk demo')

# Create a label widget (some fixed text) whose parent
# container is the window
the_label = Label(the_window, text = ' Frustration! ',
                  font = ('Arial', 32))

# Create a button widget whose parent container is the
# window (the button's text turns red when active)
the_button = Button(the_window, text = ' Push me ',
                    activeforeground = 'red',
                    font = ('Arial', 28))

# Call the geometry manager to "pack" the widgets onto
# the window (using default settings for now)
the_label.pack()
the_button.pack()

# Start the event loop to react to user inputs (in this
# case by doing nothing at all)
the_window.mainloop()
