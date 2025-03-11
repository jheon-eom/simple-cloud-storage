package com.eomproject.simple_storage.directory.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Owner {

    private Long id;

    private String account;
}
