package service;

import model.User;

public interface ILogin {
    void loginVietCap(User user);

    void sendSmsOTP(User user);
}
