package com.rme.admin.dto;

import java.util.ArrayList;
import java.util.List;

public class SuccessResponseDto {
	private List<String> msg = new ArrayList<>();
	private boolean status = true;

	public List<String> getMsg() {
		return msg;
	}

	public void setMsg(List<String> msg) {
		this.msg = msg;
	}

	public boolean isStatus() {
		return status;
	}

}
