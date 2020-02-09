package cn.edu.zjut.face;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.iai.v20180301.IaiClient;
import com.tencentcloudapi.iai.v20180301.models.CompareFaceRequest;
import com.tencentcloudapi.iai.v20180301.models.CompareFaceResponse;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRResponse;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class TencentCloudFaceCheck implements ITencentCloudFaceCheck {

    // 腾讯云个人密钥
    public static final String secretId = "PERSONAL SECRET ID";
    public static final String secretKey = "PERSONAL SECRET KEY";

    // 获得 json 对象
    public static final Gson gson = new GsonBuilder().create();

    private static IaiClient getIaiClient(Credential cred) {
        //设置 iai 相应服务器域名
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("iai.tencentcloudapi.com");

        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        // 设置相应服务器的地区为华东地区——上海
        return new IaiClient(cred, "ap-shanghai", clientProfile);
    }

    private static OcrClient getOcrClient(Credential cred) {
        //设置 ocr 相应服务器域名
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("ocr.tencentcloudapi.com");

        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        // 设置相应服务器的地区为华东地区——上海
        return new OcrClient(cred, "ap-shanghai", clientProfile);
    }

    /**
     * @param cred 密钥认证信息
     * @return FaceCompareResponse
     */
    private static FaceCompareResponse faceCompare(Credential cred,String idFaceBase64,String faceImgPath) {
        IaiClient iaiClient = getIaiClient(cred);

        FaceCompareRequest reqObj = new FaceCompareRequest(idFaceBase64, faceImgPath);

        // json 参数串
        String compareFaceParams = gson.toJson(reqObj);
        CompareFaceRequest req = CompareFaceRequest.fromJsonString(compareFaceParams, CompareFaceRequest.class);

        try {
            CompareFaceResponse resp = iaiClient.CompareFace(req);
            // 得到响应 json 串
            String jsonResponse = CompareFaceRequest.toJsonString(resp);

            return gson.fromJson(jsonResponse, FaceCompareResponse.class);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    /**
     * @param cred 密钥认证信息
     * @return IdCardRecognitionResponse
     */
    private static IdCardRecognitionResponse idCardRecognition(Credential cred,String idImgPath) {
        OcrClient ocrClient = getOcrClient(cred);

        IdCardRecognitionRequest reqObj = new IdCardRecognitionRequest(idImgPath);

        // json 参数串
        String compareFaceParams = gson.toJson(reqObj);
        IDCardOCRRequest req = IDCardOCRRequest.fromJsonString(compareFaceParams, IDCardOCRRequest.class);

        try {
            IDCardOCRResponse resp = ocrClient.IDCardOCR(req);
            // 得到响应 json 串
            String jsonResponse = IDCardOCRRequest.toJsonString(resp);

            return gson.fromJson(jsonResponse, IdCardRecognitionResponse.class);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return null;
    }


    @Override
    public boolean check(File idImg, File faceImg) {
        // 密钥认证
        Credential cred = new Credential(secretId, secretKey);

        // 身份证识别
        IdCardRecognitionResponse idCardResponse = idCardRecognition(cred,idImg.getAbsolutePath());
        assert idCardResponse != null:"not get response";
        System.out.println(idCardResponse);
        String idFaceBase64 = idCardResponse.getAdvancedInfo();

        // 人脸比对
        FaceCompareResponse faceResponse = faceCompare(cred,idFaceBase64.substring(13,idFaceBase64.length()-2),faceImg.getAbsolutePath());
        assert faceResponse != null:"not get response";
        System.out.println(faceResponse);
        if (faceResponse.getScore() >= 80){
            System.out.println("人证核验成功");
            return true;
        }
        else{
            System.out.println("人证核验失败");
            return false;
        }
    }
}
