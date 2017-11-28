package com.w2a.architectbatch1.testCases;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class ReadJson {

	public static void main(String[] args) throws JsonProcessingException, IOException {

		Map<String,String> map= new Hashtable<String,String>();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node=mapper.readTree(new File("E:\\WorkSpace\\Architectbatch1\\src\\test\\resources\\testdata\\Samplejson.json"));
	 //  System.out.println(node.size());
	   System.out.println(node.isArray());
	   
	   System.out.println(node.size());
	   if(node.isArray())
	   {
		   for(int i=0;i<node.size();i++)
		   {
			   
		   }
	   }
	   
	   Iterator<String> itr=node.fieldNames();
	   ObjectReader reader = mapper.readerFor(new TypeReference<List<String>>() {});
	   while(itr.hasNext())
	   {
		   //System.out.println(itr.next());
		   String key=itr.next();
		   JsonNode value=node.findValue(key);
		   if(value.isArray())
		   {
			  List<String> list=reader.readValue(value);
			  String s="";
			  for(String val:list)
			  {
				  s=s+val+",";
			  }
			  s=s.substring(0,s.length()-1);
			  map.put(key, s);
			   
		   }
		   else if(value.isObject())
		   {
			   Iterator<String> itrator=value.fieldNames();
			   while(itrator.hasNext())
			   {
				   String key1=itrator.next();
				   String value1=value.get(key1).toString();
				   map.put(key1, value1);
			   }
			   
		   }
		   else
		   {
			  map.put(key, value.toString()) ;
		   }
		   
	   }
	   System.out.println("final Map="+map);
	}

}
