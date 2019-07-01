package lgx.weixin.processors;

import lgx.weixin.domain.event.EventInMessage;

public interface EventMessageProcessor {

void onMessage(EventInMessage event);

}
