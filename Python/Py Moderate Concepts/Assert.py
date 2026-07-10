# Now is a good moment to show you another Python instruction, named assert. This is a keyword.

# Syntax : assert expression
 
# How does it work?
# It evaluates the expression;
# if the expression evaluates to True, or a non-zero numerical value, or a non-empty string,
# or any other value different than None, it won't do anything else;
# otherwise, it automatically and immediately raises an exception named
# AssertionError (in this case, we say that the assertion has failed)

# How it can be used?
# you may want to put it into your code where you want to be absolutely safe from evidently wrong data, and where you aren't absolutely sure that the data has been carefully examined before (e.g., inside a function used by someone else)
# raising an AssertionError exception secures your code from producing invalid results, and clearly shows the nature of the failure;
# assertions don't supersede exceptions or validate the data – they are their supplements.
# If exceptions and data validation are like careful driving, assertion can play the role of an airbag.


# Let's see the assert instruction in action. Look at the code in the editor. Run it.

import math
x = float(input("Enter a number: "))
# if i enter a negative number, then the AssertionError occurs.
assert x >= 0.0
print("Square Root of ",x, "is" ,math.sqrt(x))
