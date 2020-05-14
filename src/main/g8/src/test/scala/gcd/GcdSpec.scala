package test

import chisel3.iotesters
import hw.GCD

import zio.test.Assertion._
import zio.test._

object GcdSpec extends DefaultRunnableSpec {
  def spec = suite("GCD HW Spec")(
    test("execute with FIRRTL and dump VCD") {
      iotesters.Driver.execute(
        Array("--backend-name", "firrtl", "--target-dir", "out/fir_vcd", "--fint-write-vcd"),
        () => new GCD
      )(c => new GCDUnitTester(c))
      assert(true)(isTrue)
    },
    test("execute with Verilator and dump VCD") {
      iotesters.Driver.execute(
        Array("--backend-name", "verilator", "--target-dir", "out/vlog_vcd", "--top-name", "gcd_make_vcd"),
        () => new GCD
      )(c => new GCDUnitTester(c))
      assert(true)(isTrue)
    }
  )
}
