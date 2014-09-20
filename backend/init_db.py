import os
import sys
from sqlalchemy import Column, ForeignKey, Integer, String, Float, DateTime
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import relationship
from sqlalchemy import create_engine
 
Base = declarative_base()
 
class Store(Base):
    __tablename__ = 'store'
    id = Column(Integer, primary_key=True)
    name = Column(String(250), nullable=False)
    lat = Column(Float)
    longit = Column(Float)
    address = Column(String(450))
    post_code = Column(String(12), nullable=False)
 
class Product(Base):
    __tablename__ = 'product'
    id = Column(Integer, primary_key=True)
    ins_ts = Column(DateTime)
    store_id = Column(Integer, ForeignKey('store.id'))
    price = Column(Float)
    name = Column(String(100),nullable=False)
    store = relationship(Store)
    # person = relationship(Person)
 
# Create an engine that stores data in the local directory's
# sqlalchemy_example.db file.
engine = create_engine('sqlite:///cheapbeer.db')
 
# Create all tables in the engine. This is equivalent to "Create Table"
# statements in raw SQL.
Base.metadata.create_all(engine)