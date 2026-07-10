# If you name a method like this: __init__, it won't be a regular method – it will be a constructor.

# If a class has a constructor, it is invoked automatically and implicitly when the object of the
# class is instantiated.

# The constructor:
# is obliged to have the self parameter (it's set automatically, as usual)

# may (but doesn't need to) have more parameters than just self; if this happens, the way in which the
# class name is used to create the object must reflect the __init__ definition;

# can be used to set up the object, i.e., properly initialize its internal state, create instance variables, instantiate any other
# objects if their existence is needed, etc. 



# class Classy:
#     def __init__(self, value):
#         self.name = value

# obj_1 = Classy("Dhurandhar!")
# print("Sher-E-Baloch is ",obj_1.name,",The King of Lyari!")

# Note that the constructor:
# cannot return a value, as it is designed to return a newly created object and nothing else;

# cannot be invoked directly either from the object or from inside the class (you can invoke a constructor
# from any of the object's subclasses, but we'll discuss this issue later.)




# As __init__ is a method, and a method is a function, you can do the same tricks with constructors/methods
# as you do with ordinary functions.
# The example in the editor shows how to define a constructor with a default argument value. Test it.

# class Classy:
#     def __init__(self, value = None):
#         self.var = value

# obj_1 = Classy("object")
# obj_2 = Classy()

# print(obj_1.var)
# print(obj_2.var)






# Everything we've said about property name mangling applies to method names, too – a method whose
# name starts with __ is (partially) hidden.
# The example shows this effect:
class Classy:
    def visible(self):
        print("visible")
 
    def __hidden(self):
        print("hidden")
 

obj = Classy()
obj.visible()

try:
    obj.__hidden()
except:
    print("failed")     # as we tried ot access it, it failed due to method mangling.

obj._Classy__hidden()   # remember : __ClassName__MethodName

