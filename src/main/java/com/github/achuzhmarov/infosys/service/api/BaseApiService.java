package com.github.achuzhmarov.infosys.service.api;

import java.util.function.Supplier;

/**
 * Base class for any ApiService. Contains retry logic.
 */
public class BaseApiService {
    private final int MAX_RETRIES = 5;

    <T> T callWithRetries(Supplier<T> apiCall) {
        return callWithRetries(apiCall, 0);
    }

    private <T> T callWithRetries(Supplier<T> apiCall, int tryCount) {
        try {
            return apiCall.get();
        } catch (Exception e) {
            tryCount++;

            if (tryCount < MAX_RETRIES) {
                return callWithRetries(apiCall, tryCount);
            } else {
                throw e;
            }
        }
    }
}
