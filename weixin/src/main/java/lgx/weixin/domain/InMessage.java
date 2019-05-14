package lgx.weixin.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//接收到的信息
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class InMessage implements Serializable {
	private static final long serialVersionUID = 1l;
	@XmlElement(name="ToUserName")
	private String toUserName;
	@XmlElement(name="FromUsername")
	private String fromUsername;
	@XmlElement(name="CreateTime")
	private long createTime;
	@XmlElement(name="MsgType")
	private String msgType;
	@XmlElement(name="MsgId")
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
	public String getFromUsername() {
		return fromUsername;
	}
	public void setFromUsername(String fromUsername) {
		this.fromUsername = fromUsername;
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
