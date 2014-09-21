package jp.rotaryo.whitespace

protected[whitespace] object EndSubroutineOperation extends Operation {

  override def getSource(): String = {
    return flowControl + "\t\n"
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int) {
  }

  override def run(container: Container, index: Int): Int = {
    val option = container.popCallIndex
    if (option.nonEmpty) {
      return option.get + 1
    }

    return index + 1
  }
}
