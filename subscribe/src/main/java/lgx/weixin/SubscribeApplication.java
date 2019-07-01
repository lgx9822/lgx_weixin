package lgx.weixin;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.util.xml.StaxUtils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lgx.weixin.domain.InMessage;
import lgx.weixin.domain.event.EventInMessage;
import lgx.weixin.processors.EventMessageProcessor;
import lgx.weixin.service.JsonRedisSerializer;

@SpringBootApplication
public class SubscribeApplication implements ApplicationContextAware,CommandLineRunner,DisposableBean{
	private static final Logger LOG = (Logger) LoggerFactory.getLogger(SubscribeApplication.class);
	private ApplicationContext ctx;
	private Object ruunnerMonitor = new Object();
	@Override
	public void destroy() throws Exception {
		synchronized (ruunnerMonitor) {
			ruunnerMonitor.notify();
		}
		
	}

	@Override
	public void run(String... args) throws Exception {
		Thread t = new Thread(() -> {
			synchronized (ruunnerMonitor) {
				try {
					ruunnerMonitor.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
		
		
	}

	@Bean()
	public XmlMapper xmlMapper() {
		XmlMapper mapper = new XmlMapper(StaxUtils.createDefensiveInputFactory());
		return mapper;
	}
	
	@Bean 
	public RedisTemplate<String, ? extends InMessage> inMessageTemplate(//
			
			@Autowired RedisConnectionFactory connectionFactory) {

		RedisTemplate<String, ? extends InMessage> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		template.setValueSerializer( jsonRedisSerializer());
		return template;
	}
	@Bean
	public JsonRedisSerializer<InMessage> jsonRedisSerializer(){
		return new JsonRedisSerializer<InMessage>();
		
	}
	@Bean
	public RedisMessageListenerContainer messageListenerContainer(
			@Autowired RedisConnectionFactory connectionFactory
			) {
		RedisMessageListenerContainer c = new RedisMessageListenerContainer();
		c.setConnectionFactory(connectionFactory);
		ChannelTopic topic = new ChannelTopic("kemao_3_event");
		
		MessageListener  listener = (message,  pattern)-> {
				byte[] channel = message.getChannel();
				byte[] body = message.getBody();
				JsonRedisSerializer<InMessage> serializer = jsonRedisSerializer();
				InMessage msg = serializer.deserialize(body);
				EventInMessage event = (EventInMessage) msg;
				String eventType = event.getEvent();
				eventType = eventType.toLowerCase();
				
				String beanName = eventType + "MessageProcessor";
				EventMessageProcessor mp = (EventMessageProcessor) ctx.getBean(beanName);
				if(mp == null) {
					LOG.error("事件{} 没有找到对应的处理器",eventType);
				}else{
					mp.onMessage(event);
				}
				
		};
		c.addMessageListener(listener, topic);
		return c;
		
	}
	public static void main(String[] args) {
		SpringApplication.run(SubscribeApplication.class, args);
	}


}
