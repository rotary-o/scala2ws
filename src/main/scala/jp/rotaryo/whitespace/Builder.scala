package jp.rotaryo.whitespace

import scala.collection.mutable

class Builder {

  private[this] val operations = mutable.ArrayBuffer.empty[Operation]
  private[this] val parameterMap = mutable.HashMap.empty[Int, BigInt]

  def push(number: Int): Builder = {
    parameterMap += (operations.size -> BigInt(number))
    operations += PushOperation
    return this
  }

  def duplicate(): Builder = {
    operations += DuplicateOperation
    return this
  }

  def copy(nth: Int): Builder = {
    parameterMap += (operations.size -> BigInt(nth))
    operations += CopyOperation
    return this
  }

  def swap(): Builder = {
    operations += SwapOperation
    return this
  }

  def discard(): Builder = {
    operations += DiscardOperation
    return this
  }

  def slide(n: Int): Builder = {
    parameterMap += (operations.size -> BigInt(n))
    operations += SlideOperation
    return this
  }

  def add(): Builder = {
    operations += AddOperation
    return this
  }

  def substract(): Builder = {
    operations += SubstractOperation
    return this
  }

  def multiply(): Builder = {
    operations += MultiplyOperation
    return this
  }

  def divide(): Builder = {
    operations += DivideOperation
    return this
  }

  def remainder(): Builder = {
    operations += RemainderOperation
    return this
  }

  def store(): Builder = {
    operations += StoreOperation
    return this
  }

  def retrieve(): Builder = {
    operations += RetrieveOperation
    return this
  }

  def mark(label: Int): Builder = {
    parameterMap += (operations.size -> BigInt(label))
    operations += MarkOperation
    return this
  }

  def call(label: Int): Builder = {
    parameterMap += (operations.size -> BigInt(label))
    operations += CallOperation
    return this
  }

  def jump(label: Int): Builder = {
    parameterMap += (operations.size -> BigInt(label))
    operations += JumpOperation
    return this
  }

  def jumpIfZero(label: Int): Builder = {
    parameterMap += (operations.size -> BigInt(label))
    operations += JumpIfZeroOperation
    return this
  }

  def jumpIfNegative(label: Int): Builder = {
    parameterMap += (operations.size -> BigInt(label))
    operations += JumpIfNegativeOperation
    return this
  }

  def endSubroutine(): Builder = {
    operations += EndSubroutineOperation
    return this
  }

  def endProgram(): Builder = {
    operations += EndProgramOperation
    return this
  }

  def outputCharacter(): Builder = {
    operations += OutputCharacterOperation
    return this
  }

  def outputNumber(): Builder = {
    operations += OutputNumberOperation
    return this
  }

  def readCharacter(): Builder = {
    operations += ReadCharacterOperation
    return this
  }

  def readNumber(): Builder = {
    operations += ReadNumberOperation
    return this
  }

  def build(): Intermediate = {
    return new Container(operations.toArray, parameterMap.toMap)
  }
}

object Builder {

  def newBuilder(): Builder = {
    return new Builder
  }
}
