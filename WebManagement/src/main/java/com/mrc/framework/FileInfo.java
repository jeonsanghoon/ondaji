/**
 * 
 */
package com.mrc.framework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author jsh
 *
 */
public class FileInfo {
	/**
	 * 디렉코리생성
	 * 
	 * @param path 폴더
	 * @return 성공유무
	 */
	public Boolean MakeDerectory(String path) {
		try {
			File Folder = new File(path);
			// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
			if (!Folder.exists()) {
				try {
					Folder.mkdir(); // 폴더 생성합니다.
					System.out.println("폴더가 생성되었습니다.");
				} catch (Exception e) {
					e.getStackTrace();
				}
			} else {
				System.out.println("이미 폴더가 생성되어 있습니다.");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param path  파일 주소
	 * @param msg   글내용
	 * @param bnext true 이어쓰기 false 새로 쓰기
	 * @return
	 */
	public Boolean MakeFileWrite(String path, String msg, Boolean bnext) {
		File file = new File(path);
		FileWriter writer = null;

		try {
			// 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
			writer = new FileWriter(file, bnext);
			writer.write(msg);
			writer.flush();

			System.out.println("DONE");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	/**
	 * 디렉토리와 그 안의 파일삭제
	 * 
	 * @param path
	 * @return
	 */
	public Boolean DerectoryAndFilesDelete(String derectoryPath) {
		File file = new File(derectoryPath);
		try {
			if (file.exists()) { // 파일존재여부확인
				if (file.isDirectory()) {
					// 파일이 디렉토리인지 확인
					File[] files = file.listFiles();
					for (int i = 0; i < files.length; i++) {
						if (files[i].delete())
							System.out.println(files[i].getName() + " 삭제성공");
						else
							System.out.println(files[i].getName() + " 삭제실패");
					}
				}
				if (file.delete())
					System.out.println("파일삭제 성공");
				else
					System.out.println("파일삭제 실패");
			}

			else {
				System.out.println("파일이 존재하지 않습니다.");
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 파일삭제
	 * 
	 * @param path
	 * @return
	 */
	public Boolean FileDelete(String path) {
		File file = new File("C:/123.txt");
		try {
			if (file.exists()) {
				if (file.delete()) {
					System.out.println("파일삭제 성공");
				} else {
					System.out.println("파일삭제 실패");
				}
			} else {
				System.out.println("파일이 존재하지 않습니다.");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}
}
