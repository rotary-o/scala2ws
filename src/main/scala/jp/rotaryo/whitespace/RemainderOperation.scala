package jp.rotaryo.whitespace

protected[whitespace] object RemainderOperation extends Operation {

  override def getSource(): String = {
    return arithmetic + "\t\t"
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int) {
  }

  override def run(container: Container, index: Int): Int = {
    val second = container.popValue
    val first = container.popValue
    // 余りの符号が右辺側の符号と同じになるようにする
    val r = first % second
    if ((r > Constants.zero && second < Constants.zero) ||
        (r < Constants.zero && second > Constants.zero)) {
      container.pushValue(r + second)
    } else {
      container.pushValue(r)
    }

    return index + 1
  }
}
