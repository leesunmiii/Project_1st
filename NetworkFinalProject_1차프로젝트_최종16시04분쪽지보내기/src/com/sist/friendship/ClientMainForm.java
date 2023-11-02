package com.sist.friendship;
import javax.swing.*;

import com.sist.common.Function;
import com.sist.common.ImageChange;
import com.sist.manager.FoodManager;
import com.sist.vo.FoodCategoryVO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import java.util.*;
import java.io.*;
import java.net.*;
public class ClientMainForm extends JFrame implements ActionListener,Runnable,MouseListener{
    MenuPanel mp=new MenuPanel();
    ControllPanel cp=new ControllPanel();
    JLabel logo=new JLabel();
    Login login=new Login();
    FoodManager fm=new FoodManager();
    JPanel pan=new JPanel();
    
    // 네트워크 관련
    Socket s; // 전화기 
    OutputStream out; // 송신
    BufferedReader in; // 수신
    String myId;
    int selectRow=-1;
    String myid;
    SendMessage sm=new SendMessage();
    GetMessage rm=new GetMessage();
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
    	
    	//채팅 등록
    	cp.cp.tf.addActionListener(this);
    	cp.cp.b6.addActionListener(this);
    	cp.cp.b3.addActionListener(this);
    	cp.cp.b2.addActionListener(this);
    	cp.cp.table1.addMouseListener(this);
    	
    	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    	
    	sm.b1.addActionListener(this);
    	sm.b2.addActionListener(this);
    	rm.b1.addActionListener(this);
    	rm.b2.addActionListener(this);
    	
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
			cp.ffp.tf.setText("");
			for(int i=cp.ffp.model.getRowCount()-1;i>=0;i--)
			{
				cp.ffp.model.removeRow(i);
			}
			cp.card.show(cp, "find");
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
			try
			{
				out.write((Function.EXIT+"|\n").getBytes());
			}catch(Exception ex) {}
		}
		else if(e.getSource()==login.b1)
		{
			//서버 연결
			String id=login.tf1.getText();
			if(id.trim().length()<1)
			{
				login.tf1.requestFocus();
				return;
			}
			String name=login.tf1.getText();
			if(name.trim().length()<1)
			{
				login.tf2.requestFocus();
				return;
			}
			
			String sex="";
			if(login.rb1.isSelected())
			{
				sex="남자";
			}
			else
			{
				sex="여자";
			}
			connect(id,name,sex);
		}
		else if(e.getSource()==cp.cp.tf)
		{
			String msg=cp.cp.tf.getText();
			if(msg.trim().length()<1)
				return;
			try 
			{
				out.write((Function.WAITCHAT+"|"+msg+"\n").getBytes());
			}catch(Exception ex) {}
			cp.cp.tf.setText("");
		}
		else if(e.getSource()==cp.cp.b6)
		{
			try
			{
				out.write((Function.EXIT+"|\n").getBytes());
			}catch(Exception ex) {}
		}
		else if(e.getSource() == cp.cp.b3) {
			int row = cp.cp.table2.getSelectedRow();
			sm.tf.setText(cp.cp.table2.getValueAt(row, 0).toString());
			sm.tf.setEditable(false);
			sm.ta.setText("");
			sm.setVisible(true);
		}
		else if(e.getSource()==sm.b1) {
			String id = sm.tf.getText();
			String content = sm.ta.getText();
			if(content.length()<1) {
				sm.ta.requestFocus();
				return;
			}
			
			String msg = Function.MSGSEND+"|"+id+"|"+content+"\n";
			
			try {
				out.write(msg.getBytes());
			}catch(Exception ex){
				ex.printStackTrace();
			}
			sm.setVisible(false);
		}
		else if(e.getSource() == sm.b2) { //취소
			sm.setVisible(false);
		}
		else if(e.getSource() == rm.b1) { // 답장하기
			sm.tf.setText(rm.tf.getText()); 
			sm.ta.setText("");
			sm.setVisible(true);
			rm.setVisible(false);
			
		}
		else if(e.getSource() == rm.b2) { // 취소
			rm.setVisible(false);
		}
		else if(e.getSource()==cp.cp.b4) {
			int row = cp.cp.table2.getSelectedRow();
			String id = cp.cp.table2.getValueAt(row, 0).toString();
			String msg = Function.INFO+"|"+id+"|"+"\n";
			try {
				out.write(msg.getBytes());
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	// 서버와 연결
	public void connect(String id,String name,String sex)
	{
		try
		{
			s=new Socket("192.168.0.124",1024);// 서버 연결
			out=s.getOutputStream(); // 서버 전송
			in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			out.write((Function.LOGIN+"|"+id+"|"+name+"|"+sex+"\n").getBytes());
			
		}catch(Exception ex) {}
		// 서버로부터 들어오는 데이터를 받아서 처리 
		new Thread(this).start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				String msg=in.readLine();
				StringTokenizer st=
						new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				switch(protocol)
				{
				case Function.LOGIN:
				{
					String[] data= {st.nextToken(),
							        st.nextToken(),
							        st.nextToken(),
							        st.nextToken()
							       };
					cp.cp.model2.addRow(data);
				}
				break;
				case Function.MYLOG:
				{
					login.setVisible(false);
					setVisible(true);
				}
				break;
				case Function.WAITCHAT:
				{
					cp.cp.bar.setValue(cp.cp.bar.getMaximum());
					cp.cp.pane.append(st.nextToken()+"\n");
				}
				break;
				case Function.MSGSEND:{
					String id = st.nextToken();
					String content = st.nextToken();
					rm.tf.setText(id);
					rm.ta.setText(content);
					rm.setVisible(true);
				}
				break;
				case Function.INFO:{
					String data="아이디:"+st.nextToken()+"\n"
						     +"이름:"+st.nextToken()+"\n"
						     +"성별:"+st.nextToken();
					JOptionPane.showMessageDialog(this, data);
					break;
				}
				case Function.MYEXIT:
				{
					System.exit(0);
				}
				break;
				case Function.EXIT:
				{
					String id=st.nextToken();
					for(int i=0;i<cp.cp.model2.getRowCount();i++)
					{
						String temp=cp.cp.model2.getValueAt(i, 0).toString();
						if(id.equals(temp))
						{
							cp.cp.model2.removeRow(i);
							break;
						}
					}
				}
				break;
				}
			}
		}catch(Exception ex) {}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cp.cp.table2)
		{
			//if(e.getClickCount()==2)// 더블 클릭
			//{
			    selectRow=cp.cp.table2.getSelectedRow();
				String id=cp.cp.table2.getValueAt(selectRow, 0).toString();
				//JOptionPane.showMessageDialog(this, "선택된 ID:"+id);
				if(id.equals(myId))// 본인이면 
				{
					cp.cp.b1.setEnabled(false);
					cp.cp.b2.setEnabled(false);
				}
				else //본인이 아닌 경우 
				{
					cp.cp.b1.setEnabled(true);
					cp.cp.b2.setEnabled(true);
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

}