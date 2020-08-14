/**
 * 
 */
package nonesoft.wrkcouch;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import nonesoft.wrkcouch.FileTypes;
import java.util.HashMap;
import java.util.Map;
/**
 * @author emnadvo
 *
 */
public final class FileManager {
	/**
	 * It's manager for work with files - written easily string to custom prepare file 
	 * at custom prepared directory
	 * also easily archiving and so on 
	 * @author emnadvo
	 * 
	 */
	
	private Map<FileTypes, File> allFilesStorage;
	
	private FileOutputStream baseFileOutput = null;
	private String workDirName = "";
	private Path workDir = null;
	private String workFileName = "";
	private File workFile = null;	
	private String currentWorkPath = "";
	
	static volatile String constructDirName;
	
	public FileManager() {
	}
	
	public FileManager(String dirName) {
		this.setWorkDirName(dirName);		
	}
	
	public FileManager(String dirName, String fileName) {
		this.setWorkDirName(dirName);
		this.setWorkFileName(fileName);
	}
	
	public void Init()
	{
		if(allFilesStorage.isEmpty())
		{
			allFilesStorage = new HashMap<FileTypes, File>();
		}
		
		//get run directory
		String cwd = System.getProperty("user.dir");
	}
	
	/**
	 * 	Method generate name of directory
	 * @param createNew = define if generate new directory or only generate name
	 */
	protected void generateWorkDir(boolean createNew) {
		
		constructDirName = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
				
		//when directory hasn't name must be generated at form DATE_generatedDir_00x
		if(workDirName.isEmpty()) {
			constructDirName += "_generatedDir";			
		}
		else {
			constructDirName = getWorkDirName();
		}
		
		long lCount = 0;
		
		String cwd = getCurrentWorkPath();
		
		if ( cwd.isEmpty() ) {
			cwd = System.getProperty("user.dir");
		}

				
		//get count of generated directories		
//		File[] listOfFiles = new File(cwd).listFiles((dirname, name)->name.contains(constructDirName) );
//		lCount = listOfFiles.length;
//		constructDirName += String.valueOf(lCount);
		
		//create directory
		File newDir = new File(constructDirName);
		
		if( createNew && !newDir.exists()) {
			newDir.mkdir();
		}
		
		setWorkDir(newDir.toPath());
		setWorkDirName(constructDirName);
		setCurrentWorkPath(cwd);
		
		constructDirName = "";

	}
	
	public FileOutputStream getBaseFileOutput() {
		return baseFileOutput;
	}

	public void setBaseFileOutput(FileOutputStream baseFileOutput) {
		this.baseFileOutput = baseFileOutput;
	}
	
	public Path getWorkDir() {
		return workDir;
	}

	public void setWorkDir(Path workDir) {
		this.workDir = workDir;
	}

	public File getWorkFile() {
		return workFile;
	}

	public void setWorkFile(File workFile) {
		this.workFile = workFile;
	}

	public String getWorkDirName() {
		return workDirName;
	}

	public void setWorkDirName(String workDirName) {
		this.workDirName = workDirName;
	}

	public String getWorkFileName() {
		return workFileName;
	}

	public void setWorkFileName(String workFileName) {
		this.workFileName = workFileName;
	}

	public String getCurrentWorkPath() {
		return currentWorkPath;
	}

	public void setCurrentWorkPath(String currentWorkPath) {
		this.currentWorkPath = currentWorkPath;
	}

//	public void WritToFile() {
//		try {
//			output = new FileOutputStream("config.properties");
//			Path rootDir = FileSystems.getDefault().getPath("C:","Data","workspace");
//			File outFile = new File(rootDir.toString() + "/wholeyeardays.tex");
//			
//			if(!outFile.exists()) {
//				outFile.createNewFile();
//			}
//			
//			FileWriter fos = new FileWriter(outFile);
//			fos.write(myYear.generateListOfDays());
//			fos.close();
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (output != null) {
//				try {
//					output.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//
//		}			
}
	
//public class PropertiesTest {
//    public static void main(String[] args)
//        throws Exception {
//
//        // set up new properties object
//        // from file "myProperties.txt"
//        FileInputStream propFile =
//            new FileInputStream( "myProperties.txt");
//        Properties p =
//            new Properties(System.getProperties());
//        p.load(propFile);
//
//        // set the system properties
//        System.setProperties(p);
//        // display new properties
//        System.getProperties().list(System.out);
//    }
//}
