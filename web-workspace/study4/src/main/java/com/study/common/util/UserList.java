package com.study.common.util;

import java.util.HashMap;
import java.util.Map;

import com.study.login.vo.UserVO;

public class UserList {
	private Map<String, UserVO> userMap;


	public UserList() {
		userMap = new HashMap<String, UserVO>();
		UserVO user = null;
		user = new UserVO("malja", "말자", "1004", "ADMIN");
		userMap.put(user.getUserId(), user);

		user = new UserVO("sunja", "순자", "1111", "USER");
		userMap.put(user.getUserId(), user);

		user = new UserVO("gonja", "공자", "1226", "USER");
		userMap.put(user.getUserId(), user);

		user = new UserVO("Milkis", "밀키스", "1403", "MANAGER");
		userMap.put(user.getUserId(), user);
	}

	public UserVO getUser(String id) {
		if (userMap.containsKey(id)) {
			return userMap.get(id);
		} else {
			return null;
		}
	}
		public Map<String, UserVO> getUserMap() {
			return userMap;
		}

}
