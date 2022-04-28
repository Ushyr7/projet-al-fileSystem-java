package FileSystem.Impl;


import FileSystem.File;
import util.ElementName;

/**
 * Simple implantation of File 
 * 
 * @author Quentin RIDEL
 *
 */
public class SimpleFileImpl implements File {
	
	private ElementName name;
	
	
	private byte[] content;
	
	public SimpleFileImpl(String n) {
		try {
			name = new ElementName(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
		content = new byte[File.MAX_BYTES_NUMBER];
	}

	@Override
	public String getName() {
		return name.getName();
	}

	@Override
	public int getSize() {
		return content.length;
	}
	
	@Override
	public byte[] getContent() {
		return content;
	}

	@Override
	public void setContent(byte[] content) {
		this.content = content;
		
	}
}
