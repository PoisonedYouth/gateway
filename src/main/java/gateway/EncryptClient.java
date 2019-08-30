package gateway;

import encryption.data.Message;
import encryption.data.User;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.security.annotation.Secured;

import java.util.List;

@Client(id = "encrypt-service")
public interface EncryptClient extends EncryptOperations {

	@Post("/encrypt/{username}/{text}")
	HttpResponse<User> addEncryptedMessage(String username, String text);

	@Post("/encrypt/{username}")
	HttpResponse<User> addUser(String username);

	@Delete("/encrypt/{username}/{text}")
	HttpResponse<Void> deleteMessage(String username, String text);

	@Get("/encrypt/{username}")
	HttpResponse<List<Message>> getMessagesByUser(String username);

	@Get("/encrypt/all")
	@Secured("isAuthenticated()")
	HttpResponse<List<User>> getAllUser();
}
