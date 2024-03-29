package jp.rotaryo.whitespace

import scala.collection.mutable

protected[whitespace] object NumberParameter extends Parameter {

  override def getSource(value: BigInt): String = {
    val source = new mutable.StringBuilder()
    var v = if (value < Constants.zero) -value else value
    source.append('\n')
    while (v != Constants.zero) {
      source.append(if (v % Constants.two != Constants.zero) '\t' else ' ')
      v = v >> 1
    }
    source.append(if (value < Constants.zero) '\t' else ' ')

    return source.reverse.toString
  }

  override def parse(iterator: Iterator[Char]): BigInt = {
    var sign = Constants.zero
    var value = Constants.zero
    while (iterator.hasNext) {
      val c = iterator.next()
      if (c == ' ') {
        if (sign == Constants.zero) {
          sign = Constants.one
        } else {
          value = value << 1
        }
      } else if (c == '\t') {
        if (sign == Constants.zero) {
          sign = Constants.minusOne
        } else {
          value = (value << 1) + Constants.one
        }
      } else if (c == '\n') {
        if (sign == Constants.zero) {
          throw new RuntimeException("invalid parameter.")
        }
        return sign * value
      }
    }
    throw new RuntimeException("invalid parameter.")
  }
}
