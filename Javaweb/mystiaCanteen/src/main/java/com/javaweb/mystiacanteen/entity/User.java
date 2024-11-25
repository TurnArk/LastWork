package com.javaweb.mystiacanteen.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class User {
    private Integer username;
    private String password;
    private String name;
    private String gender;
    private Integer deposit;
    private JsonNode cart;
}
