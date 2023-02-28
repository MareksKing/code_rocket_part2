package com.meawallet.dealership.domain;

import lombok.Builder;
import lombok.Value;

import java.util.Collection;

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
