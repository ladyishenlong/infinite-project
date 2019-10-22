package com.ladyishenlong.docoperation.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author ruanchenhao
 * @Date 2019/10/22 2:42 下午
 * excel处理工具
 */
public class ExcelUtils {


    /**
     * excel文件格式判断
     *
     * @param excelFile
     * @return
     */
    public static boolean excelJudgment(MultipartFile excelFile) {

        if (excelFile == null) throw new RuntimeException("excel文件为空");

        String excelFileName = excelFile.getOriginalFilename();
        if (StringUtils.isEmpty(excelFile)) throw new RuntimeException("excel文件名异常");

        if (!excelFileName.matches("^.+\\.(?i)(xls)$") &&
                !excelFileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new RuntimeException("excel文件格式异常");
        }

        long excelFileSize = excelFile.getSize();
        if (excelFileSize == 0) throw new RuntimeException("excel文件大小为0");

        return true;
    }


}
