package com.sist.friendship;

import java.awt.CardLayout;

import javax.swing.*;

//import com.sist.client.HomePanel;

//import com.sist.firendship.FoodCategoryListPanel;
public class ControllPanel extends JPanel{
  public HomePanel hp;
  public ChatPanel cp=new ChatPanel();
  public BoardListPanel blp;
  public NewsPanel np=new NewsPanel();
  public BoardInsertPanel bip;
  public BoardDetailPanel bdp;
  public BoardDeletePanel bdel;
  public BoardUpdatePanel bup;
  public FoodDetailPanel fdp;
  public FoodCategoryListPanel fcp;
  
  
  public CardLayout card=new CardLayout();

  
  public ControllPanel()
  {
	  hp=new HomePanel(this);
	  blp=new BoardListPanel(this); // 화면 이동 => 하나의 화면으로 통합해줌
	  bip=new BoardInsertPanel(this); // 화면 이동 => 하나의 화면으로 통합해줌
	  bdp=new BoardDetailPanel(this);
	  bdel=new BoardDeletePanel(this);
	  bup=new BoardUpdatePanel(this);
	  fdp=new FoodDetailPanel(this);
	  fcp=new FoodCategoryListPanel(this);
	  setLayout(card);
	  add("home",hp);
	  add("chat",cp);
	  add("board", blp);
	  add("news",np);
	  add("insert",bip);
	  add("detail",bdp);
	  add("delete",bdel);
	  add("update",bup);
	  add("fdetail",fdp);
	  add("catefood",fcp);
	  // => @RequestMapping("update.jsp") => Spring / Spring=Boot
	  // => app.get("update") => NodeJS
  }

}