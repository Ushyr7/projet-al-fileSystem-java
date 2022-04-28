package FileSystem.Impl;

import FileSystem.SymLink;
import util.ElementName;

/**
 * Simple implemantation of symbolic link
 * 
 * @author Quentin RIDEL
 *
 */
public class SimpleSymLinkImpl implements SymLink {
	
	private ElementName name;
	
	private String path;
	
	public SimpleSymLinkImpl(String n, String p) {
		try {
			name = new ElementName(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
		path = p;
	}
	
	@Override
	public String getName() {
		return name.getName();
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public void setPath(String path) {
		this.path = path;
	}

}
