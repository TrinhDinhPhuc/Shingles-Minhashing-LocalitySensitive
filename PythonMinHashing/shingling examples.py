harrytrinh = """
░█░█░█▀█░█▀▄░█▀▄░█░█░░░▀█▀░█▀▄░▀█▀░█▀█░█░█
░█▀█░█▀█░█▀▄░█▀▄░░█░░░░░█░░█▀▄░░█░░█░█░█▀█
░▀░▀░▀░▀░▀░▀░▀░▀░░▀░░░░░▀░░▀░▀░▀▀▀░▀░▀░▀░▀

"""
print(harrytrinh)

# word shingling
n=2
word = 'harrykev'
print([word[i:i + n] for i in range(len(word) - n + 1)])
# Character Shingling in Python
theString = "The Covid-19 crisis has now reached a new critical phase where public health systems need to act decisively to contain the growth in new epicenters outside China."
shingleLength = 3
tokens = theString.split()
print ([tokens[i:i+shingleLength] for i in range(len(tokens) - shingleLength + 1) if len(tokens[i]) < 4])

