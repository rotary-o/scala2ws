package jp.rotaryo.whitespace

protected[whitespace] trait Parameter {

  def getSource(value: BigInt): String

  def parse(iterator: Iterator[Char]): BigInt
}
