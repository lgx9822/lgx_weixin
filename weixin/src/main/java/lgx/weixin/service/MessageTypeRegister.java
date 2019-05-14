package lgx.weixin.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lgx.weixin.domain.InMessage;
import lgx.weixin.domain.event.EventInMessage;
import lgx.weixin.domain.text.TextInMessage;

public class MessageTypeRegister {
	
	private static Map<String ,Class<?extends InMessage>>typeMap = new ConcurrentHashMap<>();
	
	static {
		register("text",TextInMessage.class);
		register("event",EventInMessage.class);
		register("location",TextInMessage.class);
		register("image",TextInMessage.class);
		register("video",TextInMessage.class);
		register("shortvideo",TextInMessage.class);
		register("voice",TextInMessage.class);
	}
	public static void register(String type,Class<? extends InMessage>cla) {
		typeMap.putIfAbsent(type, cla);
		
	}
	public static Class<? extends InMessage> getclass(String type) {
		// TODO Auto-generated method stub
		return typeMap.get(type);
	}
}
