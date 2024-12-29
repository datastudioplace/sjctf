package com.localhost8888.tableutils;

import com.localhost8888.exceptions.TableRowDoesNotExistException;
import com.localhost8888.webelementdata.TableData;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InteractableTableWebElementFinderAndClicker {

  public static Map<String, Integer> deletedRowOnTablePageMap = new HashMap<>();
  private TableData tableData;
  private int rowNumber;
  private String pageName;

  public InteractableTableWebElementFinderAndClicker(TableData tableData, String pageName) {
    this.tableData = tableData;
    this.pageName = pageName;
  }

  public void findAndClickInteractableTableWebElement(String interactableElementId, int rowNumber)
      throws TableRowDoesNotExistException {
    this.rowNumber = rowNumber;
    WebElement row = findRowForTable();
    WebElement element =
        row.findElement(By.id(interactableElementId + Integer.toString(this.rowNumber + 1)));
    element.click();
  }

  private WebElement findRowForTable() throws TableRowDoesNotExistException {
    checkIfAPreviousRowNumberSmallerThanGivenRowNumberHasBeenDeletedAndDecreaseRowNumberByOneAndAdjustIt();
    return tableData.getTableBodyRowWebElement(rowNumber);
  }

  private void
      checkIfAPreviousRowNumberSmallerThanGivenRowNumberHasBeenDeletedAndDecreaseRowNumberByOneAndAdjustIt() {
    for (Entry<String, Integer> entry : deletedRowOnTablePageMap.entrySet()) {
      adjustRowNumberByMinusOneIfThereIsAPreviousRowAlreadyDeleted(entry);
    }
  }

  private void adjustRowNumberByMinusOneIfThereIsAPreviousRowAlreadyDeleted(
      Entry<String, Integer> entry) {
    if (isThereAPreviousRowNumberSmallerThanGivenRowNumberAndHasBeenDeleted(entry)) {
      --rowNumber;
    }
  }

  private boolean isThereAPreviousRowNumberSmallerThanGivenRowNumberAndHasBeenDeleted(
      Entry<String, Integer> entry) {
    return entry.getKey().equals(pageName) && entry.getValue() < rowNumber;
  }
}
