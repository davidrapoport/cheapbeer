//
//  NSObject+Product.h
//  CheapestBeerNearHere
//
//  Created by Marco d'Amore on 9/20/14.
//  Copyright (c) 2014 Marco d'Amore. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Product : NSObject

@property (strong, nonatomic) NSString *productName;
@property (nonatomic) double size;
@property (nonatomic) BOOL isGood;
@property (nonatomic) int price;
//Alcohol percentage is from a 0-100 scale
@property (nonatomic) double alcoholPercentage;

- (void) setProductName:(NSString *)newName;
- (NSString *)productName;

- (void) setSize:(double)newSize;
- (double)size;

- (void)setIsGood:(BOOL)isGood;
- (BOOL)isGood;

- (void)setPrice:(int)newPrice;
- (int)price;

- (void)setAlcoholPercentage:(double)alcoholPercentage;
- (double)alcoholPercentage;


@end
