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
    d = obj.convert_to_dict(documents)
    # Write file
    f = open("save_results.txt","w")
    f.write(str(d))
    f.close()
else:
    print(__name__)
