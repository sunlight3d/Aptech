import turtle
from math import sqrt

# Cài đặt kích thước cơ bản
cell_width = 110
cell_height = round((sqrt(3) * cell_width) / 2)  # Trigonometry to calculate height of an equilateral triangle

def draw_triangle(size):
    turtle.pendown()
    start_position = turtle.pos()
    turtle.begin_fill()
    turtle.forward(size)
    turtle.left(-120)
    turtle.forward(size)
    turtle.left(-120)
    turtle.forward(size)
    turtle.end_fill()
    turtle.penup()

    height = (size * 3**0.5) / 2
    turtle.goto(start_position)  # Return to the starting position
    turtle.forward(-size / 2)  # Move to the middle of the base
    turtle.left(90)  # Turn perpendicular to the base
    turtle.forward(-height / 3)  # Move to the center of the triangle
    turtle.speed('fastest')  # Speed up the drawing

    scale_factor = 0.1
    for i in range(16):  # Outer loop
        turtle.begin_fill()
        for j in range(18):  # Inner loop
            turtle.color('green')
            turtle.right(90)
            turtle.circle((150 - j * 6) * scale_factor, 90)
            turtle.left(90)
            turtle.circle((150 - j * 6) * scale_factor, 90)
            turtle.right(180)
        turtle.circle(40 * scale_factor, 24)
        turtle.end_fill()
    turtle.backward(size * 0.4)  # Adjust position relative to the base of the triangle
    turtle.setheading(0)

def visualise_data(data):
    turtle.pencolor('black')
    turtle.goto(cell_width * 3.5, 1.5 * cell_height)
    turtle.color('black', 'pink')
    draw_triangle(cell_width)

    turtle.goto(10 + cell_width * 5, 0.5 * cell_height)
    turtle.left(180)
    turtle.color('black', 'pink')
    draw_triangle(cell_width)

    turtle.goto(cell_width * 3.5, -0.5 * cell_height)
    turtle.left(0)
    turtle.color('black', 'red')
    draw_triangle(cell_width)

    turtle.goto(10 + cell_width * 5, -1.5 * cell_height)
    turtle.left(180)
    turtle.color('black', 'red')
    draw_triangle(cell_width)

    turtle.done()

# Example usage
visualise_data(None)
