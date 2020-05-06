package com.example.springmongo.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;

public class URL {
	
	public static String decodeParam(String txt) {
		try {
			return URLDecoder.decode(txt, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Instant convertInstant(String instant, Instant defaultInstant) {
		try {
			return Instant.parse(instant);
		} catch (Exception e) {
			return defaultInstant;
		}
	}

}
