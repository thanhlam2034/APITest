package service;

import model.User;

public interface ILogin {
    void loginVietCap(User user);

    void sendSmsOTP(User user);

    /**
    @Author:
    @param: user
     */
    void validateSmsOTP(User user, String sms);

}
