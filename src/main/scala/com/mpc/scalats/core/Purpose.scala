package com.mpc.scalats.core

object Purpose extends scala.Enumeration {
  val Neither = Value("Not consumed or produced by the API") // unlikely to occur
  val OnlyConsumed = Value("Only consumed (but not produced) by the API")
  val OnlyProduced = Value("Only produced (but not consumed) by the API")
  val ConsumedAndProduced = Value("Both consumed and produced by the API")

  def from(isConsumed: Boolean, isProduced: Boolean): Value = (isConsumed, isProduced) match {
    case (false, false) => Neither
    case (false, true) => OnlyProduced
    case (true, false) => OnlyConsumed
    case (true, true) => ConsumedAndProduced
  }
}
