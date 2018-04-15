package com.perficient.util;

import java.io.File;
import java.io.IOException;

import com.perficient.core.TestDriver;

public class EmbeddingImageInExcel {

	public static void embeddingImage(String Outputfilepath) {

		String vbsfilepath = TestDriver.props.getProperty("embedexcelvbspath");
		File outputpath = new File(Outputfilepath);

		String destinationlocation = outputpath.getAbsolutePath();
		try {
			Runtime.getRuntime().exec("wscript " + " " + vbsfilepath + " " + destinationlocation);
		} catch (IOException ex) {

		}
	}
}
