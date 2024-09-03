#--------------------------------------------------------------------#
#
# Simple listbox demo
#
# As an example of how multiple widgets can be made to work together
# to get a job done, here we use a listbox widget and a button
# together to let the user choose what text to display in a label.
#

# Import relevant features from the Tkinter API
from tkinter import Tk, Text, Button, Listbox, Label, END

# Create a window
window = Tk()
window.geometry()

# Give the window a title
window.title('Listbox demonstration')

# Create a label widget with big text
display = Label(window, font = ('Arial', 48),
                width = 6,
                fg = 'dark red', text = '---')

# Create a listbox widget with three options
choices = Listbox(window, height = 3, width = 7,
                  font = ('Arial', 32))
choices.insert(END, 'Alpha')
choices.insert(END, 'Beta')
choices.insert(END, 'Gamma')

# Function to display the user's choice in the label
def display_choice():
    users_choice = choices.curselection()
    to_display = choices.get(users_choice)
    display['text'] = to_display

# Create a button to push when the user is happy with their choice
choose = Button(window, text = ' Display ',
                fg = 'blue', font = ('Arial', 32),
                command = display_choice)

# Use the geometry manager to "pack" the widgets onto
# the window (with a margin around the widgets for neatness)
margin_size = 5
display.pack(padx = margin_size, pady = margin_size)
choices.pack(padx = margin_size, pady = margin_size)
choose.pack(pady = margin_size)

# Start the event loop to react to user inputs
window.mainloop()
