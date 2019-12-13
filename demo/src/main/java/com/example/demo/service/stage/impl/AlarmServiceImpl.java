package com.example.demo.service.stage.impl;


import java.util.*;

import com.example.demo.entity.bo.stage.AlarmBO;
import com.example.demo.entity.po.stage.AlarmPO;
import com.example.demo.mapper.stage.AlarmMapper;
import com.example.demo.service.stage.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    private AlarmMapper mapper;

    @Override
    public AlarmBO add(AlarmBO record) {
        AlarmPO po = record.toPO(AlarmPO.class);
        mapper.insert(po);
        return get(po.getId());
    }

    @Override
    public AlarmBO update(AlarmBO record) {
        AlarmPO po = record.toPO(AlarmPO.class);
        mapper.updateByPrimaryKeySelective(po);
        return get(po.getId());
    }

    @Override
    public boolean delete(String id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean delete(String[] ids) {
        Arrays.asList(ids).forEach(this::delete);
        return true;
    }

    @Override
    public AlarmBO get(String id) {
        AlarmPO record = mapper.selectByPrimaryKey(id);
        Optional<AlarmBO> ss = Optional.ofNullable(record).map(po -> po.toBO(AlarmBO.class));
        return ss.orElse(null);
    }
}