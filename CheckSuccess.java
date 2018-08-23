import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.collections.ListUtils;

public class CheckSuccess {
	public static void main(String[] args) throws Exception {
// Check for groups that were initially overgeneralized but are now successful --- NB: Rename groups first, below not ok
	List<String> OVERG_1 = new LinkedList<String>(Arrays.asList("c0","c1","c2","c3","c5","c6","c9","c10","c11","c12","c15","c16","c17","c20","c21","c22","c23","c27","c29","c30","c37","c38","c40","c46","c50","c51","c52","c54","c58","c59","c61","c63","c65","c68","c69","c72","c75","c76","c77","c78","c79","c80","c81","c83","c84","c86","c87","c88","c89","c93","c94","c95","c97","c98","c100","c101","c103","c108","c109","c111","c116","c118","c119","c120","c122","c124","c125","c127","c128","c129","c132","c134","c136","c138","c142","c143","c145","c146","c147","c148","c150","c151","c153","c155","c157","c158","c159","c160","c161","c163","c166","c168","c172","c176","c179","c181","c182","c183","c185","c186","c188","c189","c190","c191","c194","c195","c197","c199","c200","c205","c206","c207","c210","c216","c217","c219","c221","c223","c226","c228","c232","c233","c235","c236","c237","c238","c239","c240","c241","c242","c244","c245","c248","c249","c250","c252","c255","c257","c261","c262","c265","c267","c268","c272","c273","c276","c278","c280","c282","c283","c285","c288","c289","c290","c292","c295","c296","c297","c298","c300","c301","c302","c304","c305","c308","c310","c311","c314","c317","c321","c323","c324","c325","c326","c327","c329","c330","c331","c337","c338","c341","c343","c350","c351","c352","c353","c354","c356","c359","c361","c362","c363","c369","c370","c371","c372","c373","c374","c375","c378","c380","c381","c382","c383","c384","c386","c387","c389","c393","c394","c401","c402","c406","c409","c410","c412","c414","c415","c416","c419","c420","c421","c423","c425","c427","c428","c429","c430","c433","c436","c439","c441","c445","c448","c449","c451","c455"));
	List<String> OVERG_2 = new LinkedList<String>(Arrays.asList("c13","c62","c247","c260","c270","c315","c336","c339","c340","c349","c259","c400","c403","c408","c453"));
	List<String> SUCC_1 = new LinkedList<String>(Arrays.asList("c4","c7","c8","c13","c14","c18","c19","c24","c25","c26","c28","c31","c32","c34","c35","c36","c39","c41","c42","c43","c44","c45","c47","c48","c49","c53","c55","c56","c57","c60","c62","c64","c66","c67","c70","c71","c73","c74","c82","c90","c91","c92","c96","c99","c102","c104","c105","c106","c107","c110","c112","c113","c114","c117","c121","c123","c126","c130","c131","c133","c135","c137","c139","c140","c141","c144","c149","c152","c154","c156","c162","c164","c165","c167","c169","c170","c171","c173","c174","c175","c177","c178","c180","c184","c187","c192","c193","c196","c198","c201","c202","c203","c204","c208","c209","c211","c212","c213","c214","c215","c220","c222","c224","c225","c227","c229","c230","c231","c234","c243","c246","c247","c251","c253","c254","c256","c258","c259","c260","c263","c264","c266","c269","c270","c271","c274","c275","c277","c279","c281","c284","c286","c287","c291","c293","c294","c299","c303","c306","c309","c312","c313","c315","c316","c318","c319","c320","c322","c328","c332","c333","c334","c335","c336","c339","c340","c342","c344","c345","c346","c347","c348","c349","c355","c357","c358","c360","c364","c365","c366","c367","c368","c376","c377","c379","c385","c388","c390","c395","c396","c398","c399","c400","c403","c404","c405","c407","c408","c411","c413","c417","c418","c422","c426","c431","c432","c434","c435","c437","c438","c440","c442","c443","c444","c446","c447","c450","c452","c453","c454"));
	List<String> SUCC_2 = new LinkedList<String>(Arrays.asList("c7","c24","c25","c26","c28","c31","c32","c34","c36","c39","c44","c47","c49","c56","c57","c60","c64","c66","c67","c71","c73","c74","c82","c91","c92","c102","c104","c107","c112","c114","c117","c121","c130","c133","c135","c137","c141","c144","c149","c152","c154","c162","c164","c165","c170","c173","c174","c175","c177","c184","c193","c198","c209","c211","c212","c213","c214","c215","c220","c222","c225","c230","c231","c251","c254","c256","c263","c264","c266","c271","c274","c277","c279","c281","c284","c286","c293","c294","c299","c316","c318","c319","c322","c328","c332","c333","c334","c335","c342","c344","c345","c346","c347","c348","c355","c360","c364","c366","c368","c376","c377","c388","c395","c396","c398","c404","c411","c417","c418","c422","c431","c434","c435","c442","c443","c444","c446","c447","c450","c452"));

//	SUCC_1.removeAll(SUCC_2);
//	System.out.println("SUCCESSFUL GRPS THAT ARE NOLONGER SUCC:	" + Arrays.toString(SUCC_1.toArray()));

	OVERG_1.retainAll(SUCC_2);
	System.out.println("OVERGEN GRPS THAT ARE NOW SUCCESSFUL:	" + Arrays.toString(OVERG_1.toArray()));//These are the required ones 		for training!!

//	SUCC_1.retainAll(OVERG_2);
//	System.out.println("SUCCESSFUL GRPS THAT ARE NOW OVERGEN:	" + Arrays.toString(SUCC_1.toArray()));//Needed to undo the change so 		that the groups remain successful.
}
}
//TODO: Build training set using the new successful from those that were originally overgeneralized i.e label all removed data as outliers and the others as good, centre them and train.

//TODO: OVERGEN_2 should be empty since all patterns have been deleted
