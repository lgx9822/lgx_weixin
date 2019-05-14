package lgx.weixin.service;

import lgx.weixin.domain.InMessage;
import lgx.weixin.domain.OutMessage;

public interface MessageService {
	OutMessage onMessage(InMessage msg);
}
