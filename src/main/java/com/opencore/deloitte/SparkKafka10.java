package com.opencore.deloitte;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import scala.Tuple2;

public class SparkKafka10 {
    public static void main( String[] args )
    {
      JavaSparkContext sc = new JavaSparkContext("local[1]", "testing");
      JavaStreamingContext ssc = new JavaStreamingContext(sc, Durations.seconds(30));

      processStream(ssc, sc);

      ssc.start();
      ssc.awaitTermination();
  }

  private static void processStream(JavaStreamingContext ssc, JavaSparkContext sc) {
    Map<String, Object> kafkaParams = new HashMap<>();
    kafkaParams.put("bootstrap.servers", "10.10.0.53:9099");
    kafkaParams.put("key.deserializer", StringDeserializer.class);
    kafkaParams.put("value.deserializer", StringDeserializer.class);
    kafkaParams.put("group.id", "test");
    // Add ssl parameters
    kafkaParams.put("security.protocol", "SSL");
    kafkaParams.put("ssl.truststore.location", "/home/sliebau/projects/db/3-Code/spark_kafka_10/src/main/resources/certs/kafka.client.truststore.jks");
    kafkaParams.put("ssl.truststore.password", "geheim");
    kafkaParams.put("ssl.keystore.location", "/home/sliebau/projects/db/3-Code/spark_kafka_10/src/main/resources/certs/kafka.client.keystore.jks");
    kafkaParams.put("ssl.keystore.password", "geheim");
    kafkaParams.put("ssl.key.password", "geheim");

    Collection<String> topics = Arrays.asList("test");

    final JavaInputDStream<ConsumerRecord<String, String>> stream =
        KafkaUtils.createDirectStream(
            ssc,
            LocationStrategies.PreferConsistent(),
            ConsumerStrategies.<String, String>Subscribe(topics, kafkaParams)
        );

    stream.mapToPair(
        new PairFunction<ConsumerRecord<String, String>, String, String>() {
          @Override
          public Tuple2<String, String> call(ConsumerRecord<String, String> record) {
            return new Tuple2<>(record.key(), record.value());
          }
        }).print();
  }
}
