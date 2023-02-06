package cn.behappyto.export.common.util;

import cn.behappyto.export.common.constant.DateConstant;
import cn.behappyto.export.common.constant.TimeZoneConstant;
import cn.hutool.core.map.MapUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * JacksonUtil 序列化
 *
 * @author behappyto.cn
 */
@Slf4j
public class JacksonUtil {

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        // 序列化时候统一日期格式
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat(DateConstant.DATE_FORMAT_4Y2M2D2H2M2S));
        // 时区
        OBJECT_MAPPER.setTimeZone(TimeZone.getTimeZone(TimeZoneConstant.TIME_ZONE_8));
        // 设置null时候不序列化(只针对对象属性)
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 反序列化时，属性不存在的兼容处理
        OBJECT_MAPPER.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 单引号处理
        OBJECT_MAPPER.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    /**
     * 私有构造函数
     */
    private JacksonUtil() {
    }

    /**
     * 将 obj 转成相应的Map
     *
     * @param obj obj
     * @return 将jsonStr转成相应的Map
     */
    public static Map<String, Object> objectToMap(Object obj) {
        try {
            String json = OBJECT_MAPPER.writeValueAsString(obj);
            return OBJECT_MAPPER.readValue(json, HashMap.class);
        } catch (Exception e) {
            log.error("对象转map失败", e);
            return MapUtil.empty();
        }
    }

    /**
     * 序列化java对象
     *
     * @param entity entity
     * @param <T>    T
     * @return 序列化java对象
     */
    public static <T> String objectToJson(T entity) {
        try {
            return OBJECT_MAPPER.writeValueAsString(entity);
        } catch (IOException e) {
            log.error("序列化失败", e);
        }
        return null;
    }

    /**
     * 转换 为集合
     *
     * @param json          json 字符串
     * @param typeReference 类型
     * @param <T>           泛型
     * @return 返回 集合
     */
    public static <T> T jsonToObject(String json, TypeReference<T> typeReference) {
        try {
            return OBJECT_MAPPER.readValue(json, typeReference);
        } catch (Exception e) {
            log.error("反序列化失败", e);
        }
        return null;
    }
}
