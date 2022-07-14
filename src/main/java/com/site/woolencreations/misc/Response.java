package com.site.woolencreations.misc;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Response {
    private String status;
    private Integer errorCode;
}
