package jp.rotaryo.whitespace

protected[whitespace] object EndProgramOperation extends Operation {

  override def getSource(): String = {
    return flowControl + "\n\n"
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int): Unit = {
  }

  override def run(container: Container, index: Int): Int = {
    return -1
  }
}
