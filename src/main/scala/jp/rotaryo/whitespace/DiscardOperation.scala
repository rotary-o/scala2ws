package jp.rotaryo.whitespace

protected[whitespace] object DiscardOperation extends Operation {

  override def getSource(): String = {
    return stackManipulation + "\n\n"
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int): Unit = {
  }

  override def run(container: Container, index: Int): Int = {
    container.popValue()

    return index + 1
  }
}
