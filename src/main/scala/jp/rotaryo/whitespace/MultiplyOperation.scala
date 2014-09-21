package jp.rotaryo.whitespace

protected[whitespace] object MultiplyOperation extends Operation {

  override def getSource(): String = {
    return arithmetic + " \n"
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int) {
  }

  override def run(container: Container, index: Int): Int = {
    val second = container.popValue
    val first = container.popValue
    container.pushValue(first * second)

    return index + 1
  }
}
