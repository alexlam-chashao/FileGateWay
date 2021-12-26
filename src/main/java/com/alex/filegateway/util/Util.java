package com.alex.filegateway.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author alex
 */
@Component

public class Util {
    @Value("${debug.log}")
    private Boolean debugMode;

    public void log(Object object) {
        if (debugMode) {
            System.out.println(object);
        }
    }

}
