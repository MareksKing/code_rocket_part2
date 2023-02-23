package com.meawallet.mareks.domain;

import lombok.Builder;
import lombok.Value;

import java.util.Collection;
import java.util.Iterator;

@Value
@Builder
public class User {

    Integer id;
    String name;
    String surname;
    String email;
    String phoneNumber;
    String town;
    Collection<Car> bookmarks;


}
