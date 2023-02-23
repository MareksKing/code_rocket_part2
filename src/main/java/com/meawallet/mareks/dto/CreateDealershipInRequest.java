package com.meawallet.mareks.dto;

import lombok.Value;

@Value
public record CreateDealershipInRequest(String name, String location) {

}
