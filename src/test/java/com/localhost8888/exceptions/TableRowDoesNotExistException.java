package com.localhost8888.exceptions;

import java.util.List;
import org.openqa.selenium.WebElement;

public class TableRowDoesNotExistException extends Exception {
  public TableRowDoesNotExistException(String message) {
    super(message);
  }

  public static void checkIfTableRowExistsOrElseThrowException(
      String string, List<WebElement> rows, int rowIndex) throws TableRowDoesNotExistException {
    if (rows == null || rows.isEmpty())
      throw new TableRowDoesNotExistException(
          "The specified row does not exist within the Academic Qualification Table.");
    try {
      rows.get(rowIndex);
    } catch (IndexOutOfBoundsException e) {
      throw new TableRowDoesNotExistException(
          "The specified row does not exist within the Academic Qualification Table.");
    }
  }
}
