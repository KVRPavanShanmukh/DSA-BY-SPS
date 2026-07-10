# The final relation between strings is determined by comparing the first different character in both
# strings (keep ASCII/UNICODE code points in mind at all times.)
# When you compare two strings of different lengths and the shorter one is identical to the
# beginning of the longer one, the longer string is considered greater.
'alpha' < 'alphabet'
# The relation is True.
# String comparison is always case-sensitive (upper-case letters are taken as lesser than lower-case ones).
# The expression is True.
'beta' > 'Beta'
# Even if a string contains digits only, it's still not a number. It's interpreted as-is, like any other
# regular string, and its (potential) numerical aspect is not taken into consideration in any way.


print('10' == '010')
print('10' > '010')
print('10' > '8')
print('20' < '8')
print('20' < '80')
# They produce the following results:
# Output
# False
# True
# False
# True
# True



# Comparing strings against numbers is generally a bad idea.
# The only comparisons you can perform with impunity are these symbolized by the == and != operators.
# The former always gives False, while the latter always produces True.
# Using any of the remaining comparison operators will raise a TypeError exception.
print('10' == 10)
print('10' != 10)
print('10' == 1)
print('10' != 1)
print('10' > 10)
# The results in this case are:
# Output
# False
# True
# False
# True
# TypeError exception