class ExampleClass:
    counter = 0
    def __init__(self, val = 1):
        self.__first = val
        ExampleClass.counter += 1
 
 
example_object_1 = ExampleClass()
example_object_2 = ExampleClass(2)
example_object_3 = ExampleClass(4)
 
print(example_object_1.__dict__, example_object_1.counter)
print(example_object_2.__dict__, example_object_2.counter)
print(example_object_3.__dict__, example_object_3.counter)



# Look:
# there is an assignment in the first line of the class definition – it sets the variable named counter to 0;
# initializing the variable inside the class but outside any of its methods makes the variable a class variable;
# accessing such a variable looks the same as accessing any instance attribute – you can see it in the
# constructor body; as you can see, the constructor increments the variable by one; in effect, the variable
# counts all the created objects.


# __dict__
# Shows only instance variables.

# For object 1:
# {'_ExampleClass__first': 1}

# For object 2:
# {'_ExampleClass__first': 2}

# For object 3:
# {'_ExampleClass__first': 4}

# Notice that counter is not present because it is a class variable.


# Memory View:
# Class:
# ExampleClass
#  └── counter = 3

# Object 1
#  └── _ExampleClass__first = 1

# Object 2
#  └── _ExampleClass__first = 2

# Object 3
#  └── _ExampleClass__first = 4

# Since counter is shared by the class, every object sees the same final value: 3.