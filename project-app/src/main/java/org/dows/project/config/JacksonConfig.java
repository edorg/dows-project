//package org.dows.project.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.util.TimeZone;
//
//@Configuration
//public class JacksonConfig {
//
//    // 定义目标格式（如：yyyy-MM-dd HH:mm:ss）全局 LocalDateTime 序列化格式
//    private static final String TARGET_PATTERN = "yyyy-MM-dd HH:mm:ss";
//    // 定义应用使用的时区
//    public static final ZoneId APP_ZONE_ID = ZoneId.of("Asia/Shanghai");
//    // 创建格式化器
//    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(TARGET_PATTERN);
//
//
//
//    /*@Bean
//    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//        return builder -> {
//            // 配置 LocalDateTime 序列化器
//            builder.serializerByType(LocalDateTime.class,
//                    new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(TARGET_PATTERN)));
//            // 如需支持 Date 类型
//            // builder.simpleDateFormat(DATE_TIME_FORMAT);
//        };
//    }*/
//
//    @Bean
//    @Primary
//    public ObjectMapper objectMapper() {
//        // 设置JVM默认时区
//        TimeZone.setDefault(TimeZone.getTimeZone(APP_ZONE_ID));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        // 设置时区
//        objectMapper.setTimeZone(TimeZone.getTimeZone(APP_ZONE_ID));
//
//        JavaTimeModule module = new JavaTimeModule();
//
//        // 1. 配置反序列化器：字符串→LocalDateTime（前端传递的字符串按TARGET_PATTERN解析）
//        LocalDateTimeDeserializer deserializer = new LocalDateTimeDeserializer(FORMATTER);
//        module.addDeserializer(LocalDateTime.class, deserializer);
//
//
//        // 2. 配置序列化器：LocalDateTime→字符串（后端返回给前端的字符串按TARGET_PATTERN生成）
//        LocalDateTimeSerializer serializer = new LocalDateTimeSerializer(FORMATTER);
//        module.addSerializer(LocalDateTime.class, serializer);
//
//        // 注册模块到Jackson
//        objectMapper.registerModule(module);
//        objectMapper.setDateFormat(new SimpleDateFormat(TARGET_PATTERN));
//        // 禁用日期时间戳序列化，确保以指定格式输出
//        //objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//
//        SimpleModule simpleModule = new SimpleModule();
//        // 将Long类型序列化为字符串
//        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
//        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
//
//        objectMapper.registerModule(simpleModule);
//        return objectMapper;
//    }
//}