#----------------------------------------------------------------
#
# Grid demo
#
# A simple demonstration of using the grid manager to
# arrange several widgets into a particular pattern
# (adapted from Y. Liang, "Introduction to Programming
# using Python")
#

# Import the Tkinter functions
from tkinter import *

# Create a window
grid_window = Tk()

# Define a common font for all the widgets
demo_font = ('Arial', 28)

# Give the window a title
grid_window.title('3x3 Grid Demo')

# Create a text message in the first column, spanning all three rows
message = Message(grid_window, font = demo_font,
                  text = "Enter your name, but don't expect much of a response!")
message.grid(row = 1, column = 1, rowspan = 3)

# Put two labels in the second column, in rows 1 and 2
first_name_label = Label(grid_window, text = 'First name:', font = demo_font)
first_name_label.grid(row = 1, column = 2)

surname_label = Label(grid_window, text = '   Surname:', font = demo_font)
surname_label.grid(row = 2, column = 2)

# Put two text entry boxes in the third column, in rows 1 and 2,
# with the first box being the "focus" when the window is selected
first_name_entry = Entry(grid_window, width = 10, font = demo_font)
first_name_entry.grid(row = 1, column = 3, padx = 5)
first_name_entry.focus()

surname_entry = Entry(grid_window, width = 10, font = demo_font)
surname_entry.grid(row = 2, column = 3, padx = 5)

# Put a button in the third row of column 3, sticking to the east side
done_button = Button(grid_window, text = ' Done ',
                     activeforeground = 'red',
                     font = demo_font, takefocus = False)
done_button.grid(row = 3, column = 3)

# Start the event loop (although this code doesn't react to
# any events)
grid_window.mainloop()
