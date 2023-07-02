package com.example.crpypst.ScheduleSync.utils.constants;

public class SecurityConstants {
    
    // Spring Security
	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZATION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT
	public static final String ISSUER_INFO = "CrPyPsT";
	public static final String SUPER_SECRET_KEY = "bjkasjhksdjajhsjh1u2312";
	public static final long TOKEN_EXPIRATION_TIME = 3600000; // 1 Hour

}
