package mairbek.calculator

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class OperationsSpec extends Spec with ShouldMatchers {
  describe("Value Operation") {
      val context = ExecutionContext.createDefault()

      val value = Value(5)

      value.execute(context)

      it ("should be pushed to the context") {
        context.pop() should be (5)
      }
  }

  describe("Sum Operation") {
      val context = ExecutionContext.createDefault()

      val sum = Plus(Value(5), Value(10))

      sum.execute(context)

      it ("should be pushed to the context") {
        context.pop() should be (15)
      }
  }

  describe("Minus Operation") {
      val context = ExecutionContext.createDefault()

      val minus = Minus(Value(10), Value(5))

      minus.execute(context)

      it ("should be pushed to the context") {
        context.pop() should be (5)
      }
  }

  describe("Complex operation") {
    val context = ExecutionContext.createDefault()

    val op = Minus(Plus(Value(5), Value(6)), Value(5))

    op.execute(context)

    it ("should be pushed to the context") {
      context.pop() should be (6)
    }

  }
}