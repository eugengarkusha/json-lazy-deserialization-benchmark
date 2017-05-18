
package benchmarks

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import model.eager._
import org.openjdk.jmh.infra.Blackhole

class EagerBenchmark_4_fields {

  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  @Benchmark
  def eager4(bh: Blackhole, holder: TxHolder): Unit = {
    val t = holder.tx.as[Transaction]
    bh.consume(t.accountId)
    bh.consume(t.devices.headOption.map(_.exactId.map(_ + "!")))
    bh.consume(t.order.created.map(_.dayOfYear))
    bh.consume((t.order.orderOrigin.map(_ + "!")))

  }

}
