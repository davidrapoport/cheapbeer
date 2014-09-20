import requests
import json
import sys
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
import time
 
from init_db import Store, Base
reload(sys)
sys.setdefaultencoding('utf-8')

os.system("rm -f cheapbeer.db")

engine = create_engine('sqlite:///cheapbeer.db')
# Bind the engine to the metadata of the Base class so that the
# declaratives can be accessed through a DBSession instance
Base.metadata.bind = engine
 
DBSession = sessionmaker(bind=engine)
# A DBSession() instance establishes all conversations with the database
# and represents a "staging zone" for all the objects loaded into the
# database session object. Any change made against the objects in the
# session won't be persisted into the database until you call
# session.commit(). If you're not happy about the changes, you can
# revert all of them back to the last commit by calling
# session.rollback()
session = DBSession()
j=0
while j<50:
	r=requests.get("http://api.sandbox.yellowapi.com/FindBusiness/?what=depanneur&where=montreal&"+
		"pg="+str(j)+"&pgLen=100&fmt=json&apikey=ny5abtncmj3q8t9wp4vgg9ev&UID=127.0.0.1")
	content = r.json()['listings']
	if not len(content):
		print "THATS ALL FOLKS"
		exit(1)
	for i in content:
		name = i['name']
		lat = i['geoCode']['latitude']
		longit = i['geoCode']['longitude']
		addre = i['address']
		address = addre['street']
		post_code = addre['pcode']
		new_store = Store(name=name,lat=lat,longit=longit,address=address,post_code=post_code)
		session.add(new_store)
		session.commit()
	time.sleep(3)
	print j
	j = j+1
 

	