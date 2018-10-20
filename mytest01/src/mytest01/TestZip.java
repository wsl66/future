package mytest01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;
import org.junit.Test;

public class TestZip {


	/**
	 * 压缩文件
	 *
	 * @param zipFilePath
	 *            压缩的文件完整名称(目录+文件名)
	 * @param srcPathName
	 *            需要被压缩的文件或文件夹
	 */
	public static void compressFiles(String zipFilePath, String srcPathName) {
		long start = System.currentTimeMillis();
		File zipFile = new File(zipFilePath);
		File srcdir = new File(srcPathName);
		if (!srcdir.exists()) {
			throw new RuntimeException(srcPathName + "不存在！");
		}
		Project prj = new Project();
		FileSet fileSet = new FileSet();
		fileSet.setProject(prj);
		if (srcdir.isDirectory()) { // 是目录
			fileSet.setDir(srcdir);
			fileSet.setIncludes("*.docx"); // 包括哪些文件或文件夹
			// eg:zip.setIncludes("*.java");
			// fileSet.setExcludes(...); //排除哪些文件或文件夹
		} else {
			fileSet.setFile(srcdir);
		}
		Zip zip = new Zip();
		zip.setProject(prj);
		zip.setDestFile(zipFile);
		zip.setEncoding("utf-8"); // 以gbk编码进行压缩，注意windows是默认以gbk编码进行压缩的
		zip.addFileset(fileSet);
		zip.execute();
		System.out.println("---compress files success---time="
				+ (System.currentTimeMillis() - start));
	}

	public static void main(String[] args) {

		String sourDir = "F://Test//zip";
		String outPath = "F://Test/zipDest";

		File[] listFiles = new File(sourDir).listFiles();
		for (File file : listFiles) {
			File[] listFiles2 = file.listFiles();
			for (File file2 : listFiles2) {
				compressFiles(
						outPath + "/" + file.getName() + "_" + file2.getName() + ".zip",
						file2.getAbsolutePath());
			}
		}

	}

	@Test
	public void testCopy() {
		String source = "F://Test/model.docx";
		String base = "F://Test/zip/00000";

		for (int k = 3; k < 10; k++) {
			String dest = base + k;

			for (int i = 0; i < 10; i++) {
				String countPath = "00" + i;
				for (int j = 0; j < 1000; j++) {
					String fileName = "a00" + j + ".docx";
					File destFile = new File(dest + "/" + countPath + "/" + fileName);
					if (!destFile.getParentFile().exists()) {
						destFile.getParentFile().mkdirs();
					}
					try {
						FileInputStream fis = new FileInputStream(source);
						FileOutputStream fos = new FileOutputStream(destFile);
						IOUtils.copy(fis, fos);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}

	}

}
