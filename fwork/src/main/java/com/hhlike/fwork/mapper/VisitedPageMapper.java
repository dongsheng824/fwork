package com.hhlike.fwork.mapper;

import com.hhlike.fwork.model.VisitedPage;
import com.hhlike.fwork.model.VisitedPageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitedPageMapper {
    long countByExample(VisitedPageExample example);

    int deleteByExample(VisitedPageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VisitedPage record);

    int insertSelective(VisitedPage record);

    List<VisitedPage> selectByExample(VisitedPageExample example);

    VisitedPage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VisitedPage record, @Param("example") VisitedPageExample example);

    int updateByExample(@Param("record") VisitedPage record, @Param("example") VisitedPageExample example);

    int updateByPrimaryKeySelective(VisitedPage record);

    int updateByPrimaryKey(VisitedPage record);
}