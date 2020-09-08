package com.blazedemo.base;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features",
glue = {"classpath:StepDefs"})
public class Runner extends AbstractTestNGCucumberTests{

}
