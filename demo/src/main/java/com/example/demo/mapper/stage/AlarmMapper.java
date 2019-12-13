package com.example.demo.mapper.stage;


import com.example.demo.entity.po.stage.AlarmPO;
import com.example.demo.entity.po.stage.AlarmPOExample;
import com.example.demo.mapper.MyBatisBaseMapper;
import com.example.demo.pojo.bo.annotation.PrimaryMapper;

/**
 * AlarmMapper继承基类
 */
@PrimaryMapper
public interface AlarmMapper extends MyBatisBaseMapper<AlarmPO, String, AlarmPOExample> {
}
