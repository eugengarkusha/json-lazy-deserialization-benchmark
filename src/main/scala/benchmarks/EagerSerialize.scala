package benchmarks

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import model.eager._
import org.openjdk.jmh.infra.Blackhole
import play.api.libs.json.Json

class EagerSerialize {

  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  @Benchmark
  def eagerSerialize(bh: Blackhole, holder: TxHolder): Unit = {
    val t = holder.tx.as[Transaction]
    bh.consume(Json.toJson(t))
  }
}
