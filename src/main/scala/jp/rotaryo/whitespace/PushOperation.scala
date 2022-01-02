package jp.rotaryo.whitespace

protected[whitespace] object PushOperation extends Operation {

  override def getSource(): String = {
    return stackManipulation + " "
  }

  override def getParameter(): Option[Parameter] = {
    return Some(NumberParameter)
  }

  override def preRun(container: Container, index: Int): Unit = {
  }

  override def run(container: Container, index: Int): Int = {
    container.pushValue(container.getParameter(index))

    return index + 1
  }
}
