package crf.term.recognition;

import java.io.PrintWriter;

public class CrfCmdControl {
	  public void CrfControl(String commend) {  
			//1、编译打包
				String[] command =
			    {
			        "cmd",
			    };
			    Process p = null;
				try {
					p = Runtime.getRuntime().exec(command);
					new Thread(new CrfCmdControlInOutPut(p.getErrorStream(), System.err)).start();
					new Thread(new CrfCmdControlInOutPut(p.getInputStream(), System.out)).start();
					PrintWriter stdin = new PrintWriter(p.getOutputStream());
					/**以下可以输入自己想输入的cmd命令*/
					stdin.println("d:"); 					//定位到D盘根目录
					stdin.println("cd "+"d://file//Crf");	//cd到项目所在路径
					//stdin.println("crf_learn template train model");				//清理
					stdin.println(commend);	
				
					stdin.close();
				} catch (Exception e) {
					throw new RuntimeException("编译出现错误："+e.getMessage());
				}
		    }  
}
