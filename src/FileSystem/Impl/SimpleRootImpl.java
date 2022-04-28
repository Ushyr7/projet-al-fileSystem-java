package FileSystem.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import FileSystem.File;
import FileSystem.FileSystemElements;
import FileSystem.Repository;
import FileSystem.Root;
import FileSystem.SymLink;
import util.ElementName;

/**
 * simple implemantation of a root repository
 * 
 * @author Quentin RIDEL
 *
 */
public class SimpleRootImpl implements Root {
	
	private static SimpleRootImpl uniqueInstance = new SimpleRootImpl();
	
	private ElementName name;
	
	private Map<String, File> files;
	
	private Map<String, Repository> repositories;
	
	private Map<String, SymLink> symbolicLinks;
	
	private SimpleRootImpl() {
		try {
			this.name = new ElementName("root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		files = new HashMap<String, File>();
		repositories = new HashMap<String, Repository>();
		symbolicLinks = new HashMap<String, SymLink>();
		repositories.put(getName() + "/", this);
	}
	
	public static SimpleRootImpl instance() {
		return uniqueInstance;
	}

	@Override
	public String getName() {
		return name.getName();
	}

	@Override
	public int getSize() {
		int result = 0;
		for(Map.Entry<String, File> e : files.entrySet()) {
			File f = e.getValue();
			result += f.getSize();
		}
		return result;
	}


	@Override
	public void addFile(File f) {
		files.put(getName() + "/" +  f.getName(), f);
	}

	@Override
	public void addRepository(Repository r) {
		repositories.put(getName() + "/" + r.getName(), r);
	}

	@Override
	public void addSymLink(SymLink sl) {
		symbolicLinks.put(getName() + "/" + sl.getName(), sl);
	}

	@Override
	public String getElementPath(FileSystemElements element) {
		for (Map.Entry<String, File> e : files.entrySet()) {
			if(element.equals(e.getValue())) {
				return e.getKey();
			}
		}
		for (Map.Entry<String, SymLink> e : symbolicLinks.entrySet()) {
			if(element.equals(e.getValue())) {
				return e.getKey();
			}
		}
		for (Map.Entry<String, Repository> e : repositories.entrySet()) {
			if(element.equals(e.getValue())) {
				return e.getKey();
			}
		}
		return null;
	}

	@Override
	public List<FileSystemElements> getContent() {
		List<FileSystemElements> result = new ArrayList<FileSystemElements>();
		List<FileSystemElements> listAll = new ArrayList<FileSystemElements>(files.values());
		listAll.addAll(repositories.values());
		listAll.addAll(symbolicLinks.values());
		for (FileSystemElements e : listAll) {
			if(getElementPath(e).split("/").length == 2) {
				result.add(e);
			}
		}
		return result;
	}
	
	public Map<String, File> getFiles() {
		return files;
	}
	
	public Map<String, Repository> getRepositories() {
		return repositories;
	}
	
	public Map<String, SymLink> getSymLinks() {
		return symbolicLinks;
	}

	@Override
	public void addToFiles(String path, File f) {
		files.put(path, f);
	}

	@Override
	public void addToRepositories(String path, Repository r) {
		repositories.put(path, r);
	}

	@Override
	public void addToSymbolicLinks(String path, SymLink sl) {
		symbolicLinks.put(path, sl);
	}
} 
