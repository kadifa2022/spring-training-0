package com.cydeo.model;

import lombok.Data;

@Data
public class Comment {//never put component in model class no relationship
    private String author;
    private String text;
}
