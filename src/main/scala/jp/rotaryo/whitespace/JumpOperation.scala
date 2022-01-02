package jp.rotaryo.whitespace

protected[whitespace] object JumpOperation extends Operation {

  override def getSource(): String = {
    return flowControl + " \n"
  }

  override def getParameter(): Option[Parameter] = {
    return Some(LabelParameter)
  }

  override def preRun(container: Container, index: Int): Unit = {
  }

  override def run(container: Container, index: Int): Int = {
    return container.getLabelIndex(container.getParameter(index)) + 1
  }
}
