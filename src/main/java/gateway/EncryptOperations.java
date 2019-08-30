package gateway;

import encryption.data.Message;
import encryption.data.User;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;

public interface EncryptOperations {

	@Post("/encrypt/{username}/{text}")
	HttpResponse<User> addEncryptedMessage(String username, String text);

	@Post("/encrypt/{username}")
	HttpResponse<User> addUser(String username);

	@Delete("/encrypt/{username}/{text}")
	HttpResponse<Void> deleteMessage(String username, String text);

	@Get("/encrypt/{username}")
	HttpResponse<List<Message>> getMessagesByUser(String username);

	@Get("/encrypt/all")
	HttpResponse<List<User>> getAllUser();
}
