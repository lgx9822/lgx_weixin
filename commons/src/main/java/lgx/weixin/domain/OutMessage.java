package lgx.weixin.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OutMessage {
	@JsonProperty("touser")
	private String toUser;
	@JsonProperty("messagetype")
	private String messageType;
}
