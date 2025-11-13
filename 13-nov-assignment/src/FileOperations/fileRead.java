package FileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class fileRead {
	public static void main(String[] args) throws IOException {
		String file="src/FileOperations/file";
		File a=new File(file);
		long cnt=0;
//		BufferedReader br=new BufferedReader(new FileReader(a));
//		try {
//			String data;
//			while((data=br.readLine())!=null) {
//				String[] linesData=data.trim().split(" ");
//				for(String i:linesData) {
//					if(i.equalsIgnoreCase("India")) {
//						cnt++;
//					}
//				}
//			}
//			System.out.println(cnt);
//		}catch(Exception e) {
//			e.printStackTrace();
//			
//		}
		try {
		cnt = Files.lines(Paths.get(file))
		        .map(String::toLowerCase)
		        .filter(line -> line.contains("india"))
		        .count();
		System.out.println(cnt);
		cnt = Files.lines(Paths.get(file))
		        .map(String::toLowerCase)
		        .mapToLong(line -> line.split("india", -1).length - 1)
		        .sum();
			System.out.println(cnt);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
