#  Output

Content of the topic was a ping command piped into the topic, hence the output format below.

```
2016-12-15 00:06:16 WARN  NativeCodeLoader:62 - Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
2016-12-15 00:06:18 WARN  StreamingContext:70 - spark.master should be set as local[n], n > 1 in local mode if you have receivers to get data, otherwise Spark jobs will not get resources to process the received data.
2016-12-15 00:06:19 WARN  KafkaUtils:70 - overriding enable.auto.commit to false for executor
2016-12-15 00:06:19 WARN  KafkaUtils:70 - overriding auto.offset.reset to none for executor
2016-12-15 00:06:19 WARN  KafkaUtils:70 - overriding executor group.id to spark-executor-test
2016-12-15 00:06:19 WARN  KafkaUtils:70 - overriding receive.buffer.bytes to 65536 see KAFKA-3135
-------------------------------------------
Time: 1481756790000 ms
-------------------------------------------
(null,64 bytes from 10.10.0.10: icmp_seq=1812 ttl=64 time=0.212 ms)
(null,64 bytes from 10.10.0.10: icmp_seq=1813 ttl=64 time=0.189 ms)
(null,64 bytes from 10.10.0.10: icmp_seq=1814 ttl=64 time=0.199 ms)
(null,64 bytes from 10.10.0.10: icmp_seq=1815 ttl=64 time=0.175 ms)
(null,64 bytes from 10.10.0.10: icmp_seq=1816 ttl=64 time=0.205 ms)
(null,64 bytes from 10.10.0.10: icmp_seq=1817 ttl=64 time=0.176 ms)
(null,64 bytes from 10.10.0.10: icmp_seq=1818 ttl=64 time=0.164 ms)
(null,64 bytes from 10.10.0.10: icmp_seq=1819 ttl=64 time=0.194 ms)
(null,64 bytes from 10.10.0.10: icmp_seq=1820 ttl=64 time=0.216 ms)
(null,64 bytes from 10.10.0.10: icmp_seq=1821 ttl=64 time=0.213 ms)
...
```