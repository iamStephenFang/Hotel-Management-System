package cn.edu.zjut.authcode;

import java.io.IOException;

public interface IAuthCode {
    String getImage() throws IOException;
    String getCode();
}
