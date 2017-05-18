package benchmarks

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import model._lazy._
import org.openjdk.jmh.infra.Blackhole


class LazyBenchmark_4_fields {

  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  @Benchmark
  def lazy4(bh: Blackhole, holder: TxHolder): Unit = {
    val t = holder.tx.as[Transaction]
    bh.consume(t.accountId.v)
    bh.consume(t.devices.v.headOption.map(_.exactId.map(_.v + "!")))
    bh.consume(t.order.v.created.map(_.v.dayOfYear))
    bh.consume(t.order.v.orderOrigin.map(_.v + "!"))
  }
}
