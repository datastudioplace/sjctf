package com.localhost8888.pagecollections;

import com.localhost8888.pages.Page;
import com.localhost8888.webdriverutilities.WebDrv;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CandidatePageCollection {

  private static final List<Class<? extends Page>> pages =
      new List<>() {
        @Override
        public int size() {
          return 0;
        }

        @Override
        public boolean isEmpty() {
          return false;
        }

        @Override
        public boolean contains(Object o) {
          return false;
        }

        @Override
        public Iterator<Class<? extends Page>> iterator() {
          return null;
        }

        @Override
        public Object[] toArray() {
          return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
          return null;
        }

        @Override
        public boolean add(Class<? extends Page> aClass) {
          return false;
        }

        @Override
        public boolean remove(Object o) {
          return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
          return false;
        }

        @Override
        public boolean addAll(Collection<? extends Class<? extends Page>> c) {
          return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Class<? extends Page>> c) {
          return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
          return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
          return false;
        }

        @Override
        public void clear() {}

        @Override
        public boolean equals(Object o) {
          return false;
        }

        @Override
        public int hashCode() {
          return 0;
        }

        @Override
        public Class<? extends Page> get(int index) {
          return null;
        }

        @Override
        public Class<? extends Page> set(int index, Class<? extends Page> element) {
          return null;
        }

        @Override
        public void add(int index, Class<? extends Page> element) {}

        @Override
        public Class<? extends Page> remove(int index) {
          return null;
        }

        @Override
        public int indexOf(Object o) {
          return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
          return 0;
        }

        @Override
        public ListIterator<Class<? extends Page>> listIterator() {
          return null;
        }

        @Override
        public ListIterator<Class<? extends Page>> listIterator(int index) {
          return null;
        }

        @Override
        public List<Class<? extends Page>> subList(int fromIndex, int toIndex) {
          return List.of();
        }
      };
  private static Page currentPage;
  private static ListIterator<Class<? extends Page>> iterator = pages.listIterator();
  private final WebDriver driver = WebDrv.getInstance().getWebDriver();

  public static void moveToPage(Class<?> pageClass) {
    if (currentPage == null || !currentPage.doesThePageHaveValidationErrors()) {
      boolean cursorHasMovedBackTwice = false;
      if (iterator.nextIndex() != 0) {
        resetIteratorToStart();
      }
      Class<?> activePage;
      while (iterator.hasNext()) {
        activePage = iterator.next();
        if (activePage == pageClass) {
          currentPage =
              (Page) PageFactory.initElements(WebDrv.getInstance().getWebDriver(), pageClass);
          break;
        }
      }
    }
  }

  private static void resetIteratorToStart() {
    while (iterator.hasPrevious()) {
      iterator.previous();
    }
  }

  public static Page getCurrentPage() {
    return currentPage;
  }

  public void assertOnHeadingText(String expectedHeadingText) {
    WebElement headingElement = driver.findElement(By.cssSelector("span.maintext"));
    String actualHeadingText = headingElement.getText().trim();
    Assert.assertEquals(
        actualHeadingText,
        expectedHeadingText,
        "The page heading text did not match the expected value.");
  }

  public WebElement getElement(By id) {
    return driver.findElement(id);
  }
}
