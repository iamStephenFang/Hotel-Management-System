package cn.edu.zjut.action;

import cn.edu.zjut.service.IFaceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;

@Controller
@Scope("prototype")
public class FaceCheckAction {
    private File idFile;
    private File faceFile;
    private IFaceCheckService faceCheckService;

    @Autowired
    public void setFaceCheckService(IFaceCheckService faceCheckService) {
        this.faceCheckService = faceCheckService;
    }
    public IFaceCheckService getFaceCheckService() {
        return faceCheckService;
    }

    public void setIdFile(File idFile) {
        this.idFile = idFile;
    }
    public File getIdFile() {
        return idFile;
    }

    public void setFaceFile(File faceFile) {
        this.faceFile = faceFile;
    }
    public File getFaceFile() {
        return faceFile;
    }

    public String check() {
        if (faceCheckService.check(idFile,faceFile))
            return "checkSuccess";
        else
            return "checkFail";
    }
}
