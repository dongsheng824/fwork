package com.hhlike.fwork.mapper;

import com.hhlike.fwork.model.ResultPage;
import com.hhlike.fwork.model.ResultPageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResultPageMapper {
    long countByExample(ResultPageExample example);

    int deleteByExample(ResultPageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ResultPage record);

    int insertSelective(ResultPage record);

    List<ResultPage> selectByExample(ResultPageExample example);

    ResultPage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ResultPage record, @Param("example") ResultPageExample example);

    int updateByExample(@Param("record") ResultPage record, @Param("example") ResultPageExample example);

    int updateByPrimaryKeySelective(ResultPage record);

    int updateByPrimaryKey(ResultPage record);
}