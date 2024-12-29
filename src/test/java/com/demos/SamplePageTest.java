package com.demos;

import com.localhost8888.pages.SamplePage;
import org.testng.annotations.Test;

public class SamplePageTest {

    @Test
    public void testCorrectAndActivePage() {
        SamplePage samplePage = new SamplePage();
        samplePage.waitForPageToBeFullyLoaded();
        //boolean isCorrectPage = samplePage.isCorrectAndActivePage();
        //Assert.assertTrue(isCorrectPage, "The page is not the correct and active page.");
    }
}