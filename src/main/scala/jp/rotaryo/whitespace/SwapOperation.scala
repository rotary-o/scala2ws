package jp.rotaryo.whitespace

protected[whitespace] object SwapOperation extends Operation {

  override def getSource(): String = {
    return stackManipulation + "\n\t"
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int): Unit = {
  }

  override def run(container: Container, index: Int): Int = {
    val second = container.popValue()
    val first = container.popValue()
    container.pushValue(second)
    container.pushValue(first)

    return index + 1
  }
}
