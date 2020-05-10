package com.springboot.pdf.controller;

import com.springboot.pdf.common.utils.PDFUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void projectExport(HttpServletRequest request, HttpServletResponse response) {
        try {

            Map map = new HashMap<String, Object>();
            map.put("title", "测试测试测试测试");
            map.put("name", "myname is");

            ByteArrayOutputStream baos = PDFUtil.createPDF("templates/project.html", map);
            //设置response文件头

            PDFUtil.renderPdf(response, baos.toByteArray(), "pdf文件");
            baos.close();
        } catch (Exception e) {
            logger.info("导出报错", e);
        }
    }
}
