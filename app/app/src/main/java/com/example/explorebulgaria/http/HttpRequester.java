package com.example.explorebulgaria.http;

import java.io.IOException;

public interface HttpRequester {

    String get(String url) throws IOException;

    String put(String url, String body) throws IOException;
}
