package com.example.crpypst.ScheduleSync.utils.constants;

public class SecurityConstants {
    
    // Spring Security
	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZATION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT
	public static final String ISSUER_INFO = "CrPyPsT";
	public static final String SUPER_SECRET_KEY = "30820122300d06092a864886f70d01010105000382010f003082010a0282010100b604a08506d9063b7b887b6cacef3e25da12797f0944017ced882e14006439624ebe6e8b210789591cc1790e611db393926fa273f124cc7d6071afefe3d572d83e251d48287450bf88fde8d9f5d666b3d58d2ae69f25816ce0a12c9c846bc1fa9cb091cbdeae30201e6d12d08840e3ded17b4f200ed150918242fe67aa653887fd2f57fe19c34ae2ffae1112a6526573ba21a481230af94e453e37966ae404bb6e83ca78ab05b6b0562c66b6212baa057351235610532cc76d7093a5c47a8fa74a5f941f18f1d6f529e62ed18928e1103548b1ec959c55e648e0101e695f2826b815757f0f3739a736ac034655374f8e03a41695fc5523778464f92cad9962590203010001";
	public static final long TOKEN_EXPIRATION_TIME = 3600000; // 1 Hour

}
