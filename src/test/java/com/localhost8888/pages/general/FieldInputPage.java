package com.localhost8888.pages.general;

import com.localhost8888.model.FieldInputModel;
import java.util.List;

public interface FieldInputPage {
  void inputFieldModelDataIntoAllPageFields(FieldInputModel fieldInputModel);

  void inputFieldModelDataIntoSpecifiedPageFields(
      FieldInputModel fieldInputModel, List<String> field);

  void assertOnAllInputFieldsBeingCorrectlyPopulated(FieldInputModel fieldInputModel);

  void assertEditableFieldsCanBeEdited();
}
