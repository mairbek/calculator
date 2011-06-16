package mairbek.calculator

import util.parsing.combinator.JavaTokenParsers

/**
 * <expression> ::= <term> | <term> "+" <expression> | <term> "-" <expression>
 * <term>       ::= <factor> | <factor> "*" <term> | <factor> "/" <term>
 * <factor>     ::= <value> | "(" <expression> ")"
 * <value>      ::= java float number
 */
trait Parser {
  def parse(text: String): Operation
}

object Parser {
  def scalaParser() = new ScalaParser()
}


class ScalaParser extends Parser with JavaTokenParsers {

  def expression: Parser[Operation] = (term ~ "+" ~ expression) ^^ {
    case left ~ plus ~ right => Plus(left, right)
  } | (term ~ "-" ~ expression) ^^ {
    case left ~ minus ~ right => Minus(left, right)
  } | term

  def term: Parser[Operation] = (factor ~ "*" ~ term) ^^ {
    case left ~ times ~ right => Times(left, right)
  } | (factor ~ "/" ~ term) ^^ {
    case left ~ div ~ right => Div(left, right)
  } | factor

  def factor: Parser[Operation] = value | "(" ~> expression <~ ")"

  def value: Parser[Value] = floatingPointNumber ^^ {
    x => Value(x.toFloat)
  }

  override def parse(text: String) = {
    parseAll(expression, text) match {
      case Success(result, in) => result
      case NoSuccess(msg, in) => throw new IllegalStateException("..." + msg)
    }
  }
}