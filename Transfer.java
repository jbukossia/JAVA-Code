import java.io.*;
import com.jcraft.jsch.*;
import java.util.Scanner;

public class Transfer
{
	public static void main(String[] args) {
	    JSch jsch = new JSch();
	    Session session = null;

	    String user = "ubuntu";
	    String password = "";
	    int port=22;

	    String remoteDir="/home/ubuntu/bundles";
	    String remoteFile="temp2.csv";
	    String localFile="/home/james/Documents/ec2/interoperability/data/temp2.csv";

	    Scanner receiver = new Scanner(System.in);
	    System.out.println("Enter the receiving server address: >");
	    String host = receiver.next();

	    Scanner keypath = new Scanner(System.in);
	    System.out.println("Enter the receiving server's private keypath: >");
	    String privateKeyPath = keypath.next();

	    try
	    {
		jsch.addIdentity(privateKeyPath);
		session = jsch.getSession(user, host, port);
		session.setPassword(password);
		session.setConfig("StrictHostKeyChecking", "no");
		System.out.println("Connecting to the receiving server ...");
		session.connect();
		System.out.println("Connection to the server has been established.");
		System.out.println("SFTP channel creation in progress ...");
		ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
		sftpChannel.connect();
		System.out.println("SFTP Channel has been created.");
		InputStream out= null;
		sftpChannel.cd(remoteDir);
		File f1 = new File(localFile);
		sftpChannel.put(new FileInputStream(f1), f1.getName(), ChannelSftp.OVERWRITE);
		sftpChannel.disconnect();
		session.disconnect();
		System.out.println(" >>>>>>>>>>> File transfer successful!! >>>>>>>>>>>\nSee " + remoteDir+"/"+remoteFile + " in the remote server: " + host);
	    }
	    catch(JSchException | SftpException | IOException e)
	{
	    System.out.println(e);
	}
	}
};
