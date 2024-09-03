#----------------------------------------------------------------
#
# Placement demo
#
# A simple demonstration of using the place manager to
# arrange several widgets into a particular pattern
# (adapted from Y. Liang, "Introduction to Programming
# using Python").
#
# Note that the precise appearance of this window will
# depend on your screen resolution, for which reason the
# place manager is best avoided unless you really need
# to put things at specific pixel locations.
#

# Import the Tkinter functions
from tkinter import *

# Create a window
place_window = Tk()

# Give the window a title
place_window.title('Placement Demo (coords are top-left corner)')

# Create three coloured widgets
red_label = Label(place_window, text = 'Red @ (20, 20)', bg = 'red',
                  width = 15, font = ('Arial', 24))
blue_label = Label(place_window, text = 'Blue @ (70, 50)', bg = 'blue',
                   fg = 'white', width = 15, font = ('Arial', 24))
green_label = Label(place_window, text = 'Green @ (120, 80)', bg = 'green',
                    width = 15, font = ('Arial', 24))

# Place the three rectangles diagonally across the window
red_label.place(x = 20, y = 20)
blue_label.place(x = 70, y = 50)
green_label.place(x = 120, y = 80)

# Since we're manually placing the widgets at particular locations
# of our choosing, we also need to manually set the window size
place_window.geometry('450x140')

# Start the event loop (although this code doesn't react to
# any events)
place_window.mainloop()
