package es.eduardoespinosa.jsonAbstract;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by eduardo on 2/05/17.
 */
public abstract class JSONAbstract {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static <T> Collection<T> getCollection(File file, Class<T> tClass) {
		CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(Collection.class, tClass);
		Collection<T> tCollection = null;
		try {
			tCollection = objectMapper.readValue(file, collectionType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tCollection;
	}

	public static <T> Collection<T> getCollection(String string, Class<T> tClass) {
		CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(Collection.class, tClass);
		Collection<T> tCollection = null;
		try {
			tCollection = objectMapper.readValue(string, collectionType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tCollection;
	}

	public static <T> T getObject(File file, Class<T> tClass) {
		T o = null;
		try {
			o = objectMapper.readValue(file, tClass);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return o;
	}

	public static <K, V> Map <K, V> getMap(String string, Class<K> kClass, Class<V> vClass) {
		MapType mapType = objectMapper.getTypeFactory().constructMapType(Map.class, kClass, vClass);
		Map<K, V> map = null;
		try {
			map = objectMapper.readValue(string, mapType);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return map;
	}
	public static <K, V> Map <K, V> getMap(File file, Class<K> kClass, Class<V> vClass) {
		MapType mapType = objectMapper.getTypeFactory().constructMapType(Map.class, kClass, vClass);
		Map<K, V> map = null;
		try {
			map = objectMapper.readValue(file, mapType);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return map;
	}

	public static <T> T getObject(String file, Class<T> tClass) {
		T o = null;
		try {
			o = objectMapper.readValue(file, tClass);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return o;
	}

	public static <T> void saveObject(T t) {
		try {
			String json = objectMapper.writer().withType(t.getClass()).writeValueAsString(t);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public static void setObjectMapper(ObjectMapper objectMapper) {
		JSONAbstract.objectMapper = objectMapper;
	}
}
