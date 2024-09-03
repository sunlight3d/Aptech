import turtle

def ring(col, rad):
    # Set the fill
    turtle.fillcolor(col)
    # Start filling the color
    turtle.begin_fill()
    # Draw a circle
    turtle.circle(rad)
    # Ending the filling of the color
    turtle.end_fill()

def draw_triangle(size):
    turtle.pendown()          
    turtle.begin_fill()
    for _ in range(3):
        turtle.forward(size)
        turtle.left(120)
    turtle.end_fill()
    turtle.penup()

def draw_bear_in_triangle(size):
    # Set up turtle screen
    turtle.speed('fastest')
    
    # Draw triangle
    turtle.penup()
    turtle.goto(-size/2, -size/3)
    draw_triangle(size)
    
    # Draw bear within the triangle
    turtle.goto(-size/6, size/6)  # Adjust the position according to triangle
    
    ##### Draw ears #####
    # Draw first ear
    turtle.setpos(-35 + turtle.xcor(), 95 + turtle.ycor())
    turtle.pendown()
    ring('black', 15)
    turtle.penup()
    
    # Draw second ear
    turtle.setpos(35 + turtle.xcor(), 95 + turtle.ycor())
    turtle.pendown()
    ring('black', 15)
    turtle.penup()
    
    ##### Draw face #####
    turtle.setpos(0 + turtle.xcor(), 35 + turtle.ycor())
    turtle.pendown()
    ring('white', 40)
    turtle.penup()
    
    ##### Draw eyes black #####
    # Draw first eye
    turtle.setpos(-18 + turtle.xcor(), 75 + turtle.ycor())
    turtle.pendown()
    ring('black', 8)
    turtle.penup()
    
    # Draw second eye
    turtle.setpos(18 + turtle.xcor(), 75 + turtle.ycor())
    turtle.pendown()
    ring('black', 8)
    turtle.penup()
    
    ##### Draw eyes white #####
    # Draw first eye
    turtle.setpos(-18 + turtle.xcor(), 77 + turtle.ycor())
    turtle.pendown()
    ring('white', 4)
    turtle.penup()
    
    # Draw second eye
    turtle.setpos(18 + turtle.xcor(), 77 + turtle.ycor())
    turtle.pendown()
    ring('white', 4)
    turtle.penup()
    
    ##### Draw nose #####
    turtle.setpos(0 + turtle.xcor(), 55 + turtle.ycor())
    turtle.pendown()
    ring('black', 5)
    turtle.penup()
    
    ##### Draw mouth #####
    turtle.setpos(0 + turtle.xcor(), 55 + turtle.ycor())
    turtle.pendown()
    turtle.right(90)
    turtle.circle(5, 180)
    turtle.penup()
    turtle.setpos(0 + turtle.xcor(), 55 + turtle.ycor())
    turtle.pendown()
    turtle.left(360)
    turtle.circle(5, -180)
    turtle.hideturtle()

# Drawing size for triangle
triangle_size = 300
draw_bear_in_triangle(triangle_size)
turtle.done()
