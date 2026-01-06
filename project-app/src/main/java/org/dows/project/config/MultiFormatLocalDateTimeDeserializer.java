package org.dows.project.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * 支持多种格式的 LocalDateTime 反序列化器
 * 支持格式：
 * 1. ISO 8601 格式：2025-01-01T00:00:00
 * 2. 标准格式：2025-01-01 00:00:00
 * 3. ISO 8601 带时区：2025-01-01T00:00:00Z
 * 4. ISO 8601 带毫秒：2025-01-01T00:00:00.000
 */
public class MultiFormatLocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    private static final DateTimeFormatter[] FORMATTERS = {
        // ISO 8601 格式：2025-01-01T00:00:00
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"),
        // ISO 8601 带毫秒：2025-01-01T00:00:00.000
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"),
        // ISO 8601 带时区：2025-01-01T00:00:00Z
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"),
        // 标准格式：2025-01-01 00:00:00
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
        // 标准格式带毫秒：2025-01-01 00:00:00.000
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"),
        // 日期格式：2025-01-01
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        // ISO 8601 完整格式：2025-01-01T00:00:00+08:00
        DateTimeFormatter.ISO_LOCAL_DATE_TIME,
        // ISO 8601 日期时间格式：2025-01-01T00:00:00.000+08:00
        DateTimeFormatter.ISO_DATE_TIME
    };

    public MultiFormatLocalDateTimeDeserializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String dateString = p.getText();
        if (dateString == null || dateString.trim().isEmpty()) {
            return null;
        }

        dateString = dateString.trim();

        // 尝试使用各种格式解析
        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                return LocalDateTime.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
                // 继续尝试下一个格式
            }
        }

        // 如果所有格式都失败，抛出异常
        throw new IOException("无法解析日期时间字符串: " + dateString + 
                "，支持的格式包括：yyyy-MM-dd'T'HH:mm:ss, yyyy-MM-dd HH:mm:ss 等");
    }
}

