package service;

import io.restassured.response.Response;
import model.User;

public interface INormalOrder {
    Response createNormalOrder(User user);

    void editNormalOrder(User user);

    void deleteNormalOrder(User user);
}
