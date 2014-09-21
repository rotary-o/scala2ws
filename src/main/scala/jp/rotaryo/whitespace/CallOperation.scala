package jp.rotaryo.whitespace

protected[whitespace] object CallOperation extends Operation {

  override def getSource(): String = {
    return flowControl + " \t"
  }

  override def getParameter(): Option[Parameter] = {
    return Some(LabelParameter)
  }

  override def preRun(container: Container, index: Int) {
  }

  override def run(container: Container, index: Int): Int = {
    container.pushCallIndex(index)

    return container.getLabelIndex(container.getParameter(index))
  }
}
