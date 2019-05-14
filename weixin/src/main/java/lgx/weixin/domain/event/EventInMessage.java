package lgx.weixin.domain.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lgx.weixin.domain.InMessage;
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventInMessage extends InMessage{
	private static final long serialVersionUID = 1l;
	
	@XmlElement(name="Event")
	private String event;
	@XmlElement(name="EventKey")
	private String eventKey;
	public EventInMessage() {
		super("event");
	}

	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
}
