package ftp;

import it.sauronsoftware.ftp4j.FTPDataTransferListener;

public class MyTransferListener implements FTPDataTransferListener {

	public void started() {
		// Transfer started
            System.out.println("FTP Started");
	}

	public void transferred(int length) {
		// Yet other length bytes has been transferred since the last time this
		// method was called
            System.out.println("FTP Transferred: "+length);
	}

	public void completed() {
		// Transfer completed
            System.out.println("FTP Completed");
	}

	public void aborted() {
		// Transfer aborted
            System.out.println("FTP Aborted");
	}

	public void failed() {
		// Transfer failed
            System.out.println("FTP Failed");
	}

}