# The third program shows a simple method allowing you to input a line filled with numbers,
# and to process them easily. Note: the routine input() function, combined together with the int() or float()
# functions, is unsuitable for this purpose.
# The processing will be extremely easy – we want the numbers to be summed.
# Look at the code in the editor. Let's analyze it.
# Using list comprehension may make the code slimmer. You can do that if you want.

# Numbers Processor.
line = input("Enter a line of numbers - separate them with spaces: ")
strings = line.split()
total = 0
try:
    for substr in strings:
        total += float(substr)
    print("The total is:", total)
except:
    print(substr, " is not a number.")
    print("FloatingPointError.")
