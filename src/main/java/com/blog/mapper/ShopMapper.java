package com.blog.mapper;

import com.blog.model.Shop;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopMapper {
    @Delete({
        "delete from shops",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into shops (id, name, ",
        "store, type, state, ",
        "remark)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{store,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, #{state,jdbcType=TINYINT}, ",
        "#{remark,jdbcType=LONGVARCHAR})"
    })
    int insert(Shop record);

    @InsertProvider(type=ShopSqlProvider.class, method="insertSelective")
    int insertSelective(Shop record);

    @Select({
        "select",
        "id, name, store, type, state, remark",
        "from shops",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="store", property="store", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.LONGVARCHAR)
    })
    Shop selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ShopSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Shop record);

    @Update({
        "update shops",
        "set name = #{name,jdbcType=VARCHAR},",
          "store = #{store,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "state = #{state,jdbcType=TINYINT},",
          "remark = #{remark,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Shop record);

    @Update({
        "update shops",
        "set name = #{name,jdbcType=VARCHAR},",
          "store = #{store,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "state = #{state,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Shop record);
}