package com.news.gfs.pojo.GfsCriteria;

import com.news.gfs.pojo.GfsNewsInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GfsCriteria extends GfsNewsInfo{
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxDate;

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

}
