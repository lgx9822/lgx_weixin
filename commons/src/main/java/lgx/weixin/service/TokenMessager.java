package lgx.weixin.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.Charset;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lgx.weixin.domain.AccessToken;

@Service
public class TokenMessager {
	private Object tokenManager;
	public String getToken() {
		String appId = "wx0ca307e4554a937f";
		String appSecret = "b707ca93e948c4b943a6b9c5e2ffc42d";
		String url = "https://api.weixin.qq.com/cgi-bin/token"
				+ "?grant_type=client_credential"
				+ "&appid=" + appId
				+ "&secret=" +appSecret;
		HttpClient client = HttpClient.newBuilder()
				.version(Version.HTTP_1_1)
				.build();
		HttpRequest request = HttpRequest.newBuilder(URI.create(url))
				.GET()
				.build();
		try {
			HttpResponse<String> response = 
					client.send(request, BodyHandlers.ofString(Charset.forName("UTF-8")));
			String json = response.body();//响应体
			if(json.indexOf("errcode")>0) {
				throw new RuntimeException("获取令牌出现问题:" + json);
			}
			ObjectMapper mapper = new ObjectMapper();
			AccessToken at = mapper.readValue(json, AccessToken.class);
			return at.getAccessToken();
			} catch (Exception e) {
				throw new RuntimeException("获取令牌出现问题:" + e.getLocalizedMessage(), e);
			}
	}
	String accessToken = ((TokenMessager) this.tokenManager).getToken();
	private String openId;
	String url = ""
			+ "" + accessToken
			+ "" + openId
			+ "" ;
			
}
