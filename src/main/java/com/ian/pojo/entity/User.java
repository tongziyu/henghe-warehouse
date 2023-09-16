package com.ian.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * user_info表的实体类:
 */
@Data
@ToString
@NoArgsConstructor
public class User {

	private int userId;//用户id

	private String userCode;//账号

	private String userName;//用户名

	private String userPwd;//用户密码

	private String userType;//用户类型

	private String userState;//用户状态

	private String isDelete;//删除状态

	private int createBy;//创建人

	//返回前端时,自动将Date转换成指定格式的json字符串
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;//创建时间

	private int updateBy;//修改人

	private LocalDateTime updateTime;//修改时间

	private String getCode;


	public User(int userId, String userCode, String userName, String userPwd,
			String userType, String userState, String isDelete, int createBy,
				LocalDateTime createTime, int updateBy, LocalDateTime updateTime) {
		this.userId = userId;
		this.userCode = userCode;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
		this.userState = userState;
		this.isDelete = isDelete;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
	}
}
