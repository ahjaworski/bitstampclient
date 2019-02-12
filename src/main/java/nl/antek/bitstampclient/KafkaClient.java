package nl.antek.bitstampclient;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Stateless
public class KafkaClient {

    private Properties properties;

    @PostConstruct
    public void init() {

        final Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:32768");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.DoubleSerializer");
        this.properties = properties;
    }

    public void send(BitstampPriceInfo bitstampPriceInfo) {
        try (org.apache.kafka.clients.producer.Producer producer = new KafkaProducer<>(properties)) {
            log.debug("Sending message to kafka: {}", bitstampPriceInfo);
            producer.send(new ProducerRecord<>("bitstamp", "price", bitstampPriceInfo.getLast()));
        }
    }
}
