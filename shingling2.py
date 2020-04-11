from bs4 import BeautifulSoup
import sys
import os.path
import string
import os
import re
import random
import time
import binascii

documents = []
printedbodies = {}
print 'Reading files'
print 'Please wait...'
t0 = time.time()

data = ''
count_docs = 0
for file in os.listdir("data/"):
    if file.endswith(".sgm"):
        filename = os.path.join("data", file)
        count_docs+=1
        f = open(filename, 'r')
        data = data + f.read()
        # print data
        # print len(data)
        # time.sleep(2)
print 'Reading data took %.2f sec.' % (time.time() - t0)
print 'NUmber of docs: ' ,count_docs

print 'len data: ' ,len(data)
print 'Transforming data...'
t0 = time.time()
soup = BeautifulSoup(data, "html.parser") #parse all the html data
bodies = soup.findAll('body') #only get the body
i = 0
for body in bodies:
    printedbodies[i] = body
    documents.append(
        re.sub(' +', ' ', str(body).replace("<body>", "").replace("</body>", "").translate(None, string.punctuation)
               .replace("", "").replace("\n", " ").lower()))
    i = i + 1

print 'Transforming data took %.2f sec.' % (time.time() - t0)
print documents
print 'The number of documents read was: ' + str(len(documents))