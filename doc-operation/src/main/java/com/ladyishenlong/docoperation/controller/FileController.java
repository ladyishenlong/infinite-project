package com.ladyishenlong.docoperation.controller;

import com.ladyishenlong.docoperation.utils.ExcelUtils;
import com.ladyishenlong.responseutils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/22 9:52 上午
 */
@Slf4j
@RestController
public class FileController {


    @PostMapping("/read/excel")
    public ResponseUtils readExcel(@RequestBody MultipartFile excelFile) {
        if (excelFile == null) return ResponseUtils.failure("上传文件为空");

        String excelFileName = excelFile.getOriginalFilename();

        if (StringUtils.isEmpty(excelFile)) return ResponseUtils.failure("上传文件为空");
        if (!excelFileName.matches("^.+\\.(?i)(xls)$")
                && !excelFileName.matches("^.+\\.(?i)(xlsx)$")) {
            return ResponseUtils.failure("文件格式错误");
        }

        long excelFileSize = excelFile.getSize();
        if (excelFileSize == 0) return ResponseUtils.failure("上传文件为空");
        log.info("文件名为：{},文件大小为：{}", excelFileName, excelFileSize);


        //开始处理文件
        try {

            InputStream inputStream = excelFile.getInputStream();
            Workbook wb;
            if (excelFileName.matches("^.+\\.(?i)(xlsx)$")) {
                wb = new XSSFWorkbook(inputStream);
            } else {
                wb = new HSSFWorkbook(inputStream);
            }


            Sheet sheet = wb.getSheetAt(0);//第一张sheet
            if (sheet == null) throw new RuntimeException("Excel数据为空");

            int column = sheet.getRow(0).getPhysicalNumberOfCells();//列数
            int rows = sheet.getLastRowNum();//行数

            //行与列的类型是自动对应的，且从0开始
            //利用for循环进行遍历
            String value = sheet.getRow(0).getCell(0).getStringCellValue();
            log.info("列数：{},行数：{}", column, rows);


            return ResponseUtils.success(value);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.failure(e.getMessage());
        }


//        return ResponseUtils.success(excelFileName + "上传成功");

    }


}
