package com.blog.mapper;

import com.blog.model.Store;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface StoreMapper {
    @Delete({
        "delete from store",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into store (id, name, ",
        "address, street, ",
        "manager, state, ",
        "remark)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{street,jdbcType=VARCHAR}, ",
        "#{manager,jdbcType=INTEGER}, #{state,jdbcType=TINYINT}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    int insert(Store record);

    @InsertProvider(type=StoreSqlProvider.class, method="insertSelective")
    int insertSelective(Store record);

    @Select({
        "select",
        "id, name, address, street, manager, state, remark",
        "from store",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="street", property="street", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager", property="manager", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    Store selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StoreSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Store record);

    @Update({
        "update store",
        "set name = #{name,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "street = #{street,jdbcType=VARCHAR},",
          "manager = #{manager,jdbcType=INTEGER},",
          "state = #{state,jdbcType=TINYINT},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Store record);
}