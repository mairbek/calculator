package mairbek.calculator

class Value(val value: Double) extends Operation {

  def execute(context: ExecutionContext) {
    context.push(value)
  }
}

object Value {
  def apply(value: Double): Value = new Value(value)
}
