package cn.edu.zjut.face;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author 黄奕涵
 * 人脸对比响应结果类
 */
@Data
public class FaceCompareResponse {

    // 相似度
    @SerializedName("Score")
    private float score;

    // 是否为同一人的判断
    @SerializedName("IsMatch")
    private boolean isMatch;

    // 算法模型版本
    @SerializedName("FaceModelVersion")
    private String faceModelVersion;

    // 唯一请求ID
    @SerializedName("RequestId")
    private String requestId;

    @Override
    public String toString() {
        return "IdCardRecognitionResponse{" +
                "score=" + score +
                ", isMatch=" + isMatch +
                ", faceModelVersion='" + faceModelVersion + '\'' +
                ", requestId='" + requestId + '\'' +
                '}';
    }
}
