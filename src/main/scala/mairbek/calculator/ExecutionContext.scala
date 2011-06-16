package mairbek.calculator

import collection.mutable.Stack

trait ExecutionContext {
  def push(value: Double)

  def pop(): Double
}

object ExecutionContext {
  def createDefault() = new DefaultExecutionContext()
}

class DefaultExecutionContext extends ExecutionContext {
  val stack: Stack[Double] = Stack()

  override def pop(): Double = {
    stack.pop()
  }

  override def push(value: Double) {
    stack.push(value)
  }
}