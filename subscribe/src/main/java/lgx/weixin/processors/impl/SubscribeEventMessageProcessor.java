package lgx.weixin.processors.impl;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lgx.weixin.domain.User;
import lgx.weixin.domain.event.EventInMessage;
import lgx.weixin.processors.EventMessageProcessor;
import lgx.weixin.respository.UserRepository;
import lgx.weixin.service.WeiXinProxy;
@Service("subscribeMessageProcessor")
public class SubscribeEventMessageProcessor implements EventMessageProcessor{
	@Autowired
	private UserRepository userRespository;
	@Autowired
	private WeiXinProxy proxy;
	
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SubscribeEventMessageProcessor.class); 
	@Override
	public void onMessage(EventInMessage event) {
		LOG.trace("关注事件处理被调用，收到的消息:\n{}",event);
		if(event.getEvent().equals("subscript")) {
			return;
		}
			String openId = event.getFromUserName();
			User user = this.userRespository.findByOpenId(openId);
			if(user != null) {
				if(user.getStatus()== User.Status.IS_SUBCRIBED) {
					return;
				}
				User wxUser = this.proxy.getWxUser(openId);
				if(user!=null) {
					wxUser.setId(user.getId());
					wxUser.setStatus(User.Status.IS_SUBCRIBED);
				}
				this.userRespository.save(wxUser);
				this.proxy.sendText(openId,"欢迎关注公众号，回复\"学习\"可以获取智能菜单。");
			}
		}
	
}
