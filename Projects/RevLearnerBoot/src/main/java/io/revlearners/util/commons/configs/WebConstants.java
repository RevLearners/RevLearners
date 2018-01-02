package io.revlearners.util.commons.configs;

public final class WebConstants {

	private WebConstants() {
	}

	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users/auth";

	// Main domain of all calls
	public static final String REST_DOMAIN = "/api/rest";

	public static final String TOPICS = REST_DOMAIN + "/topics";
	public static final String RANKS = REST_DOMAIN + "/ranks";
	public static final String USERS = REST_DOMAIN + "/users";
	public static final String QUESTIONS = REST_DOMAIN + "/questions";
	public static final String MESSAGES = REST_DOMAIN + "/messages";
	public static final String NOTIFICATIONS = REST_DOMAIN + "/notifications";
	public static final String CHALLENGES = REST_DOMAIN + "/challenges";
	public static final String REPORTS = REST_DOMAIN + "/reports";
	public static final String CERTIFICATIONS = REST_DOMAIN + "/certifications";
	public static final String USER_CERTIFICATIONS = REST_DOMAIN + "/user_certifications";
	

	// Convenience variable names for identifiers from restful JSONs
	// use these to maintain consistency between Angular4 and Spring rest calls
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String STATUS = "status";
	public static final String ROLE = "role";
	public static final String JSON = "json";

	// for multi-value queries and secondary searching
	public static final String BY = "By";
	public static final String AND = "And";

	// Not sure if Jpa supports these, but why not
	public static final String OR = "Or";
	public static final String XOR = "XOR";

	// get all and return to page
	public static final String GET_BY_ID = "/getById/{id}";

	// get all and return to list
	public static final String GET_LIST = "/getList";

	// get one
	public static final String GET_PAGE = "/getPage";

	// create one
	public static final String CREATE = "/create";

	// update one to many entities by value specified in JpaRepo method
	public static final String UPDATE_BY_ID = "/updateById";

	// delete one to many entities by value specified in JpaRepo method
	public static final String DELETE_BY = "/deleteById";

	// delete all entities
	public static final String DELETE_ALL = "/deleteAll";

	// Security header values
	public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
	public static final String WEB_REALM = "Basic realm=%s\"";
	public static final String REALM_NAME = "RevLearners";

}
