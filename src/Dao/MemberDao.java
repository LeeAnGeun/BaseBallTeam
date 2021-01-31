package Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import dto.Batter;
import dto.HumanDto;
import dto.PitcherDto;
import java.io.File;

public class MemberDao {
	Scanner sc = new Scanner(System.in);
	
	private HumanDto humanArr[] = new HumanDto[30];
	int hcount;
	File newFile;
	
	public MemberDao() {
		hcount = 0;
		
		File newFile = new File("C:\\Baseball"); 
		
		if(newFile.mkdirs()) {
			System.out.println("폴더 생성 성공");
		}
		else {
			System.out.println("폴더 생성 실패"); // 같은 이름에 디렉토리가 있을시 실패한다.
		}
	}
	
	
	// 선수추가
	public void insert() {
		int pbnumber; // 투수와 타자를 가려주기 위한 변수
	
		System.out.print(" (투수 : 1 / 타자 : 2) : ");
		pbnumber = sc.nextInt();
			
		System.out.println("==선수의 정보를 입력하세요==");
		System.out.print("투수의 이름 : ");
		String name = sc.next();
		System.out.print("투수의 나이 : ");
		String age = sc.next();
		System.out.print("투수의 키 : ");
		String height = sc.next();
		
		if(pbnumber == 1) {
			System.out.print("투수의 승리 : ");
			String win = sc.next();
			System.out.print("투수의 패배 : ");
			String lose = sc.next();
			System.out.print("투수의 방어율 : ");
			String defence = sc.next();
			
			humanArr[hcount] = new PitcherDto("투수", name, age, height, win, lose, defence);
			hcount ++;
		}
		
		else if(pbnumber == 2) {		
			System.out.print("타자의 batCount : ");
			String batcount = sc.next();
			System.out.print("타자의 hit : ");
			String hit = sc.next();
			System.out.print("타자의 hitAverage : ");
			String hitAvg = sc.next();
			
			humanArr[hcount] = new Batter("타자", name, age, height, batcount, hit, hitAvg);
			hcount ++;
		}
	}
	
	// 선수삭제
	public void delete() {
		String m_name;
		System.out.print("삭제 할 선수의 이름를 입력하세요 : ");
		m_name = sc.next();
		
		int index = serchNum(m_name);
		
		if(index == -1) {
			System.out.println("해당 선수를 찾을 수 없습니다");
			return;
		}
		
		humanArr[index] = null; //  해당 index값을 배열을 null로 초기화
		System.out.println("선수를 성공적을 삭제하였습니다.");
		
		/* 위에 코드 두 줄로 수정
		if(humanArr[index].Position().equals("투수")) {
			
			humanArr[index].setpAndb("");
			humanArr[index].setName("");
			humanArr[index].setAge("");
			humanArr[index].setHeight("");
			((PitcherDto)humanArr[index]).setWin("");
			((PitcherDto)humanArr[index]).setLose("");
			((PitcherDto)humanArr[index]).setDefence("");
			humanArr[index] = null; // 
			System.out.println("선수를 성공적을 삭제하였습니다.");
		}
		else {
			humanArr[index].setpAndb("");
			humanArr[index].setName("");
			humanArr[index].setAge("");
			humanArr[index].setHeight("");
			((Batter)humanArr[index]).setBatCount("");
			((Batter)humanArr[index]).setHit("");
			((Batter)humanArr[index]).setHitAvg("");
			humanArr[index] = null;
			System.out.println("선수를 성공적으로 삭제하였습니다.");
		}
		*/
		
	}
	
	// 선수검색
	public void select() {
		String m_name;
		System.out.print("찾을 선수의 이름를 입력하세요 : ");
		m_name = sc.next();
		
		int index = serchNum(m_name);
		if(index == -1) {
			System.out.println("해당 선수를 찾을 수 없습니다");
			return;
		}
		
		System.out.println(humanArr[index].toString()); // 해당 index에 해당하는 선수정보 출력
	
	}
	
	// 선수수정
	public void update() {
		String m_name;
		System.out.print("수정 할 선수의 이름을 입력하세요 : ");
		m_name = sc.next();
		
		int index = serchNum(m_name);
		if(index == -1) {
			System.out.println("해당 선수를 찾을 수 없습니다");
			return;
		}
		
		if(humanArr[index] instanceof PitcherDto) {
			System.out.print("해당 투수의 승리를 새로 입력하세요 : ");
			((PitcherDto)humanArr[index]).setWin(sc.next());
			System.out.print("해당 투수의 패배를 새로 입력하세요 : ");
			((PitcherDto)humanArr[index]).setLose(sc.next());
			System.out.print("해당 투수의 방어율을 새로 입력하세요 : ");
			((PitcherDto)humanArr[index]).setDefence(sc.next());
		}
		else {
			System.out.print("해당 타자의 BatCount를 새로 입력하세요 : ");
			((Batter)humanArr[index]).setBatCount(sc.next());
			System.out.print("해당 타자의 Hit를 새로 입력하세요 : ");
			((Batter)humanArr[index]).setHit(sc.next());
			System.out.print("해당 타자의 타율을 새로 입력하세요 : ");
			((Batter)humanArr[index]).setHitAvg(sc.next());
		}
		
		System.out.println("데이터를 성공적으로 수정하였습니다.");
	}
	
	// 저장하기
	public void save() {
			File newFile = new File("C:\\Baseball\\MyTeam.txt"); // 파일 포인터
			
			try { 
				newFile.createNewFile(); // 파일 생성
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
			try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(newFile)));
			
			for (int i = 0; i < humanArr.length; i++) {
				if(humanArr[i] != null && !humanArr[i].getName().equals(null)) {
					pw.println(humanArr[i]); // humanArr[] 배열에 입력된 정보를 저장함	
				}
			}
			pw.close();
			
			} catch (IOException e) {
			e.printStackTrace();
			}
	}
	
	int serchNum(String m_name) {
		int index = -1;
		
		for (int i = 0; i < humanArr.length; i++) {
			try {
				if(humanArr[i] != null && !humanArr[i].getName().equals(null)){ 
					if(humanArr[i].getName().equals(m_name)) {
						index = i;
						break;
					}
				}
			}catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
		return index;
	}
}
