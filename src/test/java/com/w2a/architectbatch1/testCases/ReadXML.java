package com.w2a.architectbatch1.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

import org.apache.commons.io.IOUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
public class ReadXML {
	
	public static void main(String[] args) throws IOException {
		String browserName="";
		String testCaseId="tc_01";
		InputStream is = new FileInputStream(
				new File("E:\\WorkSpace\\Architectbatch1\\src\\test\\resources\\testdata\\SampleXML.xml"));
		String xml = IOUtils.toString(is);

		XMLSerializer xmlSerializer = new XMLSerializer();
		JSON json = xmlSerializer.read(xml);

		System.out.println("json-->"+json);
		System.out.println(json.toString());

		// printJSON(json.toString());
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = null;
		JsonNode node = null;
		try {
			node = mapper.readTree(json.toString());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(node.isArray());
		if (node.isArray()) {
			System.out.println(node.size());
			
		}
		loop1:
		for (int i = 0; i < node.size(); i++) {
			 map = new HashMap<String, String>();
			
		//	System.out.println(node.get(0));
			//node=node.get(i);
			Iterator<String> itr = node.get(i).fieldNames();
			ObjectReader reader = mapper.readerFor(new TypeReference<List<String>>() {});
			loop2:
			while (itr.hasNext()) {
				String key = itr.next();
				
				JsonNode value = node.get(i).findValue(key);
				if (value.isArray()) {
					List<String> list = null;
					try {
						list = reader.readValue(value);
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					String s = "";
					for (String val : list) {
						s = s + val + ",";

					}

					map.put(key, s);
				} else if (value.isObject()) {
					Iterator<String> k = value.fieldNames();
					while (k.hasNext()) {
						String key1 = k.next();
						String value1 = value.findValue(key1).toString();
						
						map.put(key1, value1);
						

					}
				} else {
					
					map.put(key, value.toString());
					
				}

			}
			System.out.println(map.get("name"));
			System.out.println(map.get("browser"));
			if(map.get("name").contains((testCaseId)))
			{
				System.out.println("yes");
				browserName=map.get("browser");
				break loop1;
			}
			//syso
			/*if(map.get("name").equalsIgnoreCase("tc_01"))
			{
				System.out.println("yes");
			}*/
		}
		System.out.println("Browser-->"+browserName);
	}

}
