
package com.webank.wedatasphere.linkis.jobhistory.util;

import java.io.File;

public class ExcelContent {
    private String name;
    private File file;

    public ExcelContent(String name, String filePath) {
        this.name = name;
        this.file = new File(filePath);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
    
}
