package Devcos.AIBE.study_250304.slack;

import Devcos.AIBE.study_250304.util.logger.MyLogger;
import Devcos.AIBE.study_250304.util.logger.MyLoggerLevel;
import Devcos.AIBE.study_250304.util.secret.MySecret;
import Devcos.AIBE.study_250304.util.secret.NoEnvException;
import Devcos.AIBE.study_250304.util.secret.SecretCategory;
import Devcos.AIBE.study_250304.util.webclient.WebClient;

import java.util.HashMap;

public class Slack {
    private final MyLogger logger;
    private final WebClient webClient;
    private final MySecret secret;
    public Slack() throws NoEnvException {
        logger = MyLogger.getLogger();
        logger.setLevel(MyLoggerLevel.DEBUG);
//        logger.setLevel(MyLoggerLevel.INFO);
        secret = MySecret.getSecret();
        webClient = WebClient.getWebClient();
    }

    private void handleRequest(String body) throws NoEnvException {
        String result = "";
        HashMap<String,String> map = new HashMap<>();
        map.put("url", secret.getSecret(SecretCategory.SLACK_BOT_URL.key));
        map.put("method", "POST");
        map.put("body", body);
        try {
            result = webClient.sendRequest( webClient.makeRequest(map));
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        logger.info(result);
    }

    public void sendMessage(String msg, String imageUrl) throws NoEnvException {
        handleRequest("""
                {
                 "text": "%s",
                 "attachments": [{
                    "image_url": "%s"
                 }]
                }
                """.formatted(msg, imageUrl));
    }

    public void sendMessage(String msg) throws NoEnvException {
        handleRequest("""
                {"text": "%s"}
                """.formatted(msg));
    }
}
