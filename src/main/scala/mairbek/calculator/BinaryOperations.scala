package mairbek.calculator

trait BinaryOperation extends Operation {
  val right: Operation
  val left: Operation
}

class Plus(val right: Operation, val left: Operation) extends BinaryOperation {
  def execute(context: ExecutionContext) {
    left.execute(context)
    right.execute(context)

    val value: Double = context.pop() + context.pop()
    context.push(value)
  }
}

object Plus {
  def apply(right: Operation, left: Operation): Plus = new Plus(right, left)
}

class Minus(val right: Operation, val left: Operation) extends BinaryOperation {
  def execute(context: ExecutionContext) {
    left.execute(context)
    right.execute(context)

    val value: Double = context.pop() - context.pop()
    context.push(value)
  }
}

object Minus {
  def apply(right: Operation, left: Operation): Minus = new Minus(right, left)
}

class Times(val right: Operation, val left: Operation) extends BinaryOperation {
  def execute(context: ExecutionContext) {
    left.execute(context)
    right.execute(context)

    val value: Double = context.pop() * context.pop()
    context.push(value)
  }
}

object Times {
  def apply(right: Operation, left: Operation): Times = new Times(right, left)
}

class Div(val right: Operation, val left: Operation) extends BinaryOperation {
  def execute(context: ExecutionContext) {
    left.execute(context)
    right.execute(context)

    val value: Double = context.pop() / context.pop()
    context.push(value)
  }
}

object Div {
  def apply(right: Operation, left: Operation): Div = new Div(right, left)
}