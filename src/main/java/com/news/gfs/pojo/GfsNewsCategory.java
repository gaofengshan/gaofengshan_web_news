package com.news.gfs.pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class GfsNewsCategory {
    private Integer id;
    @NotEmpty(message = "类别不能为空")
    @Size(min = 2, max = 20, message = "姓名长度应在{min}-{max}")
    private String typeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
