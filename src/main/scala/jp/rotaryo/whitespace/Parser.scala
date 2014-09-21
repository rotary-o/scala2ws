package jp.rotaryo.whitespace

import scala.collection.mutable
import scala.io.Source

private[whitespace] object Parser {

  private val operationMap = List(
      PushOperation,
      DuplicateOperation,
      CopyOperation,
      SwapOperation,
      DiscardOperation,
      SlideOperation,
      AddOperation,
      SubstractOperation,
      MultiplyOperation,
      DivideOperation,
      RemainderOperation,
      StoreOperation,
      RetrieveOperation,
      MarkOperation,
      CallOperation,
      JumpOperation,
      JumpIfZeroOperation,
      JumpIfNegativeOperation,
      EndSubroutineOperation,
      EndProgramOperation,
      OutputCharacterOperation,
      OutputNumberOperation,
      ReadCharacterOperation,
      ReadNumberOperation).map(op => (op.getSource, op)).toMap
  private val maxSize = operationMap.keys.map(s => s.size).max
  private val includeChars = operationMap.keys.foldLeft(Set.empty[Char])(
      (set, s) => set ++ s.toCharArray)

  def parse(filePath: String): Intermediate = {
    val src = Source.fromFile(filePath)
    try {
      val operations = mutable.ArrayBuffer.empty[Operation]
      val parameterMap = mutable.HashMap.empty[Int, BigInt]
      val sb = mutable.StringBuilder.newBuilder
      while (src.hasNext) {
        val c = src.next
        if (includeChars.contains(c)) {
          sb.append(c)
          val s = sb.toString
          val op = operationMap.get(s)
          if (op.nonEmpty) {
            val param = op.get.getParameter
            if (param.nonEmpty) {
              parameterMap += (operations.size -> param.get.parse(src))
            }
            operations += op.get
            sb.clear
          } else if (sb.size >= maxSize) {
            throw new RuntimeException("invalid token : " + s)
          }
        }
      }
      // 残りは無視

      return new Container(operations.toArray, parameterMap.toMap)
    } finally {
      src.close
    }
  }
}
