package kasio.controller;

import kasio.model.CalculatorModel;
import kasio.view.CalculatorView;

public class CalculatorController {
  private final CalculatorModel model;
  private final CalculatorView view;

  public CalculatorController(CalculatorModel model, CalculatorView view) {
    this.model = model;
    this.view = view;
    addListeners();
  }

  private void updateView() {
    view.setDisplayValue(model.getCurrentExpression());
    view.setCaretVisibility(!model.isInErrorState());
  }

  private void addListeners() {
    view.addAppendButtonListener(
        (evalText) -> {
          model.appendInput(evalText);
          updateView();
        });

    view.addWrapButtonListener(
        (wrapPrefix) -> {
          model.wrapCurrentExpression(wrapPrefix);
          updateView();
        });

    view.addAllClearButtonListener(
        () -> {
          model.clear();
          updateView();
        });

    view.addDelButtonListener(
        () -> {
          model.deleteLast();
          updateView();
        });

    view.addEqualsButtonListener(
        () -> {
          model.evaluate();
          updateView();
        });

    view.addAnsButtonListener(
        () -> {
          model.appendInput(model.getlastExpressionResult());
          updateView();
        });

    view.addTrayExitListener(
        () -> {
          model.clear();
          updateView();
          System.exit(0);
        });
  }
}
