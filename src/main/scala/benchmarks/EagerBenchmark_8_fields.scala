package benchmarks

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import model.eager._
import org.openjdk.jmh.infra.Blackhole

class EagerBenchmark_8_fields {

  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  @Benchmark
  def eager8(bh: Blackhole, holder: TxHolder): Unit = {
    val t = holder.tx.as[Transaction]
    bh.consume(t.id)
    bh.consume(t.accountId)
    bh.consume(t.devices.headOption.map(_.exactId.map(_ + "!")))
    bh.consume(t.order.created.map(_.dayOfYear))
    bh.consume(t.order.orderOrigin.map(_ + "!"))
    bh.consume(t.phoneNumbers.map(_.head))
    bh.consume(t.customer.accountCreated.map(_.minusDays(1)))
    bh.consume(t.customer.dateOfBirth.map(_.dayOfMonth()))
  }
}
