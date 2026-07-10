# Demonstrating the capitalize() method:
print('aBcD'.capitalize())

print("Alpha".capitalize())
print('ALPHA'.capitalize())
print(' Alpha'.capitalize())    #Space is considered as the 1st character.
print('123'.capitalize())       #Numbers won't be capitalized.
print("αβγδ".capitalize())




# Demonstrating the center() method:
print('[' + 'alpha'.center(10) + ']')

print('[' + 'Beta'.center(2) + ']')
print('[' + 'Beta'.center(4) + ']')
print('[' + 'Beta'.center(6) + ']')



# Demonstrating the startswith() method:
print("omega".startswith("meg"))
print("omega".startswith("om"))
print()



# Demonstrating the endswith() method:  returns True if string or char is present, False if absent.:
if "epsilon".endswith("on"):
    print("yes its endswith","on")
else:
    print("no")

t = "zeta"
print(t.endswith("a"))
print(t.endswith("A"))
print(t.endswith("et"))
print(t.endswith("eta"))




# Demonstrating the find() method:
# The find() method is similar to index(), which you already know.
# It looks for a substring and returns the index of the first occurrence of this substring, but:
# it's safer – it doesn't generate an error for an argument containing a non-existent
# substring (it returns -1 then) it works with strings only – don't try to apply it to any other sequence.
print("Eta".find("ta"))
print("Eta".find("mma"))

t = 'theta'
print(t.find('eta'))
print(t.find('et'))
print(t.find('the'))
print(t.find('ha'))


# Demonstrating the isalnum() method:
# The parameterless method named isalnum() checks if the string contains only
# digits or alphabetical characters (letters), and returns True or False according to the result.
print('lambda30'.isalnum())
print('lambda'.isalnum())
print('30'.isalnum())
print('@'.isalnum())
print('lambda_30'.isalnum())
print(''.isalnum())




# Example 1: Demonstrating the isapha() method:
# The isalpha() method is more specialized – it's interested in letters only.
print("Moooo".isalpha())
print('Mu40'.isalpha())
    



# In turn, the isdigit() method looks at digits only – anything else produces False as the result.
# Example 2: Demonstrating the isdigit() method:
print('2018'.isdigit())
print("Year2019".isdigit())



# Example: Demonstrating the islower() method:
# The islower() method is a fussy variant of isalpha() – it accepts lower-case letters only.
print("Moooo".islower())
print('moooo'.islower())

# Example: Demonstrating the isupper() method:
# The isupper() method is the upper-case version of islower() – it concentrates on upper-case letters only.
print("Moooo".isupper())
print('moooo'.isupper())
print('MOOOO'.isupper())



# Demonstrating the swapcase() method:
# The swapcase() method makes a new string by swapping the cases of all letters within the
# source string: lower-case characters become upper-case, and vice versa.
print("I know that I know nothing.".swapcase())
print()



# Example: Demonstrating the isspace() method:
# The isspace() method identifies whitespaces only – it disregards any other character (the result is False then).
print(' \n '.isspace())
print(" ".isspace())
print("mooo mooo mooo".isspace())



# The join() method is rather complicated, so let us guide you through it step by step:
# as its name suggests, the method performs a join – it expects one argument as a list;
# it must be assured that all the list's elements are strings – else, method will raise a TypeError exception;
# all the list's elements will be joined into one string but...
# ...the string from which the method has been invoked is used as a separator, put among the strings;
# the newly created string is returned as a result.
# Demonstrating the join() method:
print(",".join(["Pudathama", "Enti", "Mallii"]))



# Demonstrating the lower() method:
print("SiGmA=60".lower())



# Demonstrating the lstrip() method:
# The parameterless version of the lstrip() method returns a newly created string formed from
# the original one by removing all leading whitespaces.
print("[" + " tau ".lstrip() + "]")
# The one-parameter version of the lstrip() method does the same as its parameterless version, but removes
# all characters enlisted in its argument (a string), not just whitespaces:
print("www.cisco.com".lstrip("w."))



# Demonstrating the rstrip() method:
# Two variants of the rstrip() method do nearly the same as lstrips, but affect the opposite side of the string.
# Look at the code example in the editor. Can you guess its output? Run the code to check your guesses.
print("[" + " upsilon ".rstrip() + "]")
print("cisco.com".rstrip(".com"))
print("Peddi".rstrip("Maddineni"))



# Demonstrating the replace() method:
print("PSK".replace("PSK", "PavanShanmmukhKakarla"))
print("This is it!".replace("is", " Girl is beautiful, isn't")) #two times "is" undhi, so two times printed!
print("Apple juice".replace("juice", "is a fruit that keeps us away from the Doctor!"))



# Demonstrating the rfind() method:
# The one-, two-, and three-parameter versions of the rfind() method do nearly the
# same things as their counterparts (the ones devoid of the r prefix), but start their
# searches from the end of the string, not the beginning (hence the prefix r, for right).
# Take a look at the example code in the editor and try to predict its output. Run the code
# to check if you were right.
print("tau tau tau".rfind("ta"))
print("tau tau tau".rfind("ta", 9))
print("tau tau tau".rfind("ta", 3, 9))



# Demonstrating the split() method:
# The split() method does what it says – it splits the string and builds a list of all detected substrings.
# The method assumes that the substrings are delimited by whitespaces – the spaces don't take part in the
# operation, and aren't copied into the resulting list.
# If the string is empty, the resulting list is empty too.
print("phi       chi\n psi".split())
print("Hi Darlings ~!~! \n psi".split())
print("Hi Darlings~!~! \n psi".split())



# Demonstrating the strip() method:
# The strip() method combines the effects caused by rstrip() and lstrip() – it makes a new string lacking
# all the leading and trailing whitespaces.
print("[" + "   Dabidi dibidi Dabidi dibidi    ".strip() + "]")



# Demonstrating the title() method:
# The title() method performs a somewhat similar function – it changes every word's first letter to
# upper-case, turning all other ones to lower-case.
print("I know that I know nothing. Part 1.".title())
print()



# Demonstrating the upper() method:
# Last but not least, the upper() method makes a copy of the source string,
# replaces all lower-case letters with their upper-case counterparts, and returns the string as the result.
print("I know that I know nothing. Part 2.".upper())
