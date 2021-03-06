package com.brs.userservicemanagement.dao;

import com.brs.userservicemanagement.entity.UserAuthorization;


/**
 * The Interface UserAuthorizationDAO.
 */
public interface UserAuthorizationDAO {

	/**
	 * Save user token.
	 *
	 * @param userAuth the user auth
	 * @return the integer
	 */
	Integer saveUserToken(UserAuthorization userAuth);

}
