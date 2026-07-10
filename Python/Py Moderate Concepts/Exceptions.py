# Each time your code tries to do something wrong/foolish/irresponsible/crazy/unenforceable,
# Python does two things:
# it stops your program;
# it creates a special kind of data, called an exception.
# Both of these activities are called raising an exception. We can say that Python always
# raises an exception (or that an exception has been raised) when it has no idea what to do with your code.

# What happens next?
# the raised exception expects somebody or something to notice it and take care of it;
# if nothing happens to take care of the raised exception, the program will be forcibly terminated,
# and you will see an error message sent to the console by Python;
# otherwise, if the exception is taken care of and handled properly, the suspended program can be resumed
# and its execution can continue.
# Python provides effective tools that allow you to observe exceptions, identify them and handle them
# efficiently. This is possible due to the fact that all potential exceptions have their unambiguous
# names, so you can categorize them and react appropriately.



# ZeroDivisionError: division by zero
# value = 1
# value /= 0


# IndexError: list index out of range
# my_list = []
# x = my_list[0]


# How do you handle exceptions? The word try is the key to the solution.
# What's more, it's a keyword, too.
# The recipe for success is as follows:
# first, you have to try to do something;
# next, you have to check whether everything went well.
# But wouldn't it be better to check all circumstances first and then do something only if it's safe?


# Traditional Exception Handling using If Else:
# fn = int(input("Enter the 1st number: "))
# sn = int(input("Enter the 2nd number: "))

# if sn != 0:
#     print("The Quotient is (always we get output in Floating Point): ",fn / sn)
# else:
#     print("This operation cannot be done. This leads to ZeroDivisionError")
# print("THE END.")


# Python's Exception Handling:
# a = int(input("Enter 1st num: "))
# b = int(input("Enter 2nd num: "))

# try:
#     print(a / b)
# except:
#     print("ZeroDivisionError")

# print("The End")


# Note:
# the try keyword begins a block of the code which may or may not be performing correctly;
# next, Python tries to perform the risky action; if it fails, an exception is raised and Python starts
# to look for a solution;
# the except keyword starts a piece of code which will be executed if anything inside the try
# block goes wrong – if an exception is raised inside a previous try block, it will fail here,
# so the code located after the except keyword should provide an adequate reaction to the raised exception;
# returning to the previous nesting level ends the try-except section.
# Run the code and test its behavior.




# If you need to handle more than one exception coming from the same try branch,
# you can add more than one except branch, but you have to label them with different
# exception names, like this:
# The code that always runs smoothly.
# try:
    # :
    # Risky code.
    # :
# except Except_1:
    # Crisis management takes place here.
# except Except_2:
    # We save the world here.
# :
# Back to normal.
# :



# You cannot add more than one anonymous (unnamed) except branch after the named ones.
# # The code that always runs smoothly.
# :
# try:
#     :
#     # Risky code.
#     :
# except Except_1:
#     # Crisis management takes place here.
# except Except_2:
#     # We save the world here.
# except:
#     # All other issues fall here.
# :
# # Back to normal.
# :




# Check the image of Exception before continuing to learn from here onwards:
# Note:

# ZeroDivisionError is a special case of a more general exception class named ArithmeticError;
# ArithmeticError is a special case of a more general exception class named just Exception;
# Exception is a special case of a more general class named BaseException;

# We can describe it in the following way
# (note the direction of the arrows – they always point to the more general entity):
#                                         BaseException
#                                             ↑
#                                         Exception
#                                             ↑
#                                         ArithmeticError
#                                             ↑
#                                         ZeroDivisionError
# We're going to show you how this generalization works. Let's start with some really simple code.


# try:
#     y = 1 / 0
# except ZeroDivisionError:
#     print("Ooopsss...       its a ZeroDivisionError")

# print("THE END.")


# try:
#     y = 1 / 0
# except ArithmeticError:
#     print("Ooopsss...       its a ArithmeticError")

# print("THE END.")
    

# try:
#     x = 1 / 0
# except ZeroDivisionError:
#     print("Zero Division!")
# except ArithmeticError:
#     print("Arithmetic problem!")
    
# print("THE END.")




# def bad_fun(n):
#     try:
#         return 1 / n
#     except ArithmeticError:
#         print("Arithmetic Problem!")
#     return None

# bad_fun(0)

# print("THE END.")




# def bad_fun(n):
#     return 1 / n
 
# try:
#     bad_fun(0)
# except ArithmeticError:
#     print("What happened? An exception was raised!")
 
# print("THE END.")





# Note: the exception raised can cross function and module boundaries, and travel through the
# invocation chain looking for a matching except clause able to handle it.
# If there is no such clause, the exception remains unhandled, and Python solves the problem in
# its standard way – by terminating your code and emitting a diagnostic message.
# Now we're going to suspend this discussion, as we want to introduce you to a brand
# new Python instruction.
# The raise instruction raises the specified exception named exc as if it was raised
# in a normal (natural) way:

# raise exc

# Note: raise is a keyword.
# The instruction enables you to:
# simulate raising actual exceptions (e.g., to test your handling strategy)
# partially handle an exception and make another part of the code responsible
# for completing the handling (separation of concerns).

# def bad_fun(n):
#     raise ZeroDivisionError
# try:
#     bad_fun(0)
# except ArithmeticError:
#     print("What happened? An error?")
# print("THE END.")

# There is one serious restriction: this kind of raise instruction may be used inside the
# except branch only; using it in any other context causes an error.

