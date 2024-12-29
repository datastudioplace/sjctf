package com.localhost8888.pages.general;

import com.localhost8888.enums.WebElements;
import com.localhost8888.exceptions.TableRowDoesNotExistException;
import java.util.Map;

public interface TablePage {

  void assertTableHasElementInEveryRow(WebElements deleteLink);

  void assertCorrectTableContents(Map<String, String> fieldDataFromPage)
      throws TableRowDoesNotExistException;
}
