package com.sist.friendship;

import javax.swing.*;

import com.sist.common.ImageChange;
import com.sist.manager.FoodManager;
import com.sist.vo.FoodCategoryVO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*
 *  FlowLayout : JPanel => 일자로 출력
 *       ------------
 *        버튼 버튼 .. : 일자로 출력
 *       -------------
 *  GridLayout => 일정 간격을 주고 출력
 *       ------------
 *       버튼  버튼  버튼
 *       버튼  버튼  버튼  
 *       ------------
 *  BorderLayout : JFrame
 *        -----------
 *           North 
 *        -----------
 *          |     |
 *    East  |     | West
 *          |     |
 *           Center
 *        -----------
 *           South
 *        -----------
 *  CardLayout => 감췄다가 원하는 위치를 지정하면 전환해줌
 */
public class ClientMainForm extends JFrame implements ActionListener{
    MenuPanel mp=new MenuPanel();
    ControllPanel cp=new ControllPanel();
    JLabel logo=new JLabel();
    Login login=new Login();
    FoodManager fm=new FoodManager();
    JPanel pan=new JPanel();
    public ClientMainForm()
    {
    	setLayout(null); // null => 직접 배치 
    	logo.setBounds(10, 20, 200, 150);
    	logo.setIcon(new ImageIcon(ImageChange.getImage(new ImageIcon("c:\\javaDev\\logo.png"), 120, 150)));
    	add(logo);
    	mp.setBounds(10, 175, 100, 250); // 좌표점을 잡아 (100,250 => 버튼 크기)
    	add(mp); // 윈도우에 출력해라
    	
    	cp.setBounds(135, 15, 865, 750);
    	add(cp);
    	setSize(1024, 768);
    	//setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE); // X버튼 눌렀을 때 종료
    
    	// 등록
    	mp.b1.addActionListener(this);
    	mp.b2.addActionListener(this);
    	mp.b3.addActionListener(this);
    	mp.b4.addActionListener(this);
    	mp.b5.addActionListener(this);
    	mp.b6.addActionListener(this);
    	
    	login.b1.addActionListener(this);
    	
    	ArrayList<FoodCategoryVO> list=fm.foodCategoryData(1);
    	cp.hp.cardPrint(list);
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try
	       {
	    	   UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
	       }catch(Exception ex) {}
        new ClientMainForm();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getSource()==mp.b1)
		{
			cp.card.show(cp, "home");
			
		}
		else if(e.getSource()==mp.b2)
		{
			
		}
		else if(e.getSource()==mp.b3)
		{
			cp.card.show(cp, "chat");
		}
		else if(e.getSource()==mp.b4)
		{
			cp.card.show(cp, "board");
		}
		else if(e.getSource()==mp.b5)
		{
			cp.card.show(cp, "news");
		}
		else if(e.getSource()==mp.b6)
		{
			System.exit(0);
		}
		else if(e.getSource()==login.b1)
		{
			//서버 연결
			login.setVisible(false);
			setVisible(true);
		}
	}

}