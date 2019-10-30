package com.ladyishenlong.securitytokenservice.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Author ruanchenhao
 * @Date 2019/10/30 10:13 上午
 */
public class DateUtils {

    public static LocalDateTime nowTime() {
        return LocalDateTime.now();
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    public static Date createDate() {
        return localDateTimeToDate(nowTime());
    }

    public static Date expirationDate(long calendarInterval) {
        LocalDateTime expirationDate = nowTime().plus(calendarInterval, ChronoUnit.SECONDS);
        return localDateTimeToDate(expirationDate);
    }

}
