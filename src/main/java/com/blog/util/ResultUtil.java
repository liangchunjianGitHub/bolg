package com.blog.util;

import com.blog.baseModel.ResultBean;

/**
 * Created by GD on 2017/9/11.
 */
public class ResultUtil {

    public static ResultBean success(Object object){
        ResultBean<Object> result = new ResultBean<>();
        result.setCode(200);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    public static ResultBean success(){
        return success(null);
    }

    public static ResultBean error(Integer code, String msg, Object object){
        ResultBean<Object> result = new ResultBean<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
}
