package retail_Sales;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadCSV {
	public List<Sales> readFile(String path) {
		try {

			return Files.lines(Paths.get(path)).skip(1).map(line -> line.split(","))
					.map(a -> new Sales(Integer.parseInt(a[0].trim()), a[1].trim(), a[2].trim(),
							Integer.parseInt(a[4].trim()), Integer.parseInt(a[6].trim()), Integer.parseInt(a[7].trim()),
							a[5].trim(), Integer.parseInt(a[8].trim()), a[3].trim()))
					.collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
