package org.dows.project.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Configuration
public class JacksonConfig {

    // 定义目标格式（如：yyyy-MM-dd HH:mm:ss）全局 LocalDateTime 序列化格式
    private static final String TARGET_PATTERN = "yyyy-MM-dd HH:mm:ss";
    // 定义应用使用的时区
    public static final ZoneId APP_ZONE_ID = ZoneId.of("Asia/Shanghai");
    // 创建格式化器
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(TARGET_PATTERN);

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        // 设置JVM默认时区
        TimeZone.setDefault(TimeZone.getTimeZone(APP_ZONE_ID));

        ObjectMapper objectMapper = new ObjectMapper();
        // 设置时区
        objectMapper.setTimeZone(TimeZone.getTimeZone(APP_ZONE_ID));

        JavaTimeModule module = new JavaTimeModule();

        // 1. 配置反序列化器：字符串→LocalDateTime（支持多种格式）
        org.dows.project.config.MultiFormatLocalDateTimeDeserializer deserializer = 
                new org.dows.project.config.MultiFormatLocalDateTimeDeserializer();
        module.addDeserializer(LocalDateTime.class, deserializer);

        // 2. 配置序列化器：LocalDateTime→字符串（后端返回给前端的字符串按TARGET_PATTERN生成）
        LocalDateTimeSerializer serializer = new LocalDateTimeSerializer(FORMATTER);
        module.addSerializer(LocalDateTime.class, serializer);

        // 注册模块到Jackson
        objectMapper.registerModule(module);

        SimpleModule simpleModule = new SimpleModule();
        // 将Long类型序列化为字符串
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);

        objectMapper.registerModule(simpleModule);
        return objectMapper;
    }
}