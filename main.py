harrytrinh = """
░█░█░█▀█░█▀▄░█▀▄░█░█░░░▀█▀░█▀▄░▀█▀░█▀█░█░█
░█▀█░█▀█░█▀▄░█▀▄░░█░░░░░█░░█▀▄░░█░░█░█░█▀█
░▀░▀░▀░▀░▀░▀░▀░▀░░▀░░░░░▀░░▀░▀░▀▀▀░▀░▀░▀░▀

"""
print(harrytrinh)
from read_docs import *
if __name__ == '__main__':
    obj = Read_sgm()
    data = obj.read_sgm()
    documents = obj.transformation()
    print(len(documents))
else:
    print(__name__)
