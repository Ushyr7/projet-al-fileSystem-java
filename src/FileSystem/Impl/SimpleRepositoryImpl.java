package FileSystem.Impl;


import java.util.ArrayList;
import java.util.List;

import FileSystem.File;
import FileSystem.FileSystemElements;
import FileSystem.Repository;
import FileSystem.SymLink;
import util.ElementName;

/**
 * Simple implemantation of Repository
 * 
 * @author Quentin RIDEL
 *
 */
public class SimpleRepositoryImpl implements Repository {

	private ElementName name;
	
	private List<FileSystemElements> content;
		
	
	public SimpleRepositoryImpl(String name){
		try {
			this.name = new ElementName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		content = new ArrayList<FileSystemElements>();
	}
	
	@Override
	public String getName() {
		return name.getName();
	}
	

	@Override
	public int getSize() {
		int result = 0;
		for(FileSystemElements e : content) {
			result += e.getSize();
		}
		return result;
	}
	
	@Override
	public List<FileSystemElements> getContent() {
		return content;
	}

	
	@Override
	public void addFile(File f) {
		content.add(f);
	}

	@Override
	public void addRepository(Repository r) {
		content.add(r);	
	}

	@Override
	public void addSymLink(SymLink sl) {
		content.add(sl);
	}
	
	
}
