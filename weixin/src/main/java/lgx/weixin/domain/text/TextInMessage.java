package lgx.weixin.domain.text;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lgx.weixin.domain.InMessage;
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextInMessage extends InMessage {
	
	private static final long serialVersionUID = 1l;

	@XmlElement(name="Content")
	private String content;
	
	
	public TextInMessage() {
		super("text");
	}
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

}
