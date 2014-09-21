package jp.rotaryo.whitespace

protected[whitespace] object MarkOperation extends Operation {

  override def getSource(): String = {
    return flowControl + "  "
  }

  override def getParameter(): Option[Parameter] = {
    return Some(LabelParameter)
  }

  override def preRun(container: Container, index: Int) {
    container.setLabelIndex(container.getParameter(index), index)
  }

  override def run(container: Container, index: Int): Int = {
    return index + 1
  }
}
