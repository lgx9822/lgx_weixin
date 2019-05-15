package lgx.weixin.service.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lgx.weixin.controller.MessageReceiverController;
import lgx.weixin.domain.InMessage;
import lgx.weixin.domain.OutMessage;
import lgx.weixin.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService {
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);
	@Autowired
	@Qualifier("inMessageTemplate")
	private RedisTemplate<String, ? extends InMessage> inMessageTemplate;
	@Override
	public OutMessage onMessage(InMessage msg) {
		LOG.trace("转化后的消息对象:\n{}\n", msg);
		//特征   kemao_3_ 通道
		inMessageTemplate.convertAndSend("kemao_3_" + msg.getMsgType(), msg);
		
		return null;
	}

}
