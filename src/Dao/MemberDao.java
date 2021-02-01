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
import file.DataProc;

import java.io.File;

public class MemberDao {
	Scanner sc = new Scanner(System.in);
	
	private HumanDto humanArr[] = new HumanDto[30];
	int hcount;
	
	private DataProc dp; 
	
	public MemberDao() {
		
		dp = new DataProc("BaseballTeam"); 
		dp.creatFile();
		
		dataLoad();
		
		int lastIndexNumber = 0;
		
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null) {
				lastIndexNumber = i;
			}
		}
		if(lastIndexNumber > 0 ) {
			hcount = lastIndexNumber + 1;
		}else {
			hcount = 0;
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
			System.out.print("타자의 타수 : ");
			String batcount = sc.next();
			System.out.print("타자의 안타수 : ");
			String hit = sc.next();
			System.out.print("타자의 타율 : ");
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
			System.out.print("해당 투수의 '승리'를 새로 입력하세요 : ");
			((PitcherDto)humanArr[index]).setWin(sc.next());
			System.out.print("해당 투수의 '패배'를 새로 입력하세요 : ");
			((PitcherDto)humanArr[index]).setLose(sc.next());
			System.out.print("해당 투수의 '방어율'을 새로 입력하세요 : ");
			((PitcherDto)humanArr[index]).setDefence(sc.next());
		}
		else {
			System.out.print("해당 타자의 '타수'를 새로 입력하세요 : ");
			((Batter)humanArr[index]).setBatCount(sc.next());
			System.out.print("해당 타자의 '안타수'를 새로 입력하세요 : ");
			((Batter)humanArr[index]).setHit(sc.next());
			System.out.print("해당 타자의 '타율'을 새로 입력하세요 : ");
			((Batter)humanArr[index]).setHitAvg(sc.next());
		}
		
		System.out.println("데이터를 성공적으로 수정하였습니다.");
	}
	
	// 저장하기
	public void dataSave() {
		int len = 0;
	
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null && !humanArr[i].getName().equals(null)) {
				len++;
			}
		}
		
		String datas[] = new String[len];
		int w = 0;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null && !humanArr[i].getName().equals(null)) {
				datas[w] = humanArr[i].alldata();
				w++;
			}
		}
		dp.saveFile(datas);
	}
	
	public void dataLoad() {
		String datas[] = dp.loadFile();
		
		if(datas != null) {
			for (int i = 0; i < datas.length; i++) {
				String data[] = datas[i].split("-"); // 기존 저장된 String 배열에서 "-" 를 제거하여 String data[]에 다시 저장
				
				if(data[0].equals("투수")) {
					humanArr[i] = new PitcherDto(   data[0], // 투수 
													data[1], // 이름
													data[2], // 나이
													data[3], // 키
													data[4], // 승리
													data[5], // 패배
													data[6]); // 승률
				}
				else {
					humanArr[i] = new Batter(  		 data[0], // 투수 
													data[1], // 이름
													data[2], // 나이
													data[3], // 키
													data[4], // 승리
													data[5], // 패배
													data[6]); // 승률
				}
			}
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
