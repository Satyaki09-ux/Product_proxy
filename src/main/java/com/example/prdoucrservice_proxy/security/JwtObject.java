package com.example.prdoucrservice_proxy.security;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class JwtObject {
    String email;
    Long userId;
    Date createdDate;
    Date expiryDate;
    List<Role> role = new ArrayList<>();
}
