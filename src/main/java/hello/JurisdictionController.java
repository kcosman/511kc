package hello;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JurisdictionController {

    public String jurisdiction;

    @RequestMapping(path = "/jurisdictions")
    @ResponseStatus(HttpStatus.OK)
    public void getJurisdictions() throws Exception {
        OkHttpClientSingleton client = OkHttpClientSingleton.getOkHttpClient();
        JSONObject j = client.request(Application.jur, Application.token511);
        System.out.println(j);

    }
}