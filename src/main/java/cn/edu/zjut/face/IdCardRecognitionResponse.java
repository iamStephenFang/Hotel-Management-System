package cn.edu.zjut.face;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author 黄奕涵
 * 人证识别响应结果类
 */
@Data
public class IdCardRecognitionResponse {

    // 姓名
    @SerializedName("Name")
    private String name;

    // 性别
    @SerializedName("Sex")
    private String sex;

    // 人像照片
    @SerializedName("AdvancedInfo")
    private String advancedInfo;

    @Override
    public String toString() {
        return "FaceCompareResponse{" +
                "name=" + name +
                ", sex='" + sex + '\'' +
                ", advancedInfo='" + advancedInfo + '\'' +
                '}';
    }
}
