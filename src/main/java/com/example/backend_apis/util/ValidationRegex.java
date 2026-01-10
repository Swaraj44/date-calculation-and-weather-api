package com.example.backend_apis.util;

public final class ValidationRegex {

    private ValidationRegex() {}

                                                  // YYYY-MM-DD
    public static final String DATE = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";

                                                 // number < 1000 and  max 2 decimals
    public static final String NUMBER = "^(\\d{1,3})(\\.\\d{1,2})?$";
}
