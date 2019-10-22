package com.ladyishenlong.docoperation.utils;

import org.apache.poi.hssf.record.BOFRecord;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
     */
    public static boolean excelJudgment(MultipartFile excelFile) throws IOException {

        if (excelFile == null) throw new IOException("excel文件为空");

        String excelFileName = excelFile.getOriginalFilename();
        if (StringUtils.isEmpty(excelFile)) throw new IOException("excel文件名异常");

        if (!excelFileName.matches("^.+\\.(?i)(xls)$") &&
                !excelFileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new IOException("excel文件格式异常");
        }

        long excelFileSize = excelFile.getSize();
        if (excelFileSize == 0) throw new IOException("excel文件大小为0");

        return true;
    }


}
