# This is how you can utilize it:
# class ExampleClass:
#     def __init__(self, val):
#         if val % 2 != 0:
#             self.a = 1
#         else:
#             self.b = 1
 
# example_object = ExampleClass(1)
# print(example_object.a)
 
# if hasattr(example_object, 'b'):
#     print(example_object.b)
# else :
#     print("b ledhu mowa!")

# Explanation:
#     1 % 2 anedhi != 0 kabatti---> self.a is initialized. so it exists.
#     when it exists, it can be found by hasattr.    




# class ExampleClass:
#     attr = 1
# print(hasattr(ExampleClass, 'attr'))
# print(hasattr(ExampleClass, 'prop'))



class ExampleClass:
    a = 1
    def __init__(self):
        self.b = 2
        
example_object = ExampleClass()

print(hasattr(example_object, 'b'))
print(hasattr(example_object, 'a'))

print(hasattr(ExampleClass, 'b'))
print(hasattr(ExampleClass, 'a'))



# Explanation:
#     class ExampleClass:
#     a = 1          # class variable

#     def __init__(self):
#         self.b = 2 # instance variable

# a belongs to the class.
# b belongs to the object created from the class.

# example_object = ExampleClass()

# Now memory is like:
# ExampleClass
#  └── a = 1
# example_object
#  └── b = 2

# Output
# print(hasattr(example_object, 'b'))
# b is inside the object, so:
# True
# print(hasattr(example_object, 'a'))
# a is not inside the object, but Python also checks the class. So:
# True
# print(hasattr(ExampleClass, 'b'))
# b is created only when an object is created. It is not inside the class directly. So:
# False
# print(hasattr(ExampleClass, 'a'))
# a is directly inside the class. So:
# True

# Final output:
# True
# True
# False
# True

# Main rule:
# Object can access:
# object variables + class variables

# Class can access:
# only class variables directly

# So example_object.a works, but ExampleClass.b does not.