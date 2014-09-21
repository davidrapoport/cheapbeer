//
//  NSObject+DepList.m
//  CheapestBeerNearHere
//
//  Created by Marco d'Amore on 9/21/14.
//  Copyright (c) 2014 Marco d'Amore. All rights reserved.
//

#import "DepList.h"

@interface DepList ()

@property (nonatomic) NSMutableArray *privateList;

@end

@implementation DepList

+ (instancetype) sharedList {
    static DepList *sharedList = nil;
    if (!sharedList) {
        sharedList = [[self alloc] initPrivate];
    }
    return sharedList;
}

- (instancetype)init {
    @throw [NSException exceptionWithName:@"Singleton" reason:@"Use +[DepList sharedList]" userInfo:nil];
    return nil;
}

- (instancetype)initPrivate {
    self = [super init];
    if(self) {
        _privateList = [[NSMutableArray alloc] init];
    }
    return self;
}

- (Dep *)createDep {
    Dep *dep = [Dep randomDep];
    [self.privateList addObject:dep];
    return dep;
}

- (NSArray *)allDeps {
    return self.privateList;
}

@end
