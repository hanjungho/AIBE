package Devcos.AIBE.study_250228.web_client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class WebClient implements IWebClient {

    @Override
    public String sendRequest(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    @Override
    public HttpRequest makeRequest(String path, HttpMethod method, String body, String... headers) {
        return HttpRequest.newBuilder().uri(URI.create(path))
                .method(method.name, HttpRequest.BodyPublishers.ofString(body))
                .headers(headers)
                .build();
    }
}

// default -> 같은 패키지 내부에선 자유롭게 사용 가능
interface IWebClient {
    HttpClient httpClient = HttpClient.newBuilder().build();

    // body를 받을 것이다
    String sendRequest(HttpRequest request) throws IOException, InterruptedException;

    HttpRequest makeRequest(String path, HttpMethod method, String body, String... headers);

    enum HttpMethod {
        GET("GET"), POST("POST");
        final String name;

        HttpMethod(String method) {
            this.name = method;
        }
    }
}
