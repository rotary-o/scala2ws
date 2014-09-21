package jp.rotaryo.whitespace

object Main {

  def main(args: Array[String]) {
    require(args.size > 0)

    Parser.parse(args(0)).run
  }
}
