package com.news.gfs.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class GfsNewsInfo {
    private Integer id;
    private Integer userId;
    private Integer typeId;
    private GfsNewsCategory gfsNewsCategory;
    private String writers;
    @NotEmpty(message = "标题不能为空")
    @Size(min = 2, max = 20, message = "标题长度应在{min}-{max}")
    private String title;
    private String contents;
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date createDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public GfsNewsCategory getGfsNewsCategory() {
        return gfsNewsCategory;
    }

    public void setGfsNewsCategory(GfsNewsCategory gfsNewsCategory) {
        this.gfsNewsCategory = gfsNewsCategory;
    }

    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
