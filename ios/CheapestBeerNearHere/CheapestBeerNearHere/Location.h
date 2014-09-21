//
//  NSObject+Location.h
//  CheapestBeerNearHere
//
//  Created by Marco d'Amore on 9/20/14.
//  Copyright (c) 2014 Marco d'Amore. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Location : NSObject
{
    double _distance;
    NSString *_address;
    float _latitude;
    float _longitude;
}

- (instancetype) initWithAddress:(NSString *)address
                    distance:(float)newDistance
                    longitude:(float)newLong
                        latitude:(float)newLat;
- (instancetype) initWithAddress:(NSString *)address;


//    Location *newLocation = [[Location alloc] initWithAddress:@"Test" distance:0.0 longitude:0.0 latitude:0.0]


//
//- (instancetype)initWithName:(NSString *)name
//                 depLocation:(Location *)location
//                  goodRating:(int)gRating
//                 cheapRating:(int)cRating;
//- (instancetype)initWithName:(NSString *)name
//                 depLocation:(Location *)location;

- (void) setAddress:(NSString *)str;
- (NSString *)address;


- (void) setLatitude:(float)newLat;
- (double)latitude;

- (void) setLongitude:(float)newLong;
- (double)longitude;

- (void) setDistance:(double)newDistance;
- (double)distance;

@end
