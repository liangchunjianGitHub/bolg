package com.blog.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.blog.model.Store;

public class StoreSqlProvider {

    public String insertSelective(Store record) {
        BEGIN();
        INSERT_INTO("store");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getStreet() != null) {
            VALUES("street", "#{street,jdbcType=VARCHAR}");
        }
        
        if (record.getManager() != null) {
            VALUES("manager", "#{manager,jdbcType=INTEGER}");
        }
        
        if (record.getState() != null) {
            VALUES("state", "#{state,jdbcType=TINYINT}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Store record) {
        BEGIN();
        UPDATE("store");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getStreet() != null) {
            SET("street = #{street,jdbcType=VARCHAR}");
        }
        
        if (record.getManager() != null) {
            SET("manager = #{manager,jdbcType=INTEGER}");
        }
        
        if (record.getState() != null) {
            SET("state = #{state,jdbcType=TINYINT}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}