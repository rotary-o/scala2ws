package jp.rotaryo.whitespace

protected[whitespace] object DuplicateOperation extends Operation {

  override def getSource(): String = {
    return stackManipulation + "\n "
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int) {
  }

  override def run(container: Container, index: Int): Int = {
    container.pushValue(container.getValue(Constants.zero))

    return index + 1
  }
}
