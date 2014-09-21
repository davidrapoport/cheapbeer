//
//  NSObject+Location.m
//  CheapestBeerNearHere
//
//  Created by Marco d'Amore on 9/20/14.
//  Copyright (c) 2014 Marco d'Amore. All rights reserved.
//

#import "Location.h"

@implementation Location

- (instancetype) initWithAddress:(NSString *)address distance:(float)newDistance longitude:(float)newLong latitude:(float)newLat {
    self = [super init];
    if(self) {
        _address = address;
        _distance = newDistance;
        _longitude = newLong;
        _latitude = newLat;
    }
    return self;
}

- (instancetype) initWithAddress:(NSString *)address {
    return [self initWithAddress:@"Test" distance:0.0 longitude:0.0 latitude:0.0];
}

- (void) setAddress:(NSString *)str {
    _address = str;
}
- (NSString *)address {
    return _address;
}


- (void) setLatitude:(float)newLat {
    _latitude = newLat;
}
- (double)latitude {
    return _latitude;
}

- (void) setLongitude:(float)newLong {
    _longitude = newLong;
}
- (double)longitude {
    return _longitude;
}

- (void) setDistance:(double)newDistance {
    _distance = newDistance;
}
- (double)distance {
    return _distance;
}


@end
