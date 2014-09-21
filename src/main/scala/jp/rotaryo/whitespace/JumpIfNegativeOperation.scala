package jp.rotaryo.whitespace

protected[whitespace] object JumpIfNegativeOperation extends Operation {

  override def getSource(): String = {
    return flowControl + "\t\t"
  }

  override def getParameter(): Option[Parameter] = {
    return Some(LabelParameter)
  }

  override def preRun(container: Container, index: Int) {
  }

  override def run(container: Container, index: Int): Int = {
    if (container.popValue < Constants.zero) {
      return container.getLabelIndex(container.getParameter(index)) + 1
    }

    return index + 1
  }
}
