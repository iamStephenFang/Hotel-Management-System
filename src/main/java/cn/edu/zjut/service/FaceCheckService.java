package cn.edu.zjut.service;

import cn.edu.zjut.face.ITencentCloudFaceCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FaceCheckService implements IFaceCheckService {
    private ITencentCloudFaceCheck tencentCloudFaceCheck;

    @Autowired
    public void setTencentCloudFaceCheck(ITencentCloudFaceCheck tencentCloudFaceCheck) {
        this.tencentCloudFaceCheck = tencentCloudFaceCheck;
    }
    public ITencentCloudFaceCheck getTencentCloudFaceCheck() {
        return tencentCloudFaceCheck;
    }

    public boolean check(File idFile, File faceFile) {
        try {
            return tencentCloudFaceCheck.check(idFile, faceFile);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
