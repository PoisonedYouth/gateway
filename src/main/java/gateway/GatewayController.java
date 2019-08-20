package gateway;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.tracing.annotation.SpanTag;
import io.reactivex.Single;

@Controller("/api/${api.version:v1}")
public class GatewayController implements EncryptOperations{

	private final EncryptClient encryptClient;

	public GatewayController(EncryptClient encryptClient) {
		this.encryptClient = encryptClient;
	}

	@Get("/encrypt/{text}")
	public Single<Message> encrypt(@SpanTag("plain-text") String text) {
		return encryptClient.encrypt(text);
	}
}
