package com.shortener.shortener.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;


@Data
@Table
public class Url {

    @Id
    private final String id;

    private String longUrl;

}
