import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.*;
import java.util.*;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
 
public class Rename {
	public static void main(String[] args) throws Exception {

java.text.NumberFormat nf = new java.text.DecimalFormat("00000");
for(int i = 0; i < 454; i++){

File dir = new File("~/data/Recommendation/"+nf.format(i));

FileFilter fileFilter1 = new WildcardFileFilter("Pattern*before.java");
FileFilter fileFilter2 = new WildcardFileFilter("Pattern*after.java");
File[] before = dir.listFiles(fileFilter1);
File[] after = dir.listFiles(fileFilter2);

for (int j = 0; j < before.length; j++) {
        try {
//		Necessary to avoid clashes with original files in folder, have to rename all to New***
           	File new_before = new File("~/data/Recommendation/"+nf.format(i)+"/NewPattern_"+j+"_before.java");
           	File new_after = new File("~/data/Recommendation/"+nf.format(i)+"/NewPattern_"+j+"_after.java");
		before[j].renameTo(new_before);
		after[j].renameTo(new_after);
        } catch (Exception e) {
            e.printStackTrace();}
        }
}

//	Now rename properly to Pattern***

for(int i = 0; i < 454; i++){

File dir = new File("~/data/Recommendation/"+nf.format(i));

FileFilter fileFilter3 = new WildcardFileFilter("NewPattern*before.java");
FileFilter fileFilter4 = new WildcardFileFilter("NewPattern*after.java");
File[] lbefore = dir.listFiles(fileFilter3);
File[] lafter = dir.listFiles(fileFilter4);
for (int j = 0; j < lbefore.length; j++) {
        try {
           	File new_before = new File("~/data/Recommendation/"+nf.format(i)+"/Pattern_"+j+"_before.java");
           	File new_after = new File("~/data/Recommendation/"+nf.format(i)+"/Pattern_"+j+"_after.java");
		lbefore[j].renameTo(new_before);
		lafter[j].renameTo(new_after);
        } catch (Exception e) {
            e.printStackTrace();}
        }
}
for(int i = 0; i < 454; i++){

File dir = new File("~/data/Recommendation/"+nf.format(i));
FileFilter filter = new WildcardFileFilter("Pattern*.java");
File[] pat = dir.listFiles(filter);
if(pat.length == 0) FileUtils.cleanDirectory(dir);;
//File filtered = new File("~/data/Recommendation/"+nf.format(i)+"/filtered");
/*File file1 = new File("~/data/Recommendation/"+nf.format(i)+"/Gen_after.java");
File file2 = new File("~/data/Recommendation/"+nf.format(i)+"/Gen_before.java");
File file3 = new File("~/data/Recommendation/"+nf.format(i)+"/Gen_before.java.pretty");
File file4 = new File("~/data/Recommendation/"+nf.format(i)+"/Gen_after.java.pretty");
file1.delete();
file2.delete();
file3.delete();
file4.delete();
FileUtils.deleteDirectory(data);
//FileUtils.deleteDirectory(filtered);
*/
}

}
}
