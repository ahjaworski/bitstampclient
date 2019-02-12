package nl.antek.bitstampclient;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Stateless
public class BitstampService {

    @Inject
    private BitstampClient client;

    @Schedule(second = "*/15", minute = "*", hour = "*", persistent = false)
    public void getPrice() {
        final BitstampPriceInfo bitstampPrice = client.getBitstampPrice();

        log.info("Bitstamp price: {}", bitstampPrice.getLast());
    }
}
