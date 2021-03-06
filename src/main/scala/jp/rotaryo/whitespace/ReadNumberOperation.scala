package jp.rotaryo.whitespace

import scala.collection.mutable

protected[whitespace] object ReadNumberOperation extends Operation {

  override def getSource(): String = {
    return io + "\t\t"
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int) {
  }

  override def run(container: Container, index: Int): Int = {
    val sb = mutable.StringBuilder.newBuilder
    while (sb.isEmpty || sb.last != '\n') {
      sb.append(container.readCharacter.toChar)
    }
    container.setHeap(container.popValue, BigInt(sb.toString.trim))

    return index + 1
  }
}
