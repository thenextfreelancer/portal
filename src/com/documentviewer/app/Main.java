package com.documentviewer.app;

import java.io.File;
import java.io.IOException;

import com.documentviewer.config.PathConfig;
import com.documentviewer.config.PropertiesConstant;

public class Main {

	public Main(String workingDirPath) throws IOException {
		PathConfig.setWorkingDirectory(new File(workingDirPath).getAbsolutePath());
		System.setProperty(PropertiesConstant.RESOURCE_DIRECTORY_PATH, workingDirPath);
	}

	public void boot() throws Exception {
		// Write logic to perform any operation on application startup
	}

	public void shutdown() throws Exception {
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
