package jp.rotaryo.whitespace

protected[whitespace] object SubstractOperation extends Operation {

  override def getSource(): String = {
    return arithmetic + " \t"
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int): Unit = {
  }

  override def run(container: Container, index: Int): Int = {
    val second = container.popValue()
    val first = container.popValue()
    container.pushValue(first - second)

    return index + 1
  }
}
