package cn.edu.zjut.action;

import cn.edu.zjut.service.IAuthCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class AuthCodeAction {
    private IAuthCodeService authCodeService;

    @Autowired
    public void setAuthCodeService(IAuthCodeService authCodeService) {
        this.authCodeService = authCodeService;
    }
    public IAuthCodeService getAuthCodeService() {
        return authCodeService;
    }

    public String authGenerate() {
        if (authCodeService.authGenerate())
            return "GeneratedSuccess";
        else
            return "GeneratedFail";
    }
}
