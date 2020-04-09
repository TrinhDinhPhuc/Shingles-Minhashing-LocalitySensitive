
from bs4 import BeautifulSoup
import sys
import os.path
import string
import time
import re

class Read_sgm():
    def __init__(self):
        super().__init__()
        self.documents = []
        self.printedbodies = {}
        print('Reading files')
        print('Please wait...')
        self.t0 = time.time()
        self.data = ''
        self.count_docs = 0
    def read_sgm(self):
        for file in os.listdir("data/"):
            if file.endswith(".sgm"):
                # global data
                filename = os.path.join("data", file)
                f = open(filename, 'r', encoding='utf8', errors='ignore')
                self.count_docs += 1
                self.data = self.data + f.read()
        print('Reading data took %.2f sec.' % (time.time() - self.t0))
        print('NUmber of docs: ', self.count_docs)
        return self.data
    def transformation(self):
        print('Transforming data...')
        self.t0 = time.time()
        soup = BeautifulSoup(self.data, "html.parser")  # parse all the html data
        bodies = soup.findAll('body')  # only get the body
        i = 0
        global body
        for body in bodies:
            self.printedbodies[i] = body
            self.documents.append(
                re.sub(' +', ' ',
                       str(body).replace("<body>", "").replace("</body>", "")
                       .translate(string.punctuation).
                       replace("", "").replace("\n", " ").lower()))
            i = i + 1

        print('Transforming data took %.2f sec.' % (time.time() - self.t0))
        print('The number of documents read was: ' + str(len(self.documents)))
        return self.documents

    def convert_to_dict(self,documents):
        i = 0
        d = {}
        t = {}
        t0 = time.time()
        for value in documents:
            # create a dictionary where key=docid and value=document text
            d[i] = value
            # split text into words
            d[i] = re.sub("[^\w]", " ", d[i]).split()
            # remove rows with empty values from dictionary d
            if d[i]:
                i = i + 1
            else:
                del d[i]
                del body[i]
                print(body[i] )
                print("never happened~~")
        return d
