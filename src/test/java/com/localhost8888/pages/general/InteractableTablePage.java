package com.localhost8888.pages.general;

import com.localhost8888.enums.WebElements;
import com.localhost8888.exceptions.TableRowDoesNotExistException;

public interface InteractableTablePage extends TablePage {

  void clickTableElementOnRow(WebElements tableEditButton, int rowNumber, String pageName)
      throws TableRowDoesNotExistException;
}
