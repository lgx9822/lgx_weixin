package lgx.weixin.domain;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;


public abstract class InMessage implements Serializable {
	private static final long serialVersionUID = 1l;
	@JsonProperty("ToUserName")
	private String toUserName;
	@JsonProperty("FromUserName")
	private String fromUserName;
	@JsonProperty("CreateTime")
	private long createTime;
	@JsonProperty("MsgType")
	private String msgType;
	@JsonProperty("MsgId")
	private long msgId;
	protected InMessage(String type) {
		this.msgType = type;	
	}
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public long getMsgId() {
		return msgId;
	}
	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}
	
}
