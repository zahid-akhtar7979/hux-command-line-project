package com.deloitte.hux.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deloitte.hux.manager.NetflixDataOperations;
import com.deloitte.hux.utilities.NetflixUtilities;

public class NetflixDataApplication {


	public static void main(String[] args) throws IOException, ParseException {

		Map<String, Integer>keyToIndexMap = new HashMap<String, Integer>();
		File directory = new File("./resources/static/netflix_titles.csv");
		System.out.println(directory.getAbsolutePath());
		BufferedReader br = new BufferedReader(new FileReader("./resources/static/netflix_titles.csv"));

		String firstLine = br.readLine();
		List<String> dataFields = NetflixUtilities.splitString(firstLine);

		for(int i = 0; i < dataFields.size(); i++) {
			keyToIndexMap.put(dataFields.get(i), i);
		}
		NetflixDataOperations.recordsWithTVtype(br,keyToIndexMap,5);
		br.close();
		
	}

}


