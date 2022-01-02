package jp.rotaryo.whitespace

protected[whitespace] object ReadCharacterOperation extends Operation {

  override def getSource(): String = {
    return io + "\t "
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int): Unit = {
  }

  override def run(container: Container, index: Int): Int = {
    val c = container.readCharacter()
    if (c == -1) {
      throw new RuntimeException("cannot read character.")
    }

    container.setHeap(container.popValue(), BigInt(c))

    return index + 1
  }
}
