package jp.rotaryo.whitespace

import scala.collection.mutable

protected[whitespace] object LabelParameter extends Parameter {

  override def getSource(value: BigInt): String = {
    val source = mutable.StringBuilder.newBuilder
    var v = value
    source.append('\n')
    if (value < Constants.zero) {
      v = v + Constants.one
    } else if (value > Constants.zero) {
      v = v - Constants.one
    }
    while (v != Constants.zero) {
      source.append(if (v % Constants.two != Constants.zero) '\t' else ' ')
      v = v >> 1
    }
    if (value < Constants.zero) {
      source.append('\t')
    } else if (value > Constants.zero) {
      source.append(' ')
    }

    return source.reverse.toString
  }

  override def parse(iterator: Iterator[Char]): BigInt = {
    var value = Constants.zero
    while (iterator.hasNext) {
      val c = iterator.next
      if (c == ' ') {
        if (value == Constants.zero) {
          value = Constants.one
        } else {
          value = value << 1
        }
      } else if (c == '\t') {
        if (value == Constants.zero) {
          value = Constants.minusOne
        } else {
          value = value << 1
          value +=
            (if (value < Constants.zero) Constants.minusOne else Constants.one)
        }
      } else if (c == '\n') {
        return value
      }
    }
    throw new RuntimeException("invalid parameter.")
  }
}
