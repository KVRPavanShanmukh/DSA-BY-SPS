# Each Python class and each Python object is pre-equipped with a set of useful
# attributes which can be used to examine its capabilities.
# You already know one of these – it's the __dict__ property.

# class Classy:
#     varia = 1
#     def __init__(self):
#         self.var = 2

#     def method(self):
#         pass

#     def __hidden(self):
#         pass

# obj = Classy()
# print(obj.__dict__)
# print(Classy.__dict__)





# Run it to see what it outputs. Check the output carefully.
# Find all the defined methods and attributes. Locate the context in which they exist: inside
# the object or inside the class.
# __dict__ is a dictionary. Another built-in property worth mentioning is __name__, which is a string.
# The property contains the name of the class. It's nothing exciting, just a string.

# Note: the __name__ attribute is absent from the object – it exists only inside classes.
# If you want to find the class of a particular object, you can use a function named type(), which is able
# (among other things) to find a class which has been used to instantiate any object.
# Look at the code in the editor, run it, and see for yourself.


# class Classy:
#     pass

# print(Classy.__name__)
# obj = Classy()
# print(type(obj).__name__)



# class Classy:
#     pass

# print(Classy.__module__)
# obj = Classy()
# print(obj.__module__)



# As you know, any module named __main__ is actually not a module, but the file currently being run.
# __bases__ is a tuple. The tuple contains classes (not class names) which are direct superclasses
# for the class.
# The order is the same as that used inside the class definition.
# We'll show you only a very basic example, as we want to highlight how inheritance works.
# Moreover, we're going to show you how to use this attribute when we discuss the object approach
# aspects of exceptions.
# Note: only classes have this attribute – objects don't.
# We've defined a function named printbases(), designed to present the tuple's
# contents clearly.
# Look at the code in the editor. Analyze it and run it.




class SuperOne:
    pass

class SuperTwo:
    pass

class Sub(SuperOne, SuperTwo):
    pass

def printBases(cls):
    print('( ', end='')
    
    for x in cls.__bases__:
        print(x.__name__, end=' ')
    print(')')

printBases(SuperOne)
printBases(SuperTwo)
printBases(Sub)

# Note: a class without explicit superclasses points to an
# object (a predefined Python class) as its direct ancestor.
    