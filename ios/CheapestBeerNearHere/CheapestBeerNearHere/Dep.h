//
//  NSObject+Dep.h
//  CheapestBeerNearHere
//
//  Created by Marco d'Amore on 9/20/14.
//  Copyright (c) 2014 Marco d'Amore. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Location.h"
#import "Product.h"

@interface Dep : NSObject
{
    NSString *_storeName;
    Location *_depLocation;
    int _goodRating;
    int _cheapRating;
    
}
//Designated initializer
- (instancetype)initWithName:(NSString *)name
                        depLocation:(Location *)location
                        goodRating:(int)gRating
                        cheapRating:(int)cRating;
- (instancetype)initWithName:(NSString *)name
                 depLocation:(Location *)location;


//- (void) setProductName:(NSString *)newName;
//- (NSString *)productName;
//@property (strong, nonatomic) NSString *address;

//@property (strong,nonatomic) NSString *storeName;

//
//@property double distance;
//@property int goodRating;
//@property int cheapRating;
//

- (void) setStoreName:(NSString *)storeName;
- (NSString *)storeName;

- (void) setGoodRating:(int)goodRating;
- (int) goodRating;

- (void) setCheapRating:(int)cheapRating;
- (int) cheapRating;

//- (void) setDistance:(double)distance;
//- (double)distance;

+ (instancetype) randomDep;

@end
