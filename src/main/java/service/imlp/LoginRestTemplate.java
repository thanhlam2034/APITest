package service.imlp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import service.ILoginRestTemplate;

@Slf4j
public class LoginRestTemplate implements ILoginRestTemplate {
    @Override
    public void loginByNumber() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("grant_type","password");
        map.add("client_id", "master-trade-fe");
        map.add("username", "068C678543");
        map.add("password", "abc123");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                "https://keycloak-qc.vietcap.com.vn/auth/realms/demo/protocol/openid-connect/token", request , String.class);

        log.info(response.getBody());
    }
}
