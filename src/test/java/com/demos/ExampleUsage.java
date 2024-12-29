package com.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ExampleUsage {

    private WebDriver driver;

    public ExampleUsage(WebDriver driver) {
        this.driver = driver;
    }

    public void example() {
        WebElement baseElement = driver.findElement(By.id("baseElementId"));
        WebElement targetElement = driver.findElement(By.id("targetElementId"));

        // Using RelativeLocator to find an element above the base element
        WebElement elementAbove = driver.findElement(RelativeLocator.with(By.tagName("tagName")).above(baseElement));
        System.out.println("Element above: " + elementAbove.getText());

        // Using RelativeLocator to find an element below the base element
        WebElement elementBelow = driver.findElement(RelativeLocator.with(By.tagName("tagName")).below(baseElement));
        System.out.println("Element below: " + elementBelow.getText());

        // Using RelativeLocator to find an element to the left of the base element
        WebElement elementToLeft = driver.findElement(RelativeLocator.with(By.tagName("tagName")).toLeftOf(baseElement));
        System.out.println("Element to the left: " + elementToLeft.getText());

        // Using RelativeLocator to find an element to the right of the base element
        WebElement elementToRight = driver.findElement(RelativeLocator.with(By.tagName("tagName")).toRightOf(baseElement));
        System.out.println("Element to the right: " + elementToRight.getText());

        // Using RelativeLocator to find an element near the base element
        WebElement elementNear = driver.findElement(RelativeLocator.with(By.tagName("tagName")).near(baseElement));
        System.out.println("Element near: " + elementNear.getText());
    }
}