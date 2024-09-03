from tkinter import *
# Định nghĩa hành động khi nhấn nút
i = 0
def on_button_press():
    global i  # Khai báo biến i là toàn cục
    print("i = "+str(i))
    i = i + 1

my_window = Tk()

my_button = Button(my_window, 
                   text='Press me now',
                   command=on_button_press)
my_button.pack()
my_window.mainloop()
