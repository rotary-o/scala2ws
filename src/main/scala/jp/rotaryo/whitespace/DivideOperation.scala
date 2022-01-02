package jp.rotaryo.whitespace

protected[whitespace] object DivideOperation extends Operation {

  override def getSource(): String = {
    return arithmetic + "\t "
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int): Unit = {
  }

  override def run(container: Container, index: Int): Int = {
    val second = container.popValue()
    val first = container.popValue()
    // 余りの符号が右辺側の符号と同じになるようにする
    val r = first % second
    if ((r > Constants.zero && second < Constants.zero) ||
        (r < Constants.zero && second > Constants.zero)) {
      container.pushValue(first / second - Constants.one)
    } else {
      container.pushValue(first / second)
    }

    return index + 1
  }
}
