package jp.rotaryo.whitespace

import scala.collection.mutable
import java.io.InputStreamReader

private[whitespace] class Container(
    val operations: Array[Operation], val parameterMap: Map[Int, BigInt])
    extends Intermediate {
  require(operations != null)
  require(parameterMap != null)

  private[this] val valueStack = mutable.Stack.empty[BigInt]
  private[this] val heapMap = mutable.HashMap.empty[BigInt, BigInt]
  private[this] val labelMap = mutable.HashMap.empty[BigInt, Int]
  private[this] val callStack = mutable.Stack.empty[Int]
  private[this] val reader = new InputStreamReader(System.in)

  private[whitespace] def getParameter(index: Int): BigInt = {
    require(index >= 0)

    return parameterMap(index)
  }

  private[whitespace] def pushValue(value: BigInt) {
    valueStack.push(value)
  }

  private[whitespace] def popValue(): BigInt = {
    return valueStack.pop
  }

  private[whitespace] def hasValue(nth: BigInt): Boolean = {
    return (nth >= Constants.zero &&
        nth <= Constants.intMax &&
        nth.toInt < valueStack.size)
  }

  private[whitespace] def getValue(nth: BigInt): BigInt = {
    if (hasValue(nth)) {
      return valueStack(nth.toInt)
    }
    throw new RuntimeException("invalid index of value stack : " + nth.toString)
  }

  private[whitespace] def clearValues() {
    valueStack.clear
  }

  private[whitespace] def setHeap(address: BigInt, value: BigInt) {
    require(address >= Constants.zero)

    heapMap += (address -> value)
  }

  private[whitespace] def getHeap(address: BigInt): BigInt = {
    require(address >= Constants.zero)

    val option = heapMap.get(address)
    return if (option.nonEmpty) option.get else Constants.zero
  }

  private[whitespace] def setLabelIndex(label: BigInt, index: Int) {
    require(index >= 0)

    if (!labelMap.contains(label)) {
      labelMap += (label -> index)
    }
  }

  private[whitespace] def getLabelIndex(label: BigInt): Int = {
    val option = labelMap.get(label)
    if (option.isEmpty) {
      throw new RuntimeException("invalid label : " + label.toString)
    }
    return option.get
  }

  private[whitespace] def pushCallIndex(index: Int) {
    callStack.push(index)
  }

  private[whitespace] def popCallIndex(): Option[Int] = {
    return if (callStack.nonEmpty) Some(callStack.pop) else None
  }

  private[whitespace] def readCharacter(): Int = {
    val c = reader.read
    if (c == -1) {
      throw new RuntimeException("cannot read character.")
    }
    return c
  }

  override def getSource(): String = {
    val source = mutable.StringBuilder.newBuilder
    (0 until operations.size).foreach { index =>
      val op = operations(index)
      source.append(op.getSource)
      val param = op.getParameter
      if (param.nonEmpty) {
        source.append(param.get.getSource(getParameter(index)))
      }
    }
    return source.toString
  }

  override def run() {
    try {
      (0 until operations.size).foreach { index =>
        operations(index).preRun(this, index)
      }
      var index = 0
      while (index >= 0) {
        if (index >= operations.size) {
          throw new RuntimeException("no such operations.")
        }
        index = operations(index).run(this, index)
      }
    } finally {
      valueStack.clear
      heapMap.clear
      labelMap.clear
      callStack.clear
    }
  }
}
