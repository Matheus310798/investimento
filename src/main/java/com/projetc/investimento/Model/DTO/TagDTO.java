package com.projetc.investimento.Model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TagDTO {

    private String currency;
    private String shortName;
    private String longName;
    private Double regularMarketChange;
    private Double regularMarketChangePercent;
    private String regularMarketTime;
    private Double regularMarketPrice;
    private Double regularMarketDayHigh;
    private String regularMarketDayRange;
    private Double regularMarketDayLow;
    private Integer regularMarketVolume;
    private Double regularMarketPreviousClose;
    private Double regularMarketOpen;
    private String fiftyTwoWeekRange;
    private Double fiftyTwoWeekLow;
    private Double fiftyTwoWeekHigh;
    private String symbol;
    private Double priceEarnings;
    private Double earningsPerShare;
    private String logourl;
}
