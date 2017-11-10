package hello;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class OperationsController {

    @Autowired
    public JurisdictionController jurisdictionController;
    public String jurisdiction;


    public OperationsController() {

    }

    @RequestMapping(path = "/stopMonitoring")
    @ResponseStatus(HttpStatus.OK)
    public void operators() throws IOException {
        if (jurisdiction == null) jurisdiction = jurisdictionController.jurisdiction;
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Application.opUrl).newBuilder();
        urlBuilder.addQueryParameter("api_key", jurisdiction + "/" + Application.token511);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .header("Host", "api.511.org")
                .header("Upgrade-Insecure-Requests", "1")
                .header("Consumes", "application/json; charset=utf-8")
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
        JSONObject json = new JSONObject(response.body());


    }

}