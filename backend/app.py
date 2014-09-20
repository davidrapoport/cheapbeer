from flask import Flask, make_response, request, jsonify, redirect, url_for
from init_db import Store, Product, Base
from sqlalchemy import create_engine
from math import sqrt
import datetime
import json
import os

app = Flask(__name__, static_url_path='/static/')
CENTER_LAT=45.50000
CENTER_LONG=-73.5667
DEFAULT_RAD=5

engine = create_engine('sqlite:///cheapbeer.db')
Base.metadata.bind = engine
from sqlalchemy.orm import sessionmaker
DBSession = sessionmaker()
DBSession.bind = engine
session = DBSession()
allDeps=session.query(Store).all()

@app.route('/')
def index():
	return redirect(url_for('appV'))

@app.route('/app')
def appV():
	return app.send_static_file("app/index.html")

@app.route('/deps', methods=['GET'])
def getAllDeps():
	lat = float(request.args.get('lat',CENTER_LAT))
	longit= float(request.args.get('long',CENTER_LONG))
	rad= float(request.args.get('rad',DEFAULT_RAD))
	filteredDeps=queryForDeps(lat,longit,rad)
	filteredDeps= list(map(lambda dep : {"name":dep.name, "address":dep.address,
	 "id":dep.id, "products":[], "lat":dep.lat, "long":dep.longit}, filteredDeps))
	session = DBSession()
	for dep in filteredDeps:
		products = session.query(Product).filter(Product.store_id == dep['id'])
		for product in products:
			p = {"name":product.name, "price":product.price}
			dep['products'].append(p)
	return json.dumps(filteredDeps)

@app.route('/price', methods=['POST','GET'])
def updatePrice():
	if request.method == 'GET':
		return app.send_static_file("price.html")
	session = DBSession()
	address = request.form.get('address','')
	price = request.form.get('price',0.0)
	name = request.form.get('name','')
	if not len(address) or not price or not len(name): 
		print "NOPE"
		return ""
	try:
		float(price)
	except:
		print "Value provided for price is not a number"
		return ""
	dep = session.query(Store).filter(Store.address == address).first()
	if not dep:
		print "NOPE"
		return ""
	prod = session.query(Product).filter(Product.store_id == dep.id).filter(Product.name == name).first()
	if not prod:
		new_product = Product(ins_ts=datetime.datetime.utcnow() ,store=dep, price = price, name=name)
		session.add(new_product)
		session.commit()
	else:
		session.query(Product).filter(Product.store_id == dep.id).filter(Product.name == name).update({'price':price})
		session.commit()
	return make_response("Accepted",200)



def queryForDeps(la,lo,r):
	return [dep for dep in allDeps if euclidian(la, lo, dep, r)]

def euclidian(lat,lon,dep,rad):
	return haversine(lon, lat, dep.longit, dep.lat) < rad

from math import radians, cos, sin, asin, sqrt
def haversine(lon1, lat1, lon2, lat2):
    """
    Calculate the great circle distance between two points 
    on the earth (specified in decimal degrees)
    """
    # convert decimal degrees to radians 
    # lon1, lat1, lon2, lat2 = map(radians, [lon1, lat1, lon2, lat2])

    # # haversine formula 
    # dlon = lon2 - lon1 
    # dlat = lat2 - lat1 
    # a = sin(dlat/2)**2 + cos(lat1) * cos(lat2) * sin(dlon/2)**2
    # c = 2 * asin(sqrt(a)) 

    # # 6367 km is the radius of the Earth
    # km = 6367 * c
    R = 6371 
    x = (lon2 - lon1) * cos( 0.5*(lat2+lat1) )
    y = lat2 - lat1
    d = R * sqrt( x*x + y*y )
    return d

if __name__ == '__main__':
    app.run(host="0.0.0.0", debug=True)

