package com.example.movie.dto;

import java.io.File;
import java.net.URLEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UploadResultDto {
    // uuid 값, fileName, folderPath 저장
    private String uuid; // 유효 아이디

    private String fileName; // 원본파일명

    private String folderPath; // 년/월/일

    // 썸네일 경로
    public String getThumbImageURL() {
        String fullPath = "";
        try {
            fullPath = URLEncoder.encode(folderPath + File.separator + "s_" + uuid + "_" + fileName, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fullPath;
    }

    // 원본 이미지 경로
    public String getImageURL() {
        String fullPath = "";
        try {
            fullPath = URLEncoder.encode(folderPath + File.separator + uuid + "_" + fileName, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fullPath;
    }

}
