package com.xj.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(Main.class.getResource("/"));
		// 1�����������ļ��������ļ��е����ݾ��� tracker ����ĵ�ַ��
		ClientGlobal.init("D:\\workspace\\fastDFSdemo\\target\\classes\\fdfs_client.conf");
		// 2������һ�� TrackerClient ����ֱ�� new һ����
		TrackerClient trackerClient = new TrackerClient();
		// 3��ʹ�� TrackerClient ���󴴽����ӣ����һ�� TrackerServer ����
		TrackerServer trackerServer = trackerClient.getConnection();
		// 4������һ�� StorageServer �����ã�ֵΪ null
		StorageServer storageServer = null;
		// 5������һ�� StorageClient ������Ҫ�������� TrackerServer ����StorageServer ������
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 6��ʹ�� StorageClient �����ϴ�ͼƬ��
		// ��չ��������.��
		String[] strings = storageClient.upload_file("C:\\Users\\xj\\Pictures\\Explosion_1080.jpg", "jpg", null);
		// 7���������顣����������ͼƬ��·����
		for (String string : strings) {
			System.out.println(string);
		}

	}

}
