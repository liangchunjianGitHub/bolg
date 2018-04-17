package com.blog.baseModel;

/**
 * http 返回数据
 * Created by GD on 2017/9/11.
 */
public class ResultBean<T> {

    /**返回编码*/
    private Integer code;

    private Boolean seccese;

    /** 返回信息*/
    private String msg;
    /** 返回数据*/
    private T data;

    public ResultBean(){

    }
    public ResultBean(String msg){
        this.msg = msg;
    }
    public ResultBean(T data){
        this.data = data;
    }
    public ResultBean(String msg, T data){
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSeccese() {
        return seccese;
    }

    public void setSeccese(Boolean seccese) {
        this.seccese = seccese;
    }
}
