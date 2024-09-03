
#-----Statement of Authorship----------------------------------------#
#
#  This is an individual assessment task for QUT's teaching unit
#  IFB104, "Building IT Systems", Semester 2, 2024.  By submitting
#  this code I agree that it represents my own work.  I am aware of
#  the University rule that a student must not act in a manner
#  which constitutes academic dishonesty as stated and explained
#  in QUT's Manual of Policies and Procedures, Section C/5.3
#  "Academic Integrity" and Section E/2.1 "Student Code of Conduct".
#
#  Put your student number here as an integer and your name as a
#  character string:
#
student_number = 12040339
student_name   = 'Minh Duc Nguyen'
#
#  NB: All files submitted for this assessable task will be subjected
#  to automated plagiarism analysis using a tool such as the Measure
#  of Software Similarity (http://theory.stanford.edu/~aiken/moss/).
#
#--------------------------------------------------------------------#



#-----Assessment Task 1 Description----------------------------------#
#
#  This assessment task tests your skills at processing large data
#  sets, creating reusable code and following instructions to display
#  a complex visual image.  The incomplete Python program below is
#  missing a crucial function.  You are required to complete this
#  function so that when the program runs it fills a grid with various
#  symbols, using data stored in a list to determine which symbols to
#  draw and where.  See the online video instructions for
#  full details.
#
#  Note that this assessable assignment is in multiple parts,
#  simulating incremental release of instructions by a paying
#  "client".  This single template file will be used for all parts
#  and you will submit your final solution as this single Python 3
#  file only, whether or not you complete all requirements for the
#  assignment.
#
#  This file relies on other Python modules but all of your code
#  must appear in this file only.  You may not change any of the code
#  in the other modules and you should not submit the other modules
#  with your solution.  The markers will use their own copies of the
#  other modules to test your code, so your solution will not work
#  if it relies on changes made to any other files.
#
#--------------------------------------------------------------------#  



#-----Preamble-------------------------------------------------------#
#
# This section imports necessary functions used to execute your code.
# You must NOT change any of the code in this section, and you may
# NOT import any non-standard Python modules that need to be
# downloaded and installed separately.
#

# Import standard Python modules needed to complete this assignment.
# You should not need to use any other modules for your solution.
# In particular, your solution must NOT rely on any non-standard
# Python modules that need to be downloaded and installed separately,
# because the markers will not have access to such modules.
from turtle import *
from math import *
from random import *
from sys import exit as abort
from os.path import isfile

# Confirm that the student has declared their authorship
if not isinstance(student_number, int):
    print('\nUnable to run: No student number supplied',
          '(must be an integer), aborting!\n')
    abort()
if not isinstance(student_name, str):
    print('\nUnable to run: No student name supplied',
          '(must be a character string), aborting!\n')
    abort()

# Import the functions for setting up the drawing canvas
config_file = 'assignment_1_config.py'
if isfile(config_file):
    print('\nConfiguration module found ...\n')
    from assignment_1_config import *
else:
    print(f"\nCannot find file '{config_file}', aborting!\n")
    abort()

# Define the function for generating data sets in Task 1B,
# using the imported raw data generation function if available,
# but otherwise creating a dummy function that just returns an
# empty list
data_file = 'assignment_1_data.py'
if isfile(data_file):
    print('Data generation module found ...\n')
    from assignment_1_data import raw_data
    def data_set(new_seed = randint(0, 99999)):
        return raw_data(new_seed) # return the random data set
else:
    print('No data generation module available ...\n')
    def data_set(dummy_parameter = None):
        return []

#
#--------------------------------------------------------------------#



#-----Student's Solution---------------------------------------------#
#
#  Complete the assignment by replacing the dummy function below with
#  your own function and any other functions needed to support it.
#  All of your solution code must appear in this section.  Do NOT put
#  any of your code in any other sections and do NOT change any of
#  the provided code except as allowed by the comments in the next
#  section.
#

# All of your code goes in, or is called from, this function.
# In Task 1B ensure that your code does NOT call functions data_set
# or raw_data because they're already called in the main program
# below.
#rename_me_in_task_1b
#def visualise_data(rename_me_in_task_1b):
    #pass # <--- Replace this statement with your solution

