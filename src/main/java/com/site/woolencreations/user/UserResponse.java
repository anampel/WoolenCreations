package com.site.woolencreations.user;

import com.site.woolencreations.misc.Response;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class UserResponse {
    private User user;
    private Response response;
}
