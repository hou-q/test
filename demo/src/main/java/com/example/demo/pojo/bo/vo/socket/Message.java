package com.example.demo.pojo.bo.vo.socket;

import java.util.HashMap;

public class Message extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public static final String NEW = "new";
	public static final String MOD = "mod";

	public static final String SEND_ = "SEND_";// 发送

	public static final String SEND_MESSAGE = "SEND_MESSAGE";// 消息发送
	public static final String REPLY_MESSAGE = "REPLY_MESSAGE";// 消息接收

	public static final String SEND_GROUP_CREATE = "SEND_GROUP_CREATE";// 建立群
	public static final String REPLY_GROUP_CREATE = "REPLY_GROUP_CREATE";// 建立群

	public static final String SEND_GROUP_MEMBER = "SEND_GROUP_MEMBER";// 查询群组成员
	public static final String REPLY_GROUP_MEMBER = "REPLY_GROUP_MEMBER";// 查询群组成员返回

	public static final String SEND_GROUP_MEMBER_ADD = "SEND_GROUP_MEMBER_ADD";// 群组成员添加
	public static final String REPLY_GROUP_MEMBER_ADD = "REPLY_GROUP_MEMBER_ADD";// 群组成员添加返回

	public static final String TEXT = "text";// 文本
	public static final String VOICE = "voice";// 语音
	public static final String IMAGE = "image";// 图片
	public static final String FILE = "file";// 文件
	public static final String VIDEO = "video";// 视频
	public static final String LOCATION = "location";// 地址

	public Message() {
	}

	public Message(String type, Object data) {
		this.setType(type);
		this.setData(data);
	}

	public String getType() {
		return (String) this.get("type");
	}

	public void setType(String type) {
		this.put("type", type);
	}

	public Object getData() {
		return this.get("data");
	}

	public void setData(Object data) {
		this.put("data", data);
	}

}
