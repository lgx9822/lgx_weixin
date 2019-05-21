package lgx.weixin.processors.impl;

import org.springframework.stereotype.Service;

import lgx.weixin.domain.event.EventInMessage;
import lgx.weixin.processors.EventMessageProcessor;
@Service("subscribeMessageProcessor")
public class SubscribeEventMessageProcessor implements EventMessageProcessor{

	@Override
	public void onMessage(EventInMessage event) {
		System.out.println("处理关注消息：" +event);
		
	}
	
}
