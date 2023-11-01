package com.sist.friendship;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

//import com.sist.client.ControllPanel;
import com.sist.manager.FoodManager;
import com.sist.vo.FoodCategoryVO;
import com.sist.vo.FoodHouseVO;
public class HomePanel extends JPanel implements ActionListener,MouseListener{
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	   PosterCard[] pcs=new PosterCard[12];
	   FoodManager fm=new FoodManager();
	   JPanel pan=new JPanel();
	   ControllPanel cp;
	   public HomePanel(ControllPanel cp)
	   {
		   this.cp=cp;
		   JPanel p=new JPanel();
		   p.setLayout(new GridLayout(1,3,20,20));
		   b1=new JButton("메뉴1");
		   b1.setPreferredSize(new Dimension(300,45));
		   b2=new JButton("메뉴2");
		   b2.setPreferredSize(new Dimension(300,45));
		   b3=new JButton("메뉴3");
		   b3.setPreferredSize(new Dimension(300,45));
		   b4=new JButton("메뉴4");
		   b4.setPreferredSize(new Dimension(300,45));
		   b5=new JButton("메뉴5");
		   b5.setPreferredSize(new Dimension(300,45));
		   b6=new JButton("메뉴6");
		   b6.setPreferredSize(new Dimension(300,45));
		   b7=new JButton("메뉴7");
		   b7.setPreferredSize(new Dimension(300,45));
		   b8=new JButton("메뉴8");
		   b8.setPreferredSize(new Dimension(300,45));
		   p.add(b1);p.add(b2);p.add(b3);p.add(b4);
		   p.add(b5);p.add(b6);p.add(b7);p.add(b8);
		   
		   pan.setLayout(new GridLayout(4,3,5,5));
		   //pan.setBackground(Color.black);
		   // 배치 
		   setLayout(new BorderLayout());
		   add("North",p);
		   add("Center",pan);
		   
		   b1.addActionListener(this);
		   b2.addActionListener(this);
		   b3.addActionListener(this);
		   b4.addActionListener(this);
		   b5.addActionListener(this);
		   b6.addActionListener(this);
		   b7.addActionListener(this);
		   b8.addActionListener(this);
	   
	   /*for(int i=0;i<pcs.length;i++)
	   {
		   if(pcs[i]!=null)
		   {
			   pcs[i].addMouseListener(this);
		   }
	   }*/
	   
   }
   public void cardPrint(ArrayList<FoodCategoryVO> list)
   {
	   int i=0;
	   for(FoodCategoryVO vo:list)
	   {
		   pcs[i]=new PosterCard(vo);
		   pan.add(pcs[i]);
		   pcs[i].addMouseListener(this);
		   i++;
	   }
   }
 
   public void cardInit(ArrayList<FoodCategoryVO> list)
   {
	   for(int i=0;i<list.size();i++)
	   {
		   pcs[i].poLa.setIcon(null);
		   pcs[i].tLa.setText("");
       }
	   pan.removeAll(); // 판 안에있는 데이터 제거
	   pan.validate(); // panel 재배치
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			ArrayList<FoodCategoryVO> list=
					fm.foodCategoryData(1);
			cardInit(list);
			cardPrint(list);
			  
		}
		else if(e.getSource()==b2)
		{
			ArrayList<FoodCategoryVO> list=
					fm.foodCategoryData(2);
			cardInit(list);
			cardPrint(list);
		}
		else if(e.getSource()==b3)
		{
			ArrayList<FoodCategoryVO> list=
					fm.foodCategoryData(3);
			cardInit(list);
			cardPrint(list);
		}
		else if(e.getSource()==b4)
		{
			ArrayList<FoodCategoryVO> list=
					fm.foodCategoryData(4);
			cardInit(list);
			cardPrint(list);
		}
		else if(e.getSource()==b5)
		{
			ArrayList<FoodCategoryVO> list=
					fm.foodCategoryData(5);
			cardInit(list);
			cardPrint(list);
		}
		else if(e.getSource()==b6)
		{
			ArrayList<FoodCategoryVO> list=
					fm.foodCategoryData(6);
			cardInit(list);
			cardPrint(list);
		}
		else if(e.getSource()==b7)
		{
			ArrayList<FoodCategoryVO> list=
					fm.foodCategoryData(7);
			cardInit(list);
			cardPrint(list);
		}
		else if(e.getSource()==b8)
		{
			ArrayList<FoodCategoryVO> list=
					fm.foodCategoryData(8);
			cardInit(list);
			cardPrint(list);
		}
		
	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<pcs.length;i++)
		{
			if(e.getSource()==pcs[i])
			{
				if(e.getClickCount()==2) // 더블클릭
				{
					String title=pcs[i].tLa.getText();
					FoodHouseVO vo=fm.foodInfoData(title);
//					FoodCategoryVO vo=fm.categoryInfoData(title);
//					cp.fcp.la1.setText(vo.getTitle());
//					cp.fcp.la2.setText(vo.getSubject());
//					ArrayList<FoodHouseVO> list=fm.foodHouseListData(vo.getCno());
//					cp.fcp.foodPrint(list);
					cp.fdp.foodprint(vo);
					cp.card.show(cp, "fdetail");
				}
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