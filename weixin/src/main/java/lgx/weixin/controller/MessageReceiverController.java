package lgx.weixin.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lgx.weixin.domain.InMessage;
import lgx.weixin.service.MessageService;
import lgx.weixin.service.MessageTypeRegister;
@RestController
@RequestMapping("/kemao_3/weixin/reciver")
public class MessageReceiverController {
	
	
	@Autowired
	private MessageService messageService;
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MessageReceiverController.class);
	@GetMapping
	public String echo(
			@RequestParam("signature")String signature,
			@RequestParam("timestamp")String timestamp, 
			@RequestParam("nonce")String nonce,
			@RequestParam("echostr")String echostr) {
	return 	echostr;	
	}
	@PostMapping
	public String receive(
			@RequestParam(value = "signature",required = false)String signature,
			@RequestParam(value = "timestamp",required = false)String timestamp, 
			@RequestParam(value = "nonce",required = false)String nonce,
			@RequestBody String xml
			) {
		LOG.debug("\n收到请求参数\n"
			+ "signature:{}\n"
			+ "timestamp:{}\n"
			+ "nonce:{}\n"
			+ "收到的请求内容\n{}\n"
			,signature,timestamp,nonce,xml);
		String type = xml.substring(xml.indexOf("<MsgType><![CDATA{") + 18);
		type = type.substring(0, type.indexOf("<]]MsgType>"));
		Class<? extends InMessage> cla = MessageTypeRegister.getclass(type);
		return "success";
	}
}
