package com.projetc.investimento.Utils;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@NoArgsConstructor
public class DataUtil {

    public static final String FORMAT_DATA = "dd/MM/yyyy";
    public static final String FORMAT_TIME = "HH:mm:ss";

    public static String converteDateTimeToString(final Date data){
        String convertDate = converteDateToJustDate(data);
        String convertTime = converteDateToJustTime(data);
        return convertDate + " - " + convertTime;
    }

    private static String converteDateToJustDate(final Date data){
        return new SimpleDateFormat(FORMAT_DATA).format(data);
    }

    private static String converteDateToJustTime(final Date data){
        return new SimpleDateFormat(FORMAT_TIME).format(data);
    }


}
