package jp.rotaryo.whitespace

protected[whitespace] object EndSubroutineOperation extends Operation {

  override def getSource(): String = {
    return flowControl + "\t\n"
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int): Unit = {
  }

  override def run(container: Container, index: Int): Int = {
    val option = container.popCallIndex()
    if (option.nonEmpty) {
      return option.get + 1
    }

    throw new RuntimeException("cannot return.")
  }
}
