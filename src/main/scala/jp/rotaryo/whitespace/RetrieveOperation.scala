package jp.rotaryo.whitespace

protected[whitespace] object RetrieveOperation extends Operation {

  override def getSource(): String = {
    return heapAccess + "\t"
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int) {
  }

  override def run(container: Container, index: Int): Int = {
    container.pushValue(container.getHeap(container.popValue))

    return index + 1
  }
}
