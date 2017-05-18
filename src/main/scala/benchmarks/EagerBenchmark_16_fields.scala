package benchmarks


import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import model.eager._
import org.openjdk.jmh.infra.Blackhole

class EagerBenchmark_16_fields {

  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  @Benchmark
  def lazy16(bh: Blackhole, holder: TxHolder): Unit = {
    val t = holder.tx.as[Transaction]
    bh.consume(t.id)
    bh.consume(t.eventTime)
    bh.consume(t.accountId)
    bh.consume(t.devices.headOption.map(_.exactId.map(_ + "!")))
    bh.consume(t.devices.headOption.map(_.smartId.map(_.size)))
    bh.consume(t.devices.headOption.map(_.smartId.map(_.size)))
    bh.consume(t.order.created.map(_.dayOfYear))
    bh.consume(t.order.orderOrigin.map(_ + "!"))
    bh.consume(t.phoneNumbers.map(_.headOption))
    bh.consume(t.phoneNumbers.map(_.headOption.map(_.location.map(_.lat))))
    bh.consume(t.phoneNumbers.map(_.headOption.map(_.phoneNumber)))
    bh.consume(t.customer.accountCreated.map(_.minusDays(1)))
    bh.consume(t.customer.dateOfBirth.map(_.dayOfMonth()))
    bh.consume(t.customer.customerNumber.map(_.size))
    bh.consume(t.customer.email.map(_.size))
    bh.consume(t.customer.firstName.map(_.size))
    bh.consume(t.customer.lastName.map(_.size))

  }
}
