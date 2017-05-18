package benchmarks

import java.util.concurrent.TimeUnit

import model._lazy.Transaction
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.infra.Blackhole

/**
  * Created by ievgengarkusha on 17.05.17.
  */
class LazyBenchmark_16_fields {

  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  @Benchmark
  def lazy16(bh: Blackhole, holder: TxHolder): Unit = {
    val t = holder.tx.as[Transaction]
    bh.consume(t.id.v)
    bh.consume(t.eventTime.v)
    bh.consume(t.accountId.v)
    bh.consume(t.devices.v.headOption.map(_.exactId.map(_.v + "!")))
    bh.consume(t.devices.v.headOption.map(_.smartId.map(_.v.size)))
    bh.consume(t.devices.v.headOption.map(_.smartId.map(_.v.size)))
    bh.consume(t.order.v.created.map(_.v.dayOfYear))
    bh.consume(t.order.v.orderOrigin.map(_.v + "!"))
    bh.consume(t.phoneNumbers.map(_.v.headOption))
    bh.consume(t.phoneNumbers.map(_.v.headOption.map(_.location.map(_.v.lat))))
    bh.consume(t.phoneNumbers.map(_.v.headOption.map(_.phoneNumber.v)))
    bh.consume(t.customer.v.accountCreated.map(_.v.minusDays(1)))
    bh.consume(t.customer.v.dateOfBirth.map(_.v.dayOfMonth()))
    bh.consume(t.customer.v.customerNumber.map(_.v.size))
    bh.consume(t.customer.v.email.map(_.v.size))
    bh.consume(t.customer.v.firstName.map(_.v.size))
    bh.consume(t.customer.v.lastName.map(_.v.size))

  }
}
