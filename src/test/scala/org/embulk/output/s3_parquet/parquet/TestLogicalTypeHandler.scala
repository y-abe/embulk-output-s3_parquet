package org.embulk.output.s3_parquet.parquet

import org.embulk.spi.DataException
import org.embulk.spi.`type`.Types
import org.scalatest.diagrams.Diagrams
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Try

class TestLogicalTypeHandler extends AnyFunSuite with Diagrams {

  test("IntLogicalTypeHandler.isConvertible() returns true for long") {
    val h = Int8LogicalTypeHandler

    assert(h.isConvertible(Types.LONG))
    assert(!h.isConvertible(Types.BOOLEAN))
  }

  test(
    "IntLogicalTypeHandler.consume() raises DataException if given type is not long"
  ) {
    val h = Int8LogicalTypeHandler
    val actual = Try(h.consume("invalid", null))

    assert(actual.isFailure)
    assert(actual.failed.get.isInstanceOf[DataException])
  }

  test(
    "TimestampMillisLogicalTypeHandler.isConvertible() returns true for timestamp"
  ) {
    val h = TimestampMillisLogicalTypeHandler

    assert(h.isConvertible(Types.TIMESTAMP))
    assert(!h.isConvertible(Types.BOOLEAN))
  }

  test(
    "TimestampMillisLogicalTypeHandler.consume() raises DataException if given type is not timestamp"
  ) {
    val h = TimestampMillisLogicalTypeHandler
    val actual = Try(h.consume("invalid", null))

    assert(actual.isFailure)
    assert(actual.failed.get.isInstanceOf[DataException])
  }

  test(
    "TimestampMicrosLogicalTypeHandler.isConvertible() returns true for timestamp"
  ) {
    val h = TimestampMicrosLogicalTypeHandler

    assert(h.isConvertible(Types.TIMESTAMP))
    assert(!h.isConvertible(Types.BOOLEAN))
  }

  test(
    "TimestampMicrosLogicalTypeHandler.consume() raises DataException if given type is not timestamp"
  ) {
    val h = TimestampMicrosLogicalTypeHandler
    val actual = Try(h.consume("invalid", null))

    assert(actual.isFailure)
    assert(actual.failed.get.isInstanceOf[DataException])
  }

  test(
    "TimestampNanosLogicalTypeHandler.isConvertible() returns true for timestamp"
  ) {
    val h = TimestampNanosLogicalTypeHandler

    assert(h.isConvertible(Types.TIMESTAMP))
    assert(!h.isConvertible(Types.BOOLEAN))
  }

  test(
    "TimestampNanosLogicalTypeHandler.consume() raises DataException if given type is not timestamp"
  ) {
    val h = TimestampNanosLogicalTypeHandler
    val actual = Try(h.consume("invalid", null))

    assert(actual.isFailure)
    assert(actual.failed.get.isInstanceOf[DataException])
  }

  test("JsonLogicalTypeHandler.isConvertible() returns true for json") {
    val h = JsonLogicalTypeHandler

    assert(h.isConvertible(Types.JSON))
    assert(!h.isConvertible(Types.BOOLEAN))
  }

  test(
    "JsonLogicalTypeHandler.consume() raises DataException if given type is not json"
  ) {
    val h = JsonLogicalTypeHandler
    val actual = Try(h.consume("invalid", null))
    assert(actual.isFailure)
    assert(actual.failed.get.isInstanceOf[DataException])
  }
}
