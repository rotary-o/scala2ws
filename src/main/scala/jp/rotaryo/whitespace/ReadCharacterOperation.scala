package jp.rotaryo.whitespace

protected[whitespace] object ReadCharacterOperation extends Operation {

  override def getSource(): String = {
    return io + "\t "
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int) {
  }

  override def run(container: Container, index: Int): Int = {
    container.setHeap(container.popValue, BigInt(container.readCharacter))

    return index + 1
  }
}
