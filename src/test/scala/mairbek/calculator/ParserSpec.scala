package mairbek.calculator

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers


class ParserSpec extends Spec with ShouldMatchers {
  val parser = Parser.scalaParser()

  describe("Simple int value") {

    val test = "5"
    val context = ExecutionContext.createDefault()
    it("should be parsed") {
      val result = parser.parse(test)
      result.execute(context)

      context.pop() should be(5)
    }
  }

  describe("Simple float value") {

    val test = "10.5"
    val context = ExecutionContext.createDefault()
    it("should be parsed") {
      val result = parser.parse(test)
      result.execute(context)

      context.pop() should be(10.5)
    }
  }

  describe("Simple sum") {

    val test = "5 + 2"
    val context = ExecutionContext.createDefault()
    it("should be parsed") {
      val result = parser.parse(test)
      result.execute(context)

      context.pop() should be(7)
    }
  }

  describe("Simple minus") {

    val test = "5 - 2"
    val context = ExecutionContext.createDefault()
    it("should be parsed") {
      val result = parser.parse(test)
      result.execute(context)

      context.pop() should be(3)
    }
  }

  describe("Simple times") {

    val test = "5 * 2"
    val context = ExecutionContext.createDefault()
    it("should be parsed") {
      val result = parser.parse(test)
      result.execute(context)

      context.pop() should be(10)
    }
  }

  describe("Simple div") {

    val test = "10 / 2"
    val context = ExecutionContext.createDefault()
    it("should be parsed") {
      val result = parser.parse(test)
      result.execute(context)

      context.pop() should be(5)
    }
  }

  describe("Multiply and sum") {

    val test = "10 * 2 + 5"
    val context = ExecutionContext.createDefault()
    it("should be parsed") {
      val result = parser.parse(test)
      result.execute(context)

      context.pop() should be(25)
    }
  }

  describe("Multiply and sum braces") {

    val test = "10 * (2 + 5)"
    val context = ExecutionContext.createDefault()
    it("should be parsed") {
      val result = parser.parse(test)
      result.execute(context)

      context.pop() should be(70)
    }
  }

  describe("Div and sum") {

    val test = "10 / 2 + 5"
    val context = ExecutionContext.createDefault()
    it("should be parsed") {
      val result = parser.parse(test)
      result.execute(context)

      context.pop() should be(10)
    }
  }

  describe("Div and braces") {

    val test = "10 / (5 + 5)"
    val context = ExecutionContext.createDefault()
    it("should be parsed") {
      val result = parser.parse(test)
      result.execute(context)

      context.pop() should be(1)
    }
  }

  describe("Multisum") {

    val test = "5 + 5 + 5"
    val context = ExecutionContext.createDefault()
    it("should be parsed") {
      val result = parser.parse(test)
      result.execute(context)

      context.pop() should be(15)
    }
  }

}