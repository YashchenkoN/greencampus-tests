package ua.greencampus.tests.client;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.greencampus.tests.common.request.Request;
import ua.greencampus.tests.common.response.JsonResponse;
import ua.greencampus.tests.common.response.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collections;

/**
 * @author Mykola Yashchenko
 */
public class GreenCampusClient implements Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreenCampusClient.class);

    private HttpClient httpClient;
    private String baseUrl;

    public GreenCampusClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.httpClient = HttpClientBuilder.create().build();
    }

    public GreenCampusClient(String baseUrl, String email, String password) {
        this.baseUrl = baseUrl;
        String auth = email + ":" + password;
        this.httpClient = HttpClientBuilder.create().setDefaultHeaders(Collections.singletonList(
                new BasicHeader("Authorization", "Basic " +
                        new String(Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII"))))))).build();
    }

    public Response get(Request request) {
        HttpGet getRequest = new HttpGet(baseUrl + request.getUrl());
        try {
            HttpResponse httpResponse = httpClient.execute(getRequest);
            // todo more abstraction
            return new JsonResponse(getContent(httpResponse), httpResponse.getStatusLine().getStatusCode());
        } catch (IOException e) {

        }
        return null;
    }

    public Response post(Request request) {
        HttpPost postRequest = new HttpPost(baseUrl + request.getUrl());
        postRequest.setEntity(new StringEntity(request.getBody().getContent(), ContentType.APPLICATION_JSON));

        try {
            LOGGER.info("POST request to " + baseUrl + request.getUrl());
            LOGGER.info("REQUEST BODY:\n" + request.getBody().getContent());
            HttpResponse httpResponse = httpClient.execute(postRequest);
            // todo more abstraction
            String responseContent = getContent(httpResponse);
            LOGGER.info("RESPONSE STATUS: " + httpResponse.getStatusLine().getStatusCode());
            LOGGER.info("RESPONSE BODY:\n" + responseContent);
            return new JsonResponse(responseContent, httpResponse.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response put(Request request) {
        HttpPut putRequest = new HttpPut(baseUrl + request.getUrl());
        putRequest.setEntity(new StringEntity(request.getBody().getContent(), ContentType.APPLICATION_JSON));

        try {
            LOGGER.info("PUT request to " + baseUrl + request.getUrl());
            LOGGER.info("REQUEST BODY:\n" + request.getBody().getContent());
            HttpResponse httpResponse = httpClient.execute(putRequest);
            // todo more abstraction
            String responseContent = getContent(httpResponse);
            LOGGER.info("RESPONSE STATUS: " + httpResponse.getStatusLine().getStatusCode());
            LOGGER.info("RESPONSE BODY:\n" + responseContent);
            return new JsonResponse(responseContent, httpResponse.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response delete(Request request) {
        HttpDelete deleteRequest = new HttpDelete(baseUrl + request.getUrl());
        try {
            LOGGER.info("DELETE request to " + baseUrl + request.getUrl());
            HttpResponse httpResponse = httpClient.execute(deleteRequest);
            // todo more abstraction
            String responseContent = getContent(httpResponse);
            LOGGER.info("RESPONSE STATUS: " + httpResponse.getStatusLine().getStatusCode());
            LOGGER.info("RESPONSE BODY:\n" + responseContent);
            return new JsonResponse(responseContent, httpResponse.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getContent(HttpResponse response) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line).append("\n");
        }
        return result.toString();
    }
}
