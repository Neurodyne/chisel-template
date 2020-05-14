package firtest

import Helper._
import chisel3.stage.ChiselGeneratorAnnotation
import hello.emiter._
import hw._

import zio.test.Assertion._
import zio.test._

object EmiterSpec extends DefaultRunnableSpec {
  def spec = suite("Emiter Spec")(
    suite("Emitter Suite")(
      test("High Form emit") {
        emiter.emit(firHome, bufCircuit, High)
        assert(true)(isTrue)
      },
      test("Low Form emit") {
        emiter.emit(firHome, cntCircuit, Low)
        assert(true)(isTrue)
      },
      test("High Form emit complex") {
        emiter.emit(firHome, gcdCircuit, Verilog)
        assert(true)(isTrue)
      }
    )
  )
}

object Helper {

  val firHome = "src/main/scala/fir/"

  val bufCircuit: Seq[ChiselGeneratorAnnotation] = Seq(
    chisel3.stage.ChiselGeneratorAnnotation(() => new Regbuffer())
  )
  val cntCircuit: Seq[ChiselGeneratorAnnotation] = Seq(
    chisel3.stage.ChiselGeneratorAnnotation(() => new Counter(2))
  )
  val gcdCircuit: Seq[ChiselGeneratorAnnotation] = Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new GCD()))

  val emiter: Emiter = new Emiter() {}
}
