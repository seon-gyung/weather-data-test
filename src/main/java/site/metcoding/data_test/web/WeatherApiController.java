package site.metcoding.data_test.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherApiController {
    @RequestMapping(value = "/data/weather", method = RequestMethod.GET, produces = "application/json; charset=UTF8")
    public String weather() {
        StringBuilder sb = new StringBuilder();

        sb.append("http://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst?");
        sb.append(
                "serviceKey=fyPQfeQT%2BaCn46m4Ek8JrQQymRa1FfPzp67HCAXKlkfozQVRSDoB7I5SVea5ZL5n%2FbNNJEALAQrhyN9JoNg6NA%3D%3D&");
        sb.append("pageNo=1&");
        sb.append("numOfRows=10&");
        sb.append("dataType=JSON&");
        sb.append("CURRENT_DATE=2022050118&");
        sb.append("HOUR=24&");
        sb.append("COURSE_ID=1");

        try {
            URL url = new URL(sb.toString());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;

            while ((returnLine = br.readLine()) != null) {
                sb.append(returnLine);
            }
            urlConnection.disconnect();
            return sb.toString();

            // System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return "null";
        }

    }

}
