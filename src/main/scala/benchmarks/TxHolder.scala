package benchmarks

import generators.TxGenerator
import model.eager.Transaction
import org.openjdk.jmh.annotations._
import play.api.libs.json.JsValue


@State(Scope.Thread)
class TxHolder {

  @Setup(Level.Iteration)
  def setUp() = {
    tx = TxGenerator.generate()
  }

  var tx: JsValue = _
}