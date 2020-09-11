package com.modume.main.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.modume.main.db.JdbcSelectInterface;
import com.modume.main.db.JdbcTemplate;
import com.modume.main.db.JdbcUpdateInterface;
import com.modume.main.vo.UserVO;

public class UserDAO {
	public int join(UserVO param) {
		String sql = " insert into t_user " + " (user_id,user_pw,nm,salt) " + " VALUES " + " (?,?,?,?) ";

		return JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {

			@Override
			public int update(PreparedStatement ps) throws SQLException {
				int arg0 = 1;
				ps.setNString(arg0++, param.getUser_id());
				ps.setNString(arg0++, param.getUser_pw());
				ps.setNString(arg0++, param.getNm());
				ps.setNString(arg0++, param.getSalt());
				return ps.executeUpdate();
			}
		});
	}

	public UserVO login(UserVO param) {
		UserVO result = new UserVO();
		String sql = " select i_user, user_id, user_pw,salt, nm, profile_img, r_dt, m_dt from t_user where ";

		if (param.getI_user() > 0) {
			sql += " i_user = " + param.getI_user();
		} else if (param.getUser_id() != null && !"".equals(param.getUser_id())) {
			sql += " user_id ='" + param.getUser_id() + "' ";
		}

		JdbcTemplate.executeQuery(sql, new JdbcSelectInterface() {

			@Override
			public void prepard(PreparedStatement ps) throws SQLException {

			}

			@Override
			public void executeQuery(ResultSet rs) throws SQLException {
				if (rs.next()) {
					result.setI_user(rs.getInt("i_user"));
					result.setUser_id(rs.getNString("user_id"));
					result.setUser_pw(rs.getNString("user_pw"));
					result.setNm(rs.getNString("nm"));
					result.setSalt(rs.getNString("salt"));
					result.setProfile_img(rs.getNString("profile_img"));
					result.setR_dt(rs.getString("r_dt"));
					result.setM_dt(rs.getString("m_dt"));
				}
			}
		});

		return result;

	}
}
