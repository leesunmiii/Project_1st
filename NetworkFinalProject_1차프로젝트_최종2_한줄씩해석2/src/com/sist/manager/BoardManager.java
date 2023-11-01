package com.sist.manager;
// 파일 입출력
import java.util.*; // ArrayList , Date

import com.sist.vo.BoardVO;

import java.text.*; // SimpleDateFormat
import java.io.*; // File관련 => ObjectInputStream / ObjectOutputStream
public class BoardManager {
	// 게시물 목록 => 모아서 관리 => ArrayList
	private static ArrayList<BoardVO> bList=new ArrayList<BoardVO>(); // static 넣어주지않으면 개별창에서만 수정,변경 내용 저장됨 => 공통으로 데이터 공유, 저장해줘야함
	// 값을 채운다
	static 
	{
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try
		{
			fis=new FileInputStream("c:\\java_data\\board.txt");
			ois=new ObjectInputStream(fis);
			bList=(ArrayList<BoardVO>)ois.readObject();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				fis.close();
				ois.close();
			}
			catch(Exception ex) {}
		}
	}
	// 목록 출력 
	public ArrayList<BoardVO> boardListData(int page)
	{
		ArrayList<BoardVO> list=new ArrayList<BoardVO>();
		int j=0;
		int rowSize=10; //  화면에 출력하는 게시물 갯수
		int pagecnt=(page*rowSize)-rowSize; // => (1*10)-10 => 0 => 1page ...
		/*
		 *  1page => 0~9 (인덱스 번호) => 게시물 10개까지 
		 *  2page => 10~19
		 *  3page => 20~29
		 *  
		 *  2page 요청시 0~9 스킵하고 10~19 보여줌
		 */
		// 오라클 => 인라인뷰를 통해 구현
		// MySQL => LIMIT 통해 구현
		for(int i=0;i<bList.size();i++)
		{
			if(j<10 && i>=pagecnt)
			{
				BoardVO vo=bList.get(i);
				list.add(vo);
				j++; // 10개씩만 저장
			}
		}
		return list;
	}
	public int boardTotalPage()
	{
		return (int)(Math.ceil(bList.size()/10.0));
		
		// ceil => 올림함수 => 소수점이 0이 아닌 경우 전부 올림
	}
	// 데이터 추가 === 동일 코딩 필요 => 파일에 저장을 바꿔줘야함
	public void boardInsert(BoardVO vo)
	{
		bList.add(vo); // 메모리 => 프로그램 종료 시 사라짐 => 피일에 저장해야함
					   // 수정 시 get
					   // set
		fileSave();
	}
	public void fileSave()
	{
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try
		{
			fos=new FileOutputStream("c:\\java_data\\board.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(bList);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				fos.close();
				oos.close();
			}
			catch(Exception ex) {}
		}
		
	}
	// 상세보기
	public BoardVO boardDetailData(int no)
	{
		BoardVO vo=new BoardVO();
		for(int i=0;i<bList.size();i++)
		{
			BoardVO bVO=bList.get(i);
			if(bVO.getNo()==no)
			{
				bVO.setHit(bVO.getHit()+1); // 조회수 증가 => ArrayList만 변경됨
				vo=bVO;
				fileSave(); // 파일 저장 필수! => 파일과 ArrayList가 동일 해아함
				break;
				// 다음주 => 파일 -> 오라클!
				// UPDATE board SET hit=hit+1 WHRE no=1; ==> 오라클
				// 오라클 (웹의 핵심) => SQL
				// SQL (CRUD => SELECT , INSERT, UPDATE, DELETE)
			}
		}
		return vo;
	}
	// 수정하기 === 동일 코딩 필요 => 파일에 저장을 바꿔줘야함
	public BoardVO boardUpdateData(int no)
	{
		BoardVO vo=new BoardVO();
		for(BoardVO bVO:bList)
		{
			if(bVO.getNo()==no)
			{
				vo=bVO;
				break;
			}
		}
		return vo;	
			
	}
	public String boardUpdate(BoardVO vo)
	{
		String result=""; // YES NO
		for(int i=0;i<bList.size();i++)
		{
			// remove(index) , set(index)
			BoardVO pVO=bList.get(i);
			if(pVO.getNo()==vo.getNo()) // 서버에 저장된 값 vs 클라이언트가 전송한 값
			{
				if(pVO.getPwd().equals(vo.getPwd()))
				{
					// 수정 (비밀번호가 일치)
					result="YES";
					//bList.set(i, vo); // 수정 => 메모리 안에서 변경한 후  (모든 정보가 수정되어야하기때문에 오류남)
					pVO.setContent(vo.getContent());
					pVO.setName(vo.getName());
					pVO.setSubject(vo.getSubject()); // 수정된 데이터만 선택해서 저장해줌
					
					fileSave(); // 수정된 내용 파일에 저장
					// 메모리 저장 == 파일 저장
				}
			}
			else
			{
				// 비밀번호가 틀린 상태
				result="NO";
			}
			break;
		}
		return result;
	}
	// 삭제하기 === 동일 코딩 필요 => 파일에 저장을 바꿔줘야함
	// ArrayList 제어 / 파일 제어 => 웹 => Manager
	// 웹 => 파일대신 오라클
	public String boardDelete(int no,String pwd)
	{
		String result=""; // NO, YES
		for(int i=0;i<bList.size();i++) // 삭제하기 위해서는 인덱스 번호가 필요하기 때문에 for문 사용
		{
			BoardVO vo=bList.get(i);
			if(vo.getNo()==no)
			{
				if(vo.getPwd().equals(pwd))
				{
					// 삭제 대상 => 비밀번호가 일치
					result="YES";
					bList.remove(i);
					fileSave();
				}
				else
				{
					// 비밀번호가 틀린 상태
					result="NO";
				}
				
				break;
			}
		}
		return result;
	}
	// 검색하기
	// 자동 증가번호 생성 => 스퀀스 ===> 오라클 => SELECT MAX(no)+1 FROM board
	
	public int boardSequence()
	{
		int max=0;
		for(BoardVO vo:bList)
		{
			if(vo.getNo()>max)
			{
				max=vo.getNo();
			}
		}
		return max+1;
	}
	// 공통 => 파일 저장
	
}