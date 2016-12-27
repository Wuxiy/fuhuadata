package com.fuhuadata.dao.impl;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import com.fuhuadata.dao.UserAccountDao;
import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.domain.query.UserAccountQuery;
public class UserAccountDaoImpl extends SqlMapClientTemplate implements UserAccountDao{
	public static final String ADD = "USERACCOUNT.ADD";
    public static final String UPDATE = "USERACCOUNT.UPDATE";
    public static final String DELETE_BY_ID = "USERACCOUNT.DELETE-BY-ID";
    public static final String GET_ALL = "USERACCOUNT.GET-ALL";
    public static final String GET_BY_QUERY = "USERACCOUNT.GET-BY-QUERY";
    public static final String GET_BY_ID = "USERACCOUNT.GET-BY-ID";
    public static final String GET_PAGE = "USERACCOUNT.GET-PAGE";
    public static final String COUNT = "USERACCOUNT.COUNT";
    /**
	 * 新增 userAccount,返回userAccount对象(设置了新生成id)
	 * @param userAccount
	 * @return
	 */
	public UserAccount addUserAccount(UserAccount userAccount) {
		userAccount.setId((Integer) this.insert(ADD, userAccount));
    	return userAccount;
	}
	/**
     * 按照主键id更新userAccount，成功返回1，使用接口时，请重新new UserAccount 的更新对象，设置要更新的字段
     * @param id
     * @param userAccount
     * @return
     */
	public int updateUserAccountById(int id, UserAccount userAccount) {
		userAccount.setId(id);
		return this.update(UPDATE, userAccount);
	}

	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @param id
     * @return
     */
	public int deleteUserAccountById(int id) {
		return this.update(DELETE_BY_ID, id);
	}

	 /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<UserAccount> getAllUserAccounts() {
		return this.queryForList(GET_ALL);
	}

	 /**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param userAccountQuery
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<UserAccount> getUserAccountsByQuery(UserAccountQuery userAccountQuery) {
		return this.queryForList(GET_BY_QUERY, userAccountQuery);
	}

	 /**
     * 通过主键id查询UserAccount，查询不到返回NULL值
     * @param id
     * @return
     */
	public UserAccount getUserAccountById(int id) {
		return (UserAccount) this.queryForObject(GET_BY_ID, id);
	}

	/**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param userAccountQuery
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<UserAccount> getUserAccountsByPage(UserAccountQuery userAccountQuery) {
		return this.queryForList(GET_PAGE, userAccountQuery);
	}

	 /**
     * 查询总数
     * @param userAccountQuery
     * @return
     */
	public int count(UserAccountQuery userAccountQuery) {
		return ((Integer) this.queryForObject(COUNT, userAccountQuery)).intValue();
	}

}
