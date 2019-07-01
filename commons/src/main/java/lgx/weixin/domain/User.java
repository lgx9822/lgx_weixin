package lgx.weixin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="wx_user")
public class User {
	public static enum Status{
		IS_SUBCRIBED,
		IS_UNSUBCRIBED;
	}
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(length = 36)
	private String id;
	@Enumerated(EnumType.STRING)
	private Status status;
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Transient
	private String subscribe;
	@JsonProperty("openid")
	private String openId;
	@JsonProperty("nickname")
	private String nickName;
	private String sex;
	private String city;
	private String country;
	private String province;
	private String language;
	@JsonProperty("headimgurl")
	@Column(length = 1024)
	private String headImgUrl;
	@JsonProperty("subscribe_time")
	private String subscribeTime;
	@JsonProperty("unionid")
	private String unionId;
	private String remark;
	@JsonProperty("groupid")
	private String groupId;
	@JsonProperty("tagid_list")
	private String[] tagidList;
	@JsonProperty("subscribe_scene")
	private String subscribeScene;
	@JsonProperty("qr_scene")
	private String qrScene;
	@JsonProperty("gr_scene_str")
	private String grSceneStr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getSubscribeTime() {
		return subscribeTime;
	}
	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String[] getTagidList() {
		return tagidList;
	}
	public void setTagidList(String[] tagidList) {
		this.tagidList = tagidList;
	}
	public String getSubscribeScene() {
		return subscribeScene;
	}
	public void setSubscribeScene(String subscribeScene) {
		this.subscribeScene = subscribeScene;
	}
	public String getQrScene() {
		return qrScene;
	}
	public void setQrScene(String qrScene) {
		this.qrScene = qrScene;
	}
	public String getGrSceneStr() {
		return grSceneStr;
	}
	public void setGrSceneStr(String grSceneStr) {
		this.grSceneStr = grSceneStr;
	}
	
}
