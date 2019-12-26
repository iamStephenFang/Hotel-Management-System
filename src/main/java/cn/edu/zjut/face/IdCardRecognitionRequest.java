package cn.edu.zjut.face;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

/**
 * @author 黄奕涵
 * 人证识别请求类
 */
@Data
public class IdCardRecognitionRequest {

    public static final String SIDE_BACK = "BACK";
    public static final String SIDE_FRONT = "FRONT";

    // 图片的 Base64 值
    // 支持的图片格式：PNG、JPG、JPEG
    @SerializedName(value = "ImageBase64")
    private String base64Image;

    // FRONT 为身份证有照片的一面（人像面）
    // BACK 为身份证有国徽的一面（国徽面）
    @SerializedName(value = "CardSide")
    private String cardSide;

    // CropIdCard，身份证照片裁剪，bool 类型，默认false
    // CropPortrait，人像照片裁剪，bool 类型，默认false
    @SerializedName(value = "Config")
    private String config;

    @Data
    @Builder
    static class Configuration {

        @SerializedName("CropIdCard")
        private boolean cropIdCard;

        @SerializedName("CropPortrait")
        private boolean cropPortrait;
    }

    public IdCardRecognitionRequest(String imageName) {
        Gson gson = (new GsonBuilder()).create();
        // 图片 base64 编码
        base64Image = Utils.base64FromFilePath(imageName);
        // 身份证正面
        cardSide = SIDE_FRONT;
        config = gson.toJson(Configuration.builder()
                .cropIdCard(false) // 身份证照片裁剪
                .cropPortrait(true) // 人像照片裁剪
                .build());
    }
}
