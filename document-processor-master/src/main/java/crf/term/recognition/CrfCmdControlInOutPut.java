package crf.term.recognition;

import java.io.InputStream;
import java.io.OutputStream;

public class CrfCmdControlInOutPut implements Runnable{
	  public CrfCmdControlInOutPut(InputStream istrm, OutputStream ostrm) {
	        istrm_ = istrm;
	        ostrm_ = ostrm;
	    }
	    public void run() {
	    	try{
	    		final byte[] buffer = new byte[1024];
	    		for (int length = 0; (length = istrm_.read(buffer)) != -1;){
	                ostrm_.write(buffer, 0, length);
	            }
	        }
	        catch (Exception e) {
	            throw new RuntimeException("处理命令出现错误："+e.getMessage());
	        }
	    }
		private final OutputStream ostrm_;
		private final InputStream istrm_;
}
