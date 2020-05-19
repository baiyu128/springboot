package com.baiyu.securityjwt.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author baiyu
 * @data 2020-05-19 13:31
 */
public class Role implements GrantedAuthority {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

}
