package jp.rotaryo.whitespace

protected[whitespace] object CopyOperation extends Operation {

  override def getSource(): String = {
    return stackManipulation + "\t "
  }

  override def getParameter(): Option[Parameter] = {
    return Some(NumberParameter)
  }

  override def preRun(container: Container, index: Int) {
  }

  override def run(container: Container, index: Int): Int = {
    container.pushValue(container.getValue(container.getParameter(index)))

    return index + 1
  }
}
