package jp.rotaryo.whitespace

protected[whitespace] object OutputCharacterOperation extends Operation {

  override def getSource(): String = {
    return io + "  "
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int): Unit = {
  }

  override def run(container: Container, index: Int): Int = {
    print(container.popValue().toChar)

    return index + 1
  }
}
