package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dto.HumanDto;

public class DataProc {
	
	private File newFile;
	
	public DataProc(String filename) {
		newFile = new File("c:\\Baseball\\" + filename + ".txt");
		
	}
	
	// 생성
	public void creatFile() {
		File newDir = new File("c:\\Baseball");
		
		if(newDir.mkdir()) {
			System.out.println("폴더 생성 성공");
		}else {
			System.out.println("폴더 생성 실패");
		}
		
		try {
			if(newFile.createNewFile()) {
				System.out.println("파일 생성 성공");
			}else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 저장
	public void saveFile(String[] datas) {
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(newFile)));
			
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("파일에 저장되었습니다");
	}
	
	// 불러오기
	public String[] loadFile() {
		String datas[] = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(newFile));
			
			int count = 0;
			String str = "";
			
			while((str = br.readLine()) !=null) {
				count++;
			}
			br.close();
			
			datas = new String[count];
			
			br = new BufferedReader(new FileReader(newFile)); // 커서를 다시 앞으로 가져오기 위함
			int w = 0;
			while((str = br.readLine()) != null) {
				datas[w] = str;
				w++;
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}
}
























