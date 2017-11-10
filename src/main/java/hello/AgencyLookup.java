package hello;

import com.squareup.okhttp.internal.framed.Settings;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;

import java.io.IOException;
import java.net.InetAddress;

public class AgencyLookup {

    public static void main(String[] args) throws Exception {
        lookup(61862);
    }

    public static void lookup(int stopCode) throws IOException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(Application.es), 9300));
        SearchResponse response = client.prepareSearch("transit-stops")
                .setQuery(QueryBuilders.termQuery("stopCode", stopCode))
                .get();
        System.out.println(response.getHits());
    }
}