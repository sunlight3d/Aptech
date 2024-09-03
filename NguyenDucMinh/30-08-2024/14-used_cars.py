#----------------------------------------------------------------
#
# Used Cars
#
# Here we develop a complete "IT System" that combines a file
# back end with a GUI front end.  It provides a convenient way
# for users to search for used cars within a particular price
# range and of a particular make.
#
# NB: You need to have the files "car_details.csv" and
# "used_cars.gif" in the same folder to run this demo.
#
#
# Examples
#
# 1) Searching for a HOLDEN between $1000 and $3000 produces:
#    
#    16935: KINGSWOOD, $2924
#    16934: KINGSWOOD, $2476
#    16930: KINGSWOOD, $2045
#    17795: TORANA, $2895
#    17792: TORANA, $2538
#
# 2) Searching for a FORD between $2000 and $12000 produces:
# 
#    16107: CAPRI, $2950
#    16635: FAIRLANE, $4528
#    16767: FALCON, $3096
#    16477: CORTINA, $4919
#    16755: FALCON, $5790
#    16669: FAIRMONT, $8777
#    16587: ESCORT, $5840
#    16476: CORTINA, $6210
#    16718: FALCON, $8821
#    16475: CORTINA, $11411
#    16743: FALCON, $9780
#    17129: LASER, $8710
#    17104: LASER, $8056
#    16750: FALCON, $11672
#    17140: LASER, $7315
#    17744: TELSTAR, $10853
#    17139: LASER, $8636
#    17151: LASER, $10188
#    17106: LASER, $10983
#    17116: LASER, $9352
#
# 3) Searching for a VOLKSWAGEN between $1000 and $1500
#    produces nothing.  (The cheapest is $2059.)
#


#----------------------------------------------------------------

# Import the Tkinter functions
from tkinter import *


#----------------------------------------------------------------
#
# The back end function which searches the CSV file.  (We
# bind this function to a keyboard character below which obliges
# us to have an "event" parameter, which can be used to access
# the widget that called this function, however we don't use this
# capability here.)
#
def get_cars(event = None):
    # Get the user's preferences (with the make in uppercase)
    make_wanted = preferred_make.get().upper()
    minimum = int(min_price.get())
    maximum = int(max_price.get())
    # Open the comma-separated-values file
    car_details = open('car_details.csv')
    # Search the file for used cars that meet the user's requirements
    results = []
    for car in car_details:
        fields = car.split(',') # Split the comma-separated fields
        carId, make, model, price = fields[0], fields[1], fields[2], fields[4]
        if (make == make_wanted) and (minimum <= int(price) <= maximum):
            results.append(carId + ': ' + model + ', $' + price + '\n')
    # Display the results, if any, in the text box
    results_text.delete(0.0, END)
    if len(results) == 0:
        results_text.insert(END, 'No matches found.')
    else:
        results_text.insert(END, 'Matching ' + make_wanted + 's found...\n')
        for result in results:
            results_text.insert(END, result)
    # Close the file
    car_details.close()


#----------------------------------------------------------------
#
# The front end main program which creates the GUI.
#
# Create a window
used_cars = Tk()

# Give the window a title
used_cars.title('Used Car Search')

# Create the "used car sale" image
sale_image = PhotoImage(file = 'used_cars.gif')
Label(used_cars, image = sale_image).\
                 grid(row = 0, column = 0, rowspan = 5)

# Create a text field to display the results (NB: On a Mac this
# text box allows vertical scrolling with the mouse wheel by
# default)
results_text = Text(used_cars, width = 26, height = 8,
                    wrap = WORD, bg = 'light grey', font = ('Arial', 18),
                    borderwidth = 2, relief = 'groove',
                    takefocus = False)
results_text.grid(row = 0, column = 1, columnspan = 2, padx = 5, pady = 5)

# Create labels for the three text entry fields
Label(used_cars, text = 'Minimum price:', font = ('Arial', 20)).\
    grid(row = 1, column = 1, sticky = E)

Label(used_cars, text = 'Maximum price:', font = ('Arial', 20)).\
    grid(row = 2, column = 1, sticky = E)

Label(used_cars, text = 'Preferred make:', font = ('Arial', 20)).\
    grid(row = 3, column = 1, sticky = E)

# Create a text entry field for the minimum price, with the
# text in the box preselected for replacement whenever the text
# entry field is made the "focus", and with this field being
# the initial focus when the window is first selected
min_price = Entry(used_cars, font = ('Courier', 20), justify = RIGHT, width = 10)
min_price.grid(row = 1, column = 2, padx = 5, sticky = W)
min_price.selection_range(0, END)
min_price.focus()

# Create a text entry field for the maximum price, with
# the text in the field preselected for replacement
max_price = Entry(used_cars, font = ('Courier', 20), justify = RIGHT, width = 10)
max_price.grid(row = 2, column = 2, padx = 5, sticky = W)
max_price.selection_range(0, END)

# Create a text entry field for the preferred make, with
# the text in the field preselected for replacement
preferred_make = Entry(used_cars, font = ('Courier', 20), justify = RIGHT, width = 10)
preferred_make.grid(row = 3, column = 2, padx = 5, sticky = W)
preferred_make.selection_range(0, END)

# Create a button to start the search
Button(used_cars, text = ' Search ', font = ('Arial', 20),
       activeforeground = 'red',
       takefocus = False, command = get_cars).\
    grid(row = 4, column = 1, columnspan = 2, pady = 5)

# Allow users to start the search by typing a carriage return
used_cars.bind('<Return>', get_cars)

# Start the event loop
used_cars.mainloop()
