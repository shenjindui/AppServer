package com.xingcheng.appserver.controller;

import com.xingcheng.appserver.utils.constant.SysConstant;
import com.xingcheng.appserver.utils.response.BaseAppAction;
import com.xingcheng.appserver.utils.response.ResponseVO;
import com.xingcheng.appserver.utils.util.FTPUtils;
import com.xingcheng.appserver.utils.util.StringUtils;
import com.xingcheng.appserver.utils.validator.ValidatorParamer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/file", produces = APPLICATION_JSON_VALUE)
@Api(description = "文件信息管理")
public class FileServerController  extends BaseAppAction {

    protected final static Logger logger = LoggerFactory.getLogger(BaseAppAction.class);

    @ApiOperation(value = "文件上传到文件服务器")
    @RequestMapping(value = "/uploadFolder", method = RequestMethod.POST)
    public ResponseVO uploadFolder(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            FTPUtils.sshSftp(bytes, file.getOriginalFilename());
            return successResponse("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return errorResponse("上传失败");
    }
}
