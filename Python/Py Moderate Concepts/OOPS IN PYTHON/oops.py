# class ExampleClass:
#     def __init__(self, val = 1):
#         self.first = val    # instance variable

#     def set_second(self, val):
#         self.second = val   # instance variable


# example_object_1 = ExampleClass()   # no parameter
# example_object_2 = ExampleClass(2)

# example_object_2.set_second(3)

# example_object_3 = ExampleClass(4)
# example_object_3.third = 5

# print(example_object_1.__dict__)
# print(example_object_2.__dict__)
# print(example_object_3.__dict__)



# There is one additional conclusion that should be stated here: modifying an instance variable of any
# object has no impact on all the remaining objects. Instance variables are perfectly isolated from each other.



# It needs one additional explanation before we go into any more detail. Take a look at the last three
# lines of the code. Python objects, when created, are gifted with a small set of predefined properties and
# methods. Each object has got them, whether you want them or not. One of them is a variable
# named __dict__ (it's a dictionary).

# The variable contains the names and values of all the properties (variables) the object is currently carrying.
# Let's make use of it to safely present an object's contents.

# Let's dive into the code now:
# the class named ExampleClass has a constructor, which unconditionally creates an instance variable named
# first, and sets it with the value passed through the first argument (from the class user's perspective)
# or the second argument (from the constructor's perspective); note the default value of the parameter – any
# trick you can do with a regular function parameter can be applied to methods, too;
# the class also has a method which creates another instance variable, named second;

# we've created three objects of the class ExampleClass, but all these instances differ:
# example_object_1 only has the property named first;
# example_object_2 has two properties: first and second;
# example_object_3 has been enriched with a property named third just on the fly, outside the
# class's code - this is possible and fully permissible.




class ExampleClass:
    def __init__(self, val = 1):
        self.__first = val

    def set_second(self, val = 2):
        self.__second = val


example_object_1 = ExampleClass()
example_object_2 = ExampleClass(2)

example_object_2.set_second(3)

example_object_3 = ExampleClass(4)
example_object_3.__third = 5


print(example_object_1.__dict__)
print(example_object_2.__dict__)
print(example_object_3.__dict__)



# Important Concept: Name Mangling
# Attributes beginning with __ inside a class are name-mangled by Python.
# self.__first becomes self._ExampleClass__first
# Similarly,
# self.__second becomes self._ExampleClass__second