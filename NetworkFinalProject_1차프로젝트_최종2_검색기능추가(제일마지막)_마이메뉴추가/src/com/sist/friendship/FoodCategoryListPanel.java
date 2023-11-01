package com.sist.friendship;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.sist.vo.*;
import com.sist.common.ImageChange;
import com.sist.manager.*;
import java.net.*;

public class FoodCategoryListPanel extends JPanel implements MouseListener,ActionListener{ //
	
	JLabel la1,la2; // 패널에서 사용하는 두 레이블
	JButton b; //목록이라고 레이블된 버튼
	JTable table; // 음식 카테고리 정보를 표시하기 위한 테이블
	DefaultTableModel model; // JTable의 테이블 모델입니다.
	ControllPanel cp; // UI 구성 요소 및 패널 간 전환을 관리하기 위한 ControllPanel 인스턴스입니다.
	FoodManager fm=new FoodManager(); // 음식 관련 데이터를 관리하기 위한 FoodManager 클래스의 인스턴스입니다.
	
	public FoodCategoryListPanel(ControllPanel cp) // FoodCategoryListPanel의 생성자
	{																	// 생성자는 ControllPanel 인스턴스를 매개변수로 받습니다. 
																		// 이는 다른 패널 간의 이동을 관리하기 위한 것으로 보입니다.
		this.cp=cp; // 화면 이동 => cp.card
//		la1=new JLabel();
//		la2=new JLabel();
//		
//		b=new JButton("목록");
//		
//		String[] col= {"","이미지","맛집정보"}; // 테이블의 열(세로) 이름을 정의하는 문자열 배열입니다. 
															 // 열(세로)은 세 개이며 각각 빈 문자열, "이미지", "맛집정보"로 지정됩니다.
		
//		Object[][] row=new Object[0][3];	// 테이블의 초기 데이터를 저장하는 2차원 객체 배열입니다. 
														//	여기서는 행(가로)이 없으므로 크기가 0인 배열로 초기화됩니다.
		
//		model=new DefaultTableModel(row,col) // DefaultTableModel은 테이블에 사용자가 편집할 수 없는 데이터를 표시하고, 
																// 이미지를 포함한 여러 종류의 데이터를 테이블에 표시할 수 있도록 해줍니다.
//				{
//
//					@Override // 메서드 오버라이딩, 부모 클래스에 이미 정의된 메서드를 자식 클래스에서 재정의할 때 사용됩니다.
//					public boolean isCellEditable(int row, int column) { //이 메서드는 사용자가 테이블 셀을 편집할 수 있는지를 결정합니다. 
//						
//						return false; // false를 반환하도록 했기 때문에 사용자는 테이블 셀을 편집할 수 없습니다
//					}
		
//					// 테이블 안에 이미지 출력
//					@Override
//					public Class<?> getColumnClass(int columnIndex) { //이 메서드는 각 열의 데이터 타입을 정의합니다. 
//						// TODO Auto-generated method stub
//						return getValueAt(0, columnIndex).getClass(); // 테이블의 첫 번째 행의 데이터를 가져오는데, 이 데이터의 클래스를 반환하여 해당 열에 어떤 종류의 데이터가 들어갈지를 결정합니다. 
																						// 이미지를 표시하기 위해서는 해당 열의 데이터 타입이 이미지 클래스여야 합니다.
//					}
//			
//				};
//       table=new JTable(model); //모델을 사용해 테이블을 생성
//       JScrollPane js=new JScrollPane(table); //스크롤 가능한 테이블 만듦, 스크롤 패널은 테이블이 화면에 표시되는 너비와 높이를 넘어서면 스크롤할 수 있도록 해줍니다.
		
//       table.getColumn("이미지").setPreferredWidth(80); // 테이블의 열(세로) 너비를 설정
//       table.getColumn("맛집정보").setPreferredWidth(800); // 테이블의 열(세로) 너비를 설정
		
//       table.getColumnModel().removeColumn(table.getColumnModel().getColumn(0));
//       // 테이블 모델에서 첫 번째 열을 제거 => 이렇게 함으로써 "hidden" 열, 즉 맛집 번호를 숨깁니다.
		
//       table.getTableHeader().setReorderingAllowed(false);
		//  테이블의 열 헤더에서 열의 순서를 변경할 수 없도록 설정합니다.
		
//       table.setShowVerticalLines(false); // 테이블의 세로 줄을 숨깁니다.
//       table.setRowHeight(100); // 테이블의 각 행의 높이를 100으로 설정합니다.
//       
//       // 배치
//      la1.setHorizontalAlignment(JLabel.CENTER);
//      la1.setFont(new Font("맑은 고딕", Font.BOLD, 45));
//      la2.setHorizontalAlignment(JLabel.CENTER);
//      
//      setLayout(null); // 이렇게 하면 컴포넌트의 위치와 크기를 직접 지정할 수 있습니다.
//      la1.setBounds(10, 15, 750, 55); // x,y,가로,세로
//      la2.setBounds(10, 75, 500, 35);
//      
//      b.setBounds(10, 120, 100, 30);
//      
//      js.setBounds(10, 160, 750, 650);
//      
//      add(la1);
//      add(la2);
//      add(b);
//      add(js);
//      
		//마우스 이벤트와 버튼 클릭 이벤트를 처리하기 위해 리스너를 등록합니다.
//      table.addMouseListener(this); 
//      b.addActionListener(this);
//      
//      
//	}
//	public void foodPrint(ArrayList<FoodHouseVO> list) // FoodHouseVO 객체들의 리스트를 받아와서 테이블에 데이터를 표시하는 역할을 합니다.
//	{
//		for(int i=model.getRowCount()-1;i>=0;i--) // 테이블 모델의 모든 행을 지워서 초기화하는 역할
//		{															// model.getRowCount()-1은 현재 테이블 모델의 마지막 행 인덱스를 나타냅니다. 
																	// i>=0 조건에서 행을 하나씩 지워나가면서 초기화합니다.
//			model.removeRow(i);
//		}
//		try
//		{
//			for(int i=0;i<10;i++)
//			{
//				 FoodHouseVO vo=list.get(i);  // 위 코드는 list에서 FoodHouseVO 객체를 가져와서 반복문을 통해 각 객체에 접근합니다.
															// list에는 FoodHouseVO 객체들이 들어있는 ArrayList가 전달되어야 합니다.
		
//    			 URL url=new URL(vo.getPoster()); // FoodHouseVO 객체에서 포스터 이미지의 URL을 가져옵니다.
		
//    			 Image image=ImageChange.getImage(new ImageIcon(url), 120, 150); // ImageChange.getImage() 메서드를 사용하여 URL에서 이미지를 가져옵니다.
																												// ImageIcon 클래스를 사용하여 URL을 이미지로 변환하고, 이를 ImageChange.getImage() 메서드를 통해 크기를 조정한 이미지로 얻어옵니다. 
																												// 이때 크기는 120x150으로 조정됩니다.
//    			 String data="<html>"+vo.getName()+"&nbsp;" // FoodHouseVO 객체에서 이름, 평점, 주소, 전화번호, 타입 등의 정보를 가져와 HTML 형식의 문자열로 만듭니다. 
//    			            +"<span style=\"color:orange\">"      // 이 문자열은 테이블 셀에 표시될 내용입니다. 평점은 주황색으로 표시됩니다.
//    					    +vo.getScore()+"</span><br>"
//    					    +vo.getAddress()+"<br>"
//    					    +vo.getPhone()+"<br>"
//    					    +vo.getType()
//    					    +"</html>";
		
//    			 Object[] obj={vo.getFno(),new ImageIcon(image),data}; //  위에서 만든 정보를 토대로 테이블에 표시할 데이터 배열을 만듭니다. 
																							// 각 행은 음식점 번호(vo.getFno()), 이미지(new ImageIcon(image)), 그리고 음식점 정보(data)로 구성됩니다.
		
//    			 model.addRow(obj);	 // 테이블 모델(model)에 위에서 만든 데이터 배열(obj)을 추가하여 새로운 행을 만듭니다.  
//			}
//		}
//		catch(Exception ex) {ex.printStackTrace();}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table) // 사용자가 테이블을 클릭한 경우를 처리합니다.
		{
			if(e.getClickCount()==2) //  사용자가 더블 클릭한 경우를 확인합니다.
			{
				int row=table.getSelectedRow(); // table에서 현재 선택된 행의 인덱스를 가져옵니다.
				String fno=model.getValueAt(row, 0).toString(); // 현재 선택된 행에서 첫 번째 열의 데이터, 즉 음식점 번호(fno)를 문자열로 가져옵니다.
				//System.out.println("선택 번호:"+fno);
				FoodHouseVO vo=fm.foodInfoData(Integer.parseInt(fno)); // 음식점 번호를 이용하여 FoodManager 객체(fm)의 foodInfoData 메서드를 호출하고, 해당 음식점의 정보를 FoodHouseVO 객체(vo)로 받아옵니다.
				cp.fdp.foodprint(vo); // ControllPanel 객체(cp)에서 FoodDetailPanel 객체(fdp)를 찾아 foodPrint 메서드를 호출하고, 선택한 음식점의 정보를 표시합니다.
				cp.card.show(cp, "fdetail"); // ControllPanel 객체(cp)에서 카드 레이아웃을 사용하여 "fdetail" 패널을 표시합니다. 이로써 음식점의 상세 정보를 보여주는 패널로 화면을 전환합니다.
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
		{
			cp.card.show(cp, "home");
		}
	}
	
}