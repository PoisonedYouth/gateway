package gateway;

import encryption.data.Message;
import encryption.data.User;
import io.micronaut.http.HttpResponse;
import io.micronaut.retry.annotation.Fallback;
import io.micronaut.retry.annotation.Retryable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Fallback
@Retryable
public class EncryptClientFallback implements EncryptOperations {

	@Override
	public HttpResponse<User> addEncryptedMessage(String username, String text) {
		return HttpResponse.created(new User("Fallback!", new ArrayList<>()));
	}

	@Override
	public HttpResponse<User> addUser(String username) {
		return HttpResponse.created(new User("Fallback!", new ArrayList<>()));
	}

	@Override
	public HttpResponse<Void> deleteMessage(String username, String text) {
		return HttpResponse.accepted();
	}

	@Override
	public HttpResponse<List<Message>> getMessagesByUser(String username) {
		return HttpResponse.ok(Collections.singletonList(new Message("Hallo", "ollaH")));
	}

	@Override
	public HttpResponse<List<User>> getAllUser() {
		return HttpResponse.notFound();
	}
}
