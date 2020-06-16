package io.eroshenkoam.swagger.petstore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String status;

    public Long getId() {
        return id;
    }

    public Pet setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pet setName(String name) {
        this.name = name;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Pet setStatus(String status) {
        this.status = status;
        return this;
    }

}
