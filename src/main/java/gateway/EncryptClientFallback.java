package gateway;

import io.micronaut.retry.annotation.Fallback;
import io.micronaut.retry.annotation.Retryable;
import io.reactivex.Single;

@Fallback
@Retryable
public class EncryptClientFallback implements EncryptOperations {

	@Override
	public Single<Message> encrypt(String text) {
		return Single.just(new Message("Fallback!"));
	}
}
