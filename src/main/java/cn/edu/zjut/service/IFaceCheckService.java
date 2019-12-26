package cn.edu.zjut.service;

import java.io.File;

public interface IFaceCheckService {
    boolean check(File idFile, File faceFile);
}
