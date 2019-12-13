package com.example.demo.controller.stage;


import com.example.demo.common.ResponseInfo;
import com.example.demo.entity.bo.stage.AlarmBO;
import com.example.demo.service.stage.AlarmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Alarm", tags = { "Alarm" })
@RequestMapping("/stage/test")
public class AlarmController {
    @Autowired
    private AlarmService service;

    @ApiOperation("添加")
    @PostMapping("/add")
    public ResponseInfo add(AlarmBO record) {
        return ResponseInfo.success(service.add(record));
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public ResponseInfo update(AlarmBO record) {
        return ResponseInfo.success(service.update(record));
    }

    @ApiOperation("删除")
    @PostMapping("/delete")
    public ResponseInfo delete(String id) {
        return ResponseInfo.success(service.delete(id));
    }

    @ApiOperation("根据ID获取")
    @GetMapping("/get")
    public ResponseInfo get(String id) {
        return ResponseInfo.success(service.get(id));
    }
}