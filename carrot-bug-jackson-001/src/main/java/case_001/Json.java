package case_001;

import java.io.InputStream;
import java.net.URL;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.Module;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// keep private
class Json {

	private static Logger log = LoggerFactory.getLogger(Json.class);

	private static final ObjectMapper MAPPER;

	static {

		MAPPER = new ObjectMapper();

		applyMapperPolicy(MAPPER);

		applyMapperPolicyIdent(MAPPER, true);

	}

	public static ObjectMapper getInstance() {
		return MAPPER;
	}

	@SuppressWarnings("deprecation")
	public static void applyMapperPolicy(final ObjectMapper mapper) {

		/** it is fine to use "{ a : 'b' }" */

		mapper.configure(//
				JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		mapper.configure(//
				JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

		/** must annotate fields with @JsonProperty explicitly */

		mapper.configure(//
				DeserializationConfig.Feature.AUTO_DETECT_FIELDS, false);
		mapper.configure(//
				DeserializationConfig.Feature.AUTO_DETECT_SETTERS, false);
		mapper.configure(//
				DeserializationConfig.Feature.AUTO_DETECT_CREATORS, false);

		/** make all unknown into optional */

		mapper.configure(
				DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		/** must annotate with @JsonProperty explicitly */
		mapper.configure(//
				SerializationConfig.Feature.AUTO_DETECT_FIELDS, false);
		mapper.configure(//
				SerializationConfig.Feature.AUTO_DETECT_GETTERS, false);
		mapper.configure(//
				SerializationConfig.Feature.AUTO_DETECT_IS_GETTERS, false);

		/** no more empty fields */
		mapper.configure(//
				SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);

		/** will NOT close output NOT owned by the generator */
		mapper.configure(//
				JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);

	}

	public static void registerModule(final Module module) {
		MAPPER.registerModule(module);
	}

	@SuppressWarnings("deprecation")
	public static void applyMapperPolicyIdent(final ObjectMapper mapper,
			final boolean on) {
		if (on) {
			mapper.getSerializationConfig().enable(
					SerializationConfig.Feature.INDENT_OUTPUT);
		} else {
			mapper.getSerializationConfig().disable(
					SerializationConfig.Feature.INDENT_OUTPUT);
		}
	}

	public static <T> T fromText(final String text, final Class<T> klaz) {
		try {
			final T value = MAPPER.readValue(text, klaz);
			return value;
		} catch (final Exception e) {
			log.error("", e);
			return null;
		}
	}

	public static <T> T fromCP(final String path, final Class<T> klaz) {
		try {
			final InputStream input = Json.class.getResourceAsStream(path);
			final T value = MAPPER.readValue(input, klaz);
			input.close();
			return value;
		} catch (final Exception e) {
			log.error("", e);
			return null;
		}
	}

	public static <T> T fromURL(final URL url, final Class<T> klaz) {
		try {
			final T value = MAPPER.readValue(url, klaz);
			return value;
		} catch (final Exception e) {
			log.error("", e);
			return null;
		}
	}

	public static String intoText(final Object value) {
		try {
			return MAPPER.writeValueAsString(value);
		} catch (final Exception e) {
			log.error("", e);
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	public static boolean update(final Object value, final String json) {
		try {
			final ObjectReader reader = MAPPER.updatingReader(value);
			// final ObjectReader reader = MAPPER.readerForUpdating(value);
			reader.readValue(json);
			return true;
		} catch (final Exception e) {
			log.error("", e);
			return false;
		}
	}

	// TODO enable after jackson v 1.9.0
	public static void logMapper(final ObjectMapper mapper) {

		log.debug("mapper : {}", mapper);

		log.debug("\t === SerializationConfig ===");

		for (final SerializationConfig.Feature feature : SerializationConfig.Feature
				.values()) {
			// log.debug("\t {} : {}", feature, mapper.isEnabled(feature));
		}

		log.debug("\t === DeserializationConfig ===");

		for (final DeserializationConfig.Feature feature : DeserializationConfig.Feature
				.values()) {
			// log.debug("\t {} : {}", feature, mapper.isEnabled(feature));
		}

		log.debug("\t === JsonParser ===");

		for (final JsonParser.Feature feature : JsonParser.Feature.values()) {
			// log.debug("\t {} : {}", feature, mapper.isEnabled(feature));
		}

		log.debug("\t === JsonGenerator ===");

		for (final JsonGenerator.Feature feature : JsonGenerator.Feature
				.values()) {
			// log.debug("\t {} : {}", feature, mapper.isEnabled(feature));
		}

	}

}
