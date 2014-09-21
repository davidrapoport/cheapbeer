//
//  NSObject+DepList.h
//  CheapestBeerNearHere
//
//  Created by Marco d'Amore on 9/21/14.
//  Copyright (c) 2014 Marco d'Amore. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Dep.h"

@class DepList;

@interface DepList : NSObject

@property (nonatomic, readonly) NSArray *allDeps;

+ (instancetype)sharedList;
- (Dep *)createDep;

@end
