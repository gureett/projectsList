from tkinter import *

window = Tk()
window.geometry("312x324")
window.resizable(0, 0)
window.title("Calculator")

def btnClick(item):
    global expression
    expression = expression + str(item)
    inputText.set(expression)

def btnClear():
    global expression
    expression = ""
    inputText.set("")

def btnEqual():
    global expression
    result = str(eval(expression))
    inputText.set(result)
    expression = ""

expression = ""

inputText = StringVar()

inputFrame = Frame(window,
                   width=312,
                   height=50,
                   bd=0,
                   highlightbackground='black',
                   highlightcolor='black',
                   highlightthickness=2)

inputFrame.pack(side=TOP)

inputField = Entry(inputFrame, font=('arial', 18, 'bold'),
                   textvariable=inputText,
                   width=50,
                   bg="#eee",
                   bd=0,
                   justify=RIGHT)

inputField.grid(row=0, column=0)

inputField.pack(ipady=10)

btnFrame = Frame(window,
                 width=312,
                 height=272.5,
                 bg="grey")

btnFrame.pack()

# First Row of Buttons
clear = Button(btnFrame,
               text="C",
               foreground="black",
               width=32,
               height=3,
               bd=0,
               background="#eee",
               cursor="hand2",
               command=lambda: btnClear()).grid(row=0, column=0, columnspan=3, padx=1, pady=1)

divide = Button(btnFrame,
               text="/",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#eee",
               cursor="hand2",
               command=lambda: btnClick("/")).grid(row=0, column=3, padx=1, pady=1)

# Second Row of Buttons
seven = Button(btnFrame,
               text="7",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#fff",
               cursor="hand2",
               command=lambda: btnClick(7)).grid(row=1, column=0, padx=1, pady=1)

eight = Button(btnFrame,
               text="8",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#fff",
               cursor="hand2",
               command=lambda: btnClick(8)).grid(row=1, column=1, padx=1, pady=1)

nine = Button(btnFrame,
               text="9",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#fff",
               cursor="hand2",
               command=lambda: btnClick(9)).grid(row=1, column=2, padx=1, pady=1)

multiply = Button(btnFrame,
               text="X",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#eee",
               cursor="hand2",
               command=lambda: btnClick("*")).grid(row=1, column=3, padx=1, pady=1)

# Third Row
four = Button(btnFrame,
               text="4",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#fff",
               cursor="hand2",
               command=lambda: btnClick(4)).grid(row=2, column=0, padx=1, pady=1)

five = Button(btnFrame,
               text="5",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#fff",
               cursor="hand2",
               command=lambda: btnClick(5)).grid(row=2, column=1, padx=1, pady=1)

six = Button(btnFrame,
               text="6",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#fff",
               cursor="hand2",
               command=lambda: btnClick(6)).grid(row=2, column=2, padx=1, pady=1)

minus = Button(btnFrame,
               text="-",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#eee",
               cursor="hand2",
               command=lambda: btnClick("-")).grid(row=2, column=3, padx=1, pady=1)

# Fourth Row
one = Button(btnFrame,
               text="1",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#fff",
               cursor="hand2",
               command=lambda: btnClick(1)).grid(row=3, column=0, padx=1, pady=1)

two = Button(btnFrame,
               text="2",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#fff",
               cursor="hand2",
               command=lambda: btnClick(2)).grid(row=3, column=1, padx=1, pady=1)

three = Button(btnFrame,
               text="3",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#fff",
               cursor="hand2",
               command=lambda: btnClick(3)).grid(row=3, column=2, padx=1, pady=1)

add = Button(btnFrame,
               text="+",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#eee",
               cursor="hand2",
               command=lambda: btnClick("+")).grid(row=3, column=3, padx=1, pady=1)

# Fifth Row of Buttons

point = Button(btnFrame,
               text=".",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#fff",
               cursor="hand2",
               command=lambda: btnClick(".")).grid(row=4, column=0, padx=1, pady=1)

zero = Button(btnFrame,
               text="0",
               foreground="black",
               width=21,
               height=3,
               bd=0,
               background="#fff",
               cursor="hand2",
               command=lambda: btnClick(0)).grid(row=4, column=1, columnspan=2, padx=1, pady=1)

equal = Button(btnFrame,
               text="=",
               foreground="black",
               width=10,
               height=3,
               bd=0,
               background="#eee",
               cursor="hand2",
               command=lambda: btnEqual()).grid(row=4, column=3, padx=1, pady=1)

window.mainloop()