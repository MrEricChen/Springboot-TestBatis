package com.batis.pojo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel
public class BaseJsonResult<T> {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private T data;

    public static BaseJsonResult build(Integer status, String msg, Object data) {
        return new BaseJsonResult(status, msg, data);
    }

    public static BaseJsonResult ok(Object data) {
        return new BaseJsonResult(data);
    }

    public static BaseJsonResult ok() {
        return new BaseJsonResult(null);
    }

    public static BaseJsonResult errorMsg(String msg) {
        return new BaseJsonResult(500, msg, "");
    }

    public static BaseJsonResult errorMap(Object data) {
        return new BaseJsonResult(501, "exception", data);
    }

    public static BaseJsonResult errorTokenMsg(String msg) {
        return new BaseJsonResult(502, msg, null);
    }

    public static BaseJsonResult errorException(String msg) {
        return new BaseJsonResult(555, msg, null);
    }

    public BaseJsonResult() {

    }

    public BaseJsonResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public BaseJsonResult(T data) {
        this.status = 200;
        this.msg = "SUCCESS";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     *
     * @Description: 将json结果集转化为LeeJSONResult对象
     * 				需要转换的对象是一个类
     * @param jsonData
     * @param clazz
     * @return
     */
    public static BaseJsonResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, BaseJsonResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @Description: 没有object对象的转化
     * @param json
     * @return
     */
    public static BaseJsonResult format(String json) {
        try {
            return MAPPER.readValue(json, BaseJsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @Description: Object是集合转化需要转换的对象是一个list
     * @param jsonData
     * @param clazz
     * @return
     */
    public static BaseJsonResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

}
