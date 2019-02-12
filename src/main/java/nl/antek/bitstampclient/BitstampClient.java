package nl.antek.bitstampclient;

import javax.ejb.Stateless;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@Stateless
public class BitstampClient {

    public BitstampPriceInfo getBitstampPrice() {
        return ClientBuilder.newClient()
            .target("https://www.bitstamp.net/api/v2/ticker/btceur")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .get(BitstampPriceInfo.class);
    }
}
