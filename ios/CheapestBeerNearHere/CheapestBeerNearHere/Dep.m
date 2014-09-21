//
//  NSObject+Dep.m
//  CheapestBeerNearHere
//
//  Created by Marco d'Amore on 9/20/14.
//  Copyright (c) 2014 Marco d'Amore. All rights reserved.
//

#import "Dep.h"

@implementation Dep : NSObject

- (instancetype)initWithName:(NSString *)name depLocation:(Location *)location goodRating:(int)gRating cheapRating:(int)cRating {
    self = [super init];
    if(self) {
        _storeName = name;
        _depLocation = location;
        _goodRating = gRating;
        _cheapRating = cRating;
    }
    return self;
}

- (instancetype)initWithName:(NSString *)name depLocation:(Location *)location {
    return [self initWithName:name depLocation:location goodRating:0 cheapRating:0];
}

- (void) setStoreName:(NSString *)storeName {
    _storeName = storeName;
}
- (NSString *)storeName {
    return _storeName;
}

- (void) setGoodRating:(int)goodRating {
    _goodRating = goodRating;
}
- (int) goodRating {
    return _goodRating;
}

- (void) setCheapRating:(int)cheapRating {
    _cheapRating = cheapRating;
}
- (int) cheapRating {
    return _cheapRating;
}

- (NSString *)description {
    NSString *descriptionString = [[NSString alloc] initWithFormat:@"N:%@, D:(%f)",self.storeName, _depLocation.distance];
    return descriptionString;
}

+ (instancetype) randomDep {
    Location *newLocation = [[Location alloc] initWithAddress:@"Test"];
    Dep *newDep = [[self alloc] initWithName:@"Test" depLocation: newLocation];
    return newDep;
}

@end