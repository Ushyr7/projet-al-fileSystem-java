package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * a name for an element in a file system
 * 
 * @author Quentin RIDEL
 *
 */
public class ElementName {
	
	private static final int ELEMENT_NAME_MAX_LENGTH = 20;
	
	private static final String ELEMENT_NAME_REGEX = "[a-zA-Z0-9._]+";
	
	private String name;
	
	public ElementName(String n) throws Exception {
		//vérification de la longueur
		if (n.length() > ELEMENT_NAME_MAX_LENGTH) {
			throw new Exception("Name can't have a length greater than 20");
		}
		//compilation de la regex
		Pattern p = Pattern.compile(ELEMENT_NAME_REGEX);
		//création de la recherche dans n
		Matcher m = p.matcher(n);
		//lancement de la recherche
		boolean b = m.matches();
		//si la recherche est fructueuse
		if(b) {
			name = n;
		} else {
			throw new Exception("Name is not in right format");
		}
	}

	public String getName() {
		return name;
	}

}
