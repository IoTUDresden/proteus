package eu.vicci.process.client.handlers;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.vicci.process.engine.core.ReplyState;
import rx.Subscriber;
import ws.wamp.jawampa.Reply;

public abstract class AbstractClientHandler extends Subscriber<Reply> {
	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractClientHandler.class);
	private static final int timeout = 120; // seconds

	private ObjectMapper mapper = new ObjectMapper();
	private boolean isFinished = false;
	private boolean hasError = false;
	private CountDownLatch countDownLatch = new CountDownLatch(1);

	protected String state = ReplyState.WAITING;

	public AbstractClientHandler() {
	}

	@Override
	public void onCompleted() {
		finished();
	}

	@Override
	public void onError(Throwable arg0) {
		arg0.printStackTrace();
		hasError = true;
		state = ReplyState.ERROR;
		finished();
	}

	public boolean isFinished() {
		return isFinished;
	}

	protected void finished() {
		isFinished = true;
		if (countDownLatch != null)
			countDownLatch.countDown();
	}

	/**
	 * Causes the current thread to wait until the latch has counted down to
	 * zero, unless the thread is interrupted, or the specified waiting time
	 * elapses.
	 * <br><br>
	 * If the current count is zero then this method returns immediately with
	 * the value true.
	 * <br><br>
	 * If the current count is greater than zero then the current thread becomes
	 * disabled for thread scheduling purposes and lies dormant until one of
	 * three things happen: 
	 * <ul>
	 *  <li>The count reaches zero due to invocations of the countDown method; or </li>
	 *  <li> Some other thread interrupts the current thread; or</li>
	 *  <li> The specified waiting time elapses. </li>
	 * </ul>
	 * <br><br>
	 * If the count reaches zero then the method returns with the value true.
	 * <br><br>
	 * If the current thread: 
	 * <ul>
	 *  <li> has its interrupted status set on entry to this method; or </li>
	 *  <li> is interrupted while waiting, then InterruptedException is
	 * thrown and the current thread's interrupted status is cleared.</li>
	 * </ul>
	 * If the
	 * specified waiting time elapses then the value false is returned. If the
	 * time is less than or equal to zero, the method will not wait at all.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean await() throws InterruptedException {
		return countDownLatch.await(timeout, TimeUnit.SECONDS);
	}

	public boolean hasError() {
		return hasError;
	}

	public String getState() {
		return state;
	}

	protected final <T> T convertFromJson(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected final <T> T convertFromJson(JsonNode json, Class<T> clazz) {
		try {
			return mapper.readValue(json.toString(), clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected final <T> T convertFromJson(JsonNode json, TypeReference<T> reference) {
		try {
			return mapper.readValue(json.toString(), reference);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected final Object unsafeConvertFromJson(JsonNode json, TypeReference<?> reference) {
		try {
			return mapper.readValue(json.toString(), reference);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected final <T extends Collection<?>> T convertFromJsonToCollectionType(JsonNode json, Class<T> collectionClass,
			Class<?> elementClass) {
		try {
			JavaType type = mapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
			return mapper.readValue(json.toString(), type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
