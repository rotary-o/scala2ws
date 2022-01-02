package jp.rotaryo.whitespace

protected[whitespace] object SlideOperation extends Operation {

  override def getSource(): String = {
    return stackManipulation + "\t\n"
  }

  override def getParameter(): Option[Parameter] = {
    return Some(NumberParameter)
  }

  override def preRun(container: Container, index: Int): Unit = {
  }

  override def run(container: Container, index: Int): Int = {
    val n = container.getParameter(index)
    if (n > Constants.zero) {
      val top = container.popValue()
      (Constants.zero until n).foreach { _ =>
        if (container.hasValue(Constants.zero)) {
          container.popValue()
        }
      }
      container.pushValue(top)
    } else if (n < Constants.zero) {
      val top = container.popValue()
      container.clearValues()
      container.pushValue(top)
    }
    // n == Constants.zeroのときは何もしない

    return index + 1
  }
}
