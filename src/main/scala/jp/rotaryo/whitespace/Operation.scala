package jp.rotaryo.whitespace

protected[whitespace] trait Operation {

  // IMP
  final val stackManipulation = " "
  final val arithmetic = "\t "
  final val heapAccess = "\t\t"
  final val flowControl = "\n"
  final val io = "\t\n"

  def getSource(): String

  def getParameter(): Option[Parameter]

  def preRun(container: Container, index: Int): Unit

  def run(container: Container, index: Int): Int
}
