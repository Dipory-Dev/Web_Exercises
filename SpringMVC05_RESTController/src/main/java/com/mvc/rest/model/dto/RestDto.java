package com.mvc.rest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestDto {
    private int restno;
    private String restid;
    private String restpw;
    private String restname;
}
