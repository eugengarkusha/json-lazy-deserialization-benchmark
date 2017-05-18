package benchmarks

import java.util.concurrent.TimeUnit

import model._lazy.Transaction
import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole
import play.api.libs.json.Json

class LazySerialize {
  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  @Benchmark
  def lazySerialize(bh: Blackhole, holder: TxHolder): Unit = {
    val t = holder.tx.as[Transaction]
    bh.consume(Json.toJson(t))
  }
}
