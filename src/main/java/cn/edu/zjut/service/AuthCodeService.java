package cn.edu.zjut.service;

import cn.edu.zjut.authcode.IAuthCode;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class AuthCodeService implements IAuthCodeService {
    private Map request;
    private IAuthCode authCode;

    @Autowired
    public void setAuthCode(IAuthCode authCode) {
        this.authCode = authCode;
    }
    public IAuthCode getAuthCode() {
        return authCode;
    }

    /**
     * @author 王凌云
     * @return boolean
     * 生成验证码
     */
    @Override
    public boolean authGenerate() {
        ActionContext context = ActionContext.getContext();
        request = (Map) context.get("request");
        try {
            String imageBits = authCode.getImage();
            String code = authCode.getCode();
            request.put("imageBits",imageBits);
            request.put("code",code);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
