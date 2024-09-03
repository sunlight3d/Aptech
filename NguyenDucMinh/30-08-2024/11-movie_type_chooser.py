#----------------------------------------------------------------
#
# Movie type chooser
#
# A GUI that uses variables to remember the check buttons
# selected by the user and displays the choices in a text
# box (adapted from an example in M. Dawson, "Python
# Programming for the Absolute Beginner").
#
# In this version we've made the buttons look like push
# buttons (by setting the "indicatoron" attribute) because
# this is more visible in recent versions of Apple macOS.
#

# Import the Tkinter functions
from tkinter import *

# Create a window
movie_window = Tk()

# Give the window a title
movie_window.title('Movie Chooser')

# Define a font to use for all the widgets
movie_font = ('Arial', 28)

# Introduce four Boolean GUI variables to keep track of the user's
# choices
likes_comedy = BooleanVar()
likes_drama = BooleanVar()
likes_romance = BooleanVar()
likes_action = BooleanVar()

# Function to update the text
def update_text():
    # Extract the user's likes from the button variables
    users_likes = [likes_comedy.get(), likes_drama.get(), \
                   likes_romance.get(), likes_action.get()]
    # Clear the text box
    results_text.delete(0.0, END)
    # Display the user's preferences
    if not True in users_likes:
        results_text.insert(0.0, "You don't like any kinds of movie.")
    else:
        if users_likes[0]:
            results_text.insert(END, "You like comedic movies. ")
        if users_likes[1]:
            results_text.insert(END, "You like dramatic movies. ")
        if users_likes[2]:
            results_text.insert(END, "You like romantic movies. ")
        if users_likes[3]:
            results_text.insert(END, "You like action-packed movies. ")

# Create a label containing instructions - Since the label
# never changes, and is never accessed again, we do not assign
# it to a variable
Label(movie_window, text = 'Choose your favourite movie types:',
       font = movie_font).grid(row = 0, column = 0, sticky = W)

# Create four check buttons, all "sticking" to the West margin,
# and each linked to one of the variables
Checkbutton(movie_window, text = 'Comedy',
            indicatoron = False, borderwidth = 5, width = 10,
            variable = likes_comedy, font = movie_font,
            command = update_text).grid(row = 1, column = 0, padx = 8, sticky = W)

Checkbutton(movie_window, text = 'Drama',
            indicatoron = False, borderwidth = 5, width = 10,
            variable = likes_drama, font = movie_font,
            command = update_text).grid(row = 2, column = 0, padx = 8, sticky = W)

Checkbutton(movie_window, text = 'Romance',
            indicatoron = False, borderwidth = 5, width = 10,
            variable = likes_romance, font = movie_font,
            command = update_text).grid(row = 3, column = 0, padx = 8, sticky = W)

Checkbutton(movie_window, text = 'Action',
            indicatoron = False, borderwidth = 5, width = 10,
            variable = likes_action, font = movie_font,
            command = update_text).grid(row = 4, column = 0, padx = 8, sticky = W)

# Create a text field in which to display the user's choices
results_text = Text(movie_window, width = 40, height = 5,
                    wrap = WORD, bg = 'yellow', font = movie_font,
                    borderwidth = 2, relief = 'groove')
results_text.grid(row = 5, column = 0, sticky = W)

# Start the event loop
movie_window.mainloop()
