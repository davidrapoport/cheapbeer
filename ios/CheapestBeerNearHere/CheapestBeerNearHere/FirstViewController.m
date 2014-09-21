//
//  FirstViewController.m
//  CheapestBeerNearHere
//
//  Created by Marco d'Amore on 9/20/14.
//  Copyright (c) 2014 Marco d'Amore. All rights reserved.
//

#import "FirstViewController.h"

@interface FirstViewController ()

@property (nonatomic, weak) IBOutlet UILabel *distanceLabel;

@property (nonatomic) IBOutlet UIStepper *stepper;


@end

@implementation FirstViewController

- (IBAction)stepperValueChanged:(UIStepper *)sender {
    
    [self.stepper setValue:sender.value];
    
    self.distanceLabel.text = [@((double)sender.value) stringValue];
    
}

@end
