from tkinter import *
# singup = Tk()
# singup.geometry("1000x500")
# singup.title("seshy twoy")

# is_cehcked =  IntVar()
# checkbox1 = Checkbutton(singup, variable=is_cehcked,text="EWUITYYUTYT").grid(row=0,column=0)

# is_cehcked2 =  IntVar()
# checkbox1 = Checkbutton(singup, variable=is_cehcked2,text="EWUITYYUTYT").grid(row=0,column=1)

# is_cehcked3 =  IntVar()
# checkbox1 = Checkbutton(singup, variable=is_cehcked3,text="EWUITYYUTYT").grid(row=2,column=0)

# def showChecked ():
#     print(male.get())

# male = IntVar()
# malebox = Radiobutton(singup,variable=male, text="male", value=1, command=showChecked).grid(row=3,column=0)
# girlbox = Radiobutton(singup,variable=male, text="girl", value=2 ,command=showChecked).grid(row=4,column=0)
# singup.mainloop()

root = Tk()
root.geometry("400x500")
root.title("calculator")
root.configure(bg="lightblue")


def calculate():
    try:
        result = float(num1.get()) + float(num2.get()) # this is ali here!!! the tryexpect so we dont get type error :) :) :)))))))))))))))
        Label(content, text=f"Result: {result}", font=("Arial", 14), bg="gray").pack(pady=10)
    except ValueError:
        Label(content, text="Please enter valid numbers.", font=("Arial", 14), bg="gray", fg="red").pack(pady=10)
        
canvas = Frame(root, bg="darkblue", height=80)
canvas.pack(fill=X)
canvas.pack_propagate(False)

content = Frame(root, bg="gray")
content.pack(fill="both", expand=True)
Label(content, text="welcome. please calculate", font=("Arial", 16), bg="gray").pack(pady=20)

num1 = Entry(content, font=("Arial", 14))
num1.pack(pady=10)

plusSign = Label(content, text="+", font=("Arial", 14), bg="gray")
plusSign.pack(pady=10)

num2 = Entry(content, font=("Arial", 14))
num2.pack(pady=0)

Button(content, text="calculate", bg="black", fg="white", command=calculate).pack()

Label(canvas, text="adder (my first project)", font=("Arial", 20, "bold"), bg="darkblue", fg="white").pack(pady=20)


botty = Frame(root, bg="black", height=40)
botty.pack(fill="x", side="bottom")
Label(botty, text="made by AimingBow Studios™", font=("WingleDings", 10), bg="black", fg="white").pack(pady=20)
if __name__ == "__main__":
    root.mainloop()