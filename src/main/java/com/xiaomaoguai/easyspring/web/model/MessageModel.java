package com.xiaomaoguai.easyspring.web.model;

import java.io.Serializable;

/*
 * @Description :消息模型
 * @FileName: IndexAction.java
 * @Author :WeiHui.Zhang
 * @Data : 2014年11月9日 下午1:27:57
 * @Version:1.0.0
 */
public class MessageModel implements Serializable {

	private static final long serialVersionUID = 7746383311114005133L;

	private String msg;
	private Integer code;
	private boolean success;

	public static enum MessageState {

		FAILURE(0, false), SUCCESS(1, true), EXCEPTION(2, false);

		public final int index;
		public final boolean success;

		MessageState(int index, boolean success) {
			this.index = index;
			this.success = success;
		}
	}

	public MessageModel() {
	}

	public MessageModel(boolean success) {
		this.success = success;
	}

	public MessageModel(MessageState state) {
		this.code = state.index;
		this.success = state.success;

	}

	public MessageModel(Integer code) {
		this.code = code;
	}

	public MessageModel(MessageState state, String msg) {
		this.code = state.index;
		this.success = state.success;
		this.msg = msg;
	}

	public MessageModel(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public MessageModel(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "MessageModel [msg=" + msg + ", code=" + code + ", success="
				+ success + "]";
	}
}