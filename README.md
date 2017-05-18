This repo shows the performance benefits that lazy deserialization of case class fileds may bring
in situations where only a subset of fields is used after deserialization

run it with the folowing copmmand:
jmh:run -i 10 -wi 10 -f 2 -t 1  <benchmark class name>


results I got on my machine for the provided case class tree

[info] Benchmark                         Mode  Cnt      Score       Error  Units

[info] EagerBenchmark_16_fields.lazy16  thrpt   20   2771.506 ±  1369.833  ops/s
[info] LazyBenchmark_16_fields.lazy16   thrpt   20  19256.354 ±  9757.278  ops/s

[info] EagerBenchmark_8_fields.eager8   thrpt   18   3477.382 ±  4127.934  ops/s
[info] LazyBenchmark_8_fields.lazy8     thrpt   11  20490.003 ± 34327.984  ops/s

[info] EagerBenchmark_4_fields.eager4   thrpt   20   2838.796 ±  1130.229  ops/s
[info] LazyBenchmark_4_fields.lazy4     thrpt   20  48377.896 ± 39442.699  ops/s

[info] EagerSerialize.eagerSerialize    thrpt   20    623.064 ±   274.496  ops/s
[info] LazySerialize.lazySerialize      thrpt   20    556.441 ±   225.713  ops/s




