package gateway;

import io.micronaut.security.authentication.*;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

	private static final String ADMIN_USER = "sherlock";
	private static final String ADMIN_PASSWORD = "password";

	@Override
	public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
		if (authenticationRequest.getIdentity().equals(ADMIN_USER) && authenticationRequest.getSecret().equals(ADMIN_PASSWORD)) {
			return Flowable.just(new UserDetails((String) authenticationRequest.getIdentity(), new ArrayList<>()));
		}
		return Flowable.just(new AuthenticationFailed());
	}
}