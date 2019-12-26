package cn.edu.zjut.face;

import java.io.File;

public interface ITencentCloudFaceCheck {
    boolean check(File idImg, File faceImg);
}
