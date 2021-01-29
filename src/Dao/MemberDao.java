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

public class MemberDao {
	Scanner sc = new Scanner(System.in);
	
	private HumanDto humanArr[] = new HumanDto[30];
	int hcount;
	File newFile;
	
	public MemberDao() {
		hcount = 0;
		File newFile = new File("C:\\");
		
		try {
			if(newFile.createNewFile())
				System.out.println("파일 생성 성공");
			else
				System.out.println("파일 생성 실패");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 선수추가
	public void insert() {
		int pbnumber; // 투수와 타자를 가려주기 위한 변수
		System.out.print(" (투수 : 1 / 타자 : 2) : ");
		pbnumber = sc.nextInt();
		if(pbnumber == 1) {
			
			System.out.println("==투수의 정보를 입력하세요==");
			System.out.print("투수의 이름 : ");
			String name = sc.next();
			System.out.print("투수의 나이 : ");
			String age = sc.next();
			System.out.print("투수의 키 : ");
			String height = sc.next();
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
			
			System.out.println("==타자의 정보를 입력하세요==");
			System.out.print("타자의 이름 : ");
			String name = sc.next();
			System.out.print("타자의 나이 : ");
			String age = sc.next();
			System.out.print("타자의 키 : ");
			String height = sc.next();
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
		if(humanArr[index].getpAndb().equals("투수")) {
			humanArr[index].setpAndb(null);
			humanArr[index].setName(null);
			humanArr[index].setAge(null);
			humanArr[index].setHeight(null);
			((PitcherDto)humanArr[index]).setWin(null);
			((PitcherDto)humanArr[index]).setLose(null);
			((PitcherDto)humanArr[index]).setDefence(null);
			System.out.println("선수를 성공적을 삭제하였습니다.");
		}
		else {
			humanArr[index].setpAndb(null);
			humanArr[index].setName(null);
			humanArr[index].setAge(null);
			humanArr[index].setHeight(null);
			((Batter)humanArr[index]).setBatCount(null);
			((Batter)humanArr[index]).setHit(null);
			((Batter)humanArr[index]).setHitAvg(null);
			System.out.println("선수를 성공적으로 삭제하였습니다.");
		}
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
		if(humanArr[index].getpAndb().equals("투수")) {
			System.out.println("찾으시는 선수의 정보 입니다: ");
			System.out.println(((PitcherDto)humanArr[index]).toString());
		}
		else if(humanArr[index].getpAndb().equals("타자")) {
			System.out.println("찾으시는 선수의 정보 입니다: ");
			System.out.println(((Batter)humanArr[index]).toString());
		}
	}
	
	// 선수수정
	public void update() {
		String m_name;
		System.out.print("수정 할 선수의 이름을 입력하세요 : ");
		m_name = sc.next();
		
		int index = serchNum(m_name);
		if(index == -1) {
			System.out.println("해당 선수를 찾을 수 없습니다");
		}
		if(humanArr[index].getpAndb().equals("투수")) {
			System.out.print("해당 투수의 방어율을 새로 입력하세요 : ");
			((PitcherDto)humanArr[index]).setDefence(sc.next());
		}
		else {
			System.out.print("해당 타자의 타율율을 새로 입력하세요 : ");
			((Batter)humanArr[index]).setHitAvg(sc.next());
		}
	}
	
	// 저장하기
	public void save() {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(newFile)));
			
			for (int i = 0; i < humanArr.length; i++) {
				pw.println(humanArr[i]);
			}
			
			pw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	int serchNum(String m_name) {
		int index = -1;
		
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null && !humanArr[i].getName().equals("")) {
				if(humanArr[i].getName().equals(m_name)) {
					index = i;
					break;
				}
			}
		}
		
		return index;
	}
}
