package jp.rotaryo.whitespace

protected[whitespace] object StoreOperation extends Operation {

  override def getSource(): String = {
    return heapAccess + " "
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int): Unit = {
  }

  override def run(container: Container, index: Int): Int = {
    val second = container.popValue()
    val first = container.popValue()
    container.setHeap(first, second)

    return index + 1
  }
}
