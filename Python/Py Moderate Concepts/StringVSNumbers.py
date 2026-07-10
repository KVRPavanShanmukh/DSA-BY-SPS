# There are two additional issues that should be discussed here:
# how to convert a number (an integer or a float) into a string, and vice versa.
# It may be necessary to perform such a transformation. Moreover, it's a routine way
# to process input/output data.
# The number-string conversion is simple, as it is always possible. It's done by a function named str().
# Just like here:

itg = 13
flt = 1.3
si = str(itg)
sf = str(flt)
print(si + ' ' + sf)

# The reverse transformation (string-number) is possible when and only when the string
# represents a valid number. If the condition is not met, expect a ValueError exception.
# Use the int() function if you want to get an integer, and float() if you need a floating-point value.