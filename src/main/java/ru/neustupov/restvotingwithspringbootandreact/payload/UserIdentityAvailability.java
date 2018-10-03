package ru.neustupov.restvotingwithspringbootandreact.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserIdentityAvailability {

    private Boolean available;
}
