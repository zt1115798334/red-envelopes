package com.example.redenvelopes.utils;

import org.apache.commons.lang.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/7/16 9:48
 * description:时间工具类
 */
public class DateUtils {


    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_1 = "MM/dd";
    public static final String DATE_FORMAT_2 = "MMdd";
    public static final String DATE_FORMAT_3 = "yyyyMMdd";
    public static final String DATE_FORMAT_4 = "MM月dd日";
    public static final String DATE_FORMAT_5 = "yyyy年MM月dd日";


    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_1 = "MM-dd HH:mm";
    public static final String DATE_TIME_FORMAT_2 = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_FORMAT_3 = "yyyy-MM-dd HH";
    public static final String DATE_TIME_FORMAT_4 = "yyyyMMddHHmmss";
    public static final String DATE_TIME_FORMAT_5 = "yyyyMMddHH";
    public static final String DATE_TIME_FORMAT_CHN = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String DATE_TIME_FORMAT_CHN_2 = "yyyy年MM月dd日 HH:mm";

    public static final String GREENWICH_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String DATE_TIME_CS = "yyyy年MM月dd日 HH:mm:ss";
    public static final String GREENWICH_DATE_FORMAT_2 = "yyyy-MM-dd HH:mm:ss.S";

    public static final String TIME_FORMAT = "HH:mm";
    public static final String TIME_FORMAT_1 = "HH:mm:ss";
    public static final String TIME_FORMAT_2 = "HH";

    /**
     * 获取最新日期
     *
     * @return LocalDate
     */
    public static LocalDate currentDate() {
        return LocalDate.now();
    }

    /**
     * 获取最新时间
     *
     * @return LocalDateTime
     */
    public static LocalDateTime currentDateTime() {
        return LocalDateTime.now();
    }

    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = dateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * utf时间格式字符串转换为时间
     *
     * @param dateTime 日期
     * @return LocalDateTime
     */
    public static LocalDateTime parseDateTimeUTC2(String dateTime) {
        return parseDateTime(dateTime, GREENWICH_DATE_FORMAT_2);
    }

    /**
     * 时间格式字符串转换为时间
     *
     * @param dateTime 日期
     * @return LocalDate
     */
    public static LocalDate parseDate(String dateTime) {
        return parseDate(dateTime, DATE_FORMAT);
    }

    /**
     * 时间格式字符串转换为时间
     *
     * @param dateTime   日期
     * @param dateFormat 时间规格字符
     * @return LocalDate
     */
    public static LocalDate parseDate(String dateTime, String dateFormat) {
        LocalDate result = null;
        if (StringUtils.isNotEmpty(dateTime)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            result = LocalDate.parse(dateTime, formatter);
        }
        return result;
    }

    public static boolean intervalTime(LocalDateTime startDateTime, LocalDateTime endDateTime, LocalDateTime dateTime) {
        return dateTime.isAfter(startDateTime) && dateTime.isBefore(endDateTime);
    }


    /**
     * utf时间格式字符串转换为时间
     *
     * @param dateTime 日期
     * @return LocalDateTime
     */
    public static LocalDateTime parseDateTimeUTC(String dateTime) {
        return parseDateTime(dateTime, GREENWICH_DATE_FORMAT);
    }

    /**
     * 时间格式字符串转换为时间
     *
     * @param dateTime 日期
     * @return LocalDateTime
     */
    public static LocalDateTime parseDateTime(String dateTime) {
        return parseDateTime(dateTime, DATE_TIME_FORMAT);
    }

    /**
     * 时间格式字符串转换为时间
     *
     * @param dateTime   日期
     * @param dateFormat 时间规则字符
     * @return LocalDateTime
     */
    public static LocalDateTime parseDateTime(String dateTime, String dateFormat) {
        LocalDateTime result = null;
        if (StringUtils.isNotEmpty(dateTime)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            result = LocalDateTime.parse(dateTime, formatter);
        }
        return result;
    }

    /**
     * 格式化时间为 yyyy-MM-dd 格式
     *
     * @param date 日期
     * @return String
     */
    public static String formatDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        return formatDate(date, DATE_FORMAT);
    }

    /**
     * 格式化时间为 yyyy-MM-dd 格式
     *
     * @param dateTime 日期
     * @return String
     */
    public static String formatDate(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return formatDateTime(dateTime, DATE_FORMAT);
    }

    /**
     * 格式化时间为 yyyy-MM-dd 格式
     *
     * @param dateTime 日期
     * @return String
     */
    public static String formatTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return formatDateTime(dateTime, TIME_FORMAT_1);
    }

    /**
     * 格式化时间为 yyyy-MM-dd HH:mm:ss 格式
     *
     * @param date Date
     * @return String
     */
    public static String formatDateTime(Date date) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, zone);
        return formatDateTime(dateTime, DATE_TIME_FORMAT);
    }

    /**
     * 格式化时间为 yyyy-MM-dd HH:mm:ss 格式
     *
     * @param dateTime LocalDateTime
     * @return String
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return formatDateTime(dateTime, DATE_TIME_FORMAT);
    }

    /**
     * 格式化时间为 yyyy-MM-dd HH:mm:ss 格式
     *
     * @param dateTime LocalDateTime
     * @return String
     */
    public static String formatDateTimeCHN(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return formatDateTime(dateTime, DATE_TIME_FORMAT_CHN);
    }

    /**
     * 格式化时间 为 HH:mm 格式
     *
     * @param time time
     * @return string
     */
    public static String formatTime(LocalTime time) {
        if (time == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
        return formatter.format(time);
    }

    /**
     * 格式化时间
     *
     * @param time       time
     * @param dateFormat 时间格式
     * @return string
     */
    public static String formatTime(LocalTime time, String dateFormat) {
        if (time == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return formatter.format(time);
    }

    /**
     * 格式化时间
     *
     * @param date       日期
     * @param dateFormat 时间规则字符
     * @return String
     */
    public static String formatDate(LocalDate date, String dateFormat) {
        String result = null;
        if (date != null && StringUtils.isNotEmpty(dateFormat)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            result = formatter.format(date);
        }
        return result;
    }

    /**
     * 格式化时间
     *
     * @param dateTime   日期
     * @param dateFormat 时间规则字符
     * @return String
     */
    public static String formatDateTime(LocalDateTime dateTime, String dateFormat) {
        String result = null;
        if (dateTime != null && StringUtils.isNotEmpty(dateFormat)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            result = formatter.format(dateTime);
        }
        return result;
    }

    /**
     * 根据时间获取时间戳
     *
     * @param dateTime dateTime
     * @return Long
     */
    public static Long dateTimeToTimestamp(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.toEpochSecond(ZoneOffset.ofHours(8));
    }


    /**
     * 根据时间戳获取日期时间
     *
     * @param timestamp timestamp
     * @return LocalDateTime
     */
    public static LocalDateTime timestampToDateTime(Long timestamp) {
        return timestamp == null ? null : LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.ofHours(8));
    }


    /**
     * 最新时间 + 分钟
     *
     * @param minutes 分钟
     * @return LocalDateTime
     */
    public static LocalDateTime currentDateTimeAddMinute(long minutes) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.plusMinutes(minutes);
    }

    /**
     * 最新时间 + 小时
     *
     * @param hour 小时
     * @return LocalDateTime
     */
    public static LocalDateTime currentDateTimeAddHour(long hour) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.plusHours(hour);
    }

}
