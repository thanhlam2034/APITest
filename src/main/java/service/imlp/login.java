package service.imlp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import com.sun.jersey.api.representation.Form;
import org.json.simple.JSONObject;
import org.junit.Test;
import service.ILogin;


public class login implements ILogin {

    @Test
    @Override
    public void loginByPhone() {

        Client client = Client.create();

        Form form = new Form();
        form.add("grant_type", "password");
        form.add("client_id", "master-trade-fe");
        form.add("username", "068C678543");
        form.add("password", "abc123");

        WebResource webResource = client.resource("https://keycloak-qc.vietcap.com.vn/auth/realms/demo/protocol/openid-connect/token");

        ClientResponse response = webResource
                .header("Content-Type","application/x-www-form-urlencoded")
                .post(ClientResponse.class, form);

        if (response.getStatus() == 200) {
            String responseBody = response.getEntity(String.class);
            System.out.println(response.getStatus());
            System.out.println(responseBody);
        } else {

        }
        System.out.println(response.getStatus());

    }
@Test
    public void testLoginJersey(){
        Client client = Client.create();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstname", "Lam3");
        jsonObject.put("lastname", "Nguyen3");
        jsonObject.put("subjectId", 1);

        WebResource webResource = client.resource("http://localhost:3000");

        ClientResponse response = webResource.path("/users")
                .accept("application/json")
                .header("Content-Type","application/json")
                .post(ClientResponse.class, jsonObject.toJSONString());

        if (response.getStatus() == 200) {
            String responseBody = response.getEntity(String.class);
            System.out.println(response.getStatus());
            System.out.println(responseBody);
        } else {

        }
        System.out.println(response.getStatus());

    }
}
