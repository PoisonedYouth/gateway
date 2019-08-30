package gateway;

import encryption.data.Message;
import encryption.data.User;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Post;
import io.micronaut.tracing.annotation.SpanTag;

import java.util.List;

@Controller("/api/${api.version:v1}")
public class GatewayController implements EncryptOperations {

	private final EncryptClient encryptClient;

	public GatewayController(EncryptClient encryptClient) {
		this.encryptClient = encryptClient;
	}

	@Override
	public HttpResponse<User> addEncryptedMessage(@SpanTag("plain-text") String username, @SpanTag("plain-text") String text) {
		return encryptClient.addEncryptedMessage(username, text);
	}

	@Override
	public HttpResponse<User> addUser(String username) {
		return encryptClient.addUser(username);
	}

	@Override
	public HttpResponse<Void> deleteMessage(String username, String text) {
		return encryptClient.deleteMessage(username, text);
	}

	@Override
	public HttpResponse<List<Message>> getMessagesByUser(String username) {
		return encryptClient.getMessagesByUser(username);
	}

	@Override
	public HttpResponse<List<User>> getAllUser() {
		return encryptClient.getAllUser();
	}
}
