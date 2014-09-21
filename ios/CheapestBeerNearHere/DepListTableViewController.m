//
//  DepListTableViewController.m
//  CheapestBeerNearHere
//
//  Created by Marco d'Amore on 9/20/14.
//  Copyright (c) 2014 Marco d'Amore. All rights reserved.
//

#import "DepListTableViewController.h"
#import "DepList.h"
#import "Dep.h"
#import "Product.h"
#import "Location.h"


@interface DepListTableViewController ()

@end

@implementation DepListTableViewController

- (instancetype)init {
    self = [super initWithStyle:UITableViewStylePlain];
    if (self) {
        for (int i =0; i <5; i++) {
            [[DepList sharedList] createDep];
        }
    }
    return self;
}

- (instancetype)initWithStyle:(UITableViewStyle)style {
    return [self init];
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return [[[DepList sharedList] allDeps] count];
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    //    Create an instance of UITableViewcell
    UITableViewCell *cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:@"UITableViewCell"];
    //Set text on cell w/ description of item
    NSArray *deps = [[DepList sharedList] allDeps];
    Dep *dep = deps[indexPath.row];
    
    cell.textLabel.text = [dep description];
    return cell;
}
//
//- (void)viewDidLoad {
//    [super viewDidLoad];
//    
//    [self.tableView registerClass:[UITableViewCell class] forCellReuseIdentifier:@"UITableViewCell"];
//}

@end
