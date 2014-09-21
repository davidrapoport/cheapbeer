//
//  NSObject+Product.m
//  CheapestBeerNearHere
//
//  Created by Marco d'Amore on 9/20/14.
//  Copyright (c) 2014 Marco d'Amore. All rights reserved.
//

#import "Product.h"

@implementation Product

- (void) setProductName:(NSString *)newName {
    self.productName = newName;
}
- (NSString *)productName {
    return self.productName;
}

- (void) setSize:(double)newSize {
    self.size = newSize;
}
- (double)size {
    return self.size;
}

- (void)setIsGood:(BOOL)isGood {
    self.isGood = isGood;
}
- (BOOL)isGood {
    return self.isGood;
}

- (void)setPrice:(int)newPrice {
    self.price = newPrice;
}
- (int)price {
    return self.price;
}

- (void)setAlcoholPercentage:(double)alcoholPercentage {
    self.alcoholPercentage = (alcoholPercentage) * 10;
}
- (double)alcoholPercentage {
    return self.alcoholPercentage;
}


@end