def visualise_data(data):
    pass # <--- Replace this statement with your solution
def visualise_data1(data):            
    def draw_triangle(size):      
        pendown()       
        start_position = pos()    
        begin_fill()
        forward(size)
        left(-120)
        forward(size)        
        left(-120)        
        forward(size)
        end_fill()
        penup()                
        height = (size * 3**0.5) / 2
        goto(start_position)
        forward(-size / 2)  # Di chuyển đến giữa cạnh đáy
        left(90)  # Quay vuông góc với cạnh đáy

        # Di chuyển đến gần trung tâm của tam giác, nhưng một chút sang trái
        forward(-height / 3)  # Di chuyển đến gần tâm tam giác        
    
        setheading(0)
        pendown()
        pencolor('black')
        fillcolor('blue')
        
        # Bắt đầu vẽ vật thể và áp dụng scale factor
        scale_factor = 0.2
        begin_fill()
        right(45)
        forward(50 * scale_factor)
        left(45)
        forward(70 * scale_factor)
        left(45)
        forward(50 * scale_factor)
        left(135)
        forward(140 * scale_factor)
        end_fill()
        penup()

        # Vẽ phần thân dưới của vật thể
        backward(50 * scale_factor)
        right(45)
        setheading(90)
        pendown()
        fillcolor('black')
        begin_fill()
        forward(70 * scale_factor)
        right(90)
        forward(5 * scale_factor)
        right(90)
        forward(70 * scale_factor)
        end_fill()
        penup()

        # Vẽ một phần bổ sung của vật thể
        pendown()
        pencolor('black')
        fillcolor('grey')
        begin_fill()
        forward(-20 * scale_factor)
        right(90)
        forward(60 * scale_factor)
        right(140)
        forward(80 * scale_factor)
        end_fill()
        penup()

        # Trở về vị trí bắt đầu
        backward(50 * scale_factor)  # Adjust the position
        setheading(0)   
        backward(size * 0.4)  # Đặt vị trí ở giữa cạnh đáy của tam giác                    
    pencolor('black')
    goto(cell_width * 3.5, 1.5*cell_height)    
    color('black', 'pink') 
    draw_triangle(cell_width)    

    goto(10 + cell_width * 5, 0.5*cell_height)    
    left(180)    
    color('black', 'pink') 
    draw_triangle(cell_width)
    
    
    goto(cell_width * 3.5, -0.5*cell_height)
    left(0)    
    color('black', 'red') 
    draw_triangle(cell_width)

    goto(10 + cell_width * 5, -1.5*cell_height)
    left(+180)    
    color('black', 'red') 
    draw_triangle(cell_width)      

    goto(cell_width * 3.5, 0.2*cell_height) 
    write("This is my text 1", move=True, font=("Verdana", 15, "bold"))

    goto(cell_width * 3.5, -2*cell_height) 
    write("This is my text 2", move=True, font=("Verdana", 15, "bold"))
    #done()

#--------------------------------------------------------------------#



#-----Main Program to Run Student's Solution-------------------------#
#
# This main program configures the drawing canvas, calls the student's
# function and closes the canvas.  Do NOT change any of this code
# except as allowed by the comments below.  Do NOT put any of
# your solution code in this section.
#

# Configure the drawing canvas
#
# ***** You can add arguments to this function call to modify
# ***** features of the drawing canvas such as the background
# ***** and line colours, etc
create_drawing_canvas(write_instructions = False)

# Create the data set and pass it to the student's function
#
# ***** While developing your Task 1B code you can call the
# ***** "data_set" function with a fixed seed below for the
# ***** random number generator, but your final solution must
# ***** work with "data_set()" as the function call,
# ***** i.e., for any random data set that can be returned by
# ***** the function when called with no seed
visualise_data(data_set()) # <-- no argument for "data_set" when assessed

# Exit gracefully
#
# ***** Do not change this function call
release_drawing_canvas(student_name)

#
#--------------------------------------------------------------------#
