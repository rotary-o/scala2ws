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
    val top = container.popValue()
    if (top < Constants.zero) {
      throw new RuntimeException("invalid character : " + top.toString)
    }
    print((top % Constants.charMax).toChar)

    return index + 1
  }
}
