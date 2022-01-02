package jp.rotaryo.whitespace

import scala.collection.mutable

protected[whitespace] object ReadNumberOperation extends Operation {

  override def getSource(): String = {
    return io + "\t\t"
  }

  override def getParameter(): Option[Parameter] = {
    return None
  }

  override def preRun(container: Container, index: Int): Unit = {
  }

  override def run(container: Container, index: Int): Int = {
    val sb = new mutable.StringBuilder()
    while (sb.isEmpty || sb.last != '\n') {
      val c = container.readCharacter()
      if (c == -1) {
        sb.append('\n')
      } else {
        sb.append(c.toChar)
      }
    }
    container.setHeap(container.popValue(), BigInt(sb.toString.trim))

    return index + 1
  }
}
