package com.mvc.upgrade.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardDto {

    private int myno;
    private String myname;
    private String mytitle;
    private String mycontent;
    private Date mydate;
}