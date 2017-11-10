package hello;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class OkHttpClientSingleton {
    private static final OkHttpClientSingleton client = new OkHttpClientSingleton();
    private static final OkHttpClient okclient = new OkHttpClient();

    private OkHttpClientSingleton() { }

    public static OkHttpClientSingleton getOkHttpClient() { return client; }

    public JSONObject request(String apiKey, String url) throws Exception {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        urlBuilder.addQueryParameter("api_key", apiKey);
        urlBuilder.addQueryParameter("format", "json");
        String urlBuilt = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .header("Host", "api.511.org")
                .header("Upgrade-Insecure-Requests", "1")
                .header("Consumes", "application/json; charset=utf-8")
                .url(urlBuilt)
                .build();
        Response response = okclient.newCall(request).execute();
        String result = (response.body().string()).trim();
        int i = result.indexOf("{");
        result = result.substring(i);
        return new JSONObject(result);
    }
}
