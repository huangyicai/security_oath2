/**
 * 
 */
package cn.hoarfrost.security.demo.security.provider;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * 短信登录验证信息封装类
 * 
 * @author zhailiang
 *
 */
public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	private final Object principal;
	private Object credentials;

	public SmsCodeAuthenticationToken(Object principal, Object credentials) {
		super((Collection)null);
		this.principal = principal;
		this.credentials = credentials;
		this.setAuthenticated(false);
	}

	public SmsCodeAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.credentials = credentials;
		super.setAuthenticated(true);
	}

	public Object getCredentials() {
		return this.credentials;
	}

	public Object getPrincipal() {
		return this.principal;
	}

	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		if (isAuthenticated) {
			throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
		} else {
			super.setAuthenticated(false);
		}
	}

	public void eraseCredentials() {
		super.eraseCredentials();
		this.credentials = null;
	}
}
