package cn.edu.zjut.face;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author 黄奕涵
 * 人脸对比请求类
 */
@Data
public class FaceCompareRequest {

    // A 图片 base64 数据，base64 编码后大小不可超过5M
    // 若图片中包含多张人脸，只选取其中人脸面积最大的人脸
    @SerializedName(value = "ImageA")
    private String base64ImageA;

    // B 图片 base64 数据，base64 编码后大小不可超过5M
    // 若图片中包含多张人脸，只选取其中人脸面积最大的人脸
    @SerializedName(value = "ImageB")
    private String base64ImageB;

    // 人脸识别服务所用的算法模型版本
    // 目前入参支持 “2.0”和“3.0“ 两个输入
    @SerializedName(value = "FaceModelVersion")
    private String faceModelVersion;

    // 图片质量控制
    // 0: 不进行控制
    // 1: 较低的质量要求
    // 2: 一般的质量要求
    // 3: 较高的质量要求
    // 4: 很高的质量要求
    @SerializedName(value = "QualityControl")
    private String qualityControl;

    public FaceCompareRequest(String imageNameA, String imageNameB) {
        base64ImageA = imageNameA;
        base64ImageB = Utils.base64FromFilePath(imageNameB);
        faceModelVersion = "3.0";
        qualityControl = "0";
    }

}
