package main;

import java.util.Arrays;
import java.util.Scanner;

import Dao.MemberDao;

public class MainClass {

	public static void main(String[] args) {
		/*
			DTO - Human					Pitcher	  /		Batter
			      -> Number - 투수/타자   Win				batCount
			         Name				Lose			Hit
			         Age   				defence			hitAvg
			         Height
			DAO
			선수추가
			
			선수삭제
			
			선수검색
			
			선수수정- 방어율 타율
			
			저장하기
			Menu
			저장(file)
		 */
		Scanner sc = new Scanner(System.in);
		
		MemberDao dao = new MemberDao();
		
		String Manu[] = { "1.추가 ", "2.삭제 ", "3.검색 ", "4.수정 ", "5.저장"};
		boolean b =true;
		while(b) {
			System.out.println(Arrays.toString(Manu));
			int workNumber;
			System.out.print("원하는 메뉴를 선택하세요 : ");
			workNumber = sc.nextInt();
			
			switch (workNumber) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.save();
					System.out.println("정보를 성공적으로 저장하였습니다. 시스템을 종료합니다.");
					b= false;
					break;
			}
		}
	}

}

















