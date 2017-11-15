package com.news.gfs.pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class GfsNewsUser {
    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    @Size(min = 2, max = 6, message = "姓名长度应在{min}-{max}")
    private String name;
    @Size(min = 6, max = 15, message = "密码长度应在{min}-{max}")
    private String password;
    private String avatar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
