package com.fuhuadata.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
/**
 * json序列化工具类
 * @author wangbo
 */
public class JsonUtils {
    private static JsonFactory jsonFactory = new JsonFactory();
	
    /**
     * 对象进行json序列化
     * @param obj
     * @return
     */
	public static String toJson(Object obj) {
		String json = "";
		Writer w = new StringWriter();
		try {
			JsonGenerator jg = jsonFactory.createJsonGenerator(w);
			jg.useDefaultPrettyPrinter();
			/*@SuppressWarnings("unused")
			StdSerializerProvider sp = new StdSerializerProvider();*/
			ObjectMapper mapper = new ObjectMapper();
			
			SerializationConfig c = mapper.getSerializationConfig();
			//过期的忽略Null值的属性方法
			//c.set(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
			
			//最新忽略Null值的属性方法
			c.setSerializationInclusion(Inclusion.NON_NULL);
			
			mapper.setSerializationConfig(c);
			mapper.writeValue(jg, obj);
			json = w.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				w.close();
				w = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return json;
	}
	public static <T> T toObject(Class<T> valueType,String jsonStr){
		ObjectMapper o = new ObjectMapper();
		try {
			return (T)o.readValue(jsonStr, valueType);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 返回JSON数据构造成的Map
	 * @param jsonText
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Map readToMap(String jsonText) {
		ObjectMapper o = new ObjectMapper();
		Map maps = null;
		try {
			maps = o.readValue(jsonText, Map.class);
			return maps;
		}catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_MAP;
	}
	
}

class NullSerializer extends JsonSerializer<Object> {
	public void serialize(Object value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		//jgen.writeString("");
	}
}
